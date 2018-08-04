package com.gioov.spiny.common.constant;

/**
 * @author godcheese
 * @date 2018/4/30 17:58
 */
public class Url {

    public static final String PATH_SEPARATOR = "/";
    public static final String ALL_PATH_PATTERN = "/**";

    public static final String API = "/api";

    public static final String SYSTEM = "/system";
    public static final String USER = "/user";

    /**
     * 静态资源 url
     */
    public static final String[] STATIC = {"robots.txt", "/**.ico", "/css/**", "/js/**", "/img/**", "/vendor/**"};

}
