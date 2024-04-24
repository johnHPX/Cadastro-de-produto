package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Produto;

public class ProdutoRepository {
	
	public boolean criar(Produto p) {
		String sql = "INSERT INTO produto (nome, descricao, preco, quantidade) VALUES (?,?,?,?)";
		
        try {
        	boolean resp = ConnectionDataBase.connect();
        	if (resp) {
        		PreparedStatement pstmt = ConnectionDataBase.conn.prepareStatement(sql);
                pstmt.setString(1, p.getNome());
                pstmt.setString(2, p.getDescricao());
                pstmt.setDouble(3, p.getPreco());
                pstmt.setInt(4, p.getQuantidade());
                pstmt.executeUpdate();
        	}
        	
        	boolean resp2 = ConnectionDataBase.closeConnection();
            if (resp2) {
            	return true;
            }else {
            	return false;
            }
            
        } catch (SQLException e) {
        	System.out.println(e);
            return false;
        }
        
   }
	
	public ArrayList<Produto> listar() {
		String sql = "SELECT * FROM produto";
		
		try {
			boolean resp = ConnectionDataBase.connect();
			ArrayList<Produto> produtos = new ArrayList<Produto>();
			if (resp) {
				Statement stmt =  ConnectionDataBase.conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	                Produto p = new Produto();
	                p.setId(rs.getInt("id"));
	                p.setNome(rs.getString("nome"));
	                p.setDescricao(rs.getString("descricao"));
	                p.setPreco(rs.getDouble("preco"));
	                p.setQuantidade(rs.getInt("quantidade"));
	                produtos.add(p);
	            }
			}
            
        	boolean resp2 = ConnectionDataBase.closeConnection();
            if (resp2) {
            	return produtos;
            }
            
            return null;
			
		} catch (SQLException e) {
           return null;
        }

	}
	
}
