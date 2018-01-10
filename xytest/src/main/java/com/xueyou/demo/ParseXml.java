package com.xueyou.demo;

import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by wuxueyou on 2017/11/1.
 */
public class ParseXml {
    public static String PROPERTIESFILENAME = "logback.xml";
    public static String systemId = "my-id";

    public static void main(String[] args) throws Exception {
        InputStream in = null;
        in = ParseXml.class.getClassLoader().getResourceAsStream(PROPERTIESFILENAME);
        InputSource inputSource = new InputSource(in);
        inputSource.setSystemId(systemId);

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(false);
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        SelfSAXEventRecorder selfSAXEventRecorder = new SelfSAXEventRecorder();
        saxParser.parse(inputSource, selfSAXEventRecorder);
    }
}
