package br.edu.ufersa.wsgear.model.entity;

import java.sql.Date;
import java.time.LocalDate;

import br.edu.ufersa.wsgear.api.dto.ServicoDTO;


public class Servico {
	// Garantia de integridade ---------------------------------------------------
	private static int contIdServico;
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

	public Servico(String nome, double preco, String status, String dataServico) {
		setNome(nome);
		setPreco(preco);
		setStatus(status);
		setDataServico(dataServico);
	}

	// Metodos set ---------------------------------------------------

	

	public void setIdServico(int l) {

		this.idServico = l;
	}
	
	public void gerarIdServico() {
		this.idServico =+ contIdServico;
		contIdServico++;
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

	public int getIdServico() {
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