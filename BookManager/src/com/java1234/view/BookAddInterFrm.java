package com.java1234.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java1234.dao.BookDao;
import com.java1234.dao.BooksDao;
import com.java1234.model.Book;
import com.java1234.model.Books;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField booksname;
	private JTextField booksauthor;
	private JTextField booksprice;
	private JComboBox bookstypename;
	private JTextArea booksdescribe;
	private JRadioButton male;
	private JRadioButton female;
	
	DbUtil dbutil = new DbUtil();
	BookDao bookdao = new BookDao();
	BooksDao booksdao = new BooksDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 574, 610);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		JLabel lblNewLabel_2_1 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		
		JLabel lblNewLabel_2_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		JLabel lblNewLabel_2_2_1 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		booksname = new JTextField();
		booksname.setColumns(10);
		
		booksauthor = new JTextField();
		booksauthor.setColumns(10);
		
		booksprice = new JTextField();
		booksprice.setColumns(10);
		
		booksdescribe = new JTextArea();
		
		male = new JRadioButton("\u7537");
		
		female = new JRadioButton("\u5973");
		
		bookstypename = new JComboBox();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				booksadd(evt);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				reset(evt);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2_2_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(booksdescribe, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(male)
									.addGap(10)
									.addComponent(female, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booksname, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booksprice))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booksauthor, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
							.addGap(10))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookstypename, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(booksname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(booksauthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_2_1)
						.addComponent(booksprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(male)
						.addComponent(female))
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_2)
						.addComponent(bookstypename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_2_1)
						.addComponent(booksdescribe, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		this.filltable();
	}
	
	private void booksadd(ActionEvent evt) {
		// TODO Auto-generated method stub
		String name = this.booksname.getText();
		String author = this.booksauthor.getText();
		String price = this.booksprice.getText();
		String describe = this.booksdescribe.getText();
		if (StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "书名不能为空");
			return;
		}
		if (StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "作者名不能为空");
			return;
		}
		if (StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "书价格不能为空");
			return;
		}
		String sex = "";
		if (male.isSelected() && !female.isSelected()) {
			sex = "男";
		}else if(female.isSelected() && !male.isSelected()){
			sex = "女";
		}else {
			JOptionPane.showMessageDialog(null, "性别选择错误");
			return;
		}
		Book book = (Book) bookstypename.getSelectedItem();
		int booktypeid = book.getId();
		Books books = new Books(name, author, sex, Float.parseFloat(price), booktypeid, describe);
		Connection con = null;
		try {
			con = dbutil.getCon();
			int i = booksdao.add(con, books);
			if (i==1) {
				JOptionPane.showMessageDialog(null, "图书添加成功");
				this.resetValue();
				return;
			}else {
				JOptionPane.showMessageDialog(null, "图书添加失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败");
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void resetValue() {
		// TODO Auto-generated method stub
		this.booksname.setText("");
		this.booksauthor.setText("");
		this.booksprice.setText("");
		this.booksdescribe.setText("");
		this.male.setSelected(false);
		this.female.setSelected(false);
	}

	private void reset(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.booksname.setText("");
		this.booksauthor.setText("");
		this.booksprice.setText("");
		this.booksdescribe.setText("");
		this.male.setSelected(false);
		this.female.setSelected(false);
	}

	/**
	 * 初始化图书类别下拉框
	 */
	private void filltable() {
		Connection con = null;
		Book book = new Book();
		try {
			con = dbutil.getCon();
			ResultSet rs = bookdao.list(con, book);
			while(rs.next()) {
				book = new Book();
				book.setName(rs.getString("book_name"));
				book.setId(rs.getInt("book_id"));
				this.bookstypename.addItem(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}



