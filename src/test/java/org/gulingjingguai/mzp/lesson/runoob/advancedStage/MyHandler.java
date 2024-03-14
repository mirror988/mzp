package org.gulingjingguai.mzp.lesson.runoob.advancedStage;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MyHandler extends DefaultHandler {

    private ArrayList<String> excel_name=new ArrayList<>();

    private ArrayList<String> field_key = new ArrayList<>();

    private String nodeName;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析...");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        for (int i = 0; i < excel_name.size(); i++) {
            String tempStr = "<column property=\"";
            tempStr = tempStr + field_key.get(i);
            tempStr = tempStr + "\" name=\"";
            tempStr = tempStr + excel_name.get(i);
            tempStr = tempStr + "\" order=\"";
            tempStr = tempStr + (i + 1);
            tempStr = tempStr + "\"/>";
            System.out.println(tempStr);
        }
        System.out.println("结束解析...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nodeName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        nodeName = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch(nodeName){
            case "excel_name": excel_name.add(new String(ch,start,length));break;
            case "field_key": field_key.add(new String(ch,start,length));break;
        }
    }
}

