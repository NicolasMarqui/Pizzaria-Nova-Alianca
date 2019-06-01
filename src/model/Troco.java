package model;

public class Troco {

	private boolean isMoney = false;
	private double valorTotal;
	private double valorPago;
	/**
	 * @return the isMoney
	 */
	public boolean isMoney() {
		return isMoney;
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
	
	
	
}
