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

	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet rs = dao.findAll();
		try {
			while (rs.next()) {
				Cliente cliente = new Cliente();
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
		Cliente cliente = Cliente.converter(clienteDTO);

		ResultSet rs = dao.findBySpecifiedField(cliente, "CPF");
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
