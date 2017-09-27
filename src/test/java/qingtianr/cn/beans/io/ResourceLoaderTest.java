package qingtianr.cn.beans.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by jack on 2017/9/24.
 */
public class ResourceLoaderTest {

    @Test
    public void test() throws Exception{
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("mytinyioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }

}
