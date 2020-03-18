package com.sandra.utils;

import java.util.UUID;

import org.junit.Test;

/**
 * 随机生成uid；
 */
public class IdUtil {

    public static String genId() {
        //随机生成的uid会带-号，要替换为无字符；
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 随时随地Junit
     */
    @Test
    public void test() {
        System.out.println(IdUtil.genId());
        System.out.println(IdUtil.genId());
        System.out.println(IdUtil.genId());
    }
}
