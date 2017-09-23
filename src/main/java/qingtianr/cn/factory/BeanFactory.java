package qingtianr.cn.factory;

import qingtianr.cn.BeanDefinition;

/**
 * Created by jack on 2017/9/23.
 */
public interface BeanFactory {

    /**
     * 获得Bean的接口
     * @return
     */
    public Object getBean(String name);


    /**
     * 注册Bean  普通对象被封装到BeanDefinition中
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
