package gg.letsgo.boutframework;

import gg.letsgo.boutframework.factory.AutowiredCapableBeanFactory;
import gg.letsgo.boutframework.factory.BeanFactory;
import gg.letsgo.boutframework.io.ResourceLoader;
import gg.letsgo.boutframework.xml.XMLBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {
    @Test
    public void testBeanFactory() throws Exception {


        AbstractBeanDefinitionReader beanDefinitionReader = new XMLBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinition("ApplicationContext.xml");
        BeanFactory beanFactory = new AutowiredCapableBeanFactory();
        for (Map.Entry entry : beanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition((String) entry.getKey(), (BeanDefinition) entry.getValue());
        }


        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("HelloWorld");
        helloWorld.helloWorld();
    }
}
