package br.edu.ufersa.wsgear.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.wsgear.model.dao.BaseInterDAO;
import br.edu.ufersa.wsgear.model.dao.EnderecoDAO;
import br.edu.ufersa.wsgear.model.entity.Endereco;


public class EnderecoBO implements ServiceInterface<Endereco> {
	BaseInterDAO<Endereco> biDao = new EnderecoDAO();

	public boolean inserir(Endereco end) {
		ResultSet rs = biDao.findBySpecifiedField(end, "Cpf_morador");
		try {
			if (rs == null || !(rs.next()))
				if (biDao.inserir(end) == true)
					return true;
				else
					return false;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletar(Endereco end) {
		ResultSet rs = biDao.findBySpecifiedField(end, "Cpf_morador");
		try {
			if (rs != null && rs.next())
				if (biDao.deletar(end) == true)
					return true;
				else
					return false;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean alterar(Endereco end) {
		try {
			ResultSet rs = biDao.findBySpecifiedField(end, "Cpf_morador");
			if (rs != null && rs.next())
				if (biDao.alterar(end) == true)
					return true;
				else
					return false;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
