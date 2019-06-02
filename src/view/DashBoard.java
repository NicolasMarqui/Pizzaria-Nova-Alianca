package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import model.*;
import control.*;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;


public class DashBoard extends JFrame {

	private JPanel contentPane;
	private String fixedLabelText = "Home"; 
	private JTextField cliente_nome;
	private JTextField cliente_cpf;
	private JTextField cliente_cidade;
	private JTextField cliente_rua;
	private JTextField cliente_bairro;
	private JTextField cliente_numero;
	private JTextField cliente_cep;
	private JTextField cliente_telefone;
	private JTextField nomeProduto;
	private JTextField tipoProduto;
	private JTextField precoProduto;
	private JTable tableProdutos;
	private DefaultTableModel model;
	private JTable tableProd;
	private JTable tablePrincipal;
	/**
	 * @wbp.nonvisual location=-30,259
	 */
	private final JSlider slider = new JSlider();
	private JTextField textPesquisaData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DB db = new DB();
		db.getConnection();
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
	
	public void displayItens(){
		
		ImageIcon logo = new ImageIcon("images\\logo.png");
		
		JPanel card_panel = new JPanel();
		card_panel.setBounds(264, 63, 1130, 785);
		contentPane.add(card_panel);
		card_panel.setLayout(new CardLayout(0, 0));
		
		
		
		JPanel home_panel = new JPanel();
		home_panel.setForeground(Color.WHITE);
		home_panel.setLayout(null);
		JLabel logo_label = new JLabel(logo, SwingConstants.CENTER);
		logo_label.setBackground(Color.WHITE);
		logo_label.setBounds(269, 142, 613, 194);
		home_panel.add(logo_label);
		card_panel.add(home_panel, "name_92972993277223");
		home_panel.setBackground(new Color(255, 255, 255));
		
		JPanel panelVendas = new JPanel();
		panelVendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelVendas.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelVendas.setBackground(new Color(240,240,240));
			}
		});
		panelVendas.setBounds(74, 466, 268, 199);
		panelVendas.setForeground(Color.WHITE);
		home_panel.add(panelVendas);
		panelVendas.setLayout(null);
		
		Pedido ped = new Pedido();
		
		JLabel labelTotalPedidos = new JLabel(Integer.toString(ped.quantidadePedidos()));
		labelTotalPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		labelTotalPedidos.setFont(new Font("Dialog", Font.BOLD, 36));
		labelTotalPedidos.setBounds(57, 37, 143, 106);
		panelVendas.add(labelTotalPedidos);
		
		JLabel lblProdutos = new JLabel("Vendas");
		lblProdutos.setBounds(108, 154, 76, 14);
		panelVendas.add(lblProdutos);
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setBounds(437, 466, 268, 199);
		home_panel.add(panelProdutos);
		panelProdutos.setLayout(null);
		
		panelProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelProdutos.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelProdutos.setBackground(new Color(240,240,240));
			}
		});
		
		Produto prod = new Produto();
		
		JLabel labelProdutosTotal = new JLabel(Integer.toString(prod.quantidadeProdutos()));
		labelProdutosTotal.setHorizontalAlignment(SwingConstants.CENTER);
		labelProdutosTotal.setFont(new Font("Dialog", Font.BOLD, 36));
		labelProdutosTotal.setBounds(58, 35, 143, 106);
		panelProdutos.add(labelProdutosTotal);
		
		JLabel label_2 = new JLabel("Produtos");
		label_2.setBounds(109, 152, 75, 14);
		panelProdutos.add(label_2);
		
		JPanel panelClientesTotal = new JPanel();
		panelClientesTotal.setBounds(788, 466, 268, 199);
		home_panel.add(panelClientesTotal);
		panelClientesTotal.setLayout(null);
		
		panelClientesTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelClientesTotal.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelClientesTotal.setBackground(new Color(240,240,240));
			}
		});
		
		Cliente cli = new Cliente();
		
		JLabel labelTotalClientes = new JLabel(Integer.toString(cli.quantidadeCliente()));
		System.out.println(Integer.toString(cli.quantidadeCliente()));
		labelTotalClientes.setHorizontalAlignment(SwingConstants.CENTER);
		labelTotalClientes.setFont(new Font("Dialog", Font.BOLD, 36));
		labelTotalClientes.setBounds(66, 36, 143, 106);
		panelClientesTotal.add(labelTotalClientes);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(120, 153, 70, 14);
		panelClientesTotal.add(lblClientes);
		
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
		
		nomeProduto = new JTextField();
		nomeProduto.setBounds(198, 165, 197, 31);
		cadas_prod_panel.add(nomeProduto);
		nomeProduto.setColumns(10);
		tableProd = new JTable();
		tableProd.setBounds(467, 153, 622, 200);
		
		JScrollPane scrollProdutos = new JScrollPane(tableProd);
		scrollProdutos.setBounds(467, 153, 622, 200);
		
		cadas_prod_panel.add(scrollProdutos);
		
		tableProd.repaint();
		
		DB bd = new DB();
		
		if(bd.getConnection()) {
					
			try {
				model = TableModel.getModel(bd, "SELECT * FROM produto");
				tableProd.setModel(model);
				System.out.println(model);
				//JScrollPane sp1 = new JScrollPane(tableProd);
				//cadas_prod_panel.add(sp1);
				
				
				
			}catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}finally {
				bd.close();
			}
		}
			
		
		tipoProduto = new JTextField();
		tipoProduto.setColumns(10);
		tipoProduto.setBounds(198, 213, 197, 31);
		cadas_prod_panel.add(tipoProduto);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTipo.setBounds(108, 216, 80, 28);
		cadas_prod_panel.add(lblTipo);
		
		precoProduto = new JTextField();
		precoProduto.setColumns(10);
		precoProduto.setBounds(198, 265, 197, 31);
		cadas_prod_panel.add(precoProduto);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPreo.setBounds(108, 268, 80, 28);
		cadas_prod_panel.add(lblPreo);
		
		JButton btnSalvarProdutos = new JButton("Salvar");
		btnSalvarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvarProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(nomeProduto.getText() == null || nomeProduto.getText().trim().isEmpty() || tipoProduto.getText() == null || tipoProduto.getText().trim().isEmpty() || precoProduto.getText() == null || precoProduto.getText().trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!!");
					
				}else {
					Produto prod = new Produto();		
					prod.salvarProduto(nomeProduto.getText(), tipoProduto.getText(), Double.parseDouble(precoProduto.getText()));
				}
				
			}
		});
		btnSalvarProdutos.setBounds(198, 342, 197, 61);
		cadas_prod_panel.add(btnSalvarProdutos);
		
		
		
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
		
		try {
			cliente_cpf =  new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//private JTextField telefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
	
		cliente_cpf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_cpf.setColumns(10);
		cliente_cpf.setBounds(227, 208, 206, 35);
		cadas_clientes_panel.add(cliente_cpf);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCPF.setBounds(97, 214, 100, 23);
		cadas_clientes_panel.add(lblCPF);
		
		cliente_cidade = new JTextField();
		cliente_cidade.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_cidade.setColumns(10);
		cliente_cidade.setBounds(227, 263, 206, 40);
		cadas_clientes_panel.add(cliente_cidade);
		
		JLabel lblCpf = new JLabel("Cidade");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCpf.setBounds(97, 271, 100, 23);
		cadas_clientes_panel.add(lblCpf);
		
		cliente_rua = new JTextField();
		cliente_rua.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_rua.setColumns(10);
		cliente_rua.setBounds(227, 314, 208, 35);
		cadas_clientes_panel.add(cliente_rua);
		
		JLabel lblCidade = new JLabel("Rua");
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
		
		cliente_numero = new JTextField();
		cliente_numero.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_numero.setColumns(10);
		cliente_numero.setBounds(684, 154, 168, 35);
		cadas_clientes_panel.add(cliente_numero);
		
		JLabel lblRua = new JLabel("Numero");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRua.setBounds(574, 160, 100, 23);
		cadas_clientes_panel.add(lblRua);
		
		try {
			cliente_cep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		cliente_cep.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_cep.setColumns(10);
		cliente_cep.setBounds(684, 206, 168, 39);
		cadas_clientes_panel.add(cliente_cep);
		
		JLabel lblNumero = new JLabel("CEP");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNumero.setBounds(574, 214, 100, 23);
		cadas_clientes_panel.add(lblNumero);
		
		try {
			cliente_telefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cliente_telefone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cliente_telefone.setColumns(10);
		cliente_telefone.setBounds(684, 267, 237, 31);
		cadas_clientes_panel.add(cliente_telefone);
		
		JLabel lblCep = new JLabel("Telefone");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCep.setBounds(574, 271, 100, 23);
		cadas_clientes_panel.add(lblCep);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cliente_nome.getText() == null || cliente_nome.getText().trim().isEmpty() || cliente_cpf.getText() == null || cliente_cpf.getText().trim().isEmpty() || cliente_cidade.getText() == null || cliente_cidade.getText().trim().isEmpty() || cliente_rua.getText() == null || cliente_rua.getText().trim().isEmpty() || cliente_bairro.getText() == null || cliente_bairro.getText().trim().isEmpty() || cliente_numero.getText() == null || cliente_numero.getText().trim().isEmpty() || cliente_cep.getText() == null || cliente_cep.getText().trim().isEmpty() || cliente_telefone.getText() == null || cliente_telefone.getText().trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					
				}else {
					Cliente cliente = new Cliente();
					cliente.salvarCliente(cliente_nome.getText(),cliente_cpf.getText(),cliente_cidade.getText(),cliente_rua.getText(),cliente_bairro.getText(),cliente_numero.getText(),cliente_cep.getText(),cliente_telefone.getText());
					cliente_nome.setText("");
					cliente_cpf.setText("");
					cliente_cidade.setText("");
					cliente_rua.setText("");
					cliente_bairro.setText("");
					cliente_numero.setText("");
					cliente_cep.setText("");
					cliente_telefone.setText("");
				}
			}
		});
		btnCadastrar.setBounds(398, 451, 361, 54);
		cadas_clientes_panel.add(btnCadastrar);
		
		JPanel relatorio = new JPanel();
		relatorio.setBackground(Color.LIGHT_GRAY);
		card_panel.add(relatorio, "relatorio_panel");
		relatorio.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Relat\u00F3rio");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(505, 22, 118, 37);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		relatorio.add(lblNewLabel_3);
		
		tablePrincipal = new JTable();
		tablePrincipal.setBounds(71, 124, 987, 480);
		
		JScrollPane scrollPane = new JScrollPane(tablePrincipal);
		scrollPane.setBounds(71, 124, 987, 480);
		tablePrincipal.setFillsViewportHeight(true);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.RIGHT );
		tablePrincipal.setDefaultRenderer(String.class, centerRenderer);
		
		relatorio.add(scrollPane);
		
		JTableHeader headerPrincipal = tablePrincipal.getTableHeader();
		headerPrincipal.setBackground(Color.red);
		headerPrincipal.setForeground(Color.white);
		headerPrincipal.setFont(new Font("Tahome", Font.ITALIC, 18));
		((DefaultTableCellRenderer)headerPrincipal.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		headerPrincipal.setPreferredSize(new Dimension(40, 40));
		
		tablePrincipal.setFont(new Font("Tahome", Font.ITALIC, 15));
		tablePrincipal.setRowHeight(25);
		
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.setBounds(920, 625, 138, 44);
		relatorio.add(btnExportar);
		
		JButton btnClienteMaisCompra = new JButton("Cliente + compra");
		btnClienteMaisCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnClienteMaisCompra.setBounds(813, 90, 138, 23);
		relatorio.add(btnClienteMaisCompra);
		
		JComboBox comboBoxValorCompra = new JComboBox();
		comboBoxValorCompra.setModel(new DefaultComboBoxModel(new String[] {"Valor do pedido", ">=50", ">=100", "+250"}));
		comboBoxValorCompra.setBounds(378, 85, 125, 28);
		relatorio.add(comboBoxValorCompra);
		
		JComboBox comboBoxStatus = new JComboBox();		
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Status", "Aberto ", "Pago"}));
		comboBoxStatus.setBounds(513, 85, 125, 28);
		relatorio.add(comboBoxStatus);
		
		try {
			textPesquisaData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textPesquisaData.setBounds(127, 88, 94, 23);
		relatorio.add(textPesquisaData);
		textPesquisaData.setColumns(10);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeriodo.setBounds(71, 90, 46, 14);
		relatorio.add(lblPeriodo);
		
		JButton btnPesquisaPorData = new JButton("Pesquisa");
		btnPesquisaPorData.setBounds(231, 90, 89, 23);
		relatorio.add(btnPesquisaPorData);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(961, 90, 94, 23);
		relatorio.add(btnLimpar);
		
		JButton btnMaisDetalhes = new JButton("Mais detalhes");
		btnMaisDetalhes.setBounds(71, 615, 138, 23);
		relatorio.add(btnMaisDetalhes);
		
		JPanel panel_venda = new JPanel();
		panel_venda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) card_panel.getLayout();
				cl.show(card_panel, "panel_venda");
				
				fixedLabelText = "Venda";
			}
		});
		card_panel.add(panel_venda, "panel_venda");
		
		JLabel lblVenda_1 = new JLabel("Venda");
		panel_venda.add(lblVenda_1);
		
		/*FIM DOS CAMPOS DE CLIENTE*/
		
		//Side MENU 
		
		JPanel side_nav = new JPanel();
		side_nav.setForeground(Color.WHITE);
		side_nav.setBackground(new Color(199, 42, 27));
		side_nav.setBounds(0, 0, 266, 785);
		contentPane.add(side_nav);
		side_nav.setLayout(null);
		
		/* DECORATORS */
		
		JPanel square_top1 = new JPanel();
		square_top1.setBackground(new Color(22, 108, 38));
		square_top1.setBounds(0, 738, 266, 47);
		side_nav.add(square_top1);
		
		
		/* END OF DECORATORS */
		
		JLabel lblRelatrio = new JLabel("Relat\u00F3rio");
		lblRelatrio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout) card_panel.getLayout();
				cl.show(card_panel, "relatorio_panel");
				
				fixedLabelText = "Relatorio";
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRelatrio.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblRelatrio.setFont(new Font("Tahoma", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblRelatrio.setFont(new Font("Tahoma", Font.PLAIN, 17));
			}
		});
		lblRelatrio.setForeground(Color.WHITE);
		lblRelatrio.setBackground(Color.WHITE);
		lblRelatrio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRelatrio.setBounds(75, 271, 181, 16);
		side_nav.add(lblRelatrio);
		
		JLabel lblVenda = new JLabel("Novo Pedido");
		lblVenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FazerPedido venda = new FazerPedido();
				
				venda.setVisible(true);
				venda.setLocationRelativeTo(null);
				venda.setResizable(false);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblVenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 17));
			}
		});
		lblVenda.setForeground(Color.WHITE);
		lblVenda.setBackground(Color.WHITE);
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVenda.setBounds(75, 363, 181, 16);
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
				lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 17));
			}
		});
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInfo.setBounds(75, 227, 181, 16);
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
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
			}
		});
		lblNewLabel.setBounds(75, 13, 181, 21);
		bg_home.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblEditarClientes = new JLabel("Editar Clientes");
		lblEditarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EditarCliente editar = new EditarCliente();
				editar.setVisible(true);
				editar.setLocationRelativeTo(null);
				editar.setResizable(false);
				lblEditarClientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEditarClientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblEditarClientes.setFont(new Font("Tahoma", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblEditarClientes.setFont(new Font("Tahoma", Font.PLAIN, 17));
			}
		});
		lblEditarClientes.setForeground(Color.WHITE);
		lblEditarClientes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEditarClientes.setBounds(75, 310, 181, 28);
		side_nav.add(lblEditarClientes);
		
		JLabel lblFinalizarCompra = new JLabel("Finalizar Compra");
		lblFinalizarCompra.setForeground(Color.WHITE);
		lblFinalizarCompra.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFinalizarCompra.setBackground(Color.WHITE);
		lblFinalizarCompra.setBounds(75, 408, 181, 28);
		side_nav.add(lblFinalizarCompra);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(22, 108, 38));
		panel_2.setBounds(0, 0, 266, 64);
		side_nav.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(0, 0, 266, 64);
		panel_2.add(lblData);
		
		Date date = Calendar.getInstance().getTime();
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
        String strDate = dateFormat.format(date);
        
        lblData.setText(strDate);
		
		lblFinalizarCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FinalizarCompra compra = new FinalizarCompra();
				
				compra.setVisible(true);
				compra.setLocationRelativeTo(null);
				compra.setResizable(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFinalizarCompra.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblFinalizarCompra.setFont(new Font("Tahoma", Font.PLAIN, 22));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblFinalizarCompra.setFont(new Font("Tahoma", Font.PLAIN, 17));
			}
		});
		
		/* PAINEL FIXO CIMA */
		
		JPanel top_fixed_panel = new JPanel();
		top_fixed_panel.setBackground(new Color(199, 42, 27));
		top_fixed_panel.setBounds(264, 0, 1130, 64);
		contentPane.add(top_fixed_panel);
		top_fixed_panel.setLayout(null);
		
		JButton btnFechar = new JButton("X");
		
		
		btnFechar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						btnFechar.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
				});
		btnFechar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				
				
				btnFechar.setForeground(Color.WHITE);
				btnFechar.setBackground(Color.RED);
				btnFechar.setBounds(1013, 18, 85, 27);
				top_fixed_panel.add(btnFechar);
		
		JLabel current_activity = new JLabel("Nova Alian\u00E7a");
		current_activity.setBounds(552, 11, 117, 40);
		current_activity.setForeground(Color.WHITE);
		top_fixed_panel.add(current_activity);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(22, 108, 38));
		panel.setBounds(965, 0, 165, 64);
		top_fixed_panel.add(panel);
		
		/*Close Button*/
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		/*End of Close Button*/
		
		/* FIM DO PAINEL FIXO */

		//END OF SIDE MENU
		
		
		/* COMEÇO RELATORIO */
		
		//relatorio.add(new JScrollPane(tablePrincipal));
		
		tablePrincipal.repaint();
		
		if(bd.getConnection()) {
			String sql = "SELECT COD_PEDIDO AS 'Código', VALOR_PEDIDO AS 'Valor', CONVERT(varchar(10), data_pedido, 103) AS 'Data', COD_CLIENTE, COD_PRODUTO, STATUSPEDIDO AS 'Status' from pedido";
			
			try {
				model = TableModel.getModel(bd, sql);
				tablePrincipal.setModel(model);
				
			}catch(IllegalArgumentException erro) {					
				JOptionPane.showMessageDialog(null, "Erro 6675");
			}finally {
				bd.close();
			}
		}
		
		
		btnPesquisaPorData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMaisDetalhes.setVisible(false);
				if(textPesquisaData.getText() == null || textPesquisaData.getText().trim().isEmpty() || textPesquisaData.getText().length() < 8) {
					JOptionPane.showMessageDialog(null, "Insira uma data antes");
				}else {
					if(bd.getConnection()) {
						String sql = "SELECT COD_PEDIDO AS 'Código', VALOR_PEDIDO AS 'Valor', CONVERT(varchar(10), data_pedido, 103) AS 'Data', COD_CLIENTE, COD_PRODUTO, STATUSPEDIDO AS 'Status' from pedido WHERE DATA_PEDIDO = '" + textPesquisaData.getText() + "'";
						
						try {
							model = TableModel.getModel(bd, sql);
							tablePrincipal.setModel(model);
							
						}catch(IllegalArgumentException erro) {					
							JOptionPane.showMessageDialog(null, "Nenhum produto");
						}finally {
							bd.close();
						}
					}
				}
			}
		});
		
		btnMaisDetalhes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bd.getConnection()) {
					String sql = "\r\n" + 
							"SELECT PED.COD_PEDIDO AS 'Código', PED.VALOR_PEDIDO AS 'Valor', CONVERT(varchar(10), PED.data_pedido, 103) AS 'Data', C.NOME_CLIENTE AS 'Cliente', PROD.NOME AS 'Produto',  case when ped.statusPedido = 1 then 'Pago' when ped.statusPedido = 0 then 'Em Aberto' else 'ERRO' end AS 'Status' from PEDIDO PED, CLIENTE C, PRODUTO PROD WHERE PED.COD_CLIENTE = C.COD_CLIENTE AND PED.COD_PRODUTO = PROD.COD_PRODUTO";
					
					try {
						model = TableModel.getModel(bd, sql);
						tablePrincipal.setModel(model);
						
					}catch(IllegalArgumentException erro) {					
						JOptionPane.showMessageDialog(null, "Erro 6675");
					}finally {
						bd.close();
					}
				}
			}
		});
		
		
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMaisDetalhes.setVisible(true);
				if(bd.getConnection()) {
					String sql = "SELECT COD_PEDIDO AS 'Código', VALOR_PEDIDO AS 'Valor', CONVERT(varchar(10), data_pedido, 103) AS 'Data', COD_CLIENTE, COD_PRODUTO, STATUSPEDIDO AS 'Status' from pedido";
					
					try {
						model = TableModel.getModel(bd, sql);
						tablePrincipal.setModel(model);
						
					}catch(IllegalArgumentException erro) {					
						JOptionPane.showMessageDialog(null, erro.toString());
					}finally {
						bd.close();
					}
				}
			}
		});
		
		btnClienteMaisCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(bd.getConnection()) {
					String sql = "SELECT PED.COD_CLIENTE as 'Código', C.NOME_CLIENTE AS 'Cliente' , COUNT(PED.COD_CLIENTE ) as 'N° de pedidos' FROM PEDIDO PED, CLIENTE C  WHERE PED.COD_CLIENTE = C.COD_CLIENTE GROUP BY PED.COD_CLIENTE, C.NOME_CLIENTE";
					
					try {
						model = TableModel.getModel(bd, sql);
						tablePrincipal.setModel(model);
						
					}catch(IllegalArgumentException erro) {					
						JOptionPane.showMessageDialog(null, erro.toString());
					}finally {
						bd.close();
					}
				}
			}
		});
		
		comboBoxValorCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnMaisDetalhes.setVisible(false);
				
				String valorCombo = comboBoxValorCompra.getSelectedItem().toString();
				
				if(valorCombo.equalsIgnoreCase("Valor do pedido")) {
					comboBoxValorCompra.setSelectedIndex(0);
				}
				
				switch(valorCombo) {
					case ">=50":
						try {
							buscarPorValor(50, 100);
						}catch(NullPointerException erro) {
							JOptionPane.showMessageDialog(null, "Nenhum pedido");
						}
						break;
					case ">=100":
						try {
							buscarPorValor(100, 250);
						}catch(NullPointerException erro) {
							JOptionPane.showMessageDialog(null, "Nenhum pedido");
						}
						break;
					case "+250":
						try {
							buscarPorValor(250, 5000);
						}catch(NullPointerException erro) {
							JOptionPane.showMessageDialog(null, "Nenhum pedido");
						}
						break;
					default:
						buscarPorValor(0, 5000);
				}
				
			}
		});
		
		comboBoxStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnMaisDetalhes.setVisible(false);
				
				String valorCombo = comboBoxStatus.getSelectedItem().toString();
				
				if(valorCombo.equalsIgnoreCase("Status")) {
					comboBoxStatus.setSelectedIndex(0);
				}
				
				System.out.println(valorCombo);
				
				switch(valorCombo) {
					case "Aberto":
						try {
							buscaPorStatus(0);
						}catch(NullPointerException erro) {
							JOptionPane.showMessageDialog(null, "Nenhum pedido");
						}
						break;
					case "Pago":
						try {
							buscaPorStatus(1);
						}catch(NullPointerException erro) {
							JOptionPane.showMessageDialog(null, "Nenhum pedido");
						}
						break;
					default:
						buscaPorStatus(0);
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* FIM RELATORIO */
		
	}
	
	public void buscarPorValor(double valorMinimo, double valorMaximo) {
		DB bd = new DB();
		if(bd.getConnection()) {
			String sql = "SELECT COD_PEDIDO AS 'Código', VALOR_PEDIDO AS 'Valor', CONVERT(varchar(10), data_pedido, 103) AS 'Data', COD_CLIENTE, COD_PRODUTO, STATUSPEDIDO AS 'Status' from pedido WHERE VALOR_PEDIDO >= '" + valorMinimo + "' AND VALOR_PEDIDO < '" + valorMaximo + "'";
			
			try {
				model = TableModel.getModel(bd, sql);
				tablePrincipal.setModel(model);
				
			}catch(IllegalArgumentException erro) {					
				JOptionPane.showMessageDialog(null, "Nenhum pedido encontrado");
				
				model = TableModel.getModel(bd, "SELECT COD_PEDIDO AS 'Código', VALOR_PEDIDO AS 'Valor', CONVERT(varchar(10), data_pedido, 103) AS 'Data', COD_CLIENTE, COD_PRODUTO, STATUSPEDIDO AS 'Status' from pedido");
				tablePrincipal.setModel(model);
				
			}finally {
				bd.close();
			}
		}
	}
	
	public void buscaPorStatus(int status) {
		DB bd = new DB();
		if(bd.getConnection()) {
			String sql = "SELECT COD_PEDIDO AS 'Código', VALOR_PEDIDO AS 'Valor', CONVERT(varchar(10), data_pedido, 103) AS 'Data', COD_CLIENTE, COD_PRODUTO, STATUSPEDIDO AS 'Status' from pedido WHERE statusPedido = '" + status + "'";
			
			try {
				model = TableModel.getModel(bd, sql);
				tablePrincipal.setModel(model);
				
			}catch(IllegalArgumentException erro) {					
				JOptionPane.showMessageDialog(null, "Nenhum pedido encontrado");
				
			}finally {
				bd.close();
			}
		}
	}
}

