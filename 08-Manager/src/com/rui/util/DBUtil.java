package com.rui.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类
 * 用以连接MySQL数据库
 * @author Rui
 * @since JDK1.8
 * @version 1.0
 * Date 2021年1月19日 下午1:58:08
 * Copyright © 2021
 */
public class DBUtil {
	/** 读取和处理资源文件中的信息 */
	private static Properties props = null;
	
	static {
		//加载类时调用
		props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 与MySQL数据库建立连接
	 * @return 连接对象conn
	 */
	public static Connection getMySQLConnection() {
		Connection conn = null;
		try {
			Class.forName(props.getProperty("mysqlDriver"));
			conn = DriverManager.getConnection(props.getProperty("mysqlURL"), props.getProperty("mysqlUser"), props.getProperty("mysqlPwd"));
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 关闭数据库连接
	 * @param rs ResultSet对象
	 * @param stmt Statement对象
	 * @param conn Connection对象
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭数据库连接
	 * @param stmt Statement对象
	 * @param conn Connection对象
	 */
	public static void close(Statement stmt, Connection conn) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
