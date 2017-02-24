package com.efly.service;

import com.efly.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Nic on 2017/2/22.
 * 增删改查
 */
public interface UserService {
    /**
     * 新增用户
     * @param username
     * @param password
     * @return
     */
    public int insertUser(@Param(value = "username") String username , @Param(value = "password") String password);

    /**
     * 修改用户
     * @param user
     * @param id
     * @return
     */
    public int updateUser(User user , int id);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUser(int id);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public User selectUserById(int id);

    /**
     * 查询所有的用户信息
     * @return
     */
    public List<User> selectAllUser();

    /**
     * 查询用户(用来验证登录)
     * @param username
     * @param password
     * return
     */
    public User selectCheckUser(@Param(value = "username") String username , @Param(value = "password") String password);
}
