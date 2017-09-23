package qingtianr.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 2017/9/23.
 */

/**
 * 听说这里不直接使用List的原因是因为可以封装一些操作，目前来看好像并没有封装什么操作
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues(){

    }

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues(){
        return this.propertyValueList;
    }
}
