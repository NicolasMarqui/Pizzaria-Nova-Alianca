package model;

public class Pedido {
	private String tipo_pagamento;
	private String data_pedido;
	private boolean valor_pedido;
	private int cod_cliente;
	private int cod_produto;
	private int cod_pedido;
	
	/**
	 * Constructor para adicionar pedido
	 * @param cod_pedido
	 * @param cod_produto
	 * @param cod_cliente
	 * @param valor_pedido
	 * @param data_pedido
	 */
	public Pedido(int cod_pedido, int cod_produto,  int cod_cliente, boolean valor_pedido, String data_pedido) {
		this.cod_pedido = cod_pedido;
		this.cod_produto = cod_produto;
		this.cod_cliente = cod_cliente;
		this.valor_pedido = valor_pedido;
		this.data_pedido = data_pedido;
	}
	
	public Pedido() {
		
	}
	
	
	/**
	 * Metodo para retornar o valor de data_pedido
	 * @return the data_pedido
	 */
	public String getData_pedido() {
		return data_pedido;
	}
	/**
	 * Metodo para dar set no data_pedido
	 * @param data_pedido the data_pedido to set
	 */
	public void setData_pedido(String data_pedido) {
		this.data_pedido = data_pedido;
	}
	/**
	 * Metodo para retornar o valor de valor_pedido
	 * @return the valor_pedido
	 */
	public boolean isValor_pedido() {
		return valor_pedido;
	}
	/**
	 * Metodo para dar set no valor_pedido
	 * @param valor_pedido the valor_pedido to set
	 */
	public void setValor_pedido(boolean valor_pedido) {
		this.valor_pedido = valor_pedido;
	}
	/**
	 * Metodo para retornar o valor de cod_cliente
	 * @return the cod_cliente
	 */
	public int getCod_cliente() {
		return cod_cliente;
	}
	/**
	 * Metodo para dar set no cod_cliente
	 * @param cod_cliente the cod_cliente to set
	 */
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	/**
	 * Metodo para retornar o valor de cod_produto
	 * @return the cod_produto
	 */
	public int getCod_produto() {
		return cod_produto;
	}
	/**
	 * Metodo para dar set no cod_produto
	 * @param cod_produto the cod_produto to set
	 */
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	/**
	 * Metodo para retornar o valor de cod_pedido
	 * @return the cod_pedido
	 */
	public int getCod_pedido() {
		return cod_pedido;
	}
	/**
	 * Metodo para dar set no cod_pedido
	 * @param cod_pedido the cod_pedido to set
	 */
	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}
	
}
