package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.TableModel;
import model.*;
import control.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField searchCliente;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField editar_cliente;
	private JTextField textField_6;
	private JTextField textField_7;
	private DefaultTableModel model;
	private JTextField seachCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarCliente frame = new EditarCliente();
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
	public EditarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(318, 20, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("Nome");
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(55, 176, 100, 23);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setColumns(10);
		textField.setBounds(167, 182, 206, 35);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(169, 233, 206, 35);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("CPF");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_2.setBounds(56, 232, 100, 23);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(166, 288, 206, 35);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("Cidade");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_3.setBounds(56, 287, 100, 23);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(168, 337, 208, 35);
		contentPane.add(textField_3);
		
		JLabel label_4 = new JLabel("Rua");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_4.setBounds(56, 337, 100, 23);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(167, 388, 206, 38);
		contentPane.add(textField_4);
		
		JLabel label_5 = new JLabel("Bairro");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_5.setBounds(56, 390, 100, 23);
		contentPane.add(label_5);
		
		editar_cliente = new JTextField();
		editar_cliente.setFont(new Font("Tahoma", Font.PLAIN, 24));
		editar_cliente.setColumns(10);
		editar_cliente.setBounds(170, 446, 168, 29);
		contentPane.add(editar_cliente);
		
		JLabel label_6 = new JLabel("Numero");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_6.setBounds(56, 450, 100, 23);
		contentPane.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_6.setColumns(10);
		textField_6.setBounds(610, 178, 168, 35);
		contentPane.add(textField_6);
		
		JLabel label_7 = new JLabel("CEP");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_7.setBounds(520, 182, 100, 23);
		contentPane.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_7.setColumns(10);
		textField_7.setBounds(613, 243, 237, 31);
		contentPane.add(textField_7);
		
		JLabel label_8 = new JLabel("Telefone");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_8.setBounds(500, 247, 100, 23);
		contentPane.add(label_8);
		
		table = new JTable();
		table.setBounds(21, 149, 851, -82);
		contentPane.add(table);
		
		seachCliente = new JTextField();
		DB bd = new DB();
		bd.getConnection();
		
		seachCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					String sql = "SELECT * FROM clientes WHERE nome LIKE '"+seachCliente.getText()+"%'";
					model = TableModel.getModel(bd, sql);
					table.setModel(model);
					
				}catch(IllegalArgumentException erro) {					
					JOptionPane.showMessageDialog(null, erro.toString());
				}finally {
					bd.close();
				}
			}
		});
		seachCliente.setBounds(39, 21, 257, 20);
		contentPane.add(seachCliente);
		seachCliente.setColumns(10);
		
	}
}
