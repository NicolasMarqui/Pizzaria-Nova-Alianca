package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import keeptoo.KGradientPanel;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setBounds(250, 250, 959, 636);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
	public Home() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 941, 593);
		getContentPane().add(panel);
		panel.setLayout(null);

		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setBounds(0, 0, 941, 593);
		gradientPanel.setkEndColor(new java.awt.Color(0, 204, 204));
		gradientPanel.setkGradientFocus(600);
		gradientPanel.setkStartColor(new java.awt.Color(153, 0, 153));
		panel.add(gradientPanel);
		gradientPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(551, 0, 390, 593);
		gradientPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 24));
		lblUsurio.setBounds(74, 189, 252, 31);
		panel_1.add(lblUsurio);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 233, 257, 41);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 24));
		lblSenha.setBounds(79, 304, 252, 30);
		panel_1.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(79, 348, 252, 41);
		panel_1.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
				DashBoard dash = new DashBoard();
				dash.setVisible(true);
				dash.setLocationRelativeTo(null);
				dash.setResizable(false);
				
			}
		});
		btnLogin.setBounds(90, 438, 235, 60);
		panel_1.add(btnLogin);
		
		JLabel lblNovaAliana = new JLabel("Nova Alian\u00E7a ");
		lblNovaAliana.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNovaAliana.setBounds(80, 111, 350, 167);
		gradientPanel.add(lblNovaAliana);
	
	}
}
