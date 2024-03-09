package org.gulingjingguai.mzp.lesson.runoob.advancedStage;

import java.io.*;

/**
 * 序列化和反序列化
 */
public class UseSerial implements Serializable {

    public static void main(String[] args) throws IOException {
//        serialObject();
        deSerialObject();
    }

    private static void serialObject() throws IOException {
        UseSerial obj = new UseSerial();
        String path = obj.getUrl();
        String filePath = path + File.separator + "src" + File.separator + "fileDirectory" + File.separator + "file.ser";
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void deSerialObject() throws IOException {
        UseSerial newObj = new UseSerial();
        String path = newObj.getUrl();
        String filePath = path + File.separator + "src" + File.separator + "fileDirectory" + File.separator + "file.ser";
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            newObj = (UseSerial) ois.readObject();
            System.out.println(newObj.getClass());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() throws IOException {
        //获取类加载的根路径
        String path1 = "";
        path1 = this.getClass().getResource("/").getPath();
        String path5 = "";
        path5 = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        //获取当前类所在的工程路径
        String path2 = "";
        path2 = this.getClass().getResource("").getPath();


        //获取项目路径
        String path3 = "";
        File file = new File("");
        path3 = file.getCanonicalPath();

        //获取项目路径
        String path4 = "";
        path4 = System.getProperty("user.dir");

        return path4;
    }


}
