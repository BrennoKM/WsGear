package br.edu.ufersa.wsgear.model.entity;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.wsgear.api.dto.ClienteDTO;

public class Cliente {

	private Long idCliente;

	private String nome;
	private String cpf;
	private String telefone;

	private List<Endereco> enderecos = new ArrayList<>();
	private List<Automovel> automoveis = new ArrayList<>();

	
	public Cliente() {
	}

	public Cliente(String nome) {
		setNome(nome);
	}

	public Cliente(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}

	public Cliente(String nome, String cpf, Endereco endereco) {
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
	}

	// Metodos set

	public void setNome(String nome) {
		if (!nome.isEmpty()) {
			this.nome = nome;
		} else {
			this.nome = "Cliente sem nome";
		}
	}

	public void setCpf(String cpf) {
		if (!cpf.isEmpty() && (cpf.length() == 15)) {
			this.cpf = cpf;
		} else {
			this.cpf = "-----------";
		}
	}

	public void setEndereco(Endereco endereco) {
		if (endereco != null) {
			enderecos.add(endereco);
		}
	}

	public void setEnderecos(List<Endereco> list) {
		if (list != null) {
			this.enderecos = list;
		}
	}

	public void setTelefone(String telefone) {
		if (!telefone.isEmpty()) {
			this.telefone = telefone;
		} else {
			this.telefone = "-";
		}
	}

	public void setIdCliente(Long l) {
		this.idCliente = l;
	}

	public void setVeiculo(Automovel automovel) {
		if (automovel != null) {
			automoveis.add(automovel);
		}
	}
	
	public void setAutomoveis(List<Automovel> list) {
		if (list != null) {
			this.automoveis = list;
		}
	}

	// Metodos get

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public Long getIdCliente() {
		return this.idCliente;
	}

	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

	public static Cliente converter(ClienteDTO dto) {
		Cliente c = new Cliente();
		c.setCpf(dto.getCpf());
		c.setNome(dto.getNome());
		c.setTelefone(dto.getTelefone());
		c.setEnderecos(dto.getEnderecos());
		c.setAutomoveis(dto.getAutomoveis());
		c.setIdCliente(dto.getIdCliente());
		return c;
	}
}
