package gg.letsgo.boutframework;

import java.io.IOException;

public interface BeanDefinitionReader {
    void loadBeanDefinition(String location) throws Exception;
}
