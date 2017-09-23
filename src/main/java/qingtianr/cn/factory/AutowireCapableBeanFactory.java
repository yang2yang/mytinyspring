package qingtianr.cn.factory;

import qingtianr.cn.BeanDefinition;
import qingtianr.cn.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by jack on 2017/9/23.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    /**
     * 使用反射将field注入
     * @param bean
     * @param beanDefinition
     */
    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
            Field field = bean.getClass().getDeclaredField(propertyValue.getName());
            field.setAccessible(true);
            field.set(bean,propertyValue.getValue());
        }
    }

    /**
     * 使用反射创建实例
     * @param beanDefinition
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }
}
