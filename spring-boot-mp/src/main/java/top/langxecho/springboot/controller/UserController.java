package top.langxecho.springboot.controller;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/14 14:32
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.entity.User;
import top.langxecho.springboot.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 创建用户
    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        boolean result = userService.createUser(user);
        return result ? "用户创建成功" : "用户创建失败";
    }

    // 更新用户
    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        boolean result = userService.updateUser(user);
        return result ? "用户更新成功" : "用户更新失败";
    }

    // 删除用户（逻辑删除）
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        boolean result = userService.deleteUserById(id);
        return result ? "用户删除成功" : "用户删除失败";
    }

    // 根据ID查询用户
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 按名字模糊查询用户
    @GetMapping("/name")
    public List<User> getUsersByName(@RequestParam String name) {
        return userService.getUsersByName(name);
    }

    // 分页查询用户
    @GetMapping("/page")
    public IPage<User> getUsersByPage(@RequestParam int currentPage, @RequestParam int pageSize) {
        return userService.getUsersByPage(currentPage, pageSize);
    }
}