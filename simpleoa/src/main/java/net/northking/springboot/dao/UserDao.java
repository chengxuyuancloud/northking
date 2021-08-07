package net.northking.springboot.dao;

import net.northking.springboot.entities.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserDao {
    User verifyUser(String userName);

    void insert(User user);
}
