package all;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�û�����");
		lblNewLabel.setFont(new Font("΢���ź�", Font.BOLD, 25));
		lblNewLabel.setBounds(68, 40, 146, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("���룺");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.BOLD, 25));
		lblNewLabel_1.setBounds(68, 110, 146, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("�ֻ���");
		label.setFont(new Font("΢���ź�", Font.BOLD, 25));
		label.setBounds(68, 180, 146, 60);
		contentPane.add(label);

        JLabel lblNewLabel_2 = new JLabel("���֤��");
        lblNewLabel_2.setFont(new Font("΢���ź�", Font.BOLD, 25));
		lblNewLabel_2.setBounds(68, 250, 146, 60);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(228, 63, 146, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 203, 146, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 133, 146, 24);
		contentPane.add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setBounds(228, 273, 146, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("ע��");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(data.adduser(textField.getText(),
									String.valueOf(passwordField.getPassword()),
									textField_1.getText(), 
									textField_2.getText()))
					{
						JOptionPane.showMessageDialog(getComponent(0), "ע��ɹ�");

					}
					else JOptionPane.showMessageDialog(register.this, "ע��ʧ��", "����", JOptionPane.ERROR_MESSAGE);// ����������Ϣ��ʾ��
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(register.this, "ע��ʧ��", "����", JOptionPane.ERROR_MESSAGE);// ����������Ϣ��ʾ��
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(register.this, "ע��ʧ��", "����", JOptionPane.ERROR_MESSAGE);// ����������Ϣ��ʾ��
				}
			}
		});
		btnNewButton.setFont(new Font("΢���ź�", Font.BOLD, 25));
		btnNewButton.setBounds(145, 335, 160, 50);
		contentPane.add(btnNewButton);
		


	}
}
