package top.langxecho.springboot.websocket.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FamilyTest {

    @Resource
    Family family;
    @Test
    void familyMessage() {
        System.out.println(family);
    }
}