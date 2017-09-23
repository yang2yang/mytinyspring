package qingtianr.cn.factory;

import qingtianr.cn.BeanDefinition;

/**
 * Created by jack on 2017/9/23.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try{
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        //会不会走到这一步null呢？如果抛出了异常
        return null;
    }
}
