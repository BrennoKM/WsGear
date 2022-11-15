package br.edu.ufersa.wsgear.model.entity;

import br.edu.ufersa.wsgear.api.dto.AutomovelDTO;

public class Automovel {
	// Atributos privados

	private Long idAutomovel;
	private Long idDono;

	private Cliente dono;
	private Orcamento orcamentoServico;
	private String cpfDono;
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private int ano;
	private int anomax = 2050;

	// Construtores
	public Automovel() {
	}

	public Automovel(Cliente dono, String marca) {
		setDono(dono);
		setMarca(marca);
	}

	public Automovel(Cliente dono, String marca, String modelo) {
		setDono(dono);
		setMarca(marca);
		setModelo(modelo);
	}

	public Automovel(Cliente dono, String marca, String modelo, String cor, String placa, int ano) {
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

	public void setCpfDono(String cpfDono) {
		if (!cpfDono.isEmpty()) {
			this.cpfDono = cpfDono;
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
		if (!(dono == null)) {
			this.dono = dono;
			idDono = dono.getIdCliente();
		} else
			this.dono = new Cliente("Cliente sem nome");
	}

	public void setIdDono(Long idDono) {
		if (idDono >= 0) {
			this.idDono = idDono;
		}
	}

	public void setIdAutomovel(Long idAutomovel) {
		if (idAutomovel >= 0) {
			this.idAutomovel = idAutomovel;
		}
	}

	public void setOrcamentoServico(Orcamento orcamentoServico) {
		if (orcamentoServico != null)
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

	public Long getIdDono() {
		return this.idDono;
	}

	public Long getIdAutomovel() {
		return this.idAutomovel;
	}

	public Orcamento getOrcamentoServico() {
		return this.orcamentoServico;
	}

	public String getCpfDono() {
		return cpfDono;
	}

	public static Automovel conveter(AutomovelDTO dto) {
		Automovel a = new Automovel();
		a.setCpfDono(dto.getCpfDono());
		a.setAno(dto.getAno());
		a.setCor(dto.getCor());
		a.setDono(dto.getDono());
		a.setIdDono(dto.getIdDono());
		a.setMarca(dto.getMarca());
		a.setModelo(dto.getModelo());
		a.setOrcamentoServico(dto.getOrcamentoServico());
		a.setPlaca(dto.getPlaca());
		a.setIdAutomovel(dto.getIdAutomovel());
		return a;
	}

}
