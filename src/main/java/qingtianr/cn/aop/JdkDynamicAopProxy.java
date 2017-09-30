package qingtianr.cn.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jack on 2017/9/27.
 */

/**
 * 基于jdk的动态代理，我记得好像是有两种动态代理的
 */

/**
 * 动态代理类
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler{

    /**
     * 切面？？
     */
    private AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised){
        this.advised = advised;
    }


    /**
     * 根据切面里面的类的原始数据，来获得动态代理对象
     * 动态代理对象，那么和直接使用对象.newInstance()有什么区别
     * @return
     */
    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{advised.getTargetSource().getTargetClass()},this);
    }

    /**
     * 这个函数用来实现Invocation接口，最后传递给getProxy()函数中
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),method,args));
    }


}