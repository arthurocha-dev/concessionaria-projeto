package pacote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectionUI {
	
	    private static final String URL = "jdbc:postgresql://localhost:5432/Concessionaria";

	    private static final String USER = "postgres";

	    private static final String PASSWORD = "root";



	    public static Connection connect() throws SQLException {
	    	
	     


	        return DriverManager.getConnection(URL, USER, PASSWORD);



	    



	}
	 
          public static void main(String[] args) {
        	  try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
 	             if (connection != null) {
 	                 JOptionPane.showMessageDialog(null, "Conexão estabelecida");
 	             }
 	         } catch (SQLException e) {
 	             System.out.println("Erro ao conectar: " + e.getMessage());
 	         }
	
}	   
}
