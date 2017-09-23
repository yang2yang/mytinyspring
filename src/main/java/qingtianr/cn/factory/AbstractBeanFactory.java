package qingtianr.cn.factory;

import qingtianr.cn.BeanDefinition;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jack on 2017/9/23.
 */

/**
 * 将 取出Bean   注入Bean给抽象出来
 * 实现类实现doCreateBean方式,但是如果只有一个实现类，那么其实意义也不是非常大
 */
public abstract class AbstractBeanFactory implements BeanFactory{

    /**
     * 这里直接在new，和其他方式有sm区别，好像是有什么启动顺序的区别的吧?
     */
    private ConcurrentHashMap<String,BeanDefinition> concurrentHashMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) {
        return concurrentHashMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        //应该吧BeanDefinition这个对象的构造函数改掉了，所以将Test外面的new操作，移动到这个doCreateBean里面来了
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        concurrentHashMap.put(name,beanDefinition);
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition);
}
