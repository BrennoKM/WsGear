package br.edu.ufersa.wsgear.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.wsgear.api.dto.PecaDTO;
import br.edu.ufersa.wsgear.model.dao.BaseInterDAO;
import br.edu.ufersa.wsgear.model.dao.PecaDAO;
import br.edu.ufersa.wsgear.model.entity.Peca;

public class PecaBO implements ServiceInterface<PecaDTO> {
	BaseInterDAO<Peca> dao = new PecaDAO();

	public boolean inserir(PecaDTO pecaDTO) {
		Peca peca = Peca.converter(pecaDTO);
		ResultSet rs = dao.findBySpecifiedField(peca, "idPeca");
		try {
			if (rs == null || !(rs.next()))
				if (dao.inserir(peca) == true)
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

	public boolean deletar(PecaDTO pecaDTO) {
		Peca peca = Peca.converter(pecaDTO);
		
		ResultSet rs = dao.findBySpecifiedField(peca, "idPeca");
		try {
			if (rs != null && rs.next())
				if (dao.deletar(peca) == true)
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

	public List<Peca> listar() {
		List<Peca> pecas = new ArrayList<Peca>();
		ResultSet rs = dao.findAll();
		try {
			while (rs.next()) {
				Peca peca = new Peca();
				peca.setIdPeca(rs.getInt("idPeca"));
				peca.setNome(rs.getString("Nome"));
				peca.setFab(rs.getString("Fabricante"));
				peca.setPreco(rs.getDouble("Preco"));

				pecas.add(peca);
			}
			return pecas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean alterar(PecaDTO pecaDTO) {
		Peca peca = Peca.converter(pecaDTO);
		try {
			ResultSet rs = dao.findBySpecifiedField(peca, "idPeca");
			if (rs != null && rs.next())
				if (dao.alterar(peca) == true)
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
