package net.northking.springboot.service.impl;

import net.northking.springboot.dao.UserDao;
import net.northking.springboot.entities.User;
import net.northking.springboot.service.UserService;
import net.northking.springboot.util.SaltUtil;
import net.northking.springboot.util.ShiroConstant;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        // 生成随机盐
        String salt = SaltUtil.getSalt(ShiroConstant.SALT_LENGTH);
        // 生成密码
        Md5Hash password = new Md5Hash(user.getPassword(), "8", ShiroConstant.HASH_ITERATORS);
        // 保存密码
        user.setPassword(password.toHex());
        userDao.insert(user);
    }

    @Override
    public User findUserByUserName(String userName) {
        User user = userDao.verifyUser(userName);
        return user;
    }
}
