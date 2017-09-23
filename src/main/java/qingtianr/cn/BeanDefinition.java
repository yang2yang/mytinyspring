package qingtianr.cn;

/**
 * Created by jack on 2017/9/16.
 */

/**
 * 目前来看还只是一个简单的Bean对象
 */
public class BeanDefinition {

    private Object bean;

    /**
     * 开始封装一些Object中的beanClass等信息
     */
    private Class beanClass;

    /**
     * 应该是类的绝对路径的信息，但是是不是Class中也存放了这个信息呢
     */
    private String beanClassName;

    public BeanDefinition() {
    }


    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try{
            this.beanClass = Class.forName(beanClassName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
