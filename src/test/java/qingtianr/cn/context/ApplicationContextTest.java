package qingtianr.cn.context;

import org.junit.Test;
import qingtianr.cn.HelloWorldService;

/**
 * Created by jack on 2017/9/27.
 */
public class ApplicationContextTest {

    /**
     * 跟BeanFactoryTest里面比较了一下，好像Application就是将xml读取bean的扫描器
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mytinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloworld();
    }
}
