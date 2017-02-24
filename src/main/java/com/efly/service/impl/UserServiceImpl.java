package com.efly.service.impl;

import com.efly.mapper.UserMapper;
import com.efly.pojo.User;
import com.efly.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nic on 2017/2/22.
 * UserService接口实现
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(@Param(value = "username") String username, @Param(value = "password") String password) {
        return  userMapper.insertUser(username, password);
    }

    @Override
    public int updateUser(User user, int id) {
        return userMapper.updateUser(user , id);
    }

    @Override
    public boolean deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public User selectUserById(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User selectCheckUser(@Param(value = "username") String username, @Param(value = "password") String password) {
        return userMapper.selectCheckUser(username, password);
    }
}
