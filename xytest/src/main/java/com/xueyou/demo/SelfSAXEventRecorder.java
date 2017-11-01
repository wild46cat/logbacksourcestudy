package com.xueyou.demo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by wuxueyou on 2017/11/1.
 */
public class SelfSAXEventRecorder extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println("startElement:" + "\t" + uri + "\t" + localName + "\t" + qName + "\t"  +  attributes.getValue("name"));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("endElement:" + "\t" + uri + "\t" + localName + "\t" + qName + "\t");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String bodyStr = new String(ch, start, length);
        System.out.println("bodyStr" + "\t" + bodyStr);
    }
}
