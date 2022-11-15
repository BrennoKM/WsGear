package br.edu.ufersa.wsgear.api.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.wsgear.model.entity.Peca;
import br.edu.ufersa.wsgear.model.entity.Servico;

public class OrcamentoDTO {
	private int idOrcamento;
	private List<Peca> pecas = new ArrayList<Peca>();
	private List<Servico> servicos = new ArrayList<Servico>();
	private double valor;
	
	
	public OrcamentoDTO() {
		this.valor = 0;
		idOrcamento++;
	}

	public OrcamentoDTO(Peca peca, Servico servico, double valor) {
		this.valor = 0;
		inserirPecaServicoValor(peca, servico, valor);
		idOrcamento++;
	}

	private void inserirPecaServicoValor(Peca peca, Servico servico, double valor) {
		if((peca != null) && (servico != null) && (valor > 0.0)){	
			pecas.add(peca);
			servicos.add(servico);
			somarValor(valor);
		}
	}

	public void somarValor(double valor) {
		if(valor > 0.0) {
			this.valor += valor;
		}
	}
	public void setIdOrcamento(int idOrc) {
		if(idOrc > 0)
			this.idOrcamento = idOrc;
		else
			this.idOrcamento = 0;
	}
	public void setValor(double valor) {
		if (valor > 0.0) 
			this.valor = valor;
		else 
			this.valor = valor;
	}

	public void setPeca(Peca peca) {
		if(peca != null) {
			pecas.add(peca);
		}
	}
	
	public void setPecas(ArrayList<Peca> pecas) {
		if(pecas != null) {
			this.pecas = pecas;
		}
	}
	
	public void setServico(Servico servico) {
		if(servico != null) {
			servicos.add(servico);
		}
	}
	public void setServicos(ArrayList<Servico> servicos) {
		if(servicos != null) {
			this.servicos = servicos;
		}
	}
	
	public int getIdOrcamento() {
		return this.idOrcamento;
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
}
