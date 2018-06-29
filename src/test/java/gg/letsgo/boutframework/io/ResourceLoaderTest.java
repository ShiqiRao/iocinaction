package gg.letsgo.boutframework.io;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class ResourceLoaderTest {

    @Test
    public void getResource() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("ApplicationContext.xml");
        assertNotNull("读取配置文件失败", resource.getInputStream());
    }
}