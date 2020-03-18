package com.sandra.dao;

import java.util.List;

import com.sandra.pojo.User;

/**
 * 传统数据库操作（JDBC）：
 * Dao接口的实现类；
 * 编写具体的执行SQL语句的代码（会冗余和重复）；
 */
public class UserDaoImpl implements UserDao{

    public List<User> getJDBCUserList() {

        //执行sql语句
        String sql = "select * from user";

        return null;
    }
}
