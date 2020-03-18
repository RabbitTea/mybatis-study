package com.sandra.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 由SqlSessionFactoryBuilder通过建造者模式构造SqlSessionFactory，
 * 再由SqlSessionFactory通过工厂模式构造SqlSession；
 * SqlSessionFactory为工厂，用于创建特定类对象；
 * SqlSession包含了面向数据库执行SQL的所有方法；
 * 总结：SqlSessionFactoryBuilder->SqlSessionFactory->SqlSession
 */
public class MybatisUtil {

    /**
     * 这一步的作用是提升作用域
     * （因try...catch块包围的局部变量在其他地方不能被使用）
     */
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用mybatis第一步：获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 封装获取SqlSession的方法
     * （将框架提供的接口封装为自用的函数）
     * @return
     */
    public static SqlSession getSqlSession() {

        /**
         * autoCommit设置为true，开启自动提交事务
         */
        return sqlSessionFactory.openSession(true);
    }
}
