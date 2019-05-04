package view;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import model.*;

public class DashBoard extends JFrame {

	private JPanel contentPane;
	private String fixedLabelText = "Home"; 
	private JTextField cliente_nome;
	private JTextField cliente_telefone;
	private JTextField cliente_cpf;
	private JTextField cliente_cidade;
	private JTextField cliente_bairro;
	private JTextField cliente_rua;
	private JTextField cliente_numero;
	private JTextField cliente_CEP;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setTitle("Dashboard");
					//frame.setUndecorated(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1401, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		displayItens();

	}
	
	public void displayItens() {
		
		ImageIcon logo = new ImageIcon("images\\logo.png");
		
		JPanel card_panel = new JPanel();
		card_panel.setBounds(264, 63, 1130, 785);
		contentPane.add(card_panel);
		card_panel.setLayout(new CardLayout(0, 0));
		
		JPanel home_panel = new JPanel();
		home_panel.setForeground(Color.WHITE);
		home_panel.setLayout(null);
		JLabel logo_label = new JLabel(logo, SwingConstants.CENTER);
		logo_label.setBounds(0, 0, 1130, 675);
		home_panel.add(logo_label);
		card_panel.add(home_panel, "name_92972993277223");
		home_panel.setBackground(new Color(255, 255, 255));
		
		JPanel cadastro_panel = new JPanel();
		card_panel.add(cadastro_panel, "name_94484432854786");
		cadastro_panel.setBackground(Color.GRAY);
		cadastro_panel.setLayout(null);
		
		JPanel escolha_prod_ou_funci = new JPanel();
		escolha_prod_ou_funci.setBounds(0, 0, 1130, 99);
		cadastro_panel.add(escolha_prod_ou_funci);
		escolha_prod_ou_funci.setLayout(null);

		JPanel cadastrar_selecionado_card = new JPanel();
		cadastrar_selecionado_card.setBounds(0, 100, 1130, 575);
		cadastro_panel.add(cadastrar_selecionado_card);
		cadastrar_selecionado_card.setLayout(new CardLayout(0, 0));
		
		JButton btnAdicionarProdutos = new JButton("Produtos");
		btnAdicionarProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) cadastrar_selecionado_card.getLayout();
				cl.show(cadastrar_selecionado_card, "cadas_prod");
			}
		});
		
		
		btnAdicionarProdutos.setBounds(752, 15, 286, 73);
		escolha_prod_ou_funci.add(btnAdicionarProdutos);
		
		JButton btnAdicionarClientes = new JButton("Clientes");
		btnAdicionarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) cadastrar_selecionado_card.getLayout();
				cl.show(cadastrar_selecionado_card, "cadas_cliente");
			}
		});
		btnAdicionarClientes.setBounds(40, 15, 328, 73);
		escolha_prod_ou_funci.add(btnAdicionarClientes);
		
		JPanel cadas_prod_panel = new JPanel();
		cadas_prod_panel.setBackground(Color.WHITE);
		cadastrar_selecionado_card.add(cadas_prod_panel, "cadas_prod");
		cadas_prod_panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastro de Produtos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(419, 46, 292, 52);
		cadas_prod_panel.add(lblNewLabel_2);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNome.setBounds(108, 168, 80, 28);
		cadas_prod_panel.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(198, 165, 197, 31);
		cadas_prod_panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(198, 213, 197, 31);
		cadas_prod_panel.add(textField_1);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTipo.setBounds(108, 216, 80, 28);
		cadas_prod_panel.add(lblTipo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(198, 265, 197, 31);
		cadas_prod_panel.add(textField_2);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPreo.setBounds(108, 268, 80, 28);
		cadas_prod_panel.add(lblPreo);
		
		JPanel cadas_clientes_panel = new JPanel();
		cadas_clientes_panel.setBackground(Color.WHITE);
		cadastrar_selecionado_card.add(cadas_clientes_panel, "cadas_cliente");
		cadas_clientes_panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(97, 160, 100, 23);
		cadas_clientes_panel.add(lblNewLabel_1);
		
		JLabel labelClienteTitlle = new JLabel("Cadastro de Clientes");
		labelClienteTitlle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelClienteTitlle.setBounds(399, 34, 337, 54);
		cadas_clientes_panel.add(labelClienteTitlle);
		
		/*CADASTRO DE CLIENTES FIELDS*/
		
		cliente_nome = new JTextField();
		cliente_nome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_nome.setBounds(227, 154, 206, 35);
		cadas_clientes_panel.add(cliente_nome);
		cliente_nome.setColumns(10);
		
		cliente_telefone = new JTextField();
		cliente_telefone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_telefone.setColumns(10);
		cliente_telefone.setBounds(227, 208, 206, 35);
		cadas_clientes_panel.add(cliente_telefone);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTelefone.setBounds(97, 214, 100, 23);
		cadas_clientes_panel.add(lblTelefone);
		
		cliente_cpf = new JTextField();
		cliente_cpf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_cpf.setColumns(10);
		cliente_cpf.setBounds(227, 263, 206, 40);
		cadas_clientes_panel.add(cliente_cpf);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCpf.setBounds(97, 271, 100, 23);
		cadas_clientes_panel.add(lblCpf);
		
		cliente_cidade = new JTextField();
		cliente_cidade.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_cidade.setColumns(10);
		cliente_cidade.setBounds(227, 314, 208, 35);
		cadas_clientes_panel.add(cliente_cidade);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCidade.setBounds(97, 326, 100, 23);
		cadas_clientes_panel.add(lblCidade);
		
		cliente_bairro = new JTextField();
		cliente_bairro.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_bairro.setColumns(10);
		cliente_bairro.setBounds(227, 360, 206, 38);
		cadas_clientes_panel.add(cliente_bairro);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBairro.setBounds(97, 375, 100, 23);
		cadas_clientes_panel.add(lblBairro);
		
		cliente_rua = new JTextField();
		cliente_rua.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_rua.setColumns(10);
		cliente_rua.setBounds(684, 154, 351, 35);
		cadas_clientes_panel.add(cliente_rua);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRua.setBounds(574, 160, 100, 23);
		cadas_clientes_panel.add(lblRua);
		
		cliente_numero = new JTextField();
		cliente_numero.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_numero.setColumns(10);
		cliente_numero.setBounds(684, 206, 168, 39);
		cadas_clientes_panel.add(cliente_numero);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNumero.setBounds(574, 214, 100, 23);
		cadas_clientes_panel.add(lblNumero);
		
		cliente_CEP = new JTextField();
		cliente_CEP.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_CEP.setColumns(10);
		cliente_CEP.setBounds(684, 267, 237, 31);
		cadas_clientes_panel.add(cliente_CEP);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCep.setBounds(574, 271, 100, 23);
		cadas_clientes_panel.add(lblCep);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente clie = new Cliente();
				clie.setNome(cliente_nome.getText());
				System.out.println(clie.getNome());
			}
		});
		btnCadastrar.setBounds(398, 451, 361, 54);
		cadas_clientes_panel.add(btnCadastrar);
		
		JPanel relatorio = new JPanel();
		card_panel.add(relatorio, "relatorio_panel");
		
		JLabel lblNewLabel_3 = new JLabel("Relatorio");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		relatorio.add(lblNewLabel_3);
		
		/*FIM DOS CAMPOS DE CLIENTE*/
		
		//Side MENU 
		
		JPanel side_nav = new JPanel();
		side_nav.setForeground(Color.WHITE);
		side_nav.setBackground(new Color(196, 77, 88));
		side_nav.setBounds(0, 0, 266, 785);
		contentPane.add(side_nav);
		side_nav.setLayout(null);
		
		/* DECORATORS */
		
		JPanel square_top1 = new JPanel();
		square_top1.setBackground(new Color(198, 244, 100));
		square_top1.setBounds(52, 0, 112, 36);
		side_nav.add(square_top1);
		
		JPanel square_top2 = new JPanel();
		square_top2.setBackground(Color.ORANGE);
		square_top2.setBounds(0, 0, 54, 101);
		side_nav.add(square_top2);
		
		
		/* END OF DECORATORS */
		
		JLabel lblRelatrio = new JLabel("Relat\u00F3rio");
		lblRelatrio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) card_panel.getLayout();
				cl.show(card_panel, "relatorio_panel");
				
				fixedLabelText = "Relatorio";
			}
		});
		lblRelatrio.setForeground(Color.WHITE);
		lblRelatrio.setBackground(Color.WHITE);
		lblRelatrio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRelatrio.setBounds(75, 271, 112, 16);
		side_nav.add(lblRelatrio);
		
		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setForeground(Color.WHITE);
		lblVenda.setBackground(Color.WHITE);
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVenda.setBounds(75, 317, 56, 16);
		side_nav.add(lblVenda);
		
	
		JLabel lblInfo = new JLabel("Cadastros");
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBackground(Color.WHITE);
		lblInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) card_panel.getLayout();
				cl.show(card_panel, "name_94484432854786");
				
				fixedLabelText = "Cadastro";
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInfo.setBounds(75, 227, 89, 16);
		side_nav.add(lblInfo);
		
		
		/* HOME COM BACKGROUND COLOR */
		
		JPanel bg_home = new JPanel();
		bg_home.setBackground(Color.RED);
		bg_home.setBounds(0, 162, 266, 52);
		side_nav.add(bg_home);
		bg_home.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardLayout cl = (CardLayout) card_panel.getLayout();
				cl.show(card_panel, "name_92972993277223");
				
				fixedLabelText = "Home";
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblNewLabel.setBounds(75, 13, 43, 21);
		bg_home.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		/* PAINEL FIXO CIMA */
		
		JPanel top_fixed_panel = new JPanel();
		top_fixed_panel.setBackground(new Color(196, 77, 88));
		top_fixed_panel.setBounds(264, 0, 1130, 64);
		DisplayCadastro cad = new DisplayCadastro();
		contentPane.add(top_fixed_panel);
		top_fixed_panel.add(cad);
		top_fixed_panel.setLayout(null);
		
		JButton btnX = new JButton("X");
		
		
				btnX.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						btnX.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
				});
				btnX.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				
				
				btnX.setForeground(Color.WHITE);
				btnX.setBackground(Color.RED);
				btnX.setBounds(1002, 24, 85, 27);
				top_fixed_panel.add(btnX);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(1050, 0, 68, 101);
		top_fixed_panel.add(panel);
		
		JLabel current_activity = new JLabel("Home");
		current_activity.setBounds(562, 13, 117, 27);
		current_activity.setForeground(Color.WHITE);
		top_fixed_panel.add(current_activity);
		
		/*Close Button*/
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		/*End of Close Button*/
		
		/* FIM DO PAINEL FIXO */

		//END OF SIDE MENU
	}
}
