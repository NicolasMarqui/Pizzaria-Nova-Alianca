package control;

import java.sql.*;

public class DB {

	//Realizar a conexão
	public Connection con = null;
	
	//Sabe executar instruçoes em SQL
	public PreparedStatement st = null;
	
	//Simula uma tabela em memória
	public ResultSet rs = null;
	
	private final String LOGIN = "sa";
	private final String SENHA = "123456";
	
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private final String DATABASE = "final";
	private final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=" + DATABASE;
	
	public boolean getConnection() {
		try {
			
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,LOGIN,SENHA);
			System.out.println("Conectou");
			
			return true;
			
		}catch(ClassNotFoundException erro) {
			System.out.println("Driver não encontrado");
			return false;
			
		}catch(SQLException erro) {
			System.out.println("Erro" + erro.toString());
			return false;
		}
	}
	
	
	public void close() {
		try {
			if(rs !=null) rs.close();
		}catch(SQLException erro) {
			
		}
		
		try {
			if(st !=null) st.close();
		}catch(SQLException erro) {
			
		}
		
		try {
			if(con !=null) {
				con.close();
				//System.out.println("Desconectou");
			}
		}catch(SQLException erro) {
			
		}
	}
	
	public static void main(String[] args) {
		DB bd = new DB();
		bd.getConnection();
		bd.close();
	}
	
	
	
}
