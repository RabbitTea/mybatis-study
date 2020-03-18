package com.sandra.dao;

import com.sandra.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * User数据操作接口
 */
public interface UserMapper {

    /**
     * 根据id查询用户
     */
    User queryUserById(@Param("id") int id);
}
