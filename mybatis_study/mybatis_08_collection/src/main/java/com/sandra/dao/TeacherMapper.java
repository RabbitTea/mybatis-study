package com.sandra.dao;

import com.sandra.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 老师实体类，需要的数据库操作
 */
public interface TeacherMapper {

    /**
     * 根据id查询老师；
     * 注解方式
     * @param id
     * @return
     */
    //@Select("select * from teacher where id = #{tid}")
    //Teacher getTeacher(@Param("tid") int id);

    /**
     * 获取指定老师，包含其下的所有学生；
     * 方式二：按结果嵌套处理；
     * @param id
     * @return
     */
    Teacher getTeacher(@Param("tid") int id);

    /**
     * 方式一：按查询嵌套处理；
     * @param id
     * @return
     */
    Teacher getTeacher2(@Param("tid") int id);
}
