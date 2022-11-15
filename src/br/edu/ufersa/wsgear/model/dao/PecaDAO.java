package br.edu.ufersa.wsgear.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.wsgear.model.entity.Peca;

public class PecaDAO extends BaseDAO<Peca>{
	public boolean inserir(Peca p) {
		String cmnd_ins = "INSERT INTO tb_peca (idPeca, Nome, Fabricante, Preco) VALUES (?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setInt(1, p.getIdPeca());
			pst.setString(2, p.getNome());
			pst.setString(3, p.getFab());
			pst.setDouble(4, p.getPreco());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}
	
	public boolean deletar(Peca p) {
		String cmnd_ins = "DELETE FROM tb_peca WHERE idPeca=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setInt(1, p.getIdPeca());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	public boolean alterar(Peca p) {
		String cmnd_ins = "UPDATE tb_peca SET idPeca=?, Nome=?, Fabricante=?, Preco=? WHERE idPeca=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setInt(1, p.getIdPeca());
			pst.setString(2, p.getNome());
			pst.setString(3, p.getFab());
			pst.setDouble(4, p.getPreco());
			pst.setInt(5, p.getIdPeca());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;	}
	}

	public Peca findById(Peca p) {
		String cmnd_ins = "SELECT * FROM tb_peca WHERE idPeca=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setInt(1, p.getIdPeca());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Peca p0 = new Peca();
				p0.setIdPeca(rs.getInt("idPeca"));
				p0.setNome(rs.getString("Nome"));
				p0.setFab(rs.getString("Fabricante"));
				p0.setPreco(rs.getDouble("Preco"));
				return p0;
			}
			else return null;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}

	public ResultSet findAll() {
		String cmnd_ins = "SELECT * FROM tb_peca;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}	}
	
	public ResultSet findBySpecifiedField(Peca p, String field) {
		String cmnd_ins = "SELECT * FROM tb_peca WHERE " + field + "=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			
			switch(field)
			{
			case "idPeca":
				pst.setInt(1, p.getIdPeca());
				break;
			case "Nome":
				pst.setString(1, p.getNome());
				break;
			case "Fabricante":
				pst.setString(1, p.getFab());
				break;
			case "Preco":
				pst.setDouble(1, p.getPreco());
				break;
			default:
				pst.setInt(1, p.getIdPeca());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}
}
