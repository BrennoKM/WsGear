package br.edu.ufersa.wsgear.model.entity;

import java.sql.Date;
import java.time.LocalDate;

import br.edu.ufersa.wsgear.api.dto.ServicoDTO;


public class Servico {
	// Garantia de integridade ---------------------------------------------------
	
	private int idServico;
	private String nome;
	private double preco;
	private LocalDate dataServico;
	private String status;

	// Construtores ---------------------------------------------------
	public Servico() {
	}
	
	public Servico(int id) {
		setIdServico(id);
	}
	
	public Servico(String nome) {
		setNome(nome);
	}

	public Servico(String nome, double preco) {
		setNome(nome);
		setPreco(preco);
	}

	public Servico(String nome, double preco, String status) {
		setNome(nome);
		setPreco(preco);
		setStatus(status);
	}

	public Servico(String nome, double preco, String status, LocalDate dataServico) {
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
	
	public static Servico converter(ServicoDTO dto) {
		Servico s = new Servico();
		s.setIdServico(dto.getIdServico());
		s.setNome(dto.getNome());
		s.setStatus(dto.getStatus());
		s.setPreco(dto.getPreco());
		s.setIdServico(dto.getIdServico());
		s.setDataServico(dto.getDataServico());
		return s;
	}
}