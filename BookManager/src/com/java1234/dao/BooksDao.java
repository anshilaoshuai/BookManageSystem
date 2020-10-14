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
		PreparedStatement pstmt = con.prepareStatement(sql);//Ԥ���룺PreparedStatement���󽫻��󽵵�����ʱ��
		pstmt.setString(1, books.getName());// ��һ���ʺ�
		pstmt.setString(2, books.getAuthor());// �ڶ����ʺ�
		pstmt.setString(3, books.getSex());// �ڶ����ʺ�
		pstmt.setFloat(4, books.getPrice());// �ڶ����ʺ�
		pstmt.setInt(5, books.getTypeid());// �ڶ����ʺ�
		pstmt.setString(6, books.getDescribe());// �ڶ����ʺ�
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
		PreparedStatement pstmt = con.prepareStatement(sql.toString());//Ԥ���룺PreparedStatement���󽫻��󽵵�����ʱ��
		return pstmt.executeQuery();
	}
	
	public int update(Connection con,Books books)throws Exception{
		String updatesql = "update books set books_name=?,books_author=?,books_sex=?,books_price=?,books_describe=?,books_typeid=? where books_id=?";  //�ǵü�set���ĵĵط���ǰ�棬where������������
		PreparedStatement pstmt = con.prepareStatement(updatesql);//Ԥ���룺PreparedStatement���󽫻��󽵵�����ʱ��
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
		String updatesql = "delete from books where books_id=?";  //�ǵü�set���ĵĵط���ǰ�棬where������������
		PreparedStatement pstmt = con.prepareStatement(updatesql);//Ԥ���룺PreparedStatement���󽫻��󽵵�����ʱ��
		pstmt.setInt(1, books.getId());
		return pstmt.executeUpdate();
	}

}
