package br.edu.ufersa.wsgear.model.entity;

import br.edu.ufersa.wsgear.api.dto.PecaDTO;

public class Peca {
	private Long idPeca; // Identificador: Possivelmente um Enum
	private String nome; // Nome
	private String fab; // Fabricante
	private double preco; // Valor

	public Peca() {
		setNome("");
		setFab("");
		setPreco(0.0);
	}
	
	public Peca(Long idPeca) {
		setIdPeca(idPeca);
	}
	
	public Peca(String nome, String fab, double preco) {
		setNome(nome);
		setFab(fab);
		setPreco(preco);
	}

	public void setIdPeca(Long l) {
		if (l > 0)
			this.idPeca = l;
	}

	public void setNome(String nome) {
		if (!nome.isBlank() || !nome.isEmpty())
			this.nome = nome;
		else
			this.nome = "Peca generica";
	}

	public void setFab(String fab) {
		if (!fab.isBlank() || !fab.isEmpty())
			this.fab = fab;
		else
			this.fab = "Fabricante generico";
	}

	public void setPreco(double preco) {
		if (preco > 0.0)
			this.preco = preco;
		else
			this.preco = 120.0;
	}

	public double getPreco() {
		return this.preco;
	}

	public String getNome() {
		return this.nome;
	}

	public String getFab() {
		return this.fab;
	}

	public Long getIdPeca() {
		return this.idPeca;
	}
	
	public static Peca converter(PecaDTO dto) {
		Peca p = new Peca();
		p.setFab(dto.getFab());
		p.setNome(dto.getNome());
		p.setIdPeca(dto.getIdPeca());
		p.setPreco(dto.getPreco());
		p.setIdPeca(dto.getIdPeca());
		return p;
	}
}