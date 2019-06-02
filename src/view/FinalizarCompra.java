package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.DB;
import control.TableModel;
import model.Pedido;
import model.PedidoProduto;
import model.Produto;
import model.Troco;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class FinalizarCompra extends JFrame {

	private JPanel contentPane;
	private JTextField codigoClienteFinalizar;
	private JTable tablePedidoAberto;
	private JTable tableConfirmaProduto;
	private JLabel lblModoDePagamento;
	private DefaultTableModel model;
	private JTextField textComValorPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalizarCompra frame = new FinalizarCompra();
					frame.setVisible(true);
					frame.setTitle("Caixa");
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FinalizarCompra() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 821, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		codigoClienteFinalizar = new JTextField();	
		codigoClienteFinalizar.setBounds(257, 128, 157, 20);
		contentPane.add(codigoClienteFinalizar);
		codigoClienteFinalizar.setColumns(10);
		
		JLabel lblDigiteOCdigo = new JLabel("C\u00F3digo do Cliente");
		lblDigiteOCdigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDigiteOCdigo.setBounds(87, 125, 139, 22);
		contentPane.add(lblDigiteOCdigo);
		
		tablePedidoAberto = new JTable();
		tablePedidoAberto.setBounds(588, 158, 207, 222);
		
		JScrollPane scrollAberto = new JScrollPane(tablePedidoAberto);
		scrollAberto.setBounds(423, 433, 373, 95);
		
		contentPane.add(scrollAberto);

		JLabel lblClientesComPedidos = new JLabel("Clientes com pedidos abertos");
		lblClientesComPedidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientesComPedidos.setBounds(590, 400, 206, 22);
		contentPane.add(lblClientesComPedidos);
		
		DefaultTableModel modelProdFinal = new DefaultTableModel(); 
		tableConfirmaProduto = new JTable(modelProdFinal);
		tableConfirmaProduto.setBounds(87, 159, 327, 133);
		
		JScrollPane scrollConfirmar = new JScrollPane(tableConfirmaProduto);
		scrollConfirmar.setBounds(87, 159, 687, 157);
		
		contentPane.add(scrollConfirmar);
		
		modelProdFinal.addColumn("Código");
        modelProdFinal.addColumn("Nome");
        modelProdFinal.addColumn("Valor");
		
		lblModoDePagamento = new JLabel("Modo de Pagamento");
		lblModoDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModoDePagamento.setBounds(87, 400, 139, 22);
		contentPane.add(lblModoDePagamento);
		
		JRadioButton checkDinheiro = new JRadioButton("Dinheiro");
		checkDinheiro.setBounds(341, 402, 72, 23);
		contentPane.add(checkDinheiro);
		
		JRadioButton checkCartao = new JRadioButton("Cart\u00E3o");
		checkCartao.setBounds(257, 402, 72, 23);
		contentPane.add(checkCartao);
		
		ButtonGroup groupPagamento = new ButtonGroup();
		groupPagamento.add(checkDinheiro);
		groupPagamento.add(checkCartao);
		
		JButton btnFinalizarCompra = new JButton("Finalizar");
		btnFinalizarCompra.setBounds(87, 481, 327, 45);
		contentPane.add(btnFinalizarCompra);
		
		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setForeground(Color.WHITE);
		lblCaixa.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblCaixa.setBounds(87, 24, 187, 58);
		contentPane.add(lblCaixa);
		
		JButton btnProcurarPedidos = new JButton("Procurar pedidos");
		btnProcurarPedidos.setBounds(424, 127, 133, 23);
		contentPane.add(btnProcurarPedidos);
		
		JLabel labelCodCliente = new JLabel("");
		labelCodCliente.setBounds(749, 11, 46, 14);
		contentPane.add(labelCodCliente);
		
		JPanel panelnserirDinheiro = new JPanel();
		panelnserirDinheiro.setBounds(87, 433, 327, 37);
		contentPane.add(panelnserirDinheiro);
		panelnserirDinheiro.setLayout(null);
		panelnserirDinheiro.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Valor pago: ");
		lblNewLabel.setBounds(10, 11, 92, 14);
		panelnserirDinheiro.add(lblNewLabel);
		
		textComValorPago = new JTextField();
		textComValorPago.setBounds(100, 8, 217, 20);
		panelnserirDinheiro.add(textComValorPago);
		textComValorPago.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 805, 104);
		panel.setBackground(new Color(199, 42, 27));
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(392, 327, 385, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 0, 79, 46);
		panel_1.add(lblValor);
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Dialog", Font.BOLD, 27));
		
		JLabel lblR = new JLabel("R$");
		lblR.setBounds(237, 12, 59, 22);
		panel_1.add(lblR);
		lblR.setForeground(Color.WHITE);
		lblR.setFont(new Font("Dialog", Font.BOLD, 27));
		
		JLabel labelValorFinal = new JLabel("0.00");
		labelValorFinal.setBounds(306, 12, 79, 22);
		panel_1.add(labelValorFinal);
		labelValorFinal.setForeground(Color.WHITE);
		labelValorFinal.setFont(new Font("Dialog", Font.BOLD, 27));
		
		JPanel panelTemDesconto = new JPanel();
		panelTemDesconto.setBounds(87, 327, 295, 45);
		contentPane.add(panelTemDesconto);
		panelTemDesconto.setLayout(null);
		
		JLabel lblMostrarMsg = new JLabel("Tem Desconto");
		lblMostrarMsg.setForeground(Color.RED);
		lblMostrarMsg.setHorizontalAlignment(SwingConstants.LEFT);
		lblMostrarMsg.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblMostrarMsg.setBounds(0, 0, 295, 45);
		panelTemDesconto.add(lblMostrarMsg);
		panelTemDesconto.setVisible(false);
		
		Troco troco = new Troco();
		
		checkDinheiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelnserirDinheiro.setVisible(true);
				troco.setMoney(true);
			}
		});
		
		checkCartao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelnserirDinheiro.setVisible(false);
				troco.setMoney(false);
			}
		});
		

		DB bd = new DB();
		PedidoProduto ped = new PedidoProduto();
		Pedido prod = new Pedido();
		DecimalFormat format = new DecimalFormat("##.00");
		
		if(bd.getConnection()) {
			String sql = "SELECT COD_PEDIDO, COD_CLIENTE, VALOR_PEDIDO, COD_PRODUTO FROM PEDIDO WHERE statusPedido = 0";
			
			try {
				model = TableModel.getModel(bd, sql);
				tablePedidoAberto.setModel(model);
				
			}catch(IllegalArgumentException erro) {					
				
			}finally {
				bd.close();
			}
		}

		btnProcurarPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				labelCodCliente.setText(codigoClienteFinalizar.getText());
				((DefaultTableModel) tableConfirmaProduto.getModel()).setNumRows(0);
				
				if(bd.getConnection()) {
					

					int numeroPedidos = ped.temDesconto(Integer.parseInt(labelCodCliente.getText()));
					
					if(numeroPedidos > 10) {
						panelTemDesconto.setVisible(true);
						
					}else {
						panelTemDesconto.setVisible(false);
					}
					
					
					
					DefaultTableModel modelFinal = (DefaultTableModel) tableConfirmaProduto.getModel();
					String sqlMostrarPedido = "SELECT PED.COD_PEDIDO, P.NOME,P.VALOR_UNITARIO FROM CLIENTE C ,PEDIDO PED, PRODUTO P WHERE PED.COD_CLIENTE='" +  Integer.parseInt(labelCodCliente.getText()) +"' AND C.COD_CLIENTE=PED.COD_CLIENTE AND P.COD_PRODUTO=PED.COD_PRODUTO AND PED.statusPedido = 0";
					
					try {
						
						model = TableModel.getModel(bd, sqlMostrarPedido );
		 				tableConfirmaProduto.setModel(model);
		 				codigoClienteFinalizar.setText("");
						labelCodCliente.setText("");
		 				
					}catch(IllegalArgumentException erro) {
						JOptionPane.showMessageDialog(null, "Não foi possivel achar nenhum produto");
						codigoClienteFinalizar.setText("");
						labelCodCliente.setText("");
					}
					
					/*model = TableModel.getModel(bd, sqlMostrarPedido );
	 				tableConfirmaProduto.setModel(model);*/	 				
	 				int count= tableConfirmaProduto.getModel().getRowCount();
	 				double valorFinal = 0;
	 				int[] ids = new int[count];
	 				
	 				if(count > 0) {
	 					for(int i = 0;i < count;i++) {
	 						valorFinal += Double.parseDouble(tableConfirmaProduto.getModel().getValueAt(i, 2).toString());
	 						labelValorFinal.setText(Double.toString(valorFinal));
	 						ids[i] = Integer.parseInt(tableConfirmaProduto.getModel().getValueAt(i, 0).toString());
	 					}
	 					
	 					//Troco trocoCod = new Troco(ids);
	 					
	 					troco.setCodigos(ids);
	 					troco.setQuantidadeArray(ids.length);
	 					
	 					int valorParaDesconto = 0;
	 					
	 					if(panelTemDesconto.isVisible()) {
							
							if(Double.parseDouble(labelValorFinal.getText()) > 30 && Double.parseDouble(labelValorFinal.getText()) < 50) {
								valorParaDesconto = 10;
								lblMostrarMsg.setText("Desconto de " + valorParaDesconto + "% aplicado");
								
								double desconto = (valorParaDesconto * Double.parseDouble(labelValorFinal.getText())) / 100;
								
								double valorFinalComDesconto = Double.parseDouble(labelValorFinal.getText()) - desconto;
								
								labelValorFinal.setText(Double.toString(valorFinalComDesconto));
							}else if(Double.parseDouble(labelValorFinal.getText()) > 50 && Double.parseDouble(labelValorFinal.getText()) < 200) {
								valorParaDesconto = 20;
								lblMostrarMsg.setText("Desconto de " + valorParaDesconto + "% aplicado");
								
								double desconto = (valorParaDesconto * Double.parseDouble(labelValorFinal.getText())) / 100;
								
								double valorFinalComDesconto = Double.parseDouble(labelValorFinal.getText()) - desconto;
								
								labelValorFinal.setText(format.format(valorFinalComDesconto));
								
							}else if(Double.parseDouble(labelValorFinal.getText()) > 300 && Double.parseDouble(labelValorFinal.getText()) < 1000) {
								valorParaDesconto = 30;
								lblMostrarMsg.setText("Desconto de " + valorParaDesconto + "% aplicado");
								
								double desconto = (valorParaDesconto * Double.parseDouble(labelValorFinal.getText())) / 100;
								
								double valorFinalComDesconto = Double.parseDouble(labelValorFinal.getText()) - desconto;
								
								labelValorFinal.setText(format.format(valorFinalComDesconto));
							}
						}
	 					
	 					System.out.println(Arrays.toString(troco.returnCodigos(ids)));
	 				}
		 		}
			}
		});
		
		
		btnFinalizarCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(tableConfirmaProduto.getRowCount() < 0) {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
				}

				if(panelnserirDinheiro.isVisible()) {
					if(textComValorPago.getText() == null || textComValorPago.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Insira o valor pago");
					}else {
						if(tableConfirmaProduto.getRowCount() > 0) {
							double valorTotalCompra = Double.parseDouble(labelValorFinal.getText());
							
							if(Double.parseDouble(textComValorPago.getText()) < valorTotalCompra) {
								JOptionPane.showMessageDialog(null, "Ops..O valor pago é menor que o de compra");
							}else if(Double.parseDouble(textComValorPago.getText()) == valorTotalCompra) {
								JOptionPane.showMessageDialog(null, "Tudo certo com a compra");
							}else {
								
								int input = JOptionPane.showOptionDialog(null, "Troco no valor de " + (Double.parseDouble(textComValorPago.getText()) - valorTotalCompra) + " reais", "Troco", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

								if(input == JOptionPane.OK_OPTION)
								{
									String menConclude = "Aguarde...";
									
									int valorParaDesconto = 0;
																	
									
									if(panelTemDesconto.isVisible()) {
										
										if(Double.parseDouble(labelValorFinal.getText()) > 30 && Double.parseDouble(labelValorFinal.getText()) < 50) {
											valorParaDesconto = 10;
											lblMostrarMsg.setText("Desconto de " + valorParaDesconto + "% aplicado");
											
											double desconto = (valorParaDesconto * Double.parseDouble(labelValorFinal.getText())) / 100;
											
											double valorFinalComDesconto = Double.parseDouble(labelValorFinal.getText()) - desconto;
											
											labelValorFinal.setText(Double.toString(valorFinalComDesconto));
										}else if(Double.parseDouble(labelValorFinal.getText()) > 50 && Double.parseDouble(labelValorFinal.getText()) < 100) {
											valorParaDesconto = 20;
											lblMostrarMsg.setText("Desconto de " + valorParaDesconto + "% aplicado");
											
											double desconto = (valorParaDesconto * Double.parseDouble(labelValorFinal.getText())) / 100;
											
											double valorFinalComDesconto = Double.parseDouble(labelValorFinal.getText()) - desconto;
											
											labelValorFinal.setText(format.format(valorFinalComDesconto));
											
										}else if(Double.parseDouble(labelValorFinal.getText()) > 100 && Double.parseDouble(labelValorFinal.getText()) < 300) {
											valorParaDesconto = 30;
											lblMostrarMsg.setText("Desconto de " + valorParaDesconto + "% aplicado");
											
											double desconto = (valorParaDesconto * Double.parseDouble(labelValorFinal.getText())) / 100;
											
											double valorFinalComDesconto = Double.parseDouble(labelValorFinal.getText()) - desconto;									
											
											labelValorFinal.setText(format.format(Double.toString(valorFinalComDesconto)));
										}
									}


									for(int i = 0; i < tableConfirmaProduto.getRowCount() ; i++) {
										
										prod.atualizarPedidoStatus(Integer.parseInt(tableConfirmaProduto.getModel().getValueAt(i, 0).toString()));
										
										ped.salvarDesconto(Integer.parseInt(tableConfirmaProduto.getModel().getValueAt(i, 0).toString()), Double.parseDouble(labelValorFinal.getText()) +(Double.parseDouble(labelValorFinal.getText()) * valorParaDesconto / 100 ));
										
										if(troco.salvarTroco((Double.parseDouble(textComValorPago.getText()) - valorTotalCompra), Integer.parseInt(tableConfirmaProduto.getModel().getValueAt(i, 0).toString()))) {
											menConclude = "Obrigado pela compra";
										}else {
											menConclude = "Erro durante salvamento da compra";
										}
									}
									
									JOptionPane.showMessageDialog(null,menConclude);
									textComValorPago.setText("");
									codigoClienteFinalizar.setText("");
								}
							}
							
							
						}else {
							JOptionPane.showMessageDialog(null, "Selecione um cliente antes");
						}
					}
				}else {
					if(tableConfirmaProduto.getRowCount() > 0 && !panelnserirDinheiro.isVisible()) {
						try {
							String numeroCartao = JOptionPane.showInputDialog("Digite o numero do Cartão: ");
							
							if(numeroCartao.length() == 4) {
								JOptionPane.showMessageDialog(null, "Obrigado pela compra");
							}else {
								JOptionPane.showMessageDialog(null, "Erro no cartão");
							}
							
						}catch(NumberFormatException eee) {
							JOptionPane.showMessageDialog(null, "Apenas números");
						}
					}			
				}
			}
		});

	}
}
