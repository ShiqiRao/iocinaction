package gg.letsgo.boutframework.xml;

import gg.letsgo.boutframework.AbstractBeanDefinitionReader;
import gg.letsgo.boutframework.BeanDefinition;
import gg.letsgo.boutframework.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;

public class XMLBeanDefinitionReader extends AbstractBeanDefinitionReader {

    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

    public XMLBeanDefinitionReader(ResourceLoader resourceLoader) throws ParserConfigurationException {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinition(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        loadBeanDefinition(inputStream);
    }

    private void loadBeanDefinition(InputStream inputStream) throws Exception {
        Document document = builder.parse(inputStream);
        Element element = document.getDocumentElement();
        registerBeanDefinition(element);
    }

    private void registerBeanDefinition(Element element) {
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) processBeanDefinition((Element) node);
        }
    }

    private void processBeanDefinition(Element element) {
        String name = element.getAttribute("name");
        String className = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(element,beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name,beanDefinition);
    }

    private void processProperty(Element element, BeanDefinition beanDefinition) {
        NodeList propertyNode = element.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                beanDefinition.getProperties().addProperty(name, value);
            }
        }
    }
}
