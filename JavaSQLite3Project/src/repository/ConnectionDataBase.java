package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDataBase {
	
	public static Connection conn;
	 
	public static boolean connect() {
        try {
        	String url = "jdbc:sqlite:JavaSQLite3Project/db/bancodedados.dat";
            conn = DriverManager.getConnection(url);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage()); 
            return false;
        }
    }

    public static boolean closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                return true;
            }
          
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        
        return false;
    }

}
