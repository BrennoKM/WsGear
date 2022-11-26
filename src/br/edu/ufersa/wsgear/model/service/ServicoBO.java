package br.edu.ufersa.wsgear.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.wsgear.api.dto.ServicoDTO;
import br.edu.ufersa.wsgear.model.dao.BaseInterDAO;
import br.edu.ufersa.wsgear.model.dao.ServicoDAO;
import br.edu.ufersa.wsgear.model.entity.Servico;

public class ServicoBO implements ServiceInterface<ServicoDTO> {
	BaseInterDAO<Servico> dao = new ServicoDAO();
	
	public boolean inserir(ServicoDTO servicoDTO) {
		Servico servico = Servico.converter(servicoDTO);
		ResultSet rs = dao.findBySpecifiedField(servico, "idServico");
		try {
			if (rs == null || !(rs.next())) {
				if (dao.inserir(servico) == true)
					return true;
				else
					return false;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public int buscarIdServico(ServicoDTO ServicoDTO) {
		Servico servico = Servico.converter(ServicoDTO);
		ResultSet rs = dao.findBySpecifiedField(servico, "idServico");
		try {
			if(rs!=null && rs.next()) {
				return rs.getInt("idServico");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	public List<ServicoDTO> listar() {
		List<ServicoDTO> servicos = new ArrayList<ServicoDTO>();
		ResultSet rs = dao.findAll();
		try {
			while (rs.next()) {
				ServicoDTO servico = new ServicoDTO();
				servico.setIdServico(rs.getInt("idServico"));
				servico.setNome(rs.getString("Nome"));
				servico.setPreco(rs.getDouble("Preco"));
				servico.setDataServico(LocalDate.parse(rs.getString("dataServico")));
				servico.setStatus(rs.getString("statusServico"));

				servicos.add(servico);
			}
			return servicos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean alterar(ServicoDTO servicoDTO) {
		Servico servico = Servico.converter(servicoDTO);

		ResultSet rs = dao.findBySpecifiedField(servico, "idServico");
		try {
			if (rs != null && rs.next()) {
				if (dao.alterar(servico) == true)
					return true;
				else
					return false;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletar(ServicoDTO servicoDTO) {
		Servico servico = new Servico();
		servico.setIdServico(servicoDTO.getIdServico());
		ResultSet rs = dao.findBySpecifiedField(servico, "idServico");
		try {
			if (rs != null && rs.next()) {
				if (dao.deletar(servico) == true)
					return true;
				else
					return false;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*public boolean terminar(Servico servico) {

		ResultSet rs = dao.findBySpecifiedField(servico, "idServico");
		try {
			if (rs != null && rs.next()) {
				if (dao.terminarServico(servico) == true)
					return true;
				else
					return false;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}*/
}
