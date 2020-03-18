package com.sandra.dao;

import java.util.List;

import com.sandra.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Mybatis数据库操作：
 * Mapper接口；
 * 对应原来的Dao层；
 *
 * 注意：接口命名和mapper.xml配置文件的命名要一致，且放在同一个包下，才能通过 <映射器接口实现类的完全限定类名>来绑定一个xml配置
 */
public interface UserMapper {

    /**
     * 查询全部用户；
     * 使用注解开发
     * @return List<User>
     */
    @Select("select * from mybatis.user")
    List<User> getUserList();

    /**
     * 根据id查询用户；
     * 使用注解开发；
     * 基本类型参数前加@param注解是规范，方法存在多个参数一定要加，引用类型不需要加；
     * @param id
     * @return User
     */
    @Select("select * from mybatis.user where id=#{uid}")
    User getUserById(@Param("uid") int id, @Param("name") String name);

    /**
     * 插入一个用户；
     * 使用注解开发
     * @param user
     * @return int
     */
    @Insert("insert into mybatis.user (id, name, pwd) values (#{id}, #{name}, #{pwd})")
    int addUser(User user);
}
