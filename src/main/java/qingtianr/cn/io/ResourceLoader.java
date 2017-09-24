package qingtianr.cn.io;

import java.net.URL;

/**
 * Created by jack on 2017/9/24.
 */

/**
 * 资源加载器
 * 其实如果有多个资源加载器，可能也是需要一个接口来进行进一步的抽象
 */
public class ResourceLoader {

    /**
     * 今天刚学的，使用classloader获得相对于classpath下面的文件信息
     * @param location 应该是相对于classpath的地址信息
     * @return
     */
    public Resource getResource(String location){
        URL resouce = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resouce);
    }

}
