package br.edu.ufersa.wsgear.api.dto;

public class PecaDTO {
	private int idPeca; // Identificador: Possivelmente um Enum
	private String nome; // Nome
	private String fab; // Fabricante
	private double preco; // Valor

	public PecaDTO() {
		setNome("");
		setFab("");
		setPreco(10.0);
	}

	public PecaDTO(int idPeca) {
		setIdPeca(idPeca);
	}

	public PecaDTO(String nome, String fab, double preco) {
		setNome(nome);
		setFab(fab);
		setPreco(preco);
	}

	public void setIdPeca(int l) {
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

	public int getIdPeca() {
		return this.idPeca;
	}
}
