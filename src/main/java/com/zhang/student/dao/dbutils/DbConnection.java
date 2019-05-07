package com.zhang.student.dao.dbutils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DbConnection {
	/**
	 * Alibaba数据源
	 */
	private static DataSource dataSource;
	/**
	 * 取得连接池资源
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		// 实例化Properties对象
		Properties pro = new Properties();
		// 产生输入流的jdbc配置对象
		InputStream inStream = DbConnection.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			
			// 加载文件到对象
			pro.load(inStream);
			// 读取对象文件中驱动名称
			dataSource = DruidDataSourceFactory.createDataSource(pro);
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;
	}
	/**
	 * 驱动数据库连接池的连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException
	{
		return getDataSource().getConnection();
	}
}
