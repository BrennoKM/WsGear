package br.edu.ufersa.wsgear.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.wsgear.api.dto.ClienteDTO;
import br.edu.ufersa.wsgear.model.dao.BaseInterDAO;
import br.edu.ufersa.wsgear.model.dao.ClienteDAO;
import br.edu.ufersa.wsgear.model.entity.Cliente;

public class ClienteBO implements ServiceInterface<ClienteDTO> {
	BaseInterDAO<Cliente> dao = new ClienteDAO();

	public boolean inserir(ClienteDTO clienteDTO) {
		Cliente cliente = Cliente.converter(clienteDTO);

		ResultSet rs = dao.findBySpecifiedField(cliente, "CPF");
		try {
			if (rs == null || !(rs.next())) {
				if (dao.inserir(cliente) == true)
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
	
	public int buscarIdCliente(ClienteDTO clienteDTO) {
		Cliente cliente = Cliente.converter(clienteDTO);
		ResultSet rs = dao.findBySpecifiedField(cliente, "CPF");
		try {
			if(rs!=null && rs.next()) { 
				return rs.getInt("idCliente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
	public int buscarIdClienteAutomovel(ClienteDTO clienteDTO) {
		Cliente cliente = Cliente.converterId(clienteDTO);
		ResultSet rs = dao.findBySpecifiedField(cliente, "CPF");
		try {
			if(rs!=null && rs.next()) {
				return rs.getInt("idCliente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	public Cliente buscarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = Cliente.converter(clienteDTO);
		ResultSet rs = dao.findBySpecifiedField(cliente, "CPF");
		try {
			if(rs!=null && rs.next()) {
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("Nome"));
				return cliente;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public List<ClienteDTO> listar() {
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		ResultSet rs = dao.findAll();
		try {
			while (rs.next()) {
				ClienteDTO cliente = new ClienteDTO();
				cliente.setCpf(rs.getString("CPF"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setTelefone(rs.getNString("Telefone"));
				cliente.setIdCliente(rs.getInt("idCliente"));

				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean alterar(ClienteDTO clienteDTO) {
		Cliente cliente = Cliente.converter(clienteDTO);

		ResultSet rs = dao.findBySpecifiedField(cliente, "CPF");
		try {
			if (rs != null && rs.next()) {
				if (dao.alterar(cliente) == true)
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

	public boolean deletar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(clienteDTO.getIdCliente());

		ResultSet rs = dao.findBySpecifiedField(cliente, "idCliente");
		try {
			if (rs != null && rs.next()) {
				if (dao.deletar(cliente) == true)
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

}
