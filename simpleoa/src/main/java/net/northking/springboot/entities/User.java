package net.northking.springboot.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private String role;

    /**
     * 组
     */
    private String groupId;

    /**
     * 团队
     */
    private String teamId;

    private static final long serialVersionUID = 1L;
}