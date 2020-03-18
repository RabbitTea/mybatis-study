package com.sandra.dao;

import java.util.List;

import com.sandra.pojo.User;

/**
 * 传统数据库操作（JDBC）：
 * Dao接口
 */
public interface UserDao {

    List<User> getJDBCUserList();
}
