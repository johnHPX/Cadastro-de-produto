package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.ConnectionDataBase;
import model.Produto;

public class ProdutoRepository {
	
	public boolean criar(Produto p) {
        try {
        	String sql = "INSERT INTO produto (nome, descricao, preco, quantidade) VALUES (?,?,?,?)";
        	boolean ok = ConnectionDataBase.connect();
        	if (!ok) {
        		return false;
        	}
        	
        	PreparedStatement pstmt = ConnectionDataBase.conn.prepareStatement(sql);
            pstmt.setString(1, p.getNome());
            pstmt.setString(2, p.getDescricao());
            pstmt.setDouble(3, p.getPreco());
            pstmt.setInt(4, p.getQuantidade());
            pstmt.executeUpdate();
            
            pstmt.close();
        	
        	ok = ConnectionDataBase.closeConnection();
            if (!ok) {
            	return false;
            }
            
            return true;
            
        } catch (SQLException e) {
        	System.out.println(e);
            return false;
        }
        
   }
	
	public ArrayList<Produto> listar() {
		try {
			String sql = "SELECT * FROM produto";
			boolean ok = ConnectionDataBase.connect();
			ArrayList<Produto> produtos = new ArrayList<Produto>();
			if (!ok) {
				return null;
			}
			
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
            
            stmt.close();
            rs.close();
            
            ok = ConnectionDataBase.closeConnection();
            if (!ok) {
            	return null;
            }
            
            return produtos;
			
		} catch (SQLException e) {
           return null;
        }

	}
	
	public Produto buscar(int id) {
		String sql = "SELECT * FROM produto WHERE id = ?";
		Produto p = new Produto();
		try {
			boolean ok = ConnectionDataBase.connect();
			if (!ok) {
				return null;
			}
			
			PreparedStatement pstmt = ConnectionDataBase.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
			}
			
			pstmt.close();
			rs.close();
			
			ok = ConnectionDataBase.closeConnection();
			if (!ok) {
				return null;
			}
			
			return p;
			
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}
	
	public boolean atualizar(Produto p) {
        try {
        	String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, quantidade = ? WHERE id = ?";
        	boolean ok = ConnectionDataBase.connect();
        	if (!ok) {
        		return false;
        	}
        	
        	PreparedStatement pstmt = ConnectionDataBase.conn.prepareStatement(sql);
            pstmt.setString(1, p.getNome());
            pstmt.setString(2, p.getDescricao());
            pstmt.setDouble(3, p.getPreco());
            pstmt.setInt(4, p.getQuantidade());
            pstmt.setInt(5, p.getId());
            pstmt.executeUpdate();
            
            pstmt.close();
        	
        	ok = ConnectionDataBase.closeConnection();
            if (!ok) {
            	return false;
            }
            
            return true;
            
        } catch (SQLException e) {
        	System.out.println(e);
            return false;
        }
        
   }
	
	public boolean deletar(int id) {
        try {
        	String sql = "DELETE FROM produto WHERE id = ?";
        	boolean ok = ConnectionDataBase.connect();
        	if (!ok) {
        		return false;
        	}
        	
        	PreparedStatement pstmt = ConnectionDataBase.conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
            pstmt.close();
        	
        	ok = ConnectionDataBase.closeConnection();
            if (!ok) {
            	return false;
            }
            
            return true;
            
        } catch (SQLException e) {
        	System.out.println(e);
            return false;
        }
        
   }
	
}
