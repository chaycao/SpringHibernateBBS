package com.chaycao.hibernatebbs.util;

import java.sql.*;

public class DBUtil {
	
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/bbs?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	public static final String NAME = "com.mysql.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASSWD = "caoniezi";
	
	public static Connection getConn() {					
		Connection conn = null;
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static PreparedStatement prepareStmt(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	public static ResultSet executeQuery(Statement stmt, String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}


	public static void close(Connection conn, Statement stmt,
			PreparedStatement preStatement, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (preStatement != null) {
			try {
				preStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			preStatement = null;
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
}
