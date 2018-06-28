package gg.letsgo.boutframework.xml;

import gg.letsgo.boutframework.AbstractBeanDefinitionReader;
import gg.letsgo.boutframework.BeanDefinition;
import gg.letsgo.boutframework.io.ResourceLoader;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class XMLBeanDefinitionReader extends AbstractBeanDefinitionReader {

    protected DocumentBuilder docBuilder;

    public XMLBeanDefinitionReader(ResourceLoader resourceLoader) throws Exception {
        super(resourceLoader);
        docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    @Override
    public BeanDefinition loadBeanDefinition(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        return loadBeanDefinition(inputStream);
    }

    public BeanDefinition loadBeanDefinition(InputStream inputStream) throws Exception {
        Document document = docBuilder.parse(inputStream);

    }




}
