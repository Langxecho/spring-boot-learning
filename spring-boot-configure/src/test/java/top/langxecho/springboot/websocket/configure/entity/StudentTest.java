package top.langxecho.springboot.websocket.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentTest {
    @Resource
    private Student student;

    @Test
    void studentMes() {
        System.out.println(student);
    }
}