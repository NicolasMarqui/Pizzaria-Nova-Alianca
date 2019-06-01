package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.DB;
import control.TableModel;
import model.PedidoProduto;
import model.Troco;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FinalizarCompra extends JFrame {

	private JPanel contentPane;
	private JTextField codigoClienteFinalizar;
	private JTable tablePedidoAberto;
	private JTable tableConfirmaProduto;
	private JButton btnRemoverProdutoFinalizar;
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
					frame.setTitle("Finalizar");
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
		contentPane.add(tablePedidoAberto);
		
		JLabel lblClientesComPedidos = new JLabel("Clientes com pedidos abertos");
		lblClientesComPedidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientesComPedidos.setBounds(589, 125, 206, 22);
		contentPane.add(lblClientesComPedidos);
		
		DefaultTableModel modelProdFinal = new DefaultTableModel(); 
		tableConfirmaProduto = new JTable(modelProdFinal);
		tableConfirmaProduto.setBounds(87, 159, 327, 133);
		contentPane.add(tableConfirmaProduto);
		
		modelProdFinal.addColumn("Código");
        modelProdFinal.addColumn("Nome");
        modelProdFinal.addColumn("Valor");
		
		btnRemoverProdutoFinalizar = new JButton("Remover Produto");
		btnRemoverProdutoFinalizar.setBounds(273, 303, 140, 23);
		contentPane.add(btnRemoverProdutoFinalizar);
		
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
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValor.setBounds(87, 348, 55, 22);
		contentPane.add(lblValor);
		
		JLabel lblR = new JLabel("R$");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblR.setBounds(311, 348, 46, 22);
		contentPane.add(lblR);
		
		JLabel labelValorFinal = new JLabel("0.00");
		labelValorFinal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelValorFinal.setBounds(367, 348, 46, 22);
		contentPane.add(labelValorFinal);
		
		JButton btnFinalizarCompra = new JButton("Finalizar");
		btnFinalizarCompra.setBounds(87, 481, 327, 45);
		contentPane.add(btnFinalizarCompra);
		
		JLabel lblCaixa = new JLabel("Caixa");
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

		btnProcurarPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				labelCodCliente.setText(codigoClienteFinalizar.getText());
				((DefaultTableModel) tableConfirmaProduto.getModel()).setNumRows(0);
				
				if(bd.getConnection()) {
					
					DefaultTableModel modelFinal = (DefaultTableModel) tableConfirmaProduto.getModel();
					String sqlMostrarPedido = "SELECT PED.COD_PEDIDO, P.NOME,P.VALOR_UNITARIO FROM CLIENTE C ,PEDIDO PED, PRODUTO P WHERE PED.COD_CLIENTE='" +  Integer.parseInt(labelCodCliente.getText()) +"' AND C.COD_CLIENTE=PED.COD_CLIENTE AND P.COD_PRODUTO=PED.COD_PRODUTO";
					//String sqlMostrarPedido = "SELECT * FROM PRODUTO P WHERE EXISTS (SELECT * FROM PEDIDO PE WHERE P.COD_PRODUTO = PE.COD_PRODUTO AND PE.COD_CLIENTE = ?) ";
					
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
					
					model = TableModel.getModel(bd, sqlMostrarPedido );
	 				tableConfirmaProduto.setModel(model);	 				
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
							
							if(Integer.parseInt(textComValorPago.getText()) < valorTotalCompra) {
								JOptionPane.showMessageDialog(null, "Ops..O valor pago é menor que o de compra");
							}else {
								
								int input = JOptionPane.showOptionDialog(null, "Troco no valor de " + (Integer.parseInt(textComValorPago.getText()) - valorTotalCompra) + " reais", "Troco", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

								if(input == JOptionPane.OK_OPTION)
								{
									/*if(bd.getConnection()) {
										String alterarProduto = "SELECT PED.COD_PEDIDO, P.NOME,P.VALOR_UNITARIO FROM CLIENTE C ,PEDIDO PED, PRODUTO P WHERE PED.COD_CLIENTE='" +  Integer.parseInt(labelCodCliente.getText()) +"' AND C.COD_CLIENTE=PED.COD_CLIENTE AND P.COD_PRODUTO=PED.COD_PRODUTO";
									}*/
									
									System.out.println(Arrays.toString(troco.getCodigos()));
								}
							}
							
							
						}else {
							JOptionPane.showMessageDialog(null, "Selecione um cliente antes");
						}
					}
				}else {
					if(tableConfirmaProduto.getRowCount() > 0) {
						String numeroCartao = JOptionPane.showInputDialog("Digite o numero do Cartão: ");
					}			
				}
			}
		});

	}
}
