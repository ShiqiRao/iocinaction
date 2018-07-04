package gg.letsgo.boutframework.beans.xml;

import gg.letsgo.boutframework.beans.AbstractBeanDefinitionReader;
import gg.letsgo.boutframework.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

public class XMLBeanDefinitionReaderTest {

    @Test
    public void loadBeanDefinition() throws Exception {
        AbstractBeanDefinitionReader beanDefinitionReader = new XMLBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinition("ApplicationContext.xml");
        Assert.assertTrue(beanDefinitionReader.getRegistry().size() > 0);
    }
}