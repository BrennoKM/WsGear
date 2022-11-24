package br.edu.ufersa.wsgear.model.entity;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.wsgear.api.dto.OrcamentoDTO;

public class Orcamento {

	private static int contIdOrcamento;
	private int idOrcamento;
	private int idPeca;
	private int idServico;
	private int idAutomovel;
	private List<Peca> pecas = new ArrayList<Peca>();
	private List<Servico> servicos = new ArrayList<Servico>();
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
			pecas.add(peca);
			servicos.add(servico);
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

	public void gerarIdOrcamento() {
		this.idOrcamento = +contIdOrcamento;
		contIdOrcamento++;
	}

	public void setIdPEca(int idPeca) {
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
			pecas.add(peca);
		}
	}

	public void setPecas(List<Peca> pecas) {
		if (pecas != null) {
			this.pecas = pecas;
		}
	}

	public void setServico(Servico servico) {
		if (servico != null) {
			servicos.add(servico);
		}
	}

	public void setServicos(ArrayList<Servico> servicos) {
		if (servicos != null) {
			this.servicos = servicos;
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

	public List<Peca> getPecas() {
		return this.pecas;
	}

	public List<Servico> getServicos() {
		return this.servicos;
	}

	public static Orcamento converter(OrcamentoDTO orcamentoDTO) {
		Orcamento orcamento = new Orcamento();
		orcamento.inserirPecaServicoValor(orcamentoDTO.getPecas().get(0), orcamentoDTO.getServicos().get(0),
				orcamentoDTO.getValor());
		orcamento.setIdOrcamento(orcamentoDTO.getIdOrcamento());
		return orcamento;
	}

}
