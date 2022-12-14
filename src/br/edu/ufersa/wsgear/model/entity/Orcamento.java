package br.edu.ufersa.wsgear.model.entity;


import br.edu.ufersa.wsgear.api.dto.OrcamentoDTO;

public class Orcamento {

	private int idOrcamento;
	private int idPeca;
	private int idServico;
	private int idAutomovel;
	private Peca peca;
	private Servico servico;
	private double valor;

	public Orcamento() {
		this.valor = 0;
	}

	public Orcamento(Peca peca, Servico servico, double valor) {
		this.valor = 0;
		inserirPecaServicoValor(peca, servico, valor);
	}

	private void inserirPecaServicoValor(Peca peca, Servico servico, double valor) {
		if ((peca != null) && (servico != null) && (valor > 0.0)) {
			this.peca = peca;
			this.servico = servico;
			somarValor(valor);
		}
	}

	public void somarValor(double valor) {
		if (valor > 0.0) {
			this.valor += valor;
		}
	}

	public void setIdOrcamento(int idOrc) {
		if (idOrc > 0)
			this.idOrcamento = idOrc;
	}

	public void setIdPeca(int idPeca) {
		if (idPeca > 0)
			this.idPeca = idPeca;
	}

	public void setIdServico(int idServico) {
		if (idServico > 0)
			this.idServico = idServico;
	}

	public void setIdAutomovel(int idAutomovel) {
		if (idAutomovel > 0)
			this.idAutomovel = idAutomovel;
	}

	public void setValor(double valor) {
		if (valor > 0.0)
			this.valor = valor;
		else
			this.valor = valor;
	}

	public void setPeca(Peca peca) {
		if (peca != null) {
			this.peca = peca;
		}
	}

	public void setServico(Servico servico) {
		if (servico != null) {
			this.servico = servico;
		}
	}

	public int getIdOrcamento() {
		return this.idOrcamento;
	}

	public int getIdPeca() {
		return this.idPeca;
	}

	public int getIdServico() {
		return this.idServico;
	}

	public int getIdAutomovel() {
		return this.idAutomovel;
	}

	public double getValor() {
		return this.valor;
	}

	public Peca getPeca() {
		return this.peca;
	}

	public Servico getServico() {
		return this.servico;
	}

	public static Orcamento converter(OrcamentoDTO orcamentoDTO) {
		Orcamento orcamento = new Orcamento();
		orcamento.setIdAutomovel(orcamentoDTO.getIdAutomovel());
		orcamento.setIdPeca(orcamentoDTO.getIdPeca());
		orcamento.setValor(orcamentoDTO.getValor());
		orcamento.setIdServico(orcamentoDTO.getIdServico());
		orcamento.setIdOrcamento(orcamentoDTO.getIdOrcamento());
		return orcamento;
	}

}
