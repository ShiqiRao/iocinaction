package gg.letsgo.boutframework;

import gg.letsgo.boutframework.beans.BeanDefinition;
import gg.letsgo.boutframework.beans.factory.AbstractBeanFactory;
import gg.letsgo.boutframework.beans.factory.AutowiredCapableBeanFactory;
import gg.letsgo.boutframework.beans.io.ResourceLoader;
import gg.letsgo.boutframework.beans.xml.XMLBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {
    @Test
    public void testLazyInit() throws Exception {
        //读取配置
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("ApplicationContext.xml");
        //注册Bean
        AbstractBeanFactory beanFactory = new AutowiredCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }
        //获取Bean
        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("HelloWorld");
        helloWorld.helloWorld();
    }

    @Test
    public void testPreInit() throws Exception {
        //读取配置
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("ApplicationContext.xml");
        //注册Bean
        AbstractBeanFactory beanFactory = new AutowiredCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }
        //预加载
        beanFactory.preInstantiateSingletons();
        //获取Bean
        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("HelloWorld");
        helloWorld.helloWorld();
    }
}
