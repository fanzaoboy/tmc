package com.tmc.Utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static String db_driver = null;
	private static String db_url = null;
	private static String db_username = null;
	private static String db_password = null;

	static {
		try {
			// 读取db.properties文件中的数据库连接信息
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
			Properties prop = new Properties();
			prop.load(in);
			db_driver = prop.getProperty("driver");
			db_url = prop.getProperty("url");
			db_username = prop.getProperty("username");
			db_password = prop.getProperty("password");

			Class.forName(db_driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取Connection对象
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(db_url, db_username, db_password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 有结果集的关闭
	public static void close(Connection conn, PreparedStatement ps, ResultSet res) {
		if (conn != null && ps != null && res != null) {
			try {
				conn.close();
				ps.close();
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	// 没有结果集的关闭
	public static void close(Connection conn, PreparedStatement ps) {
		if (conn != null && ps != null) {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
