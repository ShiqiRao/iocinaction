package gg.letsgo.boutframework.factory;

import gg.letsgo.boutframework.BeanDefinition;

import java.lang.reflect.Field;
import java.util.Map;

public class AutowiredCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(BeanDefinition beanDefinition) {
        Object bean = createBeanInstance(beanDefinition);
        applyProperties(bean, beanDefinition);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void applyProperties(Object bean, BeanDefinition beanDefinition) {
        for (Map.Entry entry : beanDefinition.getProperties().getPropertyMap().entrySet()) {
            try {
                Field field = bean.getClass().getDeclaredField((String) entry.getKey());
                field.setAccessible(true);
                field.set(bean, entry.getValue());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
