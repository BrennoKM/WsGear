package br.edu.ufersa.wsgear.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.wsgear.model.entity.Cliente;


public class ClienteDAO extends BaseDAO<Cliente> {

	public boolean inserir(Cliente cliente) {
		String sql = "INSERT INTO tb_cliente  (CPF,Nome,Telefone) VALUES (?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, cliente.getCpf());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getTelefone());
			pst.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletar(Cliente cliente) {
		String sql = "DELETE FROM tb_cliente WHERE CPF=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, cliente.getCpf());
			pst.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean alterar(Cliente cliente) {
		String sql = "UPDATE tb_cliente SET CPF=?,Nome=?,Telefone=? WHERE CPF=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, cliente.getCpf());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getTelefone());
			pst.setString(4, cliente.getCpf());
			pst.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Cliente findById(Cliente e) {
		String sql = "SELECT * FROM tb_cliente WHERE idCliente=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, e.getIdCliente());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Cliente c = new Cliente();
				c.setCpf(rs.getString("CPF"));
				c.setNome(rs.getString("Nome"));
				c.setTelefone(rs.getString("Telefone"));
				c.setIdCliente(e.getIdCliente());
				return c;
			} else
				return null;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Cliente findByNome(Cliente e) {
		String sql = "SELECT * FROM tb_cliente WHERE Nome=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, e.getNome());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Cliente c = new Cliente();
				c.setCpf(rs.getString("CPF"));
				c.setNome(rs.getString("Nome"));
				c.setTelefone(rs.getString("Telefone"));
				c.setIdCliente(rs.getInt("idCliente"));
				return c;
			} else
				return null;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_cliente;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultSet findBySpecifiedField(Cliente e, String field) {
		String sql = "SELECT * FROM tb_cliente WHERE " + field + "=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "CPF":
				pst.setString(1, e.getCpf());
				break;

			case "Nome":
				pst.setString(1, e.getNome());
				break;

			case "Telefone":
				pst.setString(1, e.getTelefone());
				break;

			}

			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}


	public ResultSet buscar() {
		String sql = "SELECT * FROM tb_cliente;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}