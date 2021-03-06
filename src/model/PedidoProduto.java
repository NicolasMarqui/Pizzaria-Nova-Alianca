package model;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import control.DB;

public class PedidoProduto {
	private int cod_produto;
	private int cod_pedido;
	private int quantidade;
	/**
	 * @return the cod_produto
	 */
	public int getCod_produto() {
		return cod_produto;
	}
	/**
	 * @return the cod_pedido
	 */
	public int getCod_pedido() {
		return cod_pedido;
	}
	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}
	/**
	 * @param cod_produto the cod_produto to set
	 */
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	/**
	 * @param cod_pedido the cod_pedido to set
	 */
	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	DB bd = new DB();
	
	public void todosPedidosCliente(int id) {
		if(bd.getConnection()) {
			
			String sqlMostrarPedido = "SELECT PED.COD_PEDIDO, PED.COD_CLIENTE, PED.COD_PRODUTO , PED.VALOR_PEDIDO , P.NOME, P.VALOR_UNITARIO FROM CLIENTE C ,PEDIDO PED, PRODUTO P WHERE PED.COD_CLIENTE = ? AND C.COD_CLIENTE = PED.COD_CLIENTE AND P.COD_PRODUTO = PED.COD_PRODUTO";
			
			try{
				
				bd.st = bd.con.prepareStatement(sqlMostrarPedido);
				bd.st.setInt(1,id);
				
				bd.st.executeUpdate();
				
				//JOptionPane.showMessageDialog(null, "Pedido salvo com sucesso");
							
			}catch(SQLException erro) {
				JOptionPane.showMessageDialog(null, "N�o foi possivel carregar os pedidos, tente novamente mais tarde");
				JOptionPane.showMessageDialog(null, erro.toString());
			}finally {
				bd.close();
			}
		}
	}
	
	public int temDesconto(int codigoCliente) {
		if(bd.getConnection()) {
			
			String sqlChecarDesconto = "SELECT PED.COD_CLIENTE as 'C�digo', C.NOME_CLIENTE AS 'Cliente' , COUNT(PED.COD_CLIENTE ) as 'pedidos' FROM PEDIDO PED, CLIENTE C  WHERE PED.COD_CLIENTE = ? AND C.COD_CLIENTE = ? GROUP BY PED.COD_CLIENTE, C.NOME_CLIENTE";
			
			try{
				
				bd.st = bd.con.prepareStatement(sqlChecarDesconto);
				bd.st.setInt(1,codigoCliente);
				bd.st.setInt(2,codigoCliente);
				
				bd.rs = bd.st.executeQuery();
				
				while (bd.rs.next()) {
					return bd.rs.getInt("pedidos");
		        }
									
			}catch(SQLException erro) {
				return 0;
			}finally {
				bd.close();
			}
		}
		return 0;
	}
	
	public void salvarDesconto(int cod_pedido, double valor_desconto) {
		if(bd.getConnection()) {	
			String salvarDesconto = "INSERT INTO DESCONTO(COD_PEDIDO,VALOR_DESCONTO) VALUES (?,?)";
			
			try{
				
				bd.st = bd.con.prepareStatement(salvarDesconto);
				bd.st.setInt(1,cod_pedido);
				bd.st.setDouble(2,valor_desconto);
				
				bd.st.executeUpdate();
									
			}catch(SQLException erro) {
				
			}finally {
				bd.close();
			}
		}
	}
	
}
