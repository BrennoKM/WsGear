package br.edu.ufersa.wsgear.model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.edu.ufersa.wsgear.model.entity.Servico;

public class ServicoDAO extends BaseDAO<Servico> {
	
	public boolean inserir(Servico servico) {
		String sql = "INSERT INTO tb_servico  (Nome,Preco,dataServico,statusServico) VALUES (?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, servico.getNome());
			pst.setDouble(2, servico.getPreco());
			pst.setDate(3, Date.valueOf(servico.getDataServico()));
			pst.setString(4, servico.getStatus());
			pst.execute();
			
		//	ResultSet generatedKeys = pst.getGeneratedKeys();
		//	if(generatedKeys.next()) {
		//		servico.setIdServico(generatedKeys.getInt("idServico"));
		//	}
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletar(Servico servico) {
		String sql = "DELETE FROM tb_servico WHERE idServico=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, servico.getIdServico());
			pst.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean alterar(Servico servico) {
		String sql = "UPDATE tb_servico SET nome=?,preco=?,dataServico=?,statusServico=? WHERE idServico=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, servico.getNome());
			pst.setDouble(2, servico.getPreco());
			pst.setDate(3, Date.valueOf(servico.getDataServico()));
			pst.setString(4, servico.getStatus());
			pst.setInt(5, servico.getIdServico());
			pst.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Servico findById(Servico e) {
		String sql = "SELECT * FROM tb_servico WHERE id=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, e.getIdServico());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Servico s = new Servico();
				s.setIdServico(rs.getInt("IdServico"));
				s.setNome(rs.getString("Nome"));
				s.setPreco(rs.getDouble("Preco"));
				s.setDataServico(LocalDate.parse(rs.getString("DataServico")));
				s.setStatus(rs.getString("Status"));
				return s;
			} else
				return null;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_servico;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ResultSet findBySpecifiedField(Servico e, String field) {
		String sql = "SELECT * FROM tb_servico WHERE " + field + "=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "IdServico":
				pst.setInt(1, e.getIdServico());
				break;

			case "Nome":
				pst.setString(1, e.getNome());
				break;

			case "Preco":
				pst.setDouble(1, e.getPreco());
				break;

			case "DataServico":
				pst.setDate(1, Date.valueOf(e.getDataServico()));
				break;

			case "Status":
				pst.setString(1, e.getStatus());
				break;

			default:
				pst.setInt(1, e.getIdServico());
			}

			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean terminarServico(Servico servico) {
		String sql = "UPDATE tb_servico SET status=? WHERE idServico=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, servico.getIdServico());
			pst.setString(2, "Finalizado");
			pst.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
