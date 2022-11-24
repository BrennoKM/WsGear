package br.edu.ufersa.wsgear.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.wsgear.model.entity.Automovel;

public class AutomovelDAO extends BaseDAO<Automovel> {
	public boolean inserir(Automovel automovel) {
		String sql = "INSERT INTO tb_automovel  (marca,modelo,cor,placa,ano) VALUES (?,?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, automovel.getMarca());
			pst.setString(2, automovel.getModelo());
			pst.setString(3, automovel.getCor());
			pst.setString(4, automovel.getPlaca());
			pst.setInt(5, automovel.getAno());
			//
			//
			pst.execute();
			
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletar(Automovel automovel) {
		String sql = "DELETE FROM tb_automovel WHERE idDono=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setLong(1, automovel.getIdDono());
			pst.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean alterar(Automovel automovel) {
		String sql = "UPDATE tb_automovel SET marca=?,modelo=?,cor=?,placa=?,ano=? WHERE idDono=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, automovel.getMarca());
			pst.setString(2, automovel.getModelo());
			pst.setString(3, automovel.getCor());
			pst.setString(4, automovel.getPlaca());
			pst.setInt(5, automovel.getAno());
			pst.setLong(6, automovel.getIdDono());
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Automovel findById(Automovel e) {
		String sql = "SELECT * FROM tb_automovel WHERE idDono=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setLong(1, e.getIdDono());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Automovel a = new Automovel();
				a.setMarca(rs.getString("marca"));
				a.setModelo(rs.getString("modelo"));
				a.setCor(rs.getString("cor"));
				a.setPlaca(rs.getString("placa"));
				a.setIdDono(rs.getLong("idDono"));
				a.setIdAutomovel(rs.getLong("idAutomovel"));
				return a;
			} else
				return null;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_automovel;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ResultSet findBySpecifiedField(Automovel e, String field) {
		String sql = "SELECT * FROM tb_automovel WHERE " + field + "=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "marca":
				pst.setString(1, e.getMarca());
				break;

			case "modelo":
				pst.setString(1, e.getModelo());
				break;

			case "placa":
				pst.setString(1, e.getPlaca());
				break;

			default:
				pst.setLong(1, e.getIdAutomovel());
			}

			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Automovel buscar(Automovel automovel) {
		String sql = "SELECT * FROM tb_automovel WHERE idAutomovel = ?";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setLong(1, automovel.getIdAutomovel());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return automovel;
			} else
				return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public ResultSet buscar() {
		String sql = "SELECT * FROM tb_automovel;";
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
