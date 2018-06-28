package gg.letsgo.boutframework.factory;

import gg.letsgo.boutframework.BeanDefinition;

public interface BeanFactory {
    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);

}
