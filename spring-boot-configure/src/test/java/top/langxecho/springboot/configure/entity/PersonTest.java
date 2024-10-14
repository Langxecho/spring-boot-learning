package top.langxecho.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonTest {
    @Resource
    Person person;
    @Test
    void showPerson() {
        System.out.println(person);
    }
}