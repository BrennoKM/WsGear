package br.edu.ufersa.wsgear.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.wsgear.api.dto.AutomovelDTO;
import br.edu.ufersa.wsgear.model.dao.AutomovelDAO;
import br.edu.ufersa.wsgear.model.dao.BaseInterDAO;
import br.edu.ufersa.wsgear.model.entity.Automovel;


public class AutomovelBO implements ServiceInterface<AutomovelDTO>{
	BaseInterDAO<Automovel> dao = new AutomovelDAO();
	public boolean inserir(AutomovelDTO automovelDTO) {
		Automovel automovel = Automovel.converter(automovelDTO);
		ResultSet rs = dao.findBySpecifiedField(automovel, "Placa");
		try {
			if(rs==null || !(rs.next()) ) {
				if(dao.inserir(automovel) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public List<AutomovelDTO> listar(){
		List<AutomovelDTO> automoveis = new ArrayList<AutomovelDTO>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				AutomovelDTO automovel = new AutomovelDTO();
				automovel.setMarca(rs.getString("Marca"));
				automovel.setModelo(rs.getString("Modelo"));
				automovel.setCor(rs.getNString("Cor"));
				automovel.setIdDono(rs.getInt("idDono"));
				
				automoveis.add(automovel);
			}
			return automoveis;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int buscarIdAutomovel(AutomovelDTO AutomovelDTO) {
		Automovel automovel = Automovel.converter(AutomovelDTO);
		ResultSet rs = dao.findBySpecifiedField(automovel, "Placa");
		try {
			if(rs!=null && rs.next()) {
				//cliente.setIdCliente(rs.getInt("idCliente"));
				//return cliente;
				return rs.getInt("idAutomovel");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
	public boolean alterar(AutomovelDTO automovelDTO) {
		Automovel automovel = Automovel.converter(automovelDTO);
		ResultSet rs = dao.findBySpecifiedField(automovel, "idDono");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.alterar(automovel) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	public boolean deletar(AutomovelDTO automovelDTO) {
		Automovel automovel = Automovel.converter(automovelDTO);
		ResultSet rs = dao.findBySpecifiedField(automovel, "idDono");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.deletar(automovel) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
}
