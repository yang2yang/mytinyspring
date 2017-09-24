package qingtianr.cn.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import qingtianr.cn.AbstractBeanDefinitionReader;
import qingtianr.cn.BeanDefinition;
import qingtianr.cn.PropertyValue;
import qingtianr.cn.io.ResourceLoader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by jack on 2017/9/24.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader){
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        //得到classpath下面文件的流对象
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception{
        //前面两句应该都是简单的使用api，第三句将inputstream这个流对象转换为Document对象，进行xml文件的解析
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        //解析Bean
        registerBeanDefinitions(document);
        inputStream.close();
    }

    /**
     * 如果只是简单地获得Element对象，这个函数是不是有点多余？
     * @param document
     */
    public void registerBeanDefinitions(Document document){
        Element root = document.getDocumentElement();

        parseBeanDefinitions(root);
    }

    /**
     * 初步地解析BeanDefinition,其实下面的几个方法都是一步步来的，一层层，像剥洋葱一样
     * @param root
     */
    protected void parseBeanDefinitions(Element root){
        NodeList nodeList = root.getChildNodes();
        for(int i = 0; i < nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Element element = (Element) node;
                processBeanDefinition(element);
            }
        }
    }

    /**
     * 通过解析xml文件，将className这个属性的设置移动到xmlBeanDefinitionReader里面来了
     * @param element
     */
    protected void processBeanDefinition(Element element) {
        //这里两句是获得两个属性
        String name = element.getAttribute("name");
        String className = element.getAttribute("class");
        //这里其实和Step3里面test部分的代码是一样的，干了一件事情，就是将className设置在beanDefinitioin里面
        //其实这样那么BeanDefinition的类定位也渐渐清晰起来了，就是包含一个bean的Object的实例，还有className之类的相关信息
        BeanDefinition beanDefinition = new BeanDefinition();
        //new 操作之后，使用两种set操作，将属性和className都放入到BeanDefinition中
        processProperty(element,beanDefinition);
        beanDefinition.setBeanClassName(className);
        //这个Registry的功能好像之前是factory在干的事情，之前是factory有一个map，现在也移动到beandefinitionreader里面来了吗
        getRegistry().put(name,beanDefinition);
    }

    /**
     * 这里也只是将xml里面的property的一些属性放入到BeanDefinition中
     * @param element
     * @param beanDefinition
     */
    private void processProperty(Element element, BeanDefinition beanDefinition){
        NodeList nodeList = element.getElementsByTagName("property");
        for(int i = 0; i < nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Element propertyElement = (Element) node;
                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
            }
        }
    }
}
