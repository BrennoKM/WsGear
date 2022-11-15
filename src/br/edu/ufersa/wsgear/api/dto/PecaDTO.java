package br.edu.ufersa.wsgear.api.dto;

public class PecaDTO {
	private int idPeca; // Identificador: Possivelmente um Enum
	private String nome; // Nome
	private String fab; // Fabricante
	private double preco; // Valor

	public PecaDTO() {
		setIdPeca(0);
		setNome("");
		setFab("");
		setPreco(0.0);
	}

	public PecaDTO(int idPeca, String nome, String fab, double preco) {
		setIdPeca(idPeca);
		setNome(nome);
		setFab(fab);
		setPreco(preco);
	}

	public void setIdPeca(int idPeca) {
		if (idPeca > 0)
			this.idPeca = idPeca;
		else
			this.idPeca = 0;
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

	public int getIdPeca() {
		return this.idPeca;
	}
}
