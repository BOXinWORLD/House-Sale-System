package all;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;


public class Login extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	JLabel lblNewLabel_1 = new JLabel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	class newpanel extends JPanel{
		public void paintComponent(Graphics g) {
			File f = new File("");//参数为空
			
			Image image=Toolkit.getDefaultToolkit().getImage( f.getAbsolutePath()+"//666.jpg"); 
		      super.paintComponent(g);
		      setBackground(Color.WHITE);
		      if (image != null) {
		         int height = image.getHeight(this);
		         int width = image.getWidth(this);
		 
		         if (height != -1 && height > getHeight())
		            height = getHeight();
		 
		         if (width != -1 && width > getWidth())
		            width = getWidth();
		 
		         int x = (int) (((double) (getWidth() - width)) / 2.0);
		         int y = (int) (((double) (getHeight() - height)) / 2.0);
		         g.drawImage(image, x, y, width, height, this);
		      }
		   }
			
		}
	//添加背景图
	public Login() {
		
		
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);

       
		

		
		setTitle("\u623F\u5C4B\u552E\u5356-\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("微软雅黑", Font.BOLD, 25));
		label.setBounds(73, 22, 121, 82);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("  \u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 25));
		label_1.setBounds(83, 90, 121, 82);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u767B\u9646");
		button.setFont(new Font("幼圆", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(data.login(textField.getText(), String.valueOf(passwordField.getPassword())))
					{
					try {
									mainFrame frame1 = new mainFrame();
									frame1.setVisible(true);
									frame1.setLocationRelativeTo(null);
								} catch (Exception b) {
									b.printStackTrace();
								}
								setVisible(false);
					}
					else JOptionPane.showMessageDialog(Login.this, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(Login.this, "数据库错误", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
				}
						
			}
		});
		button.setBounds(83, 185, 121, 52);
		contentPane.add(button);
		
		JButton button_1 = new JButton("注册");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
				register frame1 = new register();
				frame1.setVisible(true);
				frame1.setLocationRelativeTo(null);
				
			}
		});
		button_1.setFont(new Font("幼圆", Font.BOLD, 15));
		button_1.setBounds(239, 185, 121, 52);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(216, 56, 143, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(216, 124, 143, 24);
		contentPane.add(passwordField);
		
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(184, 154, 122, 18);
		contentPane.add(lblNewLabel_1);
		
		try {
			data.connectToDatabase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		addWindowListener(new WindowAdapter() {//监听关闭事件
//		      public void windowClosing(WindowEvent e) {
//		    	  data.disconnectFromDatabase();
//		      }
//		    });

		
		
		
		
	}
}
