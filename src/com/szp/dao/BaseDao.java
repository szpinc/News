package com.szp.dao;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

/**
 * 此类是所有自定义DAO的父类
 * 所有自定义dao都建议继承此类，因为此类提供了dao的通用方法
 *
 * 此类只提供数据的更改和查询两个方法
 * Created by ghostdog on 16/11/24.
 */
public class BaseDao {
    private static final long serialVersionUID = 1L;

    /**
     * 定义QueryRunner对象
     */
    private QueryRunner queryRunner;

    public BaseDao(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    /**
     * 数据更改的通用方法
     * 此方法可以对数据进行插入，删除，更改
     * 需要提供指定参数
     * @param sql sql语句
     * @param values 参数的集合，如果没有参数，则传入null即可
     * Created by ghostdog on 16/11/24
     */
    public boolean update(String sql, Object... params){
        try {
            queryRunner.update(sql,params);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 批量处理数据更改
     * @param sql sql语句
     * @param values 参数的集合
     */
    public void batch(String sql, Object[][] values) {

        try {
            queryRunner.batch(sql,values);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 数据查询的通用方法
     * 此方法返回数据封装的集合对象
     * @param sql sql语句
     * @param values 参数的集合，如果没有参数，则传入null即可
     * @param bean 指定类的class对象
     * @return 指定类对象的List集合
     */

    public <T> List<T> query(String sql, Class<T> bean, Object... params) {
        try {
            return queryRunner.query(sql, new BeanListHandler<T>(bean), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 数据查询的通用方法
     * 此方法返回数据封装的单个对象
     * @param sql sql语句
     * @param values 参数的集合，如果没有参数，则传入null即可
     * @param bean 指定类的class对象
     * @return 指定类对象
     */
    public <T> T queryBean(String sql, Class<T> bean, Object... params) {
        try {
            return queryRunner.query(sql,new BeanHandler<T>(bean),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
