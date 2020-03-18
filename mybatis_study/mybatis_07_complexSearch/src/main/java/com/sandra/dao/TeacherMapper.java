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
    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacher(@Param("tid") int id);
}
