package qingtianr.cn;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jack on 2017/9/17.
 */

/**
 * Bean工厂 里面有所有的BeanDefinition对象
 */
public class BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 将Bean注入到Factory中
     * @param name 是不是相当于ID
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }

}
