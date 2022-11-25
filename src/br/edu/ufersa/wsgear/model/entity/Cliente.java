package br.edu.ufersa.wsgear.model.entity;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.wsgear.api.dto.ClienteDTO;

public class Cliente {

	private int idCliente;

	private String nome;
	private String cpf;
	private String telefone;

	private Endereco endereco;
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
		if ((!nome.isEmpty())&& (nome != null) ) {
			this.nome = nome;
		} else {
			this.nome = "Cliente sem nome";
		}
	}

	public void setCpf(String cpf) {
		if (!cpf.isEmpty()) {
			this.cpf = cpf;
		}
	}

	public void setEndereco(Endereco endereco) {
		if (endereco != null) {
			this.endereco =endereco;
		}
	}


	public void setTelefone(String telefone) {
		if (!telefone.isEmpty()) {
			this.telefone = telefone;
		} else {
			this.telefone = "-";
		}
	}

	public void setIdCliente(int l) {
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

	public Endereco getEnderecos() {
		return endereco;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public int getIdCliente() {
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
		c.setEndereco(dto.getEndereco());
		c.setAutomoveis(dto.getAutomoveis());
		c.setIdCliente(dto.getIdCliente());
		return c;
	}
}
