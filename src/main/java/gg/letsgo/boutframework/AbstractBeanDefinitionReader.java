package gg.letsgo.boutframework;

import gg.letsgo.boutframework.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    protected Map<String, Object> registry;

    protected ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, Object> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
