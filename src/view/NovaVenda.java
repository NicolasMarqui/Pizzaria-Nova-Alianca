package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JRadioButton;

public class NovaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField codProduto;
	private JTextField codCliente;
	private JTextField textField;
	private JTable table;
	private JTextField quantidadeProd;

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
		
		textField = new JTextField();
		textField.setBounds(542, 105, 148, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisa");
		btnNewButton.setBounds(574, 139, 75, 23);
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
		
		/* DADOS */
	}
}
