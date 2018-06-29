package gg.letsgo.boutframework.xml;

import gg.letsgo.boutframework.AbstractBeanDefinitionReader;
import gg.letsgo.boutframework.BeanDefinitionReader;
import gg.letsgo.boutframework.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;

import static org.junit.Assert.*;

public class XMLBeanDefinitionReaderTest {

    @Test
    public void loadBeanDefinition() throws Exception {
        AbstractBeanDefinitionReader beanDefinitionReader = new XMLBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinition("ApplicationContext.xml");
        Assert.assertTrue(beanDefinitionReader.getRegistry().size() > 0);
    }
}