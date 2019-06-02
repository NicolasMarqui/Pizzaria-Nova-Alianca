package model;

import java.sql.SQLException;

import control.DB;

public class Relatorio {
	
	DB bd = new DB();
	
	public int pesquisaPorData() {
		if(bd.getConnection()) {
			
			String contarCliente = "SELECT COUNT(*) AS PEDIDOS FROM PEDIDO";
			int value = 0;
			
			try{
				
				bd.st = bd.con.prepareStatement(contarCliente);
				bd.rs = bd.st.executeQuery();			
					
				while (bd.rs.next()) {
					return bd.rs.getInt("PEDIDOS");
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
