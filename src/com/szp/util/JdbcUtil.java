package com.szp.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.szp.constants.JdbcConstant;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.*;

/**
 * 数据库的工具类
 * 此工具类提供了数据库的连接，关闭等方法
 * @author Ghost Dog
 */

public class JdbcUtil {

	private static DataSource dataSource;


	static {
		/**
		 * 创建数据库连接池对象
		 * 使用的是c3p0连接池技术，已将所有配置放进根目录的c3p0-config.xml文件中
		 */
		dataSource = new ComboPooledDataSource();

	}


	/**
	 * 获取QueryRunner对象
	 * @return QueryRunner对象
	 */
	public static QueryRunner getQueryRunner() {
		return new QueryRunner(dataSource);
	}
	
	/**
	 * 获取数据库连接对象，返回null则连接失败
	 * Get A Connection , if return null,connect fail.
	 * @return
	 */
	@Deprecated
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 已过时，不建议使用
	 * 获取数据库连接对象，返回null则连接失败
	 * @return
	 */
	@Deprecated
	public static Connection getConnection1(){
		try {
			//注册驱动
			Class.forName(JdbcConstant.DIRIVER);
			//连接数据库
			return DriverManager.getConnection(JdbcConstant.URL,JdbcConstant.DB_USER,JdbcConstant.DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * 关闭连接，释放资源
	 * @param connection
	 */
	@Deprecated
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
                connection = null;//建议垃圾回收器回收此对象
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}


	/**
	 * 关闭数据库连接，释放资源
	 * close connection, free of resource.
	 * 
	 * @param connection Connection 连接对象
	 * @param statement Statement Statement对象
	 */
	@Deprecated
	public static void close(Connection connection,Statement statement){
		close(connection);
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	
	/**
	 * 关闭数据库连接，释放资源
	 * close connection, free of resource.
	 * @param connection Connection Connection对象
	 * @param statement Statement Statement对象
	 * @param resultSet ResultSet ResultSet对象
	 */
	@Deprecated
	public static void close(Connection connection,Statement statement,ResultSet resultSet){
		close(connection, statement);
		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
}
