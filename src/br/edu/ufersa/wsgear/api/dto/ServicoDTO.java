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

		public ServicoDTO(int idServico, String nome) {
			setIdServico(idServico);
			setNome(nome);
			setDataInicialServico();
		}

		public ServicoDTO(int idServico, String nome, double preco) {
			setIdServico(idServico);
			setNome(nome);
			setPreco(preco);
			setDataInicialServico();
		}

		public ServicoDTO(int idServico, String nome, double preco, String status) {
			setIdServico(idServico);
			setNome(nome);
			setPreco(preco);
			setStatus(status);
			setDataInicialServico();
		}

		public ServicoDTO(int idServico, String nome, double preco, String status, String dataServico) {
			setIdServico(idServico);
			setNome(nome);
			setPreco(preco);
			setStatus(status);
			setDataServico(dataServico);
		}

		// Metodos set ---------------------------------------------------

		public void setIdServico(int idServico2) {

			this.idServico = idServico2;
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
}
