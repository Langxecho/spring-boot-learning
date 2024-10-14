package top.mqxu.springboot.configuration.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import top.langxecho.springboot.configure.service.TestBeanService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
@ContextConfiguration(locations = {"classpath:beans.xml"})  // 加载 beans.xml 配置文件
class TestBeanServiceTest {

    // 注入Spring上下文环境
    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    public void testLoadService() {
        // 测试Spring上下文环境中是否有testBeanService这样一个bean，有的话表示xml配置文件生效
        boolean flag = ioc.containsBean("testBeanService");
        assertTrue(flag);

        TestBeanService testBeanService = (TestBeanService) ioc.getBean("testBeanService");
        log.info(String.valueOf(testBeanService));
        assertEquals("SpringBoot", testBeanService.getName());
    }
}
