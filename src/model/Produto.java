package model;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import control.*;

public class Produto {
	private int cod_produto;
	private boolean valor_unitario;
	private String tipo;
	private String nome;
	
	public Produto(boolean valor_unitario, String tipo, String nome) {
		this.cod_produto = cod_produto;
		this.valor_unitario = valor_unitario;
		this.tipo = tipo;
		this.nome = nome;
	}
	
	public Produto() {
		
	}
	
	/**
	 * @return the cod_produto
	 */
	public int getCod_produto() {
		return cod_produto;
	}
	/**
	 * @return the valor_unitario
	 */
	public boolean isValor_unitario() {
		return valor_unitario;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Metodo para dar set no cod_produto
	 * @param cod_produto the cod_produto to set
	 */
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	/**
	 * Metodo para dar set no valor_unitario
	 * @param valor_unitario the valor_unitario to set
	 */
	public void setValor_unitario(boolean valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	/**
	 * Metodo para dar set no tipo
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Metodo para dar set no nome
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	DB bd = new DB();
	
	public void salvarProduto(String nome, String tipo, double preco) {			
		if(bd.getConnection()) {
			
			String sqlSalvarProd = "INSERT INTO produto(nome,tipo,valor_unitario) values(?, ? , ?)";
			
			try{
				
				bd.st = bd.con.prepareStatement(sqlSalvarProd);
				bd.st.setString(1,nome);
				bd.st.setString(2,tipo);
				bd.st.setDouble(3,preco);
				bd.st.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Produto salvo com sucesso");
				
			}catch(SQLException erro) {
				JOptionPane.showMessageDialog(null, "Não foi possivel salvar o produto, tente novamente mais tarde");
				JOptionPane.showMessageDialog(null, erro.toString());
			}finally {
				bd.close();
			}
		}
	}
	
	public int quantidadeProdutos() {
		if(bd.getConnection()) {
			
			String contarCliente = "SELECT COUNT(*) AS PRODUTOS FROM PRODUTO";
			int value = 0;
			
			try{
				
				bd.st = bd.con.prepareStatement(contarCliente);
				bd.rs = bd.st.executeQuery();			
					
				while (bd.rs.next()) {
					return bd.rs.getInt("PRODUTOS");
		        }
				
				return value;
				
				
			}catch(SQLException erro) {
				
				return 0;
				
				
			}finally {
				bd.close();
			}
			
		}
		return 10;
	}
}
