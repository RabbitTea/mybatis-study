package com.sandra.dao;

import com.sandra.pojo.User;

/**
 * Mybatis数据库操作：
 * Mapper接口；
 * 对应原来的Dao层；
 *
 * 注意：接口命名和mapper.xml配置文件的命名要一致，且放在同一个包下，才能通过 <映射器接口实现类的完全限定类名>来绑定一个xml配置
 */
public interface UserMapper {

    /**
     * 根据id查询用户
     * @param id
     * @return User
     */
    User getUserById(int id);
}
