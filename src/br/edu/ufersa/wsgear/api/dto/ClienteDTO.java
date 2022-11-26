package br.edu.ufersa.wsgear.api.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.wsgear.model.entity.Automovel;
import br.edu.ufersa.wsgear.model.entity.Endereco;

public class ClienteDTO {
	private int idCliente;

	private String nome;
	private String cpf;
	private String telefone;

	private Endereco endereco;
	private List<Automovel> automoveis = new ArrayList<>();

	
	//atributos endereco
	private String cep; // CEP
	private String rua; // Rua
	private String bairro; // Bairro
	private String complemento; // Complemento
	private int numero; // Numero
	
	public ClienteDTO() {
	}

	public ClienteDTO(String nome) {
		setNome(nome);
	}

	public ClienteDTO(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}

	public ClienteDTO(String nome, String cpf, Endereco endereco) {
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
			this.endereco = endereco;
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
	public void setCep(String cep) {
		if (!cep.isBlank() || !cep.isEmpty())
			this.cep = cep;
		else
			this.cep = "n/a";
	}

	public void setRua(String rua) {
		if (!rua.isBlank() || !rua.isEmpty())
			this.rua = rua;
		else
			this.rua = "n/a";
	}

	public void setBairro(String bairro) {
		if (!bairro.isBlank() || !bairro.isEmpty())
			this.bairro = bairro;
		else
			this.bairro = "n/a";
	}

	public void setComplemento(String complemento) {
		if (!complemento.isBlank() || !complemento.isEmpty())
			this.complemento = complemento;
		else
			this.complemento = "n/a";
	}

	public void setNumero(int numero) {
		if (numero > 0)
			this.numero = numero;
		else
			this.numero = 0;
	}

	public int getNumero() {
		return this.numero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public String getRua() {
		return this.rua;
	}

	public String getBairro() {
		return this.bairro;
	}

	public String getCep() {
		return this.cep;
	}
	// Metodos get

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public Endereco getEndereco() {
		return this.endereco;
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

}
