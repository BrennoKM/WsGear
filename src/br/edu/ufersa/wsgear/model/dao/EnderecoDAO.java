package br.edu.ufersa.wsgear.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.wsgear.model.entity.Endereco;


public class EnderecoDAO extends BaseDAO<Endereco> {
	public boolean inserir(Endereco end) {
		String cmnd_ins = "INSERT INTO tb_endereco VALUES (?,?,?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setString(1, end.getCpf_morador());
			pst.setString(2, end.getCep());
			pst.setString(3, end.getRua());
			pst.setString(4, end.getBairro());
			pst.setString(5, end.getComplemento());
			pst.setInt(6, end.getNumero());
			pst.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletar(Endereco end) {
		String cmnd_ins = "DELETE FROM tb_endereco WHERE Cpf_morador=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setString(1, end.getCpf_morador());
			pst.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean alterar(Endereco end) {
		String cmnd_ins = "UPDATE tb_endereco SET Cpf_morador=?, CEP=?, Rua=?, Bairro=?, Complemento=?, Numero=? WHERE Cpf_morador=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setString(1, end.getCpf_morador());
			pst.setString(2, end.getCep());
			pst.setString(3, end.getRua());
			pst.setString(4, end.getBairro());
			pst.setString(5, end.getComplemento());
			pst.setInt(6, end.getNumero());
			pst.setString(7, end.getCpf_morador());
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ResultSet findBySpecifiedField(Endereco end, String field) {
		String cmnd_ins = "SELECT * FROM tb_endereco WHERE " + field + "=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);

			switch (field) {
			case "Cpf_morador":
				pst.setString(1, end.getCpf_morador());
				break;
			case "CEP":
				pst.setString(1, end.getCep());
				break;
			case "Rua":
				pst.setString(1, end.getRua());
				break;
			case "Bairro":
				pst.setString(1, end.getBairro());
				break;
			case "Complemento":
				pst.setString(1, end.getComplemento());
				break;
			case "Numero":
				pst.setInt(1, end.getNumero());
				break;
			default:
				pst.setString(1, end.getCpf_morador());
			}

			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_endereco;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
