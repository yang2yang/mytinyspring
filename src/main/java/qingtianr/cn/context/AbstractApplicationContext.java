package qingtianr.cn.context;

import qingtianr.cn.beans.factory.AbstractBeanFactory;

/**
 * Created by jack on 2017/9/27.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {

    }

    @Override
    public Object getBean(String name) throws Exception{
        return beanFactory.getBean(name);
    }
}
