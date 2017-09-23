package qingtianr.cn;

/**
 * Created by jack on 2017/9/23.
 */
public class PropertyValue {
    //看来final类型只能在构造函数中进行初始化了吧
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
