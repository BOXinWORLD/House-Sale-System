package all;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;




public class userFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtA_1;
	JTabbedPane tabbedPane = new JTabbedPane();
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userFrame frame = new userFrame();
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
	public userFrame() {
		setTitle("\u8D26\u6237\u4FE1\u606F\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		final JComboBox comboBox_1 = new JComboBox();
		
		
		
		
		tabbedPane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("修改账户信息", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		
		panel_3.setLayout(null);
		panel_2.add(panel_3, BorderLayout.CENTER);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_2.setBounds(99, 94, 148, 60);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("\u624B\u673A");
		label_3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_3.setBounds(99, 131, 148, 60);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("\u9009\u62E9\u8D26\u6237\uFF1A");
		label_4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_4.setBounds(99, 21, 148, 60);
		panel_3.add(label_4);
		
		JButton button_2 = new JButton("\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//trim()方法用于去掉你可能误输入的空格号

				try {

					if ( data.setuser(textField_2.getText(), 
							txtA_1.getText(),
							textField_3.getText(),
							textField_4.getText(), 
							data.nowuser[0])) 
					{JOptionPane.showMessageDialog(getComponent(0), "修改成功");} 
					else JOptionPane.showMessageDialog(userFrame.this, "修改用户失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
				
				}   catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(userFrame.this, "修改用户失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button_2.setBounds(99, 232, 123, 49);
		panel_3.add(button_2);
		
		JButton button_3 = new JButton("\u5237\u65B0");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				textField_2.setText("");
				txtA_1.setText("");
				textField_3.setText("");
				textField_4.setText("");
				comboBox_1.removeAllItems();
				//初始化选择框
		        for(int p=0;p<data.countc;p++)
					comboBox_1.addItem(new String(data.c[p][0]));
				
				
				
			}
		});
		
		button_3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button_3.setBounds(238, 232, 123, 49);
		panel_3.add(button_3);
		
		txtA_1 = new JTextField();
		
		txtA_1.setColumns(10);
		txtA_1.setBounds(228, 115, 133, 24);
		panel_3.add(txtA_1);
		
		
	
		comboBox_1.setBounds(228, 42, 133, 24);	
		panel_3.add(comboBox_1);

		
		JLabel label_5 = new JLabel("\u7528\u6237\u540D");
		label_5.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_5.setBounds(99, 57, 148, 60);
		panel_3.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(228, 78, 133, 24);

		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(228, 152, 133, 24);
		panel_3.add(textField_3);
		
		JLabel label_6 = new JLabel("\u8EAB\u4EFD\u8BC1");
		label_6.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_6.setBounds(99, 167, 148, 60);
		panel_3.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(228, 188, 133, 24);
		panel_3.add(textField_4);
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("新增账户信息", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel.setBounds(99, 73, 148, 60);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("\u624B\u673A");
		label.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label.setBounds(99, 110, 148, 60);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_1.setBounds(99, 36, 148, 60);
		panel_1.add(label_1);
		
		JButton button = new JButton("\u65B0\u589E");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(userFrame.this, "用户名为空", "错误", JOptionPane.ERROR_MESSAGE);
					
				}
				if(textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(userFrame.this, "密码为空", "错误", JOptionPane.ERROR_MESSAGE);
					
				}
				if(textField.getText().isEmpty()!=true&&textField_1.getText().isEmpty()!=true){
				try {
					if(data.adduser(textField.getText(),
							textField_1.getText(),
									textField_5.getText(), 
									textField_6.getText()))
					{
						JOptionPane.showMessageDialog(getComponent(0), "新增成功");

					}
					else JOptionPane.showMessageDialog(userFrame.this, "新增失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(userFrame.this, "新增失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(userFrame.this, "新增失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
				}
			}
			}
		});
		
		button.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button.setBounds(99, 212, 123, 49);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u6E05\u7A7A");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_5.setText("");
				textField_6.setText("");
				
			}
		});
		
		button_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button_1.setBounds(238, 212, 123, 49);
		panel_1.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(228, 57, 133, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(228, 94, 133, 24);
		panel_1.add(textField_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(228, 131, 133, 24);
		panel_1.add(textField_5);
		
		JLabel label_7 = new JLabel("\u8EAB\u4EFD\u8BC1");
		label_7.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_7.setBounds(99, 146, 148, 60);
		panel_1.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(228, 167, 133, 24);
		panel_1.add(textField_6);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("删除账户信息", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_5.add(scrollPane_1, BorderLayout.CENTER);
		
		JTable table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_1.setViewportView(table);
		final DefaultTableModel model;
		table.setModel(model=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"用户名", "密码", "手机", "身份证"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		
		
		try {
			data.inituser();
		} catch (IOException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int p=0;p<data.countc;p++)
        	model.addRow(new Object[]{data.c[p][0],data.c[p][1],data.c[p][2],data.c[p][3]});		
		for(int i=0;i<12;i++)
			model.addRow(new Object[]{null, null, null});
		
		//初始化选择框
        for(int p=0;p<data.countc;p++)
			comboBox_1.addItem(new String(data.c[p][0]));
		
		
		
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.SOUTH);
		
		final JButton button_4 = new JButton("\u5220\u9664");
		
		
		panel_7.add(button_4);
		button_4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		JButton button_5 = new JButton("\u5237\u65B0");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
	            table.setModel(model); 
				try {//刷新
					data.inituser();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int p=0;p<data.countc;p++)
		        	model.addRow(new Object[]{data.c[p][0],data.c[p][1],data.c[p][2],data.c[p][3]});		
				for(int i=0;i<12;i++)
					model.addRow(new Object[]{null, null, null});        
			}
		});
		panel_7.add(button_5);
		button_5.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		

		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				button_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						try {
							boolean b = data.deleteuser(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
							if ( b != false) {
								
								JOptionPane.showMessageDialog(getComponent(0), "删除用户成功");
								
							} 
							else{
								JOptionPane.showMessageDialog(userFrame.this, "删除用户失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
							}
						} catch (SQLException ex) {
							JOptionPane.showMessageDialog(userFrame.this, "数据库错误" + ex.getMessage(), "错误",
									JOptionPane.ERROR_MESSAGE); // 弹出出错信息提示框
						}
						model.setRowCount(0);
			            table.setModel(model); 		
				try {//刷新
					data.inituser();
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int p=0;p<data.countc;p++)
		        	model.addRow(new Object[]{data.c[p][0],data.c[p][1],data.c[p][2],data.c[p][3]});		
				for(int i=0;i<12;i++)
					model.addRow(new Object[]{null, null, null}); 
					}
				});
				
				
				
			}
		});
		
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				try {
					data.getuser((String) comboBox_1.getSelectedItem());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_2.setText((String) comboBox_1.getSelectedItem());
				txtA_1.setText(data.nowuser[1]);
				textField_3.setText(data.nowuser[2]);
				textField_4.setText(data.nowuser[3]);	
			}
		});
		
	
		
	}
	
	
}