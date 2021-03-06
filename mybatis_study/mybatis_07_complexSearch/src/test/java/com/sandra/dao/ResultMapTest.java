package com.sandra.dao;

import java.util.List;

import com.sandra.pojo.Student;
import com.sandra.pojo.Teacher;
import com.sandra.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class ResultMapTest {

    /**
     * 日志
     */
    static private Logger logger = Logger.getLogger(ResultMapTest.class);

    @Test
    public void getTeacher() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        int tid = 1;
        Teacher teacher = teacherMapper.getTeacher(tid);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void getStudentList() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void getStudentList2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudentList2();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}
