package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import control.DB;

public class Cliente {
	
	private String bairro;
	private String rua;
	private String telefone;
	private String cep;
	private String numero;
	private String cidade;
	private String cpf;
	private String nome;
	private int codigoCliente;
	
	/**
	 * Constructor para adicionar cliente
	 * @param nome
	 * @param cpf
	 * @param cidade
	 * @param rua
	 * @param bairro
	 * @param numero
	 * @param cep
	 * @param telefone
	 */
	public Cliente(String nome, String cpf, String cidade, String rua, String bairro , String numero, String cep, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.telefone = telefone;
		
	}
	
	public Cliente() {
		
	}

	/**
	 * Metodo para retorno do bairro
	 * @return String - nome do bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * 
	 * @param bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Metodo para retorno da rua
	 * @return String - nome da rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * Metodo para dar set na rua
	 * @param rua
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * Metodo para retorno do telefone
	 * @return String - numero de Telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Metodo para dar set no telefone
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Metodo para retorno do CEP
	 * @return String - cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Metodo para dar set no CEP
	 * @param cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Metodo para retorno do numero
	 * @return String - numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Metodo para dar set no numero
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Metodo para retorno da cidade
	 * @return String - cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Metodo para dar set na cidade
	 * @param cidade
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Metodo para retorno do cpf
	 * @return String cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Metodo para dar set no CPF
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Metodo para retorno do nome
	 * @return String - nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo para dar set no nome
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo para retorno do codigo do Cliente
	 * @return String - codigo do cliente
	 */
	public int getCodigoCliente() {
		System.out.println("Cod Retornado é " + this.codigoCliente);
		return codigoCliente;

	}

	/**
	 * Metodo para dar set no codigo
	 * @param codigoCliente
	 */
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
		
		System.out.println("Cod é " + this.codigoCliente);
	}
	
	public void salvarCliente(String nome, String cpf, String cidade, String rua, String bairro , String numero, String cep, String telefone) {
		DB bd = new DB();
			
		if(bd.getConnection()) {
			
			String sqlSalvarProd = "INSERT INTO cliente(NOME_CLIENTE,cpf,cidade,rua,bairro,numero,cep,telefone) values(?, ? , ?, ? , ? , ?, ?, ?)";
			
			try{
				
				bd.st = bd.con.prepareStatement(sqlSalvarProd);
				bd.st.setString(1,nome);
				bd.st.setString(2,cpf);
				bd.st.setString(3,cidade);
				bd.st.setString(4,rua);
				bd.st.setString(5,bairro);
				bd.st.setString(6,numero);
				bd.st.setString(7,cep);
				bd.st.setString(8,telefone);
				
				bd.st.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
				
			}catch(SQLException erro) {
				JOptionPane.showMessageDialog(null, "Não foi possivel salvar o cliente, tente novamente mais tarde");
				JOptionPane.showMessageDialog(null, erro.toString());
			}finally {
				bd.close();
			}
		}
	}
	
	public void atualizarCliente(int id , String nome, String cpf, String cidade, String rua, String bairro , String numero, String cep, String telefone) {
		
		DB bd = new DB();
		
		if(bd.getConnection()) {
			
			String sqlAtualizarProd = "UPDATE cliente SET NOME_CLIENTE = ? , cpf = ? , cidade = ? , rua = ? , bairro = ? , numero = ?  , cep = ? , telefone = ? WHERE COD_CLIENTE = ?";
			
			try{
				
				bd.st = bd.con.prepareStatement(sqlAtualizarProd);
				bd.st.setString(1,nome);
				bd.st.setString(2,cpf);
				bd.st.setString(3,cidade);
				bd.st.setString(4,rua);
				bd.st.setString(5,bairro);
				bd.st.setString(6,numero);
				bd.st.setString(7,cep);
				bd.st.setString(8,telefone);
				bd.st.setInt(9, id);
				
				bd.st.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
				
			}catch(SQLException erro) {
				JOptionPane.showMessageDialog(null, "Não foi possivel atualizar o cliente, tente novamente mais tarde");
				JOptionPane.showMessageDialog(null, erro.toString());
			}finally {
				bd.close();
			}
			
		}
		
	}
	
	public void deletarCliente(int id) {
		DB bd = new DB(); 
		
		if(bd.getConnection()) {
			
			String sqlDeletarCliente = "DELETE FROM cliente WHERE COD_CLIENTE = ?";
			
			try{
				
				bd.st = bd.con.prepareStatement(sqlDeletarCliente);
				bd.st.setInt(1,id);
				
				bd.st.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cliente Deletado com sucesso");
				
			}catch(SQLException erro) {
				JOptionPane.showMessageDialog(null, "Não foi possivel excluir o cliente, tente novamente mais tarde");
				JOptionPane.showMessageDialog(null, erro.toString());
			}finally {
				bd.close();
			}
			
		}
	}
	
	
}
