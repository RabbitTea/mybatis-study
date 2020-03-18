package com.sandra.dao;

import java.util.List;

import com.sandra.pojo.Student;

/**
 * Student实体类，需要的数据库操作
 */
public interface StudentMapper {

    /**
     * 查询所有的学生信息，包括关联的老师信息；
     * 方式一：按照查询嵌套处理
     */
    List<Student> getStudentList();

    /**
     * 查询所有的学生信息，包括关联的老师信息；
     * 方式二：按照结果嵌套处理
     */
    List<Student> getStudentList2();

}
