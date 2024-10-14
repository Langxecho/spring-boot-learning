package top.langxecho.springboot.thymeleaf.quickstart.service;

import org.springframework.stereotype.Service;
import top.langxecho.springboot.thymeleaf.quickstart.entity.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/2 18:47
 */
@Service
public class UserService {
    private final List<User> users = List.of(
            new User(1L,"张三",22),
            new User(1L,"张四",23),
            new User(1L,"张五",24),
            new User(1L,"张六",25)
    );

    public List<String> getAdultUserName(){
        return users.stream()
                .filter(user -> user.getAge() > 18)
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
