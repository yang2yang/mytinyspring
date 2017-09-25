package qingtianr.cn;

import org.junit.Test;
import qingtianr.cn.factory.AbstractBeanFactory;
import qingtianr.cn.factory.AutowireCapableBeanFactory;
import qingtianr.cn.factory.BeanFactory;
import qingtianr.cn.io.ResourceLoader;
import qingtianr.cn.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Created by jack on 2017/9/23.
 */
public class BeanFactoryTest {

    /**
     * 测试懒加载
     *
     * @throws Exception
     */
    @Test
    public void testLazy() throws Exception {
        //1.读取配置
        //必须使用抽象类才可以获得抽象类里面的属性，这样来说，那么其实接口也没啥用处了
        AbstractBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("mytinyioc.xml");

        //2.初始化BeanFactory并注册bean
        //这里果然有一个过程就是将xml里面的东西放入到factory中
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

        //3.获取bean
        //这里好像有循环依赖的问题啊
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloworld();
        System.out.println("1" + (helloWorldService.getOutputService() == null));
        System.out.println("2" + (helloWorldService.getOutputService().getHelloWorldService() == null));
        System.out.println("3" + (helloWorldService.getOutputService().getHelloWorldService().getOutputService() == null));
        OutputService outputService = (OutputService) beanFactory.getBean("outputService");
        System.out.println("out1" + (outputService.getHelloWorldService() == null));
        System.out.println("out2" + (outputService.getHelloWorldService().getOutputService() == null));
        System.out.println("out3" + (outputService.getHelloWorldService().getOutputService().getHelloWorldService() == null));
    }

    /**
     * 测试预加载
     *
     * @throws Exception
     */
    @Test
    public void testPreInstantiate() throws Exception{
        //1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("mytinyioc.xml");

        //2.初始化BeanFactory
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

        beanFactory.preInstantiateSingletons();

        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloworld();

    }

}