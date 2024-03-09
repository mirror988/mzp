//package org.gulingjingguai.mzp.lesson.runoob.basicStage;
//
//import com.spire.xls.*;
//import org.apache.poi.hssf.usermodel.HSSFDataFormat;
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.Test;
//
//import java.awt.*;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ExcelFileOperater {
//    public static void main(String[] args) throws IOException {
//
//        //操作excel的数据
//        List<Map> userData = new ArrayList<>();
//        Map userInfo = new HashMap();
//        userInfo.put("NAME", "苗泽圃");
//        userInfo.put("AGE", "25");
//        userInfo.put("GENDER", "男");
//        userData.add(userInfo);
//
//        ExcelFileOperater excelFileOperater = new ExcelFileOperater();
//        String path = excelFileOperater.getUrl();
//        //模板文件存放路径
//        String excelTempPath = path + File.separator + "src" + File.separator + "fileDirectory" +
//                File.separator + "template.xlsx";
//        String excelCopyPath = path + File.separator + "src" + File.separator + "fileDirectory" +
//                File.separator + "copy.xlsx";
//        File tempFile = new File(excelTempPath);
//        File copyFile = null;
//
//        if (tempFile.exists()) {
//            BufferedInputStream in = new BufferedInputStream(new FileInputStream(tempFile));
//            FileOutputStream out = new FileOutputStream(excelCopyPath);
//            byte[] buffer = new byte[1024];
//            int byteRead = 0;
//            while ((byteRead = in.read(buffer)) != -1) {
//                out.write(buffer, 0, byteRead);
//            }
//            in.close();
//            out.close();
//            copyFile = new File(excelCopyPath);
//        } else {
//            System.out.println("模板文件不存在");
//        }
//
//        updateExcel(copyFile, userData);
//    }
//
//    private static void updateExcel(File copyFile, List<Map> userData) throws IOException {
//        FileInputStream in = new FileInputStream(copyFile);
//        XSSFWorkbook wb = new XSSFWorkbook(in);
//        if (null != wb) {
//            Sheet sh = wb.getSheetAt(0);
//            XSSFCellStyle style = wb.createCellStyle();
//            style.setWrapText(true);
//            style.setAlignment((short) 2);
//
//            XSSFFont font = wb.createFont();
//            font.setFontName("黑体");
//            font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);//粗体显示
//            style.setFont(font);//选择需要用到的字体格式
//            style.setBorderTop(XSSFCellStyle.BORDER_THIN);
//            style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
//            style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
//            style.setBorderRight(XSSFCellStyle.BORDER_THIN);
//            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            style.setFillForegroundColor(new XSSFColor(new Color(141,180,226)));
//
//            Row row0 = sh.createRow(1);
//
//            for (int i = 0; i < userData.size(); i++) {
//                Map<String, Object> dataMap = formatMap(userData.get(i));
//
//                String NAME = dataMap.get("NAME").toString();
//                String AGE = dataMap.get("AGE").toString();
//                String GENDER = dataMap.get("GENDER").toString();
//
//
//                row0.createCell(0).setCellStyle(style);
//                row0.getCell(0).setCellValue(NAME);
//
//                row0.createCell(1).setCellStyle(style);
//                row0.getCell(1).setCellValue(AGE);
//
//                row0.createCell(2).setCellStyle(style);
//                row0.getCell(2).setCellValue(GENDER);
//            }
//        }
//
//        in.close();
//        FileOutputStream fos = new FileOutputStream(copyFile);
//        wb.write(fos);
//        fos.close();// 关闭文件输出流
//    }
//
//
//    //将dataMap中的null值替换为空格字符串
//    private static Map formatMap(Map<String, Object> dataMap) {
//        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
//            if ("null".equals(String.valueOf(entry.getValue()))) {
//                dataMap.put(entry.getKey(), "  ");
//            }
//        }
//        return dataMap;
//    }
//
//    public String getUrl() throws IOException {
//        //获取类加载的根路径
//        String path1 = "";
//        path1 = this.getClass().getResource("/").getPath();
//        String path5 = "";
//        path5 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//
//        //获取当前类所在的工程路径
//        String path2 = "";
//        path2 = this.getClass().getResource("").getPath();
//
//
//        //获取项目路径
//        String path3 = "";
//        File file = new File("");
//        path3 = file.getCanonicalPath();
//
//        //获取项目路径
//        String path4 = "";
//        path4 = System.getProperty("user.dir");
//
//        return path4;
//    }
//
//    @Test
//    public void writeDataToExcel() throws IOException {
//        String data = "1.00%";
//
//        ExcelFileOperater excelFileOperater = new ExcelFileOperater();
//        String path = excelFileOperater.getUrl();
//        //模板文件存放路径
//        String excelFilePath = path + File.separator + "src" + File.separator + "fileDirectory" +
//                File.separator + "1,2,3,4,5.xlsx";
//        updateExcelBasic(excelFilePath,data);
//    }
//
//    private static void updateExcelBasic(String filePath,String data) throws IOException {
//        File file = new File(filePath);
//        FileInputStream in = new FileInputStream(file);
//        XSSFWorkbook wob = new XSSFWorkbook(in);
//
//        Workbook wb = new Workbook();
//        wb.loadFromFile(filePath);
//
//        if (null != wob) {
//            Worksheet sheet = wb.getWorksheets().get(0);
//            CellRange range = sheet.getCellRange("A1:B2");
//
//            ConditionalFormatWrapper format = range.getConditionalFormats().addCondition();
//            format.setFormatType(ConditionalFormatType.DataBar);
//            format.getDataBar().setBarColor(new Color(152,251,152));
//
//            wb.saveToFile(filePath,ExcelVersion.Version2013);
//            wb.dispose();
//
//            Sheet sh = wob.getSheetAt(0);
//            XSSFCellStyle style = wob.createCellStyle();
//            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
//
//            Row row0 = sh.createRow(0);
//            row0.createCell(0).setCellStyle(style);
//            row0.getCell(0).setCellValue(data);
//        }
//
//        in.close();
//        FileOutputStream fos = new FileOutputStream(file);
//        wob.write(fos);
//        fos.close();// 关闭文件输出流
//    }
//}
