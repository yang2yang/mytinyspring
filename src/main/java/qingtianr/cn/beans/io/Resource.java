package qingtianr.cn.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jack on 2017/9/24.
 */

/**
 * Resouce听说是spring内部定位资源的接口
 * 作为所有资源的一个抽象
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
