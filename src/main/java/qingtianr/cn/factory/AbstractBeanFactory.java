package qingtianr.cn.factory;

import qingtianr.cn.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jack on 2017/9/23.
 */

/**
 * 将取出Bean   注入Bean给抽象出来
 * 实现类实现doCreateBean方式,但是如果只有一个实现类，那么其实意义也不是非常大
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * 这里直接在new，和其他方式有sm区别，好像是有什么启动顺序的区别的吧?
     */
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    /**
     * 获得bean实例
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        //什么情况下会触发这个情况呢,如果代码正常运转应该不会触发这个if
        //其实这算是一个懒加载吧，只在使用的使用真正创建这个bean，原来的思路是在register的时候直接创建实例对象
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    /**
     * 因为是懒加载，所以这里原来注册的时候就初始化bean的操作，放入了getBean中
     * @param name
     * @param beanDefinition
     * @throws Exception
     */
    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    /**
     * 这个函数是啥意思？woc，看不懂，好像是把目前所有的beandefinition都进行实例化
     * 其实是如果调用这个函数就预加载
     * @throws Exception
     */
    public void preInstantiateSingletons() throws Exception {
        for (Iterator iterator = this.beanDefinitionNames.iterator(); iterator.hasNext(); ) {
            String beanName = (String) iterator.next();
            getBean(beanName);
        }
    }

    /**
     * 使用反射创建真正的Bean对象
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
