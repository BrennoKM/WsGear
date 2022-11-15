package br.edu.ufersa.wsgear.api.dto;

import br.edu.ufersa.wsgear.model.entity.Cliente;
import br.edu.ufersa.wsgear.model.entity.Orcamento;

public class AutomovelDTO {
	// Atributos privados
	private Cliente dono;
	private Orcamento orcamentoServico;
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private int ano;
	private int anomax = 2050;
	private int idDono;

	// Construtores
	public AutomovelDTO() {
	}
	public AutomovelDTO(Cliente dono, String marca) {
		setDono(dono);
		setMarca(marca);
	}

	public AutomovelDTO(Cliente dono, String marca, String modelo) {
		setDono(dono);
		setMarca(marca);
		setModelo(modelo);
	}

	public AutomovelDTO(Cliente dono, String marca, String modelo, String cor, String placa, int ano) {
		setDono(dono);
		setMarca(marca);
		setModelo(modelo);
		setCor(cor);
		setPlaca(placa);
		setAno(ano);
	}

	// Metodos set

	public void setMarca(String marca) {
		if (!marca.isEmpty()) {
			this.marca = marca;
		} else {
			this.marca = "Generica";
		}
	}

	public void setModelo(String modelo) {
		if (!modelo.isEmpty()) {
			this.modelo = modelo;
		} else {
			this.modelo = "Generico";
		}
	}

	public void setCor(String cor) {
		if (!cor.isEmpty()) {
			this.cor = cor;
		} else {
			this.cor = "-";
		}
	}

	public void setPlaca(String placa) {
		if (!placa.isEmpty() && (placa.length() == 7)) {
			this.placa = placa;
		} else {
			this.placa = "-";
		}
	}

	public void setAno(int ano) {
		if ((ano >= 1971) && (ano <= this.anomax)) {
			this.ano = ano;
		} else {
			this.ano = 2022;
		}
	}

	public void setDono(Cliente dono) {
		if(!(dono == null)) {
			this.dono = dono;
			idDono = dono.getIdCliente();
		}
		else 
			this.dono = new Cliente("Juju");
	}
	
	public void setIdDono(int iDdono) {
		if(!(idDono >= 0)) {
			this.idDono = iDdono;
		}
	}

	public void setOrcamentoServico(Orcamento orcamentoServico) {
		if(orcamentoServico != null)
			this.orcamentoServico = orcamentoServico;
		else
			this.orcamentoServico = new Orcamento();
	}

	// Metodos get

	public String getMarca() {
		return this.marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public String getCor() {
		return this.cor;
	}

	public String getPlaca() {
		return this.placa;
	}

	public int getAno() {
		return this.ano;
	}

	public Cliente getDono() {
		return this.dono;
	}

	public int getIdDono() {
		return this.idDono;
	}

	public Orcamento getOrcamentoServico() {
		return this.orcamentoServico;
	}
}
