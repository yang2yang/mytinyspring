package qingtianr.cn;

import org.junit.Test;
import qingtianr.cn.factory.AutowireCapableBeanFactory;
import qingtianr.cn.factory.BeanFactory;

/**
 * Created by jack on 2017/9/23.
 */
public class BeanFactoryTest {

    @Test
    public void Test() throws Exception {
        //1.初始化BeanFactory对象
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        //2.注入Bean
        BeanDefinition beanDefinition = new BeanDefinition();
        //虽然将new操作通过反射给放入到厘米了，但是这里还是需要显示地传入类的全路径名字
        beanDefinition.setBeanClassName("qingtianr.cn.HelloWorldService");

        PropertyValue propertyValue = new PropertyValue("text","hello worldddddd!");
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(propertyValue);
        beanDefinition.setPropertyValues(propertyValues);

        //注入Bean
        beanFactory.registerBeanDefinition("helloworldservice",beanDefinition);

        //3.获取Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloworldservice");
        helloWorldService.helloworld();
    }
}
