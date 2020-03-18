package com.sandra.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类；这里使用了Lombok，即使用注解简化代码和配置；
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
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
     */
    private String pwd;
}
