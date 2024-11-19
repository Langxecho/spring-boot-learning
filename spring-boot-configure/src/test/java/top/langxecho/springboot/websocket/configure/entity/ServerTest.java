package top.langxecho.springboot.websocket.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerTest {
    @Resource
    Server server;

    @Test
    void serverTest() {
        System.out.println(server);
    }
}