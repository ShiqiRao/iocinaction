package gg.letsgo.boutframework;

import java.io.IOException;

public interface BeanDefinitionReader {
    BeanDefinition loadBeanDefinition(String location) throws IOException, Exception;
}
