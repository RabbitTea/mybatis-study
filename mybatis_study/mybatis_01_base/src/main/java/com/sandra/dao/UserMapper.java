package com.sandra.dao;

import java.util.List;
import java.util.Map;

import com.sandra.pojo.User;

/**
 * Mybatis数据库操作：
 * Mapper接口；
 * 对应原来的Dao层；
 */
public interface UserMapper {

    /**
     * 查询全部用户
     * @return List<User>
     */
    List<User> getUserList();

    /**
     * 根据id查询用户
     * @param id
     * @return User
     */
    User getUserById(int id);

    /**
     * 万能的Map（查询用户）(不一定根据id查询了，可设置多个匹配条件)
     * @param map
     * @return User
     */
    User getUserByMap(Map<String, Object> map);

    /**
     * 插入一个用户
     * @param user
     * @return int
     */
    int addUser(User user);

    /**
     * 万能的Map (代替原来的传参User)（插入一个用户）
     * @param map
     * @return int
     */
    int addUser2(Map<String, Object> map);

    /**
     * 修改一个用户
     * @param user
     * @return int
     */
    int updateUser(User user);

    /**
     * 删除一个用户
     * @param id
     * @return int
     */
    int deleteUser(int id);

    /**
     * 模糊查询
     * @param value
     * @return List<User>
     */
    List<User> getUserLike(String value);
}
