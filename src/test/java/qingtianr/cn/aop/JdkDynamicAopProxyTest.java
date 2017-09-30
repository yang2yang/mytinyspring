package qingtianr.cn.aop;

import org.junit.Test;
import qingtianr.cn.HelloWorldService;
import qingtianr.cn.context.ApplicationContext;
import qingtianr.cn.context.ClassPathXmlApplicationContext;

/**
 * Created by jack on 2017/9/27.
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void testIntercepter() throws Exception{
        // --------helloWorldService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mytinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloworld();

        //1.设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        //2.设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        //3.创建代理
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();

        //4.基于AOP的调用
        helloWorldServiceProxy.helloworld();
    }
}
