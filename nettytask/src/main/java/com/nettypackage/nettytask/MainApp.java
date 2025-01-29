package com.nettypackage.nettytask;

import org.apache.camel.spring.Main;

/**
 * A Camel Application
 */

public class MainApp {
    public static void main(String[] args) throws Exception {
    	Main m = new Main();
		m.setApplicationContextUri("META-INF/spring/nettycity.xml");
		m.start();
		Thread.sleep(2000000);
		m.stop();

    }
}
