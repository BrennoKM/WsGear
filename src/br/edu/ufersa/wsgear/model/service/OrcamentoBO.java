package br.edu.ufersa.wsgear.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.wsgear.api.dto.OrcamentoDTO;
import br.edu.ufersa.wsgear.model.dao.BaseInterDAO;
import br.edu.ufersa.wsgear.model.dao.OrcamentoDAO;
import br.edu.ufersa.wsgear.model.entity.Orcamento;
import br.edu.ufersa.wsgear.model.entity.Peca;
import br.edu.ufersa.wsgear.model.entity.Servico;

public class OrcamentoBO implements ServiceInterface<OrcamentoDTO>{
	BaseInterDAO<Orcamento> dao = new OrcamentoDAO();

	public boolean inserir(OrcamentoDTO orcamentoDTO) {
		Orcamento orcamento = Orcamento.converter(orcamentoDTO);
		ResultSet rs = dao.findBySpecifiedField(orcamento, "idOrcamento");
		try {
			if (rs == null || !(rs.next()))
				if (dao.inserir(orcamento) == true)
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

	public boolean deletar(OrcamentoDTO orcamentoDTO) {
		Orcamento orcamento = Orcamento.converter(orcamentoDTO);
		
		ResultSet rs = dao.findBySpecifiedField(orcamento, "idOrcamento");
		try {
			if (rs != null && rs.next())
				if (dao.deletar(orcamento) == true)
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

	public List<OrcamentoDTO> listar() {
		List<OrcamentoDTO> orcamentos = new ArrayList<OrcamentoDTO>();
		ResultSet rs = dao.findAll();
		try {
			while (rs.next()) {
				OrcamentoDTO orcamento = new OrcamentoDTO();
				orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
				orcamento.setValor(rs.getDouble("Valor"));
				orcamento.setPeca(new Peca(rs.getInt("orcIdPeca")));
				orcamento.setServico(new Servico(rs.getInt("orcIdServico")));
			
				orcamentos.add(orcamento);
			}
			return orcamentos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean alterar(OrcamentoDTO orcamentoDTO) {
		Orcamento orcamento = Orcamento.converter(orcamentoDTO);
		try {
			ResultSet rs = dao.findBySpecifiedField(orcamento, "idOrcamento");
			if (rs != null && rs.next())
				if (dao.alterar(orcamento) == true)
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
