package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
}
