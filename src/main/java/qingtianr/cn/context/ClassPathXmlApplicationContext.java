package qingtianr.cn.context;

import qingtianr.cn.beans.BeanDefinition;
import qingtianr.cn.beans.factory.AbstractBeanFactory;
import qingtianr.cn.beans.factory.AutowireCapableBeanFactory;
import qingtianr.cn.beans.io.ResourceLoader;
import qingtianr.cn.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Created by jack on 2017/9/27.
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    /**
     * 可以选择传递一个beanFactory的类对象
     * @param configLocation
     * @param beanFactory
     * @throws Exception
     */
    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    /**
     * 如果说这里refresh里面调用了xmlBeanDefinitionReader，那么其实本质上Application还是一个BeanFactory
     * @throws Exception
     */
    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }

}
