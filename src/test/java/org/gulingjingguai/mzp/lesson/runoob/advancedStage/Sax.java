package org.gulingjingguai.mzp.lesson.runoob.advancedStage;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Sax {

    public static void main(String[] args) {
        try{
            // 获得一个xmlReader实例
            XMLReader xmlReader= SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            // 设置内容解析器
            xmlReader.setContentHandler(new MyHandler());
            // 传入内容开始解析
            xmlReader.parse(new InputSource("./src/DataStructure/temp.xml"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

