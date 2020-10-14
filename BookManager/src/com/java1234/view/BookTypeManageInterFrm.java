package com.java1234.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.BookDao;
import com.java1234.model.Book;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class BookTypeManageInterFrm extends JInternalFrame {
	private JTable booktypetable;
	private JTextField bookaddname;
	private DbUtil dbutil = new DbUtil();
	private BookDao bookdao = new BookDao();
	private JTextField bookid;
	private JTextField bookname;
	JTextArea bookdescribe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
	public BookTypeManageInterFrm() {
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 599, 638);
		
		JScrollPane booktable = new JScrollPane();
		booktable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				getbook(evt);
			}
		});;
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
		
		bookaddname = new JTextField();
		bookaddname.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchbook(evt);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(115)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(booktable, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addGap(18)
								.addComponent(bookaddname, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookaddname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(37)
					.addComponent(booktable, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		JLabel lblNewLabel_1_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_1_2 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		bookid = new JTextField();
		bookid.setEditable(false);
		bookid.setColumns(10);
		
		bookname = new JTextField();
		bookname.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				changebook(evt);
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("\u5220\u9664");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deletebook(evt);
			}
		});
		
		bookdescribe = new JTextArea();
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(bookid, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookname, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
								.addComponent(bookdescribe, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(bookname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(bookdescribe, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_1_1))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		booktypetable = new JTable();
		booktypetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				getbook(evt);
			}
		});
		booktypetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		booktypetable.getColumnModel().getColumn(0).setPreferredWidth(50);
		booktypetable.getColumnModel().getColumn(1).setPreferredWidth(88);
		booktypetable.getColumnModel().getColumn(2).setPreferredWidth(163);
		booktable.setViewportView(booktypetable);
		getContentPane().setLayout(groupLayout);
		
		
		this.filltable(new Book());
	}
	
	protected void deletebook(ActionEvent evt) {
		// TODO Auto-generated method stub
		Connection con = null;
		String id = bookid.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请输入删除信息");
			return;
		}
		try {
			con = dbutil.getCon();
			int cf = JOptionPane.showConfirmDialog(null, "是否确认删除");
			boolean x = bookdao.whetherbooktype(con, id);
			if(x) {
				JOptionPane.showMessageDialog(null, "当前类别下有图书无法删除！");
				return;
			}
			if (cf==0) {
				int db = bookdao.delete(con, id);
				if(db==1) {
					JOptionPane.showMessageDialog(null, "图书类别删除成功");
					this.reset();
					this.filltable(new Book());
				}else {
					JOptionPane.showMessageDialog(null, "图书删除失败");
				}
		}
		}catch(Exception e){
			e.printStackTrace();;
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
	 * 修改图书信息
	 * @param evt
	 */
	protected void changebook(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = bookid.getText();
		String name = bookname.getText();
		String describe = bookdescribe.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请输入修改信息");
			return;
		}
		Book book = new Book(Integer.parseInt(id), name, describe);
		Connection con = null;
		try {
			con = dbutil.getCon();
			int bu = bookdao.update(con, book);
			if (bu==1) {
				JOptionPane.showMessageDialog(null, "图书信息修改成功");
				this.reset();
				this.filltable(new Book());
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
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
	
	
	/**
	 * 点击栏目对应信息
	 * @param evt
	 */
	private void getbook(MouseEvent evt) {  //一定要设置到表格booktypetable上
		// TODO Auto-generated method stub
		int row = booktypetable.getSelectedRow();
		bookid.setText((String)booktypetable.getValueAt(row, 0));
		bookname.setText((String)booktypetable.getValueAt(row, 1));
		bookdescribe.setText((String)booktypetable.getValueAt(row, 2));
	}

	
	/**
	 * 图书类别搜索
	 */
	private void searchbook(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookname = this.bookaddname.getText();
		Book bookofsearch = new Book(bookname);
		this.filltable(bookofsearch);
	}

	
	/**
	 * 初始化表格
	 * @param book
	 */
	private void filltable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel) booktypetable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbutil.getCon();
			ResultSet rs = bookdao.list(con, book);
			while (rs.next()) {//如果rs有值
				Vector v = new Vector();//Vector 可实现自动增长的对象数组
				v.add(rs.getString("book_id"));
				v.add(rs.getString("book_name"));
				v.add(rs.getString("book_describe"));
				dtm.addRow(v);
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
	
	/**
	 * 重置表单操作
	 */
	private void reset() {
		// TODO Auto-generated method stub
		this.bookid.setText("");
		this.bookname.setText("");
		this.bookdescribe.setText("");
	}
}
