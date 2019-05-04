package model;

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
	
	
}
