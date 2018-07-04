package gg.letsgo.boutframework.context;

import gg.letsgo.boutframework.beans.BeanDefinition;
import gg.letsgo.boutframework.beans.factory.AbstractBeanFactory;
import gg.letsgo.boutframework.beans.factory.AutowiredCapableBeanFactory;
import gg.letsgo.boutframework.beans.io.ResourceLoader;
import gg.letsgo.boutframework.beans.xml.XMLBeanDefinitionReader;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String cofingLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowiredCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory abstractBeanFactory) throws Exception {
        super(abstractBeanFactory);
        this.cofingLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition(cofingLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
