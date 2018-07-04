package gg.letsgo.boutframework.context;

import gg.letsgo.boutframework.HelloWorld;
import org.junit.Test;

public class ClassPathXmlApplicationContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HelloWorld helloWorldService = (HelloWorld) applicationContext.getBean("HelloWorld");
        helloWorldService.helloWorld();
    }
}