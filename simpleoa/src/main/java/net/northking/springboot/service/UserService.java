package net.northking.springboot.service;

import net.northking.springboot.entities.User;

public interface UserService {
    /**
     * 用户注册
     * @param user
     */
    void register(User user);
    /**
     * 根据用户名获取用户
     */
    User findUserByUserName(String userName);
}
