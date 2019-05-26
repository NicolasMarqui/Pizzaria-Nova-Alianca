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

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinalizarCompra extends JFrame {

	private JPanel contentPane;
	private JTextField codigoClienteFinalizar;
	private JTable tablePedidoAberto;
	private JTable tableConfirmaProduto;
	private JButton btnRemoverProdutoFinalizar;
	private JLabel lblModoDePagamento;
	private DefaultTableModel model;

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
		checkCartao.setBounds(341, 428, 72, 23);
		contentPane.add(checkCartao);
		
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
		btnFinalizarCompra.setBounds(150, 481, 207, 23);
		contentPane.add(btnFinalizarCompra);
		
		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblCaixa.setBounds(87, 24, 187, 58);
		contentPane.add(lblCaixa);
		
		JButton btnProcurarPedidos = new JButton("Procurar pedidos");
		btnProcurarPedidos.setBounds(424, 127, 133, 23);
		contentPane.add(btnProcurarPedidos);
		
		DB bd = new DB();
		PedidoProduto ped = new PedidoProduto();

		btnProcurarPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				((DefaultTableModel) tableConfirmaProduto.getModel()).setNumRows(0);
				if(bd.getConnection()) {
					
					DefaultTableModel modelFinal = (DefaultTableModel) tableConfirmaProduto.getModel();
					String sqlMostrarPedido = "SELECT PED.COD_PEDIDO, PED.COD_CLIENTE, PED.COD_PRODUTO , PED.VALOR_PEDIDO , P.NOME, P.VALOR_UNITARIO FROM CLIENTE C ,PEDIDO PED, PRODUTO P WHERE PED.COD_CLIENTE = ? AND C.COD_CLIENTE = PED.COD_CLIENTE AND P.COD_PRODUTO = PED.COD_PRODUTO";
					
		 			try {
		 				
		 				bd.st = bd.con.prepareStatement(sqlMostrarPedido);
						bd.st.setInt(1,Integer.parseInt(codigoClienteFinalizar.getText() ));
						
						bd.rs = bd.st.executeQuery();
						
						if(!bd.rs.next()) {
							JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado para esse cliente");
						}
						
						while(bd.rs.next()) {
							
							int id = bd.rs.getInt("cod_produto");
							String nome = bd.rs.getString("nome");
							double preco = bd.rs.getDouble("valor_unitario");
							
							modelFinal.addRow(new Object[]{id,nome,preco});
						}
		 				
		 				model = TableModel.getModel(bd, sqlMostrarPedido );
		 				tableConfirmaProduto.setModel(model);
		 				
		 			}catch(IllegalArgumentException erro) {					
		 				JOptionPane.showMessageDialog(null, erro.getMessage().toString());
		 			} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage().toString());
					}finally {
		 				bd.close();
		 			}
		 		}
			}
		});
	}
}
