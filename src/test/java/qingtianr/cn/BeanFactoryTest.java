package qingtianr.cn;

import org.junit.Test;

/**
 * Created by jack on 2017/9/23.
 */
public class BeanFactoryTest {

    @Test
    public void Test(){
        //1.初始化BeanFactory对象
        BeanFactory beanFactory = new BeanFactory();

        //2.注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloworldservice",beanDefinition);

        //3.获取Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloworldservice");
        helloWorldService.helloworld();
    }
}
