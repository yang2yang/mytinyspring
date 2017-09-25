package qingtianr.cn.factory;

import qingtianr.cn.BeanDefinition;
import qingtianr.cn.BeanReference;
import qingtianr.cn.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by jack on 2017/9/23.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = createBeanInstance(beanDefinition);
        //奇怪了，之前这句话一直都是没有的吗？
        //之前是放在了外面 AbstractBeanFactory 类里面
        beanDefinition.setBean(bean);
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
            //这个value是一个对象？而且是有类型的？先把其他的部分的代码给敲好吧
            Object value = propertyValue.getValue();
            if(value instanceof BeanReference){
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            field.set(bean,value);
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
