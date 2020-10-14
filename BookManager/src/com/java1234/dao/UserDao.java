package com.java1234.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.User;


/**
 * �û�Dao��
 * @author ������˧
 *
 */

public class UserDao {
	
	/**
	 * ��½��֤
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		// jdbc����
		User resultUser = null;
		String sql = "select * from t_user where userName=? and password=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);//Ԥ���룺PreparedStatement���󽫻��󽵵�����ʱ��
		pstmt.setString(1, user.getUserName());// ��һ���ʺ�
		pstmt.setString(2, user.getPassword());// �ڶ����ʺ�
		ResultSet rs = pstmt.executeQuery();//ִ��sql
		
		if (rs.next()) {//���rs��ֵ
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
		
	}

}
