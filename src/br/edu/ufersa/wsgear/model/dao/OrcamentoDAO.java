package br.edu.ufersa.wsgear.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.wsgear.model.entity.Orcamento;

public class OrcamentoDAO extends BaseDAO<Orcamento>{
	public boolean inserir(Orcamento o) {
		String cmnd_ins = "INSERT INTO tb_orcamento (orcIdPeca, orcIdServico, Valor, orcIdAutomovel) VALUES (?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setInt(1, o.getPecas().get(0).getIdPeca());
			pst.setInt(2, o.getServicos().get(0).getIdServico());
			pst.setDouble(3, o.getValor());
			pst.setInt(4, o.getIdAutomovel());
			pst.execute();
			
		//	ResultSet generatedKeys = pst.getGeneratedKeys();
		//	if(generatedKeys.next()) {
		//		o.setIdOrcamento(generatedKeys.getInt("idOrcamento"));
		//	}
			return true;		
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}				
	}
	
	public boolean deletar(Orcamento o) {
		String cmnd_ins = "DELETE FROM tb_orcamento WHERE idOrcamento=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setInt(1, o.getIdOrcamento());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean alterar(Orcamento o) {
		String cmnd_ins = "UPDATE tb_orcamento SET orcIdPeca=? , orcIdServico=? , Valor=? WHERE idOrcamento=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setInt(1, o.getPecas().get(0).getIdPeca());
			pst.setInt(2, o.getServicos().get(0).getIdServico());
			pst.setDouble(3, o.getValor());
			pst.setInt(4, o.getIdOrcamento());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;	}
	}

	public Orcamento findById(Orcamento orcamento) {
		String cmnd_ins = "SELECT * FROM tb_orcamento WHERE idOrcamento=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			pst.setInt(1, orcamento.getIdOrcamento());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Orcamento o = new Orcamento();
				o.setIdOrcamento(rs.getInt("idOrcamento"));
				o.getPecas().get(0).setIdPeca(rs.getInt("orcIdPeca"));
				o.getServicos().get(0).setIdServico(rs.getInt("orcIdServico"));
				o.setValor(rs.getDouble("Valor"));
				return o;
			}
			else return null;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ResultSet findAll() {
		String cmnd_ins = "SELECT * FROM tb_orcamento;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}	}
	
	public ResultSet findBySpecifiedField(Orcamento o, String field) {
		String cmnd_ins = "SELECT * FROM tb_orcamento WHERE " + field + "=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(cmnd_ins);
			
			switch(field)
			{
			case "idOrcamento":
				pst.setInt(1, o.getIdOrcamento());
				break;
			case "orcIdPeca":
				pst.setInt(1, o.getPecas().get(0).getIdPeca());
				break;
			case "orcIdServico":
				pst.setInt(1, o.getServicos().get(0).getIdServico());
				break;
			case "Valor":
				pst.setDouble(1, o.getValor());
				break;
			default:
				pst.setInt(1, o.getIdOrcamento());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
