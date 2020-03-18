package com.sandra.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户实体类；实现序列化接口；
 */
@Data
public class User implements Serializable {

    private int id;
    private String name;
    private String pwd;
}
