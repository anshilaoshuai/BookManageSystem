package com.java1234.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.User;


/**
 * 用户Dao类
 * @author 安是老帅
 *
 */

public class UserDao {
	
	/**
	 * 登陆验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		// jdbc操作
		User resultUser = null;
		String sql = "select * from t_user where userName=? and password=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);//预编译：PreparedStatement对象将会大大降低运行时间
		pstmt.setString(1, user.getUserName());// 第一个问号
		pstmt.setString(2, user.getPassword());// 第二个问号
		ResultSet rs = pstmt.executeQuery();//执行sql
		
		if (rs.next()) {//如果rs有值
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
		
	}

}
