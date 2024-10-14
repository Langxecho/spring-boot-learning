package top.langxecho.springboot.service;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.langxecho.springboot.entity.User;
import top.langxecho.springboot.mapper.UserMapper;


import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    // 创建用户，自动填充创建时间和更新时间
    public boolean createUser(User user) {
        return this.save(user);
    }

    // 更新用户，自动填充更新时间
    public boolean updateUser(User user) {
        return this.updateById(user);
    }

    // 逻辑删除用户
    public boolean deleteUserById(Long id) {
        // 使用逻辑删除
        return this.removeById(id);
    }

    // 根据ID查询用户
    public User getUserById(Long id) {
        // 查询单个用户
        return this.getById(id);
    }

    // 按名字模糊查询用户
    public List<User> getUsersByName(String name) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 查询未逻辑删除的数据
        queryWrapper.like(User::getName, name).eq(User::getDeleted, 0);
        return this.list(queryWrapper);
    }

    // 分页查询用户
    public IPage<User> getUsersByPage(int currentPage, int pageSize) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 查询未逻辑删除的数据
        queryWrapper.eq(User::getDeleted, 0);
        return this.page(new Page<>(currentPage, pageSize), queryWrapper);
    }
}