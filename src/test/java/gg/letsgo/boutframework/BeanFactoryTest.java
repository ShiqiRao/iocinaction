package gg.letsgo.boutframework;

import gg.letsgo.boutframework.factory.AutowiredCapableBeanFactory;
import gg.letsgo.boutframework.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {
    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = new AutowiredCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("gg.letsgo.boutframework.HelloWorld");
        beanFactory.registerBeanDefinition("HelloWorld", beanDefinition);

        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("HelloWorld");
        helloWorld.helloworld();
    }
}
