package top.langxecho.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.langxecho.springboot.quickstart.dto.BookDTO;

import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/2 16:03
 */
@Service
public class BookService {
    public List<BookDTO> getAllBooks(){
        return List.of(new BookDTO(1111,"java programme","Alice",29.99),
                new BookDTO(1111,"java programme","Alice",29.99));

    }
}
