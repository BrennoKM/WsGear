package br.edu.ufersa.wsgear.model.entity;

import java.sql.Date;
import java.time.LocalDate;

import br.edu.ufersa.wsgear.api.dto.ServicoDTO;


public class Servico {
	// Garantia de integridade ---------------------------------------------------
	private Long idServico;
	private String nome;
	private double preco;
	private LocalDate dataServico;
	private String status;

	// Construtores ---------------------------------------------------
	public Servico() {
	}

	public Servico(long idServico) {
		setIdServico(idServico);
	}
	
	public Servico(String nome) {
		setNome(nome);
		setDataInicialServico();
	}

	public Servico(String nome, double preco) {
		setNome(nome);
		setPreco(preco);
		setDataInicialServico();
	}

	public Servico(String nome, double preco, String status) {
		setNome(nome);
		setPreco(preco);
		setStatus(status);
		setDataInicialServico();
	}

	public Servico(String nome, double preco, String status, String dataServico) {
		setNome(nome);
		setPreco(preco);
		setStatus(status);
		setDataServico(dataServico);
	}

	// Metodos set ---------------------------------------------------

	public void setIdServico(long l) {

		this.idServico = l;
	}

	public void setNome(String nome) {

		if (!nome.isEmpty()) {
			this.nome = nome;
		} else {
			this.nome = "ServiÃ§o";
		}
	}

	public void setPreco(double preco) {

		this.preco = preco;
	}

	public void setDataServico(String dataServico) {
		this.dataServico = LocalDate.parse(dataServico);
	}

	public void setDataInicialServico() {
		this.dataServico = LocalDate.now();
	}

	public void setStatus(String status) {
		this.status = status;
	}
	// Metodos get ---------------------------------------------------

	public Long getIdServico() {
		return idServico;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public Date getDataServico() {
		return Date.valueOf(dataServico);
	}

	public String getStatus() {
		return status;
	}
	
	public static Servico converter(ServicoDTO dto) {
		Servico s = new Servico();
		s.setIdServico(dto.getIdServico());
		s.setNome(dto.getNome());
		s.setStatus(dto.getStatus());
		s.setPreco(dto.getPreco());
		s.setIdServico(dto.getIdServico());
		return s;
	}
}