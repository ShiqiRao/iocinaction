package gg.letsgo.boutframework;

import org.junit.Test;

public class BeanFactoryTest {
    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorld());
        beanFactory.registerBean("HelloWorld", beanDefinition);

        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("HelloWorld");
        helloWorld.helloworld();
    }
}
