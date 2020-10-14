package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.Book;
import com.java1234.model.Books;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

public class BooksDao {
	
	public int add(Connection con,Books books) throws Exception{
		String sql = "insert into Books Values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);//预编译：PreparedStatement对象将会大大降低运行时间
		pstmt.setString(1, books.getName());// 第一个问号
		pstmt.setString(2, books.getAuthor());// 第二个问号
		pstmt.setString(3, books.getSex());// 第二个问号
		pstmt.setFloat(4, books.getPrice());// 第二个问号
		pstmt.setInt(5, books.getTypeid());// 第二个问号
		pstmt.setString(6, books.getDescribe());// 第二个问号
		return pstmt.executeUpdate();
	}
	
	public ResultSet list(Connection con,Books books)throws Exception{
		StringBuffer sql = new StringBuffer("select * from books b ,book bt where b.books_typeid = bt.book_id");
		if (StringUtil.isNotEmpty(books.getName())) {
			sql.append(" and b.books_name like '%"+ books.getName() +"%'");
		}
		if (StringUtil.isNotEmpty(books.getAuthor())) {
			sql.append(" and b.books_author like '%"+ books.getAuthor() +"%'");
		}
		if (books.getTypeid()!=null && books.getTypeid()!=-1) {
			sql.append(" and b.books_typeid ="+ books.getTypeid());
		}
		PreparedStatement pstmt = con.prepareStatement(sql.toString());//预编译：PreparedStatement对象将会大大降低运行时间
		return pstmt.executeQuery();
	}
	
	public int update(Connection con,Books books)throws Exception{
		String updatesql = "update books set books_name=?,books_author=?,books_sex=?,books_price=?,books_describe=?,books_typeid=? where books_id=?";  //记得加set，改的地方在前面，where后是限制条件
		PreparedStatement pstmt = con.prepareStatement(updatesql);//预编译：PreparedStatement对象将会大大降低运行时间
		pstmt.setString(1, books.getName());
		pstmt.setString(2, books.getAuthor());
		pstmt.setString(3, books.getSex());
		pstmt.setFloat(4, books.getPrice());
		pstmt.setString(5, books.getDescribe());
		pstmt.setInt(6, books.getTypeid());
		pstmt.setInt(7, books.getId());
		
		return pstmt.executeUpdate();
	}
	
	public int delete(Connection con,Books books)throws Exception{
		String updatesql = "delete from books where books_id=?";  //记得加set，改的地方在前面，where后是限制条件
		PreparedStatement pstmt = con.prepareStatement(updatesql);//预编译：PreparedStatement对象将会大大降低运行时间
		pstmt.setInt(1, books.getId());
		return pstmt.executeUpdate();
	}

}
