package camel.twoxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String... args) throws Exception {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/RouteRefIncludeXmlFileTest.xml")) {
            System.out.println("Application context started.");
            Thread.sleep(5000); // Allow Camel to process the timer route
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Application context closed.");
    }
}

