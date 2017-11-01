package com.xueyou.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wuxueyou on 2017/10/25.
 */
public class App {
    public static Logger logger = LoggerFactory.getLogger("xytestAppLogger");
    public static void main(String[] args) {
        System.out.println(123);
        logger.info("sdfsdfsdf");
    }
}
