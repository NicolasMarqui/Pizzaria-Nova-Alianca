package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import control.DB;

public class Troco {

	private boolean isMoney = false;
	private double valorTotal;
	private double valorPago;	
	private int quantidadeArray;
	private int[] codigos;
	private int codigoPedido;
	
	public Troco() {
		
	}
	
	/**
	 * @return the quantidadeArray
	 */
	public int getQuantidadeArray() {
		return quantidadeArray;
	}

	/**
	 * @param quantidadeArray the quantidadeArray to set
	 */
	public void setQuantidadeArray(int quantidadeArray) {
		this.quantidadeArray = quantidadeArray;
	}

	public Troco(int[] codigos) {
		this.codigos = codigos;
	}
	
	/**
	 * @return the isMoney
	 */
	public boolean isMoney() {
		return isMoney;
	}
	/**
	 * @return the codigos
	 */
	public int[] getCodigos() {
		return codigos;
	}

	/**
	 * @param codigos the codigos to set
	 */
	public void setCodigos(int[] codigos) {
		this.codigos = codigos;
	}

	/**
	 * @return the valorTotal
	 */
	public double getValorTotal() {
		return valorTotal;
	}
	/**
	 * @return the valorPago
	 */
	public double getValorPago() {
		return valorPago;
	}
	/**
	 * @param isMoney the isMoney to set
	 */
	public void setMoney(boolean isMoney) {
		this.isMoney = isMoney;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(double valorTotal) {
		if(this.isMoney) {
			this.valorTotal = valorTotal;
		}
	}
	/**
	 * @param valorPago the valorPago to set
	 */
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	public void salvarCodigos(int[] arrayItem) {
		returnCodigos(arrayItem);
		//return arrayItem;
	}
	
	public boolean salvarTroco(double valorPago, int codigoPedido) {
		DB bd = new DB();
		
		if(bd.getConnection()) {
			
			String sqlSalvarTroco = "INSERT INTO troco(valor_troco,cod_pedido) values(?, ?)";
			
			try{
				
				bd.st = bd.con.prepareStatement(sqlSalvarTroco);
				bd.st.setDouble(1,valorPago);
				bd.st.setInt(2,codigoPedido);
				
				bd.st.executeUpdate();
				
				//JOptionPane.showMessageDialog(null, "Obrigado pela compra");
				
				return true;
				
			}catch(SQLException erro) {
				JOptionPane.showMessageDialog(null, "Não foi possivel salvar o troco");
				JOptionPane.showMessageDialog(null, erro.toString());
				return false;
			}finally {
				bd.close();
			}
		}
		
		return false;
	}
	
	
	public int[] returnCodigos(int[] arrays) {
		int quant = arrays.length;
		
		this.quantidadeArray = quant;
		
		int[] codPedido = new int[quant];
		
		for(int i = 0; i < quant;i++) {
			codPedido[i] = arrays[i];
		}
		
		return codPedido;
		
	}
	
}
