package com;

import org.springframework.boot.loader.JarLauncher;
import org.springframework.boot.loader.archive.Archive;
import org.springframework.boot.loader.archive.JarFileArchive;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThinJarLauncher extends JarLauncher {
    private static final String PROP_THIN_LIB = "thin.lib.path";
    private static final String KOCA_THIN_CLASSPATH = "Koca-Thin-Classpath";
    private static final String CP_LINUX_SEPARATOR = ":";
    private static final String CP_WINDOWS_SEPARATOR = ";";
    private static final Logger LOGGER = Logger.getLogger(ThinJarLauncher.class.getName());

    public ThinJarLauncher() {
    }

    public Iterator<Archive> getClassPathArchivesIterator() throws Exception {
        Iterator<Archive> archives = this.getArchive().getNestedArchives((Archive.EntryFilter)null, this::isNestedArchive);
        ArrayList list = new ArrayList();

        while(archives.hasNext()) {
            list.add(archives.next());
        }

        String libPath = System.getProperty("thin.lib.path");
        this.log(Level.INFO, "thin.lib.path: " + libPath);
        if (libPath != null && !libPath.trim().isEmpty()) {
            File file = new File(libPath);
            if (!file.exists()) {
                throw new IllegalArgumentException("Lib path not exists: " + libPath);
            }

            if (!file.isDirectory()) {
                throw new IllegalArgumentException("Lib path is not a directory: " + libPath);
            }

            List<File> jarFiles = new ArrayList();
            this.getJarFiles(file, jarFiles);
            if (!jarFiles.isEmpty()) {
                String classpath = this.getClasspath();
                if (classpath == null) {
                    Iterator var7 = jarFiles.iterator();

                    while(var7.hasNext()) {
                        File jarFile = (File)var7.next();
                        list.add(new JarFileArchive(jarFile));
                    }
                } else {
                    List<String> idxOrderedJarName = this.getOrderedJarName(classpath);
                    Map<String, File> fsOrderedJar = new LinkedHashMap();
                    Iterator var9 = jarFiles.iterator();

                    while(var9.hasNext()) {
                        File jarFile = (File)var9.next();
                        fsOrderedJar.put(jarFile.getName(), jarFile);
                    }

                    var9 = idxOrderedJarName.iterator();

                    while(var9.hasNext()) {
                        String fileName = (String)var9.next();
                        if (fsOrderedJar.containsKey(fileName)) {
                            list.add(new JarFileArchive((File)fsOrderedJar.get(fileName)));
                            fsOrderedJar.remove(fileName);
                        } else {
                            this.log(Level.WARNING, "Classpath jar not found within lib path: " + fileName);
                        }
                    }

                    if (!fsOrderedJar.isEmpty()) {
                        var9 = fsOrderedJar.entrySet().iterator();

                        while(var9.hasNext()) {
                            Map.Entry<String, File> entry = (Map.Entry)var9.next();
                            this.log(Level.WARNING, "Found lib path jar not in classpath: " + (String)entry.getKey());
                            list.add(new JarFileArchive((File)entry.getValue()));
                        }
                    }
                }
            }
        }

        this.postProcessClassPathArchives(list);
        return list.iterator();
    }

    private List<String> getOrderedJarName(String classpath) {
        String separator = ":";
        if (classpath.contains(":") && classpath.contains(";")) {
            separator = ";";
        }

        return (List) Stream.of(classpath.split(separator)).filter((i) -> {
            return i.toLowerCase().endsWith("jar") || i.toLowerCase().endsWith("zip");
        }).map((path) -> {
            return path.substring(this.getLastSeparatorIndex(path) + 1);
        }).collect(Collectors.toList());
    }

    private int getLastSeparatorIndex(String path) {
        int linux = path.lastIndexOf(47);
        int windows = path.lastIndexOf(92);
        return Math.max(windows, linux);
    }

    private String getClasspath() throws IOException {
        Archive archive = this.getArchive();
        Manifest manifest = archive.getManifest();
        if (manifest == null) {
            this.log(Level.WARNING, "MANIFEST.MF not found.");
            return null;
        } else {
            String classpath = manifest.getMainAttributes().getValue("Koca-Thin-Classpath");
            if (classpath != null && !classpath.trim().isEmpty()) {
                return classpath;
            } else {
                this.log(Level.WARNING, "An attribute named 'Koca-Thin-Classpath' not found in MANIFEST.MF, jar loaded with file system default order.");
                return null;
            }
        }
    }

    private void getJarFiles(File root, List<File> jarFiles) {
        File[] files = root.listFiles();
        if (files != null && files.length > 0) {
            File[] var4 = files;
            int var5 = files.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                File file = var4[var6];
                if (file.isFile()) {
                    String lowerFileName = file.getName().toLowerCase();
                    if (lowerFileName.endsWith(".jar") || lowerFileName.endsWith(".zip")) {
                        jarFiles.add(file);
                    }
                } else {
                    this.getJarFiles(file, jarFiles);
                }
            }
        }

    }

    private void log(Level level, String msg) {
        LOGGER.log(level, msg);
    }

    public static void main(String[] args) throws Exception {
        (new ThinJarLauncher()).launch(args);
    }
}
