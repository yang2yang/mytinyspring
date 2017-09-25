package qingtianr.cn;

/**
 * Created by jack on 2017/9/25.
 */

/**
 * 这个类的定位是？？
 * 为什么不直接使用BeanDefinition来抽象类的引用，而是又创建一个新的类
 */
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
