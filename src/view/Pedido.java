package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.List;

public class Pedido extends JFrame {

	private JPanel contentPane;
	private JTextField clienteBusca;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textCliente;
	private JTextField pesquisaProduto;
	private JTable tableProduto;
	private JTable tableProdutoFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedido frame = new Pedido();
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
	public Pedido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1067, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVenda = new JLabel("Pedido");
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVenda.setBounds(316, 11, 93, 50);
		contentPane.add(lblVenda);
		
		clienteBusca = new JTextField();		
		clienteBusca.setBounds(534, 125, 148, 20);
		contentPane.add(clienteBusca);
		clienteBusca.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisa");
		btnNewButton.setBounds(589, 151, 93, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(464, 185, 218, 91);
		contentPane.add(table);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(259, 475, 137, 39);
		contentPane.add(btnFinalizar);
		
		ButtonGroup group = new ButtonGroup();
		
		/* DADOS */
		
		DB bd = new DB();
		
		if(bd.getConnection()) {
			String sql = "SELECT cod_cliente, nome_cliente FROM cliente ";
			
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
					String sql = "SELECT cod_cliente, nome_cliente FROM cliente WHERE nome_cliente LIKE '%"+clienteBusca.getText()+"%' ";
					
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
				textCliente.setText(table.getModel().getValueAt(row, 0).toString());

			}
		});
		
		 Date date = Calendar.getInstance().getTime();
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
         String strDate = dateFormat.format(date);
         
         JLabel lblDataDoPedido = new JLabel("Data do pedido");
         lblDataDoPedido.setFont(new Font("Tahoma", Font.PLAIN, 19));
         lblDataDoPedido.setBounds(48, 156, 153, 29);
         contentPane.add(lblDataDoPedido);
         
         JLabel lblValor = new JLabel("Valor");
         lblValor.setFont(new Font("Tahoma", Font.PLAIN, 19));
         lblValor.setBounds(48, 425, 69, 29);
         contentPane.add(lblValor);
         
         JLabel lblCdigoDoCliente = new JLabel("C\u00F3digo do Cliente");
         lblCdigoDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
         lblCdigoDoCliente.setBounds(48, 196, 153, 29);
         contentPane.add(lblCdigoDoCliente);

         DateTimePicker dt = new DateTimePicker();
         
         //textData.setText(dt.toString());
         getContentPane().add(dt);
         
         textCliente = new JTextField();
         textCliente.setColumns(10);
         textCliente.setBounds(293, 203, 116, 22);
         contentPane.add(textCliente);
         
         pesquisaProduto = new JTextField();
         pesquisaProduto.setColumns(10);
         pesquisaProduto.setBounds(844, 125, 148, 20);
         contentPane.add(pesquisaProduto);
         
         JButton searchProduto = new JButton("Pesquisa");
         searchProduto.setBounds(899, 156, 93, 23);
         contentPane.add(searchProduto);
         
         tableProduto = new JTable();         
         tableProduto.setBounds(727, 185, 265, 92);
         contentPane.add(tableProduto);
         
         if(bd.getConnection()) {
 			String sql = "SELECT cod_produto, nome, valor_unitario FROM produto ";
 			
 			try {
 				model = TableModel.getModel(bd, sql);
 				tableProduto.setModel(model);
 				
 			}catch(IllegalArgumentException erro) {					
 				JOptionPane.showMessageDialog(null, erro.toString());
 			}finally {
 				bd.close();
 			}
 		}
         
         JLabel[] labels = new JLabel[100];
         
         /*if(bd.getConnection()) { 	 
  			String sql = "SELECT nome, valor_unitario FROM produto";
  			
  			try {
  				bd.st = bd.con.prepareStatement(sql);
  				bd.rs = bd.st.executeQuery();
  				int columnCount = bd.rs.getMetaData().getColumnCount();
  				
  				while(bd.rs.next())
  				{
  				    for (int i=0; i <columnCount ; i++)
  				    {
  				    	String nomeProd = bd.rs.getString("nome");
  				    	Double precoProd = bd.rs.getDouble("valor_unitario");
  				    	JLabel label = new JLabel(nomeProd);
  				    	JLabel espaco = new JLabel(precoProd.toString());
  				    	panelProdutos.add(label);
  				    	panelProdutos.add(espaco);
  				    }
  				}
  				
  				
  			}catch(IllegalArgumentException erro) {					
  				JOptionPane.showMessageDialog(null, erro.toString());
  			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
  				bd.close();
  			}
  		}*/
         
         JLabel lblValorTotal = new JLabel("0.00");
         lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 26));
         lblValorTotal.setBounds(334, 421, 75, 33);
         contentPane.add(lblValorTotal);
         
         DefaultTableModel modelProdFinal = new DefaultTableModel(); 
         tableProdutoFinal = new JTable(modelProdFinal);
         tableProdutoFinal.setBounds(48, 285, 346, 111);
         contentPane.add(tableProdutoFinal);
         
         modelProdFinal.addColumn("Código");
         modelProdFinal.addColumn("Nome");
         modelProdFinal.addColumn("Valor");
 
         tableProduto.addMouseListener(new MouseAdapter() {
          	@Override
          	public void mouseClicked(MouseEvent arg0) {
          		int row = tableProduto.getSelectedRow();
         
          		DefaultTableModel modelFinal = (DefaultTableModel) tableProdutoFinal.getModel();
          		
          		String codigo = tableProduto.getModel().getValueAt(row, 0).toString();
          		String nome = tableProduto.getModel().getValueAt(row, 1).toString();
          		//String preco = tableProduto.getModel().getValueAt(row, 2).toString();
          		
          		modelFinal.addRow(new Object[]{codigo,nome});
          		
          		int rowCount = tableProdutoFinal.getRowCount();
          		double soma = 0;
          		
          		for(int i = 0; i < rowCount  ;i++) {
          			soma += Integer.parseInt(tableProdutoFinal.getValueAt(i, 0).toString());
          		}
          		
          		lblValorTotal.setText(Double.toString(soma));

          	}
          });

         
         JLabel lblR = new JLabel("R$");
         lblR.setFont(new Font("Tahoma", Font.PLAIN, 19));
         lblR.setBounds(259, 425, 49, 29);
         contentPane.add(lblR);
         
     
           
         
         btnFinalizar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				/*if(codProduto.getText() == null || codCliente.getText().trim().isEmpty() || quantidadeProd.getText() == null || quantidadeProd.getText().trim().isEmpty()) {
 					
 					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
 					
 					if(!checkDinheiro.isSelected() && !checkCartao.isSelected()) {
 						JOptionPane.showMessageDialog(null, "Selecione um metodo de pagamento");
 					}
 					
 					
 				}else {
 					
 				}*/
 			}
 		});
         
        
		
	}
}
