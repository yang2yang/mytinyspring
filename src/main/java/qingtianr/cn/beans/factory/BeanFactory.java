package qingtianr.cn.beans.factory;

import qingtianr.cn.beans.BeanDefinition;

/**
 * Created by jack on 2017/9/23.
 */
public interface BeanFactory {

    /**
     * 获得Bean的接口
     * @return
     */
    public Object getBean(String name) throws Exception;
}
