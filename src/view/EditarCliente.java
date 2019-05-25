package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import control.TableModel;
import model.*;
import control.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField searchCliente;
	private JTable table;
	private JTextField editarNomeCliente;
	private JTextField editarCPFCliente;
	private JTextField editarCidadeCliente;
	private JTextField editarRuaCliente;
	private JTextField editarBairroCliente;
	private JTextField editarNumeroCliente;
	private JTextField editarCEPCliente;
	private JTextField editarTelefoneCliente;
	private DefaultTableModel model;
	private JTextField seachCliente;
	private JTextField Id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarCliente frame = new EditarCliente();
					frame.setVisible(true);
					frame.setTitle("Editar/Remover Cliente");
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		label.setBounds(56, 186, 100, 23);
		contentPane.add(label);
		
		editarNomeCliente = new JTextField();
		editarNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		editarNomeCliente.setColumns(10);
		editarNomeCliente.setBounds(167, 182, 206, 35);
		contentPane.add(editarNomeCliente);
		
		try {
			editarCPFCliente = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		editarCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		editarCPFCliente.setColumns(10);
		editarCPFCliente.setBounds(169, 233, 206, 35);
		contentPane.add(editarCPFCliente);
		
		JLabel label_2 = new JLabel("CPF");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_2.setBounds(56, 232, 100, 23);
		contentPane.add(label_2);
		
		editarCidadeCliente = new JTextField();
		editarCidadeCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		editarCidadeCliente.setColumns(10);
		editarCidadeCliente.setBounds(166, 288, 206, 35);
		contentPane.add(editarCidadeCliente);
		
		JLabel label_3 = new JLabel("Cidade");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_3.setBounds(56, 287, 100, 23);
		contentPane.add(label_3);
		
		editarRuaCliente = new JTextField();
		editarRuaCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		editarRuaCliente.setColumns(10);
		editarRuaCliente.setBounds(168, 337, 208, 35);
		contentPane.add(editarRuaCliente);
		
		JLabel label_4 = new JLabel("Rua");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_4.setBounds(56, 337, 100, 23);
		contentPane.add(label_4);
		
		editarBairroCliente = new JTextField();
		editarBairroCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		editarBairroCliente.setColumns(10);
		editarBairroCliente.setBounds(167, 388, 206, 38);
		contentPane.add(editarBairroCliente);
		
		JLabel label_5 = new JLabel("Bairro");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_5.setBounds(56, 390, 100, 23);
		contentPane.add(label_5);
		
		editarNumeroCliente = new JTextField();
		editarNumeroCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		editarNumeroCliente.setColumns(10);
		editarNumeroCliente.setBounds(170, 446, 168, 29);
		contentPane.add(editarNumeroCliente);
		
		JLabel label_6 = new JLabel("Numero");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_6.setBounds(56, 450, 100, 23);
		contentPane.add(label_6);
		
		try {
			editarCEPCliente = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		editarCEPCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		editarCEPCliente.setColumns(10);
		editarCEPCliente.setBounds(610, 178, 168, 35);
		contentPane.add(editarCEPCliente);
		
		JLabel label_7 = new JLabel("CEP");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_7.setBounds(520, 182, 100, 23);
		contentPane.add(label_7);
		
		try {
			editarTelefoneCliente = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		editarTelefoneCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		editarTelefoneCliente.setColumns(10);
		editarTelefoneCliente.setBounds(613, 243, 237, 31);
		contentPane.add(editarTelefoneCliente);
		
		JLabel label_8 = new JLabel("Telefone");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_8.setBounds(500, 247, 100, 23);
		contentPane.add(label_8);
		
		
		seachCliente = new JTextField();
		DB bd = new DB();
		bd.getConnection();
		model = TableModel.getModel(bd,"SELECT * FROM cliente");
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				Id.setText(table.getModel().getValueAt(row, 0).toString());
				editarNomeCliente.setText(table.getModel().getValueAt(row, 1).toString());
				editarCPFCliente.setText(table.getModel().getValueAt(row, 2).toString());
				editarCidadeCliente.setText(table.getModel().getValueAt(row, 3).toString());
				editarRuaCliente.setText(table.getModel().getValueAt(row, 4).toString());
				editarBairroCliente.setText(table.getModel().getValueAt(row, 5).toString());
				editarNumeroCliente.setText(table.getModel().getValueAt(row, 6).toString());
				editarCEPCliente.setText(table.getModel().getValueAt(row, 7).toString());
				editarTelefoneCliente.setText(table.getModel().getValueAt(row, 8).toString());
			}
		});
		table.setBounds(21, 54, 851, 111);
		contentPane.add(table);
		//JScrollPane sp = new JScrollPane(table);
		//contentPane.add(sp);
		
		seachCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(bd.getConnection()) {
					String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
					
					try {
						bd.st = bd.con.prepareStatement(sql);
						bd.st.setString(1, "%" + seachCliente.getText() + "%");
						
						model = TableModel.getModel(bd, sql);
						table.setModel(model);
						
					}catch(IllegalArgumentException erro) {					
						JOptionPane.showMessageDialog(null, erro.toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						bd.close();
					}
				}
			}
		});
		seachCliente.setBounds(39, 21, 257, 20);
		contentPane.add(seachCliente);
		seachCliente.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cliente cliente = new Cliente();
				
				cliente.atualizarCliente(Integer.parseInt(Id.getText()), editarNomeCliente.getText(), editarCPFCliente.getText(), editarCidadeCliente.getText(), editarRuaCliente.getText(), editarBairroCliente.getText(), editarNumeroCliente.getText(), editarCEPCliente.getText(), editarTelefoneCliente.getText());
				
				Id.setText("");
				editarNomeCliente.setText("");
				editarCPFCliente.setText("");
				editarCidadeCliente.setText("");
				editarRuaCliente.setText("");
				editarBairroCliente.setText("");
				editarNumeroCliente.setText("");
				editarCEPCliente.setText("");
				editarTelefoneCliente.setText("");
			}
		});
		btnAtualizar.setBounds(511, 324, 168, 48);
		contentPane.add(btnAtualizar);
		
		JButton btnRemoverCliente = new JButton("Remover Cliente");
		btnRemoverCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Cliente cliente = new Cliente();
				
				cliente.deletarCliente(Integer.parseInt(Id.getText()));
				Id.setText("");
				editarNomeCliente.setText("");
				editarCPFCliente.setText("");
				editarCidadeCliente.setText("");
				editarRuaCliente.setText("");
				editarBairroCliente.setText("");
				editarNumeroCliente.setText("");
				editarCEPCliente.setText("");
				editarTelefoneCliente.setText("");
				
			}
		});
		btnRemoverCliente.setBackground(Color.RED);
		btnRemoverCliente.setForeground(Color.BLACK);
		btnRemoverCliente.setBounds(511, 399, 168, 48);
		contentPane.add(btnRemoverCliente);
		
		Id = new JTextField();
		Id.setBounds(831, 21, 41, 20);
		contentPane.add(Id);
		Id.setColumns(10);
		
	}
}
