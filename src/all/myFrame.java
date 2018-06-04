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



public class myFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtA_1;
	JTabbedPane tabbedPane = new JTabbedPane();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myFrame frame = new myFrame();
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
	public myFrame() {
		setTitle("\u8D26\u6237\u4FE1\u606F\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		tabbedPane.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("ÐÞ¸ÄÕË»§ÐÅÏ¢", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		
		panel_3.setLayout(null);
		panel_2.add(panel_3, BorderLayout.CENTER);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		label_2.setBounds(99, 74, 148, 60);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("\u624B\u673A");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		label_3.setBounds(99, 111, 148, 60);
		panel_3.add(label_3);
		
		JButton button_2 = new JButton("\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if ( data.setuser(textField_2.getText(), 
							txtA_1.getText(),
							textField_3.getText(),
							textField_4.getText(), 
							data.nowuser[0])) 
					{JOptionPane.showMessageDialog(getComponent(0), "ÐÞ¸Ä³É¹¦");} 
					else JOptionPane.showMessageDialog(myFrame.this, "ÐÞ¸ÄÓÃ»§Ê§°Ü", "´íÎó", JOptionPane.ERROR_MESSAGE);// µ¯³ö³ö´íÐÅÏ¢ÌáÊ¾¿ò
				
				}   catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(myFrame.this, "ÐÞ¸ÄÓÃ»§Ê§°Ü", "´íÎó", JOptionPane.ERROR_MESSAGE);// µ¯³ö³ö´íÐÅÏ¢ÌáÊ¾¿ò
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		button_2.setBounds(99, 220, 123, 49);
		panel_3.add(button_2);
		
		JButton button_3 = new JButton("\u5237\u65B0");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				textField_2.setText(data.nowuser[0]);
				txtA_1.setText(data.nowuser[1]);				
				textField_3.setText(data.nowuser[2]);
				textField_4.setText(data.nowuser[3]);
			}
		});
		
		button_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		button_3.setBounds(238, 220, 123, 49);
		panel_3.add(button_3);
		
		txtA_1 = new JTextField();
		
		txtA_1.setColumns(10);
		txtA_1.setBounds(228, 95, 133, 24);
		panel_3.add(txtA_1);

		
		JLabel label_5 = new JLabel("\u7528\u6237\u540D");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		label_5.setBounds(99, 37, 148, 60);
		panel_3.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(228, 58, 133, 24);

		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(228, 132, 133, 24);
		panel_3.add(textField_3);
		
		JLabel label_6 = new JLabel("\u8EAB\u4EFD\u8BC1");
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		label_6.setBounds(99, 147, 148, 60);
		panel_3.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(228, 168, 133, 24);
		panel_3.add(textField_4);
		
		textField_2.setText(data.nowuser[0]);
		txtA_1.setText(data.nowuser[1]);				
		textField_3.setText(data.nowuser[2]);
		textField_4.setText(data.nowuser[3]);

		
		
	}

}