package top.langxecho.springboot.websocket.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonTest {
    @Resource
    Person person;
    @Test
    void showPerson() {
        System.out.println(person);
    }
}