package all;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.UIManager;



public class mainFrame extends JFrame {

	private JPanel contentPane;
	JTabbedPane tabbedPane = new JTabbedPane();
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	String img1 =new String();
	String img2 =new String();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	class imgPanel1 extends JPanel{

	    Image image=null;

	     

	    public void paint(Graphics g){

	        try {
	        	if(!img1.isEmpty()){
	            image=ImageIO.read(new File(img1));
	        	g.drawImage(image, 0, 0, 200, 200, null);}
	            else g.clearRect(0, 0, getSize().width, getSize().height);  

	        } catch (Exception e) {

	            // TODO Auto-generated catch block

	            e.printStackTrace();

	        }

	    }

	    
	}
	class imgPanel2 extends JPanel{

	    Image image=null;

	     

	    public void paint(Graphics g){

	        try {
	        	if(!img2.isEmpty()){
	            image=ImageIO.read(new File(img2));
	        	g.drawImage(image, 0, 0, 200, 200, null);}
	            else g.clearRect(0, 0, getSize().width, getSize().height);  

	        } catch (Exception e) {

	            // TODO Auto-generated catch block

	            e.printStackTrace();

	        }

	    }

	    
	}
	
	
	
	public mainFrame() {
		if (data.juese==1)setTitle("房屋售卖系统-管理员权限");
		else setTitle("房屋售卖系统-用户权限");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("账户信息管理");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(data.juese==1){
				userFrame frame = new userFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				}
				else {
					myFrame frame = new myFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}
			}
		});
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));	
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		tabbedPane.setFont(new Font("微软雅黑", Font.BOLD, 18));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		
		
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("房屋信息", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 465, 471);
		panel_5.add(scrollPane_1);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_1.setViewportView(table);
		final DefaultTableModel model;
		table.setModel(model=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"房屋地址", "价格/w", "面积/m2", "状态"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(464, 0, 503, 471);
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnNewButton = new JButton("\u5237\u65B0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//刷新
				model.setRowCount(0);
				try {
					data.inithouse(0);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int p=0;p<data.counta;p++)
		        	model.addRow(new Object[]{data.a[p][0],data.a[p][1],data.a[p][2],data.a[p][3]});
				for(int i=0;i<32;i++)
					model.addRow(new Object[]{null, null, null});
				table.setModel(model);
			}
		});

		btnNewButton.setBounds(0, 343, 139, 37);
		panel_7.add(btnNewButton);
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		
		JButton button = new JButton("价格↓排序");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//价格刷新
				model.setRowCount(0);
				try {
					data.inithouse(1);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int p=0;p<data.counta;p++)
		        	model.addRow(new Object[]{data.a[p][0],data.a[p][1],data.a[p][2],data.a[p][3]});
				for(int i=0;i<32;i++)
					model.addRow(new Object[]{null, null, null});
				table.setModel(model);
			}
		});
		button.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button.setBounds(0, 382, 139, 37);
		panel_7.add(button);
		
		JButton button_1 = new JButton("面积↓排序");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//大小刷新
				model.setRowCount(0);
				try {
					data.inithouse(2);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int p=0;p<data.counta;p++)
		        	model.addRow(new Object[]{data.a[p][0],data.a[p][1],data.a[p][2],data.a[p][3]});
				for(int i=0;i<32;i++)
					model.addRow(new Object[]{null, null, null});
				table.setModel(model);
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button_1.setBounds(0, 421, 139, 37);
		panel_7.add(button_1);
		
		JButton btnNewButton_1 = new JButton("购买");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 22));
		btnNewButton_1.setBounds(241, 366, 139, 53);
		if(data.juese==0)
			panel_7.add(btnNewButton_1);
		
		JLabel label = new JLabel("\u5730\u5740\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setBounds(14, 220, 72, 18);
		panel_7.add(label);
		
		JLabel lblm = new JLabel("\u5927\u5C0F/m2\uFF1A");
		lblm.setFont(new Font("宋体", Font.BOLD, 20));
		lblm.setBounds(14, 251, 96, 18);
		panel_7.add(lblm);
		
		JLabel lblw = new JLabel("\u4EF7\u683C/w\uFF1A");
		lblw.setFont(new Font("宋体", Font.BOLD, 20));
		lblw.setBounds(14, 311, 85, 18);
		panel_7.add(lblw);
		
		JLabel label_1 = new JLabel("\u6237\u578B\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(14, 282, 72, 18);
		panel_7.add(label_1);
		
		imgPanel1 panel = new imgPanel1();
		panel.setBounds(86, 13, 200, 200);
		panel.setLayout(null);
		panel_7.add(panel);

		
		imgPanel2 panel_1 = new imgPanel2();
		panel_1.setBounds(289, 13, 200, 200);
		panel_1.setLayout(null);
		panel_7.add(panel_1);

		
		JLabel label_2 = new JLabel("\u56FE\u7247\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(14, 189, 72, 18);
		panel_7.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(403, 311, 86, 24);
		panel_7.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(403, 280, 86, 24);
		panel_7.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(403, 250, 86, 24);
		panel_7.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(86, 219, 403, 24);
		panel_7.add(textField_3);
		
		JButton button_7 = new JButton("\u53D1\u5E03\u65B0\u7684");
		button_7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				newFrame frame3 = new newFrame();
				frame3.setVisible(true);
				frame3.setLocationRelativeTo(null);
				frame3.addWindowListener(new WindowAdapter() {//监听关闭事件
				      public void windowClosing(WindowEvent e) {
				    	//刷新
							model.setRowCount(0);
							try {
								data.inithouse(0);
							} catch (IOException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for(int p=0;p<data.counta;p++)
					        	model.addRow(new Object[]{data.a[p][0],data.a[p][1],data.a[p][2],data.a[p][3]});
							for(int i=0;i<32;i++)
								model.addRow(new Object[]{null, null, null});
							table.setModel(model);
				      }
				    });
			}
		});
		button_7.setFont(new Font("微软雅黑", Font.BOLD, 22));
		button_7.setBounds(158, 384, 139, 53);
		if(data.juese==1)panel_7.add(button_7);
		
		JButton button_8 = new JButton("修改发布");
		button_8.setFont(new Font("微软雅黑", Font.BOLD, 22));
		button_8.setBounds(299, 384, 139, 53);
		if(data.juese==1)panel_7.add(button_8);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(1);
		table.getColumnModel().getColumn(2).setPreferredWidth(1);
		table.getColumnModel().getColumn(3).setPreferredWidth(1);
		
		
		try {
			data.inithouse(0);
		} catch (IOException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int p=0;p<data.counta;p++)
        	model.addRow(new Object[]{data.a[p][0],data.a[p][1],data.a[p][2],data.a[p][3]});
		for(int i=0;i<32;i++)
			model.addRow(new Object[]{null, null, null});
				
				
				
				JPanel panel24 = new JPanel();
				tabbedPane.addTab("订单信息", null, panel24, null);
				panel24.setLayout(null);

				
				JPanel panel27 = new JPanel();
				panel27.setBounds(464, 0, 503, 471);
				panel24.add(panel27);
				panel27.setLayout(null);
				

				
				JLabel labe2 = new JLabel("\u5730\u5740\uFF1A");
				labe2.setFont(new Font("宋体", Font.BOLD, 20));
				labe2.setBounds(14, 220, 72, 18);
				panel27.add(labe2);
				
				JLabel lbl2 = new JLabel("\u5927\u5C0F/m2\uFF1A");
				lbl2.setFont(new Font("宋体", Font.BOLD, 20));
				lbl2.setBounds(14, 251, 96, 18);
				panel27.add(lbl2);
				
				JLabel lbl12 = new JLabel("\u4EF7\u683C/w\uFF1A");
				lbl12.setFont(new Font("宋体", Font.BOLD, 20));
				lbl12.setBounds(14, 311, 85, 18);
				panel27.add(lbl12);
				
				JLabel label21 = new JLabel("\u6237\u578B\uFF1A");
				label21.setFont(new Font("宋体", Font.BOLD, 20));
				label21.setBounds(14, 282, 72, 18);
				panel27.add(label21);
				
				imgPanel1 panl2 = new imgPanel1();
				panl2.setBounds(86, 13, 200, 200);
				panel27.add(panl2);
				
				imgPanel2 panel12 = new imgPanel2();
				panel12.setBounds(289, 13, 200, 200);
				panel27.add(panel12);
				
				JLabel label22 = new JLabel("\u56FE\u7247\uFF1A");
				label22.setFont(new Font("宋体", Font.BOLD, 20));
				label22.setBounds(14, 189, 72, 18);
				panel27.add(label22);
				
				textField_8 = new JTextField();
				textField_8.setEditable(false);
				textField_8.setColumns(10);
				textField_8.setBounds(86, 219, 403, 24);
				panel27.add(textField_8);
				
				textField_9 = new JTextField();
				textField_9.setEditable(false);
				textField_9.setColumns(10);
				textField_9.setBounds(403, 250, 86, 24);
				panel27.add(textField_9);
				
				textField_10 = new JTextField();
				textField_10.setEditable(false);
				textField_10.setColumns(10);
				textField_10.setBounds(403, 281, 86, 24);
				panel27.add(textField_10);
				
				textField_11 = new JTextField();
				textField_11.setEditable(false);
				textField_11.setColumns(10);
				textField_11.setBounds(403, 310, 86, 24);
				panel27.add(textField_11);
				
				JButton button_5 = new JButton("\u53D6\u6D88\u8BA2\u5355");
				button_5.setFont(new Font("微软雅黑", Font.BOLD, 22));
				button_5.setBounds(241, 366, 139, 53);
				panel27.add(button_5);
				
				JButton button_6 = new JButton("\u5237\u65B0");				
				button_6.setFont(new Font("微软雅黑", Font.BOLD, 20));
				button_6.setBounds(0, 343, 139, 37);
				panel27.add(button_6);
						
				final DefaultTableModel model112;
						JScrollPane scrollPane21 = new JScrollPane();
						scrollPane21.setBounds(0, 0, 465, 471);
						panel24.add(scrollPane21);
						
						JTable table22 = new JTable();
						table22.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						
						scrollPane21.setViewportView(table22);
						table22.setModel(model112=new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"房屋地址", "价格", "买家", "订单时间"
							}
						) {
							boolean[] columnEditables = new boolean[] {
								false, false, false, false
							};
							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
						
						
						
						
						table22.getColumnModel().getColumn(0).setPreferredWidth(200);
						table22.getColumnModel().getColumn(1).setPreferredWidth(1);
						table22.getColumnModel().getColumn(2).setPreferredWidth(1);
						table22.getColumnModel().getColumn(3).setPreferredWidth(80);
						try {
							data.initbuy();
						} catch (IOException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for(int p=0;p<data.countb;p++)
				        	model112.addRow(new Object[]{data.b[p][0],data.b[p][1],data.b[p][2],data.b[p][3]});
						for(int i=0;i<32;i++)
							model112.addRow(new Object[]{null, null, null});
						
						
						button_6.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								//刷新订单
								model112.setRowCount(0);
								try {
									data.initbuy();
								} catch (IOException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								for(int p=0;p<data.countb;p++)
						        	model112.addRow(new Object[]{data.b[p][0],data.b[p][1],data.b[p][2],data.b[p][3]});
								for(int i=0;i<32;i++)
									model112.addRow(new Object[]{null, null, null});
								table22.setModel(model112);
							}
						});
						
						
						table22.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								button_5.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
								
										try {
											boolean b = data.deletebuy(String.valueOf(table22.getValueAt(table22.getSelectedRow(), 0)));
											if ( b != false) {
												
												JOptionPane.showMessageDialog(getComponent(0), "删除订单成功");
												textField_8.setText("");
												textField_9.setText("");
												textField_10.setText("");
												textField_11.setText("");
												img1=new String();
												img2=new String();
												panel12.repaint();
												panl2.repaint();
											} 
											else{
												JOptionPane.showMessageDialog(mainFrame.this, "删除订单失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
											}
										} catch (SQLException ex) {
											JOptionPane.showMessageDialog(mainFrame.this, "数据库错误" + ex.getMessage(), "错误",
													JOptionPane.ERROR_MESSAGE); // 弹出出错信息提示框
										}
										model112.setRowCount(0);
							            table22.setModel(model112);
										try {
											data.initbuy();
										} catch (IOException | SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										for(int p=0;p<data.countb;p++)
								        	model112.addRow(new Object[]{data.b[p][0],data.b[p][1],data.b[p][2],data.b[p][3]});
										for(int i=0;i<32;i++)
											model112.addRow(new Object[]{null, null, null});
									
									}
								});
								
								
								
							}
						});
						

						//显示详细
						table.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								try {
									data.gethouse(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
									textField.setText(data.get[3]);
									textField_1.setText(data.get[2]);
									textField_2.setText(data.get[1]);
									textField_3.setText(data.get[0]);
									data.readDB2Image(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
									img1="D:\\temp\\1.png";
									img2="D:\\temp\\2.png";
									panel.repaint();
									panel_1.repaint();
									

								
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						});
						
						table22.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								try {
									data.gethouse(String.valueOf(table22.getValueAt(table22.getSelectedRow(), 0)));
									textField_11.setText(data.get[3]);
									textField_10.setText(data.get[2]);
									textField_9.setText(data.get[1]);
									textField_8.setText(data.get[0]);
									data.readDB2Image(String.valueOf(table22.getValueAt(table22.getSelectedRow(), 0)));
									img1="D:\\temp\\1.png";								
									panl2.repaint();
									img2="D:\\temp\\2.png";
									panel12.repaint();
								
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						});
						
						button_8.addActionListener(new ActionListener() {//修改房屋信息
							public void actionPerformed(ActionEvent e) {
								if(String.valueOf(table.getValueAt(table.getSelectedRow(), 3)).equals("已售"))
									JOptionPane.showMessageDialog(mainFrame.this, "不可修改已售房屋信息", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框;
								else{
								try {
									if(data.sethouse(textField_3.getText(), 
											textField_2.getText(), 
											textField_1.getText(), 
											textField.getText(), 
											String.valueOf(table.getValueAt(table.getSelectedRow(), 0)))
								)
									{JOptionPane.showMessageDialog(getComponent(0), "修改重新发布成功");
									//刷新
									model.setRowCount(0);
									try {
										data.inithouse(0);
									} catch (IOException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									for(int p=0;p<data.counta;p++)
							        	model.addRow(new Object[]{data.a[p][0],data.a[p][1],data.a[p][2],data.a[p][3]});
									for(int i=0;i<32;i++)
										model.addRow(new Object[]{null, null, null});
									table.setModel(model);
									}
									else JOptionPane.showMessageDialog(mainFrame.this, "发布失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框

								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									JOptionPane.showMessageDialog(mainFrame.this, "发布失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
								}
								
							}}
						});
						
						
						
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									if(data.addbuy(String.valueOf(table.getValueAt(table.getSelectedRow(), 0))))
									{	JOptionPane.showMessageDialog(getComponent(0), "下单购买成功");
									textField_3.setText("");
									textField_2.setText("");
									textField_1.setText("");
									textField.setText("");
//									img1=new String();
//									img2=new String();
//									panel.repaint();
//									panel_1.repaint();
									//刷新
									model.setRowCount(0);
									try {
										data.inithouse(0);
									} catch (IOException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									for(int p=0;p<data.counta;p++)
							        	model.addRow(new Object[]{data.a[p][0],data.a[p][1],data.a[p][2],data.a[p][3]});
									for(int i=0;i<32;i++)
										model.addRow(new Object[]{null, null, null});
									table.setModel(model);
									//刷新订单
									model112.setRowCount(0);
									try {
										data.initbuy();
									} catch (IOException | SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									for(int p=0;p<data.countb;p++)
							        	model112.addRow(new Object[]{data.b[p][0],data.b[p][1],data.b[p][2],data.b[p][3]});
									for(int i=0;i<32;i++)
										model112.addRow(new Object[]{null, null, null});
									table22.setModel(model112);
									
									
									}
									else JOptionPane.showMessageDialog(mainFrame.this, "购买失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									JOptionPane.showMessageDialog(mainFrame.this, "购买失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
								}
							}
						});
						
						
						

	}
	
	
	

}