package qingtianr.cn;

/**
 * Created by jack on 2017/9/16.
 */

/**
 * 目前来看还只是一个简单的Bean对象
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean(){
        return bean;
    }
}
