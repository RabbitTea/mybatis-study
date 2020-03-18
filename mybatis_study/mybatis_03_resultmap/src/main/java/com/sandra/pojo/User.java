package com.sandra.pojo;

/**
 * 实体类
 */
public class User {

    /**
     * 属性与数据表中列的命名保持一致
     */
    /**
     * userId
     */
    private int id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     * 注意这里和数据表列名不一致
     */
    private String password;

    public User() {

    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.password = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", pwd='" + password + '\'' +
            '}';
    }
}
