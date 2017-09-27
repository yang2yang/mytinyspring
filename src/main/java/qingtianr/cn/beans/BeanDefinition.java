package qingtianr.cn.beans;

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

    /**
     * 之前没发现,而且没有测试，这个版本测试了，就发现少了这一步
     * 这个肯定是在new的时候就会创建出来了，但是如果使用反射呢,而且和构造函数的区别有吗
     */
    private PropertyValues propertyValues = new PropertyValues();

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

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
