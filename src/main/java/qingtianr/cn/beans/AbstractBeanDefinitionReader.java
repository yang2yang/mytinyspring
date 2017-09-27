package qingtianr.cn.beans;


import qingtianr.cn.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jack on 2017/9/24.
 */

/**
 * 抽象自动读取Bean的抽象类
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private Map<String,BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader){
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String,BeanDefinition> getRegistry(){
        return this.registry;
    }

    public ResourceLoader getResourceLoader(){
        return this.resourceLoader;
    }

}
