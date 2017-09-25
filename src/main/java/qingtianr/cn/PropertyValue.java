package qingtianr.cn;

/**
 * Created by jack on 2017/9/23.
 */

/**
 * 抽象bean的属性，属性拥有一个名字和值，名字是字符类型的，value是一个object，必须是对象，而且是任意对象
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
