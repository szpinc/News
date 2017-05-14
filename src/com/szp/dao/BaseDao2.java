package com.szp.dao;

import com.szp.entity.Article;
import com.szp.entity.Column;
import com.szp.entity.PrimaryKey;
import com.szp.entity.Table;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by GhostDog on 2017/5/14.
 */
public class BaseDao2<T> {

    private QueryRunner queryRunner = JdbcUtil.getQueryRunner();

    private Class<T> tClass;
    private String tableName;
    private String primaryColumn;

    //拿到当前运行类的参数化类型中的实际类型
    public BaseDao2 () {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        Type[] actualTypeArguments = pt.getActualTypeArguments();
        tClass = (Class<T>)actualTypeArguments[0];

        //获取表名
        Table table = tClass.getAnnotation(Table.class);

        tableName = table.value();


        //获取主键字段

        //获取当前运行类的所有字段、遍历获取每一个字段上的注解
        Field[] fields = tClass.getDeclaredFields();

        for (Field field : fields) {

            //设置强制访问
            field.setAccessible(true);

            //获取每一个字段上的主键注解
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);

            if (primaryKey != null) {
                //如果当前字段上有注解注解，则当前字段为主键,再次获得字段名称
                Column column = field.getAnnotation(Column.class);
                //获取注解值
                primaryColumn = column.value();
                break;
            }
        }
    }




    public T getById (int id) {

        String sql = "SELECT * FROM "+tableName+" WHERE "+primaryColumn+"=?";

        try {
            return queryRunner.query(sql,new BeanHandler<T>(tClass),id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public List<T> getAll () {
        String sql = "SELECT * FROM "+tableName;
        try {
            return queryRunner.query(sql,new BeanListHandler<T>(tClass));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public T getObject () throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }





    @Test
    public void test () throws InstantiationException, IllegalAccessException {

        BaseDao2<Article> baseDao2 = new BaseDao2<Article>();
        Article object = baseDao2.getObject();
        object.setContent("aaa");
        System.out.println(object.getContent());

    }



}
