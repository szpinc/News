package com.szp.constants;
/**
 *
 * JDBC的常量配置类
 * 此类配置了jdbc所需要的所有常量，以方便修改
 * Created by ghostdog on 16/11/26.
 */
public class JdbcConstant {

    /**
     * 数据库登陆用户名
     */
    public static final String DB_USER = "root";

    /**
     * 数据库登陆密码
     */
    public static final String DB_PASSWORD = "0652";

    /**
     * 数据库驱动
     */
    public static final String DIRIVER = "com.mysql.jdbc.Driver";

    /**
     * 连接数据库的名称
     */
    public static final String DB_NAME = "user";

    /**
     * 保存数据的默认编码集
     */
    public static final String DEFAULT_CHARACTER = "UTF-8";

    /**
     * 是否使用unicode字符集
     */
    public static final String USE_UNICODE = "true";

    /**
     * 数据库连接URL
     */
    public static final String URL = "jdbc:mysql://localhost:3306/"+DB_NAME+"?"+"useUnicode="+USE_UNICODE+"&"+"characterEncoding="+DEFAULT_CHARACTER;
}
