package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.Book;
import com.java1234.util.StringUtil;


/**
 * BookDao��
 * @author ������˧
 *
 */
public class BookDao {
	
	/**
	 * ͼ��������
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception{
		Book resultbook = null;
		String sql = "insert into book Values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);//Ԥ���룺PreparedStatement���󽫻��󽵵�����ʱ��
		pstmt.setString(1, book.getName());// ��һ���ʺ�
		pstmt.setString(2, book.getDescribe());// �ڶ����ʺ�
//		ResultSet rs = pstmt.executeQuery();//ִ��sql
//		
//		if (rs.next()) {//���rs��ֵ
//			resultbook = new Book();
//			resultbook.setId(rs.getInt("id"));
//			resultbook.setName(rs.getString("userName"));
//			resultbook.setDescribe(rs.getString("password"));
//		}
		return pstmt.executeUpdate();
	}
	
	/**
	 * ͼ������ѯ
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer sb = new StringBuffer("select * from book");
		if (StringUtil.isNotEmpty(book.getName())) {
			sb.append(" and book_name like '%"+book.getName()+"%'");//ģ����ѯ+ǰ��ǵ��и��ո�+���t_name
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));//Ԥ���룺PreparedStatement���󽫻��󽵵�����ʱ��
		return pstmt.executeQuery();
	}
	

	public int update(Connection con,Book book)throws Exception{
		String updatesql = "update book set book_name=?,book_describe=? where book_id=?";  //�ǵü�set���ĵĵط���ǰ�棬where������������
		PreparedStatement pstmt = con.prepareStatement(updatesql);//Ԥ���룺PreparedStatement���󽫻��󽵵�����ʱ��
		pstmt.setString(1, book.getName());// ��һ���ʺ�
		pstmt.setString(2, book.getDescribe());// �ڶ����ʺ�
		pstmt.setInt(3, book.getId());// �ڶ����ʺ�
		return pstmt.executeUpdate();
	}
	
	public int delete(Connection con,String id)throws Exception{
		String deletesql = "delete from book where book_id = ?";  //�ǵü�set���ĵĵط���ǰ�棬where������������
		PreparedStatement pstmt = con.prepareStatement(deletesql);//Ԥ���룺PreparedStatement���󽫻��󽵵�����ʱ��
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	public boolean whetherbooktype(Connection con,String booktypeid) throws Exception{
		String sql1 = "select * from books where books_typeid = ?";  //������Ѿ������ˣ����������ϲ�ѯ������ֱ�Ӵ�books�����typeid
		PreparedStatement pstmt = con.prepareStatement(sql1);//Ԥ���룺PreparedStatement���󽫻��󽵵�����ʱ��
		pstmt.setString(1, booktypeid);
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
}
