package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.Book;
import com.java1234.util.StringUtil;


/**
 * BookDao类
 * @author 安是老帅
 *
 */
public class BookDao {
	
	/**
	 * 图书类别添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception{
		Book resultbook = null;
		String sql = "insert into book Values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);//预编译：PreparedStatement对象将会大大降低运行时间
		pstmt.setString(1, book.getName());// 第一个问号
		pstmt.setString(2, book.getDescribe());// 第二个问号
//		ResultSet rs = pstmt.executeQuery();//执行sql
//		
//		if (rs.next()) {//如果rs有值
//			resultbook = new Book();
//			resultbook.setId(rs.getInt("id"));
//			resultbook.setName(rs.getString("userName"));
//			resultbook.setDescribe(rs.getString("password"));
//		}
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书类别查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer sb = new StringBuffer("select * from book");
		if (StringUtil.isNotEmpty(book.getName())) {
			sb.append(" and book_name like '%"+book.getName()+"%'");//模糊查询+前面记得有个空格+书叫t_name
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));//预编译：PreparedStatement对象将会大大降低运行时间
		return pstmt.executeQuery();
	}
	

	public int update(Connection con,Book book)throws Exception{
		String updatesql = "update book set book_name=?,book_describe=? where book_id=?";  //记得加set，改的地方在前面，where后是限制条件
		PreparedStatement pstmt = con.prepareStatement(updatesql);//预编译：PreparedStatement对象将会大大降低运行时间
		pstmt.setString(1, book.getName());// 第一个问号
		pstmt.setString(2, book.getDescribe());// 第二个问号
		pstmt.setInt(3, book.getId());// 第二个问号
		return pstmt.executeUpdate();
	}
	
	public int delete(Connection con,String id)throws Exception{
		String deletesql = "delete from book where book_id = ?";  //记得加set，改的地方在前面，where后是限制条件
		PreparedStatement pstmt = con.prepareStatement(deletesql);//预编译：PreparedStatement对象将会大大降低运行时间
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	public boolean whetherbooktype(Connection con,String booktypeid) throws Exception{
		String sql1 = "select * from books where books_typeid = ?";  //主外键已经关联了，可以用联合查询，可以直接从books表里查typeid
		PreparedStatement pstmt = con.prepareStatement(sql1);//预编译：PreparedStatement对象将会大大降低运行时间
		pstmt.setString(1, booktypeid);
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
}
