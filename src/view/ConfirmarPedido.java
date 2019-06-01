package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.DB;
import control.TableModel;
import model.Troco;
import javax.swing.JTable;

public class ConfirmarPedido extends JFrame {

	private JPanel contentPane;
	private JTable tableConfirma;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmarPedido frame = new ConfirmarPedido();
					frame.setVisible(true);
					frame.setTitle("Confirma");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConfirmarPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableConfirma = new JTable();
		tableConfirma.setBounds(21, 59, 335, 113);
		contentPane.add(tableConfirma);
		
		Troco troco = new Troco();
		
		DB bd = new DB();
		
		if(bd.getConnection()) {
			
			DefaultTableModel modelFinal = (DefaultTableModel) tableConfirma.getModel();
			//String sqlMostrarPedido = "SELECT * FROM PRODUTO P WHERE EXISTS (SELECT * FROM PEDIDO PE WHERE P.COD_PRODUTO = PE.COD_PRODUTO AND PE.COD_CLIENTE = ?) ";
			
			/*try {
				
				String[] cod = new String[troco.getQuantidadeArray()];
				
				for(int i = 0; i < troco.getQuantidadeArray(); i++) {
					String sqlMostrarPedido = "SELECT PED.COD_PEDIDO, P.NOME,P.VALOR_UNITARIO FROM CLIENTE C ,PEDIDO PED, PRODUTO P WHERE PED.COD_CLIENTE='" + cod[i]  +"' AND C.COD_CLIENTE=PED.COD_CLIENTE AND P.COD_PRODUTO=PED.COD_PRODUTO";
				}
				
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
				}*/
 		}
		
		
	}
}
