package com.sandra.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandra.pojo.User;
import com.sandra.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void getUserList() {
        // 传统的数据库操作要获取PrepareStatement去执行SQL语句

        /**初始代码
         */
        // mybatis数据库操作获取SqlSession即可（可使用项目中封装的方法）
        // 1.得到SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        if (sqlSession == null) {
            System.out.println("sqlSession is null");
            return;
        }

        // 2.找到sql执行语句（Mapper接口和mapper.xml是一致的，一般通过接口获取）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 3.执行sql
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        // 4.关闭SqlSession
        sqlSession.close();

        /**
         * 按官网建议的try-with-resources语法糖来优化代码，避免每次由开发者手动关闭资源;
         * 前提是MybatisUtil类实现AutoClosable接口，重写close方法
         * https://juejin.im/entry/57f73e81bf22ec00647dacd0
         */
        /*
        try(SqlSession sqlSession = MybatisUtil.getSqlSession()) {
            if (sqlSession = null) {
                System.out.println("sqlSession is null");
                return;
            }
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e){
           e.printStackTrace();
        }
        */
    }

    @Test
    public void getUserById() {
        int id = 2;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(id);
        System.out.println(user);

        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 增删改需要提交事务
     */
    @Test
    public void addUser() {
        User user = new User(4, "赵六", "101");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int addResult = userMapper.addUser(user);

        if (addResult == 1) {
            System.out.println("插入用户成功 {" + user.toString() + "}");
        } else {
            System.out.println("插入用户失败 {" + user.toString() + "}");
        }

        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        User user = new User(4, "李六", "110");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int updateRes = userMapper.updateUser(user);

        if (updateRes > 0) {
            System.out.println("修改用户成功 {" + user.toString() + "}");
        } else {
            System.out.println("修改用户失败 {" + user.toString() + "}");
        }

        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        int id = 4;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int deleteRes = userMapper.deleteUser(id);
        if (deleteRes > 0) {
            System.out.println("删除用户成功：id=" + id);
        } else {
            System.out.println("删除用户失败");
        }

        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //注意这种map实例化写法
        Map<String, Object> map = new HashMap<>();
        map.put("userid", 4);
        map.put("username", "赵六");
        map.put("userpassword", "233");
        int addRes = userMapper.addUser2(map);

        if(addRes > 0) {
            System.out.println("使用map插入用户成功");
        } else {
            System.out.println("使用map插入用户失败");
        }

        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserByMap() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("userid", 2);
        map.put("username", "李四");
        User user = userMapper.getUserByMap(map);

        System.out.println("user = " + user.toString());

        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 模糊查询测试
     */
    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //模糊查询值加上%号
        String value = "%李%";
        List<User> userList = userMapper.getUserLike(value);
        System.out.println(userList.size());

        for (User user : userList) {
            System.out.println(user.toString());
        }

        //关闭sqlSession
        sqlSession.close();
    }
}
