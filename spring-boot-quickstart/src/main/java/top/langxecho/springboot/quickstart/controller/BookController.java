package top.langxecho.springboot.quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.quickstart.dto.BookDTO;
import top.langxecho.springboot.quickstart.service.BookService;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/2 16:04
 */
@RestController
public class BookController {
    @Resource
    BookService service;

    @GetMapping("/getBooks")
    public List<BookDTO> getBookMessage(){
        return service.getAllBooks();
    }
}
