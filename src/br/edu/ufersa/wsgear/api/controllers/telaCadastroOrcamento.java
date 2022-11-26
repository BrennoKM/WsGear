package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.OrcamentoDTO;
import br.edu.ufersa.wsgear.model.service.OrcamentoBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class telaCadastroOrcamento {
	@FXML private TextField orcamentoIdPeca;
	@FXML private TextField orcamentoIdServico;
	@FXML private TextField orcamentoIdAutomovel;
	@FXML private TextField orcamentoPreco;
		private OrcamentoBO bo = new OrcamentoBO();
		
		public void cadastrar() {
			OrcamentoDTO dto = new OrcamentoDTO();
			dto.setValor(Double.parseDouble(orcamentoPreco.getText()));
			dto.setIdServico(Integer.parseInt(orcamentoIdServico.getText()));
			dto.setIdPeca(Integer.parseInt(orcamentoIdPeca.getText()));
			dto.setIdAutomovel(Integer.parseInt(orcamentoIdAutomovel.getText()));
			bo.inserir(dto);
			Telas.telaPesquisaOrcamento();
		}
		
		public void chamarTelaPrincipal() {
			Telas.telaPrincipal();
		}
		public void voltarTelaPesquisaOrcamento() {
			Telas.telaPesquisaOrcamento();
		}
}
