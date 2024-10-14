package top.langxecho.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FamilyTest {

    @Resource
    Family family;
    @Test
    void familyMessage() {
        System.out.println(family);
    }
}