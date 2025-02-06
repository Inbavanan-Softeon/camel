package aggregate.camel;

import org.apache.camel.spring.Main;
/**
 * A Camel Application
 */

public class MainApp {
    public static void main(String[] args) throws Exception {
    	Main m = new Main();
		m.setApplicationContextUri("META-INF/spring/camel-context1.xml");
		m.start();
		Thread.sleep(100000);
		m.stop();

    }
}

