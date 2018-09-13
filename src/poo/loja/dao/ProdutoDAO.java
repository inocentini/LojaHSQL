package poo.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import poo.loja.modelo.Produto;
import poo.loja.util.ConnectionLojaFactory;

public class ProdutoDAO {
	
	
	public void insert(Produto produto) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "INSERT INTO PRODUTO(CODIGO, NOME, PRECO) "
					+ "VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, indiceId());
			ps.setString(2, produto.getNome());
			ps.setDouble(3, produto.getValor());
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			ConnectionLojaFactory.closeConnection(conn);
		}
	}
	
	public Produto read(Produto produto) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "SELECT * FROM PRODUTO WHERE CODIGO = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, produto.getId());
			ResultSet rs = ps.executeQuery();
			Produto p = new Produto();
			while(rs.next()) {				
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setValor(rs.getDouble(3));		
			}
			return p;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			ConnectionLojaFactory.closeConnection(conn);
		}
	}
	
	public Produto read(int id) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "SELECT * FROM PRODUTO WHERE CODIGO = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Produto p = new Produto();
			while(rs.next()) {				
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setValor(rs.getDouble(3));		
			}
			return p;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			ConnectionLojaFactory.closeConnection(conn);
		}
	}
	
	public List<Produto> listAll() {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "SELECT * FROM PRODUTO";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Produto> produtos = new ArrayList<>();
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setValor(rs.getDouble(3));
				produtos.add(p);		
			}
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.closeConnection(conn);
		}
	}
	
	public void update(Produto produto) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "UPDATE PRODUTO SET NOME = ?, PRECO = ? WHERE CODIGO = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setDouble(2, produto.getValor());
			ps.setInt(3, produto.getId());
			ps.executeUpdate(); 			
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.closeConnection(conn);
		}
	}
	
	public void delete(Produto produto) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "DELETE FROM PRODUTO WHERE CODIGO = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, produto.getId());
			ps.executeUpdate(); 			
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.closeConnection(conn);
		}
	}

	public List<Produto> searchByName(String name) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "SELECT * FROM PRODUTO WHERE NOME LIKE ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ResultSet rs = ps.executeQuery();
			List<Produto> produtos = new ArrayList<>();
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setValor(rs.getDouble(3));
				produtos.add(p);		
			}
			return produtos;			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.closeConnection(conn);
		}
	}
	
	public List<Produto> searchByPrice(double preco, boolean op) {
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			if(op) {
				String sql = "SELECT * FROM PRODUTO WHERE PRECO > ?  ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1, preco);
				ResultSet rs = ps.executeQuery();
				List<Produto> produtos = new ArrayList<>();
				while(rs.next()) {
					Produto p = new Produto();
					p.setId(rs.getInt(1));
					p.setNome(rs.getString(2));
					p.setValor(rs.getDouble(3));
					produtos.add(p);		
				}
				return produtos;
			}else {
				String sql = "SELECT * FROM PRODUTO WHERE PRECO < ? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1, preco);
				ResultSet rs = ps.executeQuery();
				List<Produto> produtos = new ArrayList<>();
				while(rs.next()) {
					Produto p = new Produto();
					p.setId(rs.getInt(1));
					p.setNome(rs.getString(2));
					p.setValor(rs.getDouble(3));
					produtos.add(p);		
				}
				return produtos;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionLojaFactory.closeConnection(conn);
		}
	}

	public int indiceId(){
		Connection conn = ConnectionLojaFactory.getConnection();
		try {
			String sql = "SELECT CODIGO FROM PRODUTO";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int id = 0;
			while(rs.next()) {
				id = (rs.getInt(1));
			}
			id++;
			return id;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			ConnectionLojaFactory.closeConnection(conn);
		}
	}

}
