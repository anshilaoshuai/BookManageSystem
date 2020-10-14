package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author 安是老帅
 *
 */
public class DbUtil {
	private String dbUtl="jdbc:mysql://localhost:3306/db_book?useSSL=false";//数据库连接地址
	private String dbUserName="root";//用户名
	private String dbPassword="";//密码
	private String jdbcName="com.mysql.jdbc.Driver";//驱动名称
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUtl,dbUserName,dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if (con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		
	}

}
