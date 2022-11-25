package br.edu.ufersa.wsgear.api.dto;

import java.sql.Date;
import java.time.LocalDate;

public class ServicoDTO {
	// Garantia de integridade ---------------------------------------------------
	private int idServico;
	private String nome;
	private double preco;
	private LocalDate dataServico;
	private String status;

	// Construtores ---------------------------------------------------
	public ServicoDTO() {
	}
	
	public ServicoDTO(String nome) {
		setNome(nome);
	}

	public ServicoDTO(String nome, double preco) {
		setNome(nome);
		setPreco(preco);
	}

	public ServicoDTO(String nome, double preco, String status) {
		setNome(nome);
		setPreco(preco);
		setStatus(status);
	}

	public ServicoDTO(String nome, double preco, String status, LocalDate dataServico) {
		setNome(nome);
		setPreco(preco);
		setStatus(status);
		setDataServico(dataServico);
	}

	// Metodos set ---------------------------------------------------

	public void setIdServico(int l) {
		if(l > 0)
			this.idServico = l;
		else
			this.idServico = 0;
	}
	

	public void setNome(String nome) {

		if (!nome.isEmpty()) {
			this.nome = nome;
		} else {
			this.nome = "Servico";
		}
	}

	public void setPreco(double preco) {
		if(preco >= 0.0)
			this.preco = preco;
		else
			this.preco = 100.0;
	}

	public void setDataServico(LocalDate localDate) {
		if(localDate != null)
			this.dataServico = localDate;
		else
			this.dataServico = LocalDate.of(1, 1, 2001);
	}

	public void setDataInicialServico() {
		this.dataServico = LocalDate.now();
	}

	public void setStatus(String status) {
		if(status != null && !(status.isEmpty()) && !(status.isBlank()))
			this.status = status;
		else
			this.status = "Indefinido";
	}
	// Metodos get ---------------------------------------------------

	public int getIdServico() {
		return idServico;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public LocalDate getDataServico() {
		return this.dataServico;
	}

	public String getStatus() {
		return status;
	}
}
