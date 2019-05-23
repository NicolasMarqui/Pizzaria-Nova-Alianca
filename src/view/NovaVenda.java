package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import control.DB;
import control.TableModel;
import model.Cliente;
import model.PedidoProduto;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class NovaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField codProduto;
	private JTextField codCliente;
	private JTextField clienteBusca;
	private JTable table;
	private JTextField quantidadeProd;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaVenda frame = new NovaVenda();
					frame.setVisible(true);
					frame.setTitle("Venda");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovaVenda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 746, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVenda.setBounds(316, 11, 93, 50);
		contentPane.add(lblVenda);
		
		JLabel lblCdigoDoProduto = new JLabel("C\u00F3digo do Produto");
		lblCdigoDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCdigoDoProduto.setBounds(48, 99, 158, 29);
		contentPane.add(lblCdigoDoProduto);
		
		codProduto = new JTextField();
		codProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		codProduto.setBounds(268, 105, 141, 20);
		contentPane.add(codProduto);
		codProduto.setColumns(10);
		
		JLabel lblCdigoOuNome = new JLabel("C\u00F3digo ou nome Cliente");
		lblCdigoOuNome.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCdigoOuNome.setBounds(48, 139, 215, 29);
		contentPane.add(lblCdigoOuNome);
		
		codCliente = new JTextField();
		codCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		codCliente.setColumns(10);
		codCliente.setBounds(268, 145, 141, 20);
		contentPane.add(codCliente);
		
		clienteBusca = new JTextField();		
		clienteBusca.setBounds(542, 105, 148, 20);
		contentPane.add(clienteBusca);
		clienteBusca.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisa");
		btnNewButton.setBounds(574, 139, 93, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(542, 185, 140, 194);
		contentPane.add(table);
		
		JRadioButton checkSemCadastro = new JRadioButton("Cliente sem cadastro");
		checkSemCadastro.setBounds(268, 181, 141, 23);
		contentPane.add(checkSemCadastro);
		
		quantidadeProd = new JTextField();
		quantidadeProd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantidadeProd.setColumns(10);
		quantidadeProd.setBounds(268, 217, 141, 20);
		contentPane.add(quantidadeProd);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblQuantidade.setBounds(48, 211, 215, 29);
		contentPane.add(lblQuantidade);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPagamento.setBounds(48, 262, 123, 29);
		contentPane.add(lblPagamento);
		
		JRadioButton checkDinheiro = new JRadioButton("Dinheiro");	
		checkDinheiro.setBounds(305, 269, 109, 23);
		contentPane.add(checkDinheiro);
		
		JRadioButton checkCartao = new JRadioButton("Cart\u00E3o");
		checkCartao.setBounds(305, 303, 109, 23);
		contentPane.add(checkCartao);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(268, 356, 137, 39);
		contentPane.add(btnFinalizar);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(627, 418, 93, 14);
		contentPane.add(lblData);
		
		ButtonGroup group = new ButtonGroup();
		group.add(checkDinheiro);
		group.add(checkCartao);
		
		/* DADOS */
		
		DB bd = new DB();
		
		if(bd.getConnection()) {
			String sql = "SELECT codigoCliente, nome FROM clientes ";
			
			try {
				model = TableModel.getModel(bd, sql);
				table.setModel(model);
				
			}catch(IllegalArgumentException erro) {					
				JOptionPane.showMessageDialog(null, erro.toString());
			}finally {
				bd.close();
			}
		}
		
		clienteBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(bd.getConnection()) {
					String sql = "SELECT codigoCliente, nome FROM clientes WHERE nome LIKE '%"+clienteBusca.getText()+"%' ";
					
					try {
						model = TableModel.getModel(bd, sql);
						table.setModel(model);
						
					}catch(IllegalArgumentException erro) {					
						JOptionPane.showMessageDialog(null, erro.toString());
					}finally {
						bd.close();
					}
				}
			}
		});
		
		/* ADICIONA NOME EM TEXTFIELD */
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				codCliente.setText(table.getModel().getValueAt(row, 0).toString());

			}
		});
		
		 Date date = Calendar.getInstance().getTime();
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
         String strDate = dateFormat.format(date);  
         lblData.setText(strDate);
         
         btnFinalizar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				if(codProduto.getText() == null || codCliente.getText().trim().isEmpty() || quantidadeProd.getText() == null || quantidadeProd.getText().trim().isEmpty()) {
 					
 					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
 					
 					if(!checkDinheiro.isSelected() && !checkCartao.isSelected()) {
 						JOptionPane.showMessageDialog(null, "Selecione um metodo de pagamento");
 					}
 					
 					
 				}else {
 					
 				}
 			}
 		});
         
         
         checkDinheiro.addItemListener(new ItemListener() {
 			public void itemStateChanged(ItemEvent arg0) {
 				Dinheiro dim = new Dinheiro();
				dim.setVisible(true);
				dim.setLocationRelativeTo(null);
				dim.setResizable(false);
 			}
 		});
         
        
		
	}
}
