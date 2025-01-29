package com.splitter.camel_splitter;

import org.apache.camel.spring.Main;

/**
 * A Camel Application
 */

public class MainApp {
    public static void main(String[] args) throws Exception {
    	Main m = new Main();
		m.setApplicationContextUri("META-INF/spring/camel-context4.xml");
		m.start();
		Thread.sleep(20000);
		m.stop();

    }
}


