package com.java1234.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.BookDao;
import com.java1234.dao.BooksDao;
import com.java1234.model.Book;
import com.java1234.model.Books;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookManageInterFrm extends JInternalFrame {
	private JTextField booksname;
	private JTextField booksauthor;
	private JTable bookstypetable;
	private JTextField id;
	private JTextField name;
	private JTextField price;
	private JTextField author;
	private Books books;
	private JComboBox bookstype;
	private JTextArea describe;
	private JComboBox type;
	private JRadioButton male;
	private JRadioButton female;
	DbUtil dbutil = new DbUtil();
	BooksDao booksdao = new BooksDao();
	BookDao bookdao = new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public BookManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 784, 634);
		
		JPanel x = new JPanel();
		x.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
						.addComponent(x, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
					.addGap(81))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(x, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u7F16\u53F7\uFF1A");
		
		JLabel lblNewLabel_2_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_2_1_2 = new JLabel("\u4EF7\u683C\uFF1A");
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		JLabel lblNewLabel_2_1_2_1_1_1 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				booksupdate(evt);
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("\u5220\u9664");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deletebooks(evt);
			}
		});
		
		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		
		price = new JTextField();
		price.setColumns(10);
		
		author = new JTextField();
		author.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		JLabel lblNewLabel_3_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		male = new JRadioButton("\u7537");
		
		female = new JRadioButton("\u5973");
		
		type = new JComboBox();
		
		describe = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(86)
									.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2_1_2, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(id)
										.addComponent(price))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_1_2_1))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(name, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addComponent(author, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
							.addGap(26)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(18)
									.addComponent(male)
									.addGap(28)
									.addComponent(female, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(type, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
							.addGap(42))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(describe, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(female)
						.addComponent(male))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_2)
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_2_1)
						.addComponent(author, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_1)
						.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_2_1_1_1)
						.addComponent(describe, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_1_1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		bookstypetable = new JTable();
		bookstypetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				getbooks(evt);
			}
		});
		bookstypetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(bookstypetable);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		JLabel lblNewLabel_1_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				search(evt);
			}
		});
		
		booksname = new JTextField();
		booksname.setColumns(10);
		
		booksauthor = new JTextField();
		booksauthor.setColumns(10);
		
		bookstype = new JComboBox();
		GroupLayout gl_x = new GroupLayout(x);
		gl_x.setHorizontalGroup(
			gl_x.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_x.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(booksname, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(booksauthor, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookstype, 0, 66, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		gl_x.setVerticalGroup(
			gl_x.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_x.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_x.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1_1)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel_1)
						.addComponent(booksname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(booksauthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookstype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		x.setLayout(gl_x);
		getContentPane().setLayout(groupLayout);
		
		this.filltable(new Books());
		this.fillbooktypetable("search");
		this.fillbooktypetable("modify");
	}
	
	/**
	 * 图书删除功能
	 * @param evt
	 */
	private void deletebooks(ActionEvent evt) {
		// TODO Auto-generated method stub
		Integer id2 = Integer.parseInt(this.id.getText());
		if(id2==null) {
			JOptionPane.showMessageDialog(null, "请输入要删除的信息！");
			return;
		}
		Connection con = null;
		try {
			con = dbutil.getCon();
			Books books = new Books(id2);
			int cf = JOptionPane.showConfirmDialog(null, "是否确认删除");
			if(cf==0) {
				int i = booksdao.delete(con, books);
				if (i==1) {
					JOptionPane.showMessageDialog(null, "图书删除成功！");
					this.resetvalue();
					this.filltable(new Books());
				}else {
					JOptionPane.showMessageDialog(null, "图书删除失败！");
					return;
				}
			}		
		}catch(Exception e){
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

	/**
	 * 图书修改功能
	 * @param evt
	 */
	private void booksupdate(ActionEvent evt) {
		// TODO Auto-generated method stub
		Integer id1 = Integer.parseInt(this.id.getText());
		if(id1==null) {
			JOptionPane.showMessageDialog(null, "请输入要修改的信息！");
			return;
		}
		String name1 = this.name.getText();
		String sex1 = "";
		if (male.isSelected()) {
			sex1 = "男";
		}else{
			sex1 = "女";
		}
		String author1 = this.author.getText();
		float price1 = Float.parseFloat(this.price.getText());	
		String describe1 = this.describe.getText();
		Book book = (Book) this.type.getSelectedItem();
		int typeid1 = book.getId();
		Connection con = null;
		try {
			con = dbutil.getCon();
			Books books = new Books(id1, name1, author1, sex1, price1, typeid1, describe1);
			int i = booksdao.update(con, books);
			if (i==1) {
				JOptionPane.showMessageDialog(null, "图书修改成功！");
				this.resetvalue();
				this.filltable(new Books());
			}else {
				JOptionPane.showMessageDialog(null, "图书修改失败！");
				return;
			}
		}catch(Exception e){
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
	
	/**
	 * 重置表单
	 */
	private void resetvalue() {
		// TODO Auto-generated method stub
		this.name.setText("");
		this.author.setText("");
		this.price.setText("");
		this.id.setText("");
		this.describe.setText("");
		this.male.setSelected(false);
		this.female.setSelected(false);
	}

	/**
	 * 图书搜索功能
	 * @param evt
	 */
	private void search(ActionEvent evt) {
		// TODO Auto-generated method stub
		String booksname1 = this.booksname.getText();
		String booksauthor1 = this.booksauthor.getText();
		Book book = (Book) this.bookstype.getSelectedItem();
		int bookid = book.getId();
		Books books = new Books(booksname1, booksauthor1, bookid);
		this.filltable(books);
	}

	/**
	 * 鼠标单击表格对应信息
	 * @param evt
	 */
	private void getbooks(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row = bookstypetable.getSelectedRow();
		id.setText(bookstypetable.getValueAt(row, 0).toString());
		name.setText((String)bookstypetable.getValueAt(row, 1));
		author.setText((String)bookstypetable.getValueAt(row, 2));
		String sex = (String)bookstypetable.getValueAt(row, 3);
		if ("男".equals(sex)) {
			male.setSelected(true);
			female.setSelected(false);
		}
		if ("女".equals(sex)) {
			male.setSelected(false);
			female.setSelected(true);
		}
		price.setText((String)bookstypetable.getValueAt(row, 4));
		describe.setText((String)bookstypetable.getValueAt(row, 5));
		String type1 = (String)this.bookstypetable.getValueAt(row, 6);
		int n = this.type.getItemCount();
		for(int i=0; i<n; i++) {
			Book book = (Book) this.type.getItemAt(i);
			if (book.getName().equals(type1)) {
				this.type.setSelectedIndex(i);
			}
		}
	}

	
	/**
	 * 初始化表单
	 * @param books
	 */
	private void filltable(Books books) {
		DefaultTableModel dtm = (DefaultTableModel) bookstypetable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbutil.getCon();
			ResultSet rs = booksdao.list(con, books);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("books_id"));
				v.add(rs.getString("books_name"));
				v.add(rs.getString("books_author"));
				v.add(rs.getString("books_sex"));
				v.add(rs.getString("books_price"));
				v.add(rs.getString("books_describe"));
				v.add(rs.getString("book_name"));  // 因为是关联查询，所以都可以查到
				dtm.addRow(v);
			}
		}catch(Exception e){
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
	
	
	/**
	 * 初始化图书类别下拉框
	 */
	private void fillbooktypetable(String s) {
		Connection con = null;
		Book book = new Book();
		try {
			con = dbutil.getCon();
			ResultSet rs = bookdao.list(con, book);
			if("search".equals(s)) {
				book = new Book();
				book.setName("请选择...");
				book.setId(-1);
				this.bookstype.addItem(book);
			}
			while(rs.next()) {
				book = new Book();
				book.setName(rs.getString("book_name"));
				book.setId(rs.getInt("book_id"));
				if("search".equals(s)) {
					this.bookstype.addItem(book);
				}else if("modify".equals(s)) {
					this.type.addItem(book);
				}
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
