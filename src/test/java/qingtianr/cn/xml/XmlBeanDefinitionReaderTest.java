package qingtianr.cn.xml;

import org.junit.Assert;
import org.junit.Test;
import qingtianr.cn.BeanDefinition;
import qingtianr.cn.io.ResourceLoader;

import java.util.Map;

/**
 * Created by jack on 2017/9/24.
 */

/**
 * 这个test没有完整地使用到factory，估计factory要有所改变了，毕竟registry有一部分功能和factory有重叠
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("mytinyioc.xml");
        Map<String,BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
    }
}
