package all;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class newFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String img;
	String img1;
	String img2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newFrame frame = new newFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	class imgPanel extends JPanel{

		public void paintComponent(Graphics g) {			
			Image image=Toolkit.getDefaultToolkit().getImage(img); 
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
	/**
	 * Create the frame.
	 */
	public newFrame() {
		setTitle("\u53D1\u5E03\u623F\u5C4B\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel7 = new JPanel();
		panel7.setBounds(5, 5, 520, 422);
		panel7.setLayout(null);
		contentPane.add(panel7);

		
		JLabel labe = new JLabel("\u5730\u5740\uFF1A");
		labe.setFont(new Font("宋体", Font.BOLD, 20));
		labe.setBounds(14, 220, 72, 18);
		panel7.add(labe);
		
		JLabel lbl = new JLabel("\u5927\u5C0F/m2\uFF1A");
		lbl.setFont(new Font("宋体", Font.BOLD, 20));
		lbl.setBounds(14, 251, 96, 18);
		panel7.add(lbl);
		
		JLabel lbl1 = new JLabel("\u4EF7\u683C/w\uFF1A");
		lbl1.setFont(new Font("宋体", Font.BOLD, 20));
		lbl1.setBounds(14, 311, 85, 18);
		panel7.add(lbl1);
		
		JLabel label1 = new JLabel("\u6237\u578B\uFF1A");
		label1.setFont(new Font("宋体", Font.BOLD, 20));
		label1.setBounds(14, 282, 72, 18);
		panel7.add(label1);
		
		imgPanel panl = new imgPanel();
		panl.setBounds(86, 13, 200, 200);
		panl.setBorder(UIManager.getBorder("CheckBox.border"));
		panl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser chooser = new JFileChooser("D:\\");
				
				FileNameExtensionFilter filter1 = new FileNameExtensionFilter("JPG & PNG images", "jpg","png");
				chooser.setFileFilter(filter1);
				chooser.setMultiSelectionEnabled(false);//设置不可多选
				chooser.setDialogTitle("选择图片");     //自定义选择框标题
				
				int result = chooser.showOpenDialog(chooser);
				if(result == JFileChooser.APPROVE_OPTION){
					
					File upfile = chooser.getSelectedFile();
					img=upfile.getAbsolutePath();
					img1=upfile.getAbsolutePath();
					panl.repaint();

				}
			}
		});
		panel7.add(panl);
		
		imgPanel pan2 = new imgPanel();
		pan2.setBounds(289, 13, 200, 200);
		pan2.setBorder(UIManager.getBorder("CheckBox.border"));
		pan2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser chooser = new JFileChooser("D:\\");
				
				FileNameExtensionFilter filter1 = new FileNameExtensionFilter("JPG & PNG images", "jpg","png");
				chooser.setFileFilter(filter1);
				chooser.setMultiSelectionEnabled(false);//设置不可多选
				chooser.setDialogTitle("选择图片");     //自定义选择框标题
				
				int result = chooser.showOpenDialog(chooser);
				if(result == JFileChooser.APPROVE_OPTION){
					
					File upfile = chooser.getSelectedFile();
					img=upfile.getAbsolutePath();
					img2=upfile.getAbsolutePath();
					pan2.repaint();
				

				}
			}
		});
		panel7.add(pan2);
		
		JLabel label2 = new JLabel("\u56FE\u7247\uFF1A");
		label2.setFont(new Font("宋体", Font.BOLD, 20));
		label2.setBounds(14, 189, 72, 18);
		panel7.add(label2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(86, 219, 403, 24);
		panel7.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(403, 250, 86, 24);
		panel7.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(403, 281, 86, 24);
		panel7.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(403, 310, 86, 24);
		panel7.add(textField_3);
		
		JButton btnNewButton = new JButton("\u53D1\u5E03\u623F\u5C4B");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean b=data.addhouse(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText());
					if ( b != false) {
						if(data.readImage2DB(img1, img2, textField.getText()))
							JOptionPane.showMessageDialog(getComponent(0), "发布成功");
						
					} 
					else{
						JOptionPane.showMessageDialog(newFrame.this, "发布失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(newFrame.this, "发布失败", "错误", JOptionPane.ERROR_MESSAGE);// 弹出出错信息提示框
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 25));
		btnNewButton.setBounds(182, 360, 168, 49);
		panel7.add(btnNewButton);
		

	}
}
