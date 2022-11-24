package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.OrcamentoDTO;
import br.edu.ufersa.wsgear.model.service.OrcamentoBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class telaCadastroOrcamento {
	@FXML private TextField orcamentoIdPeca;
	@FXML private TextField orcamentoIdServico;
	@FXML private TextField orcamentoPlaca;
	@FXML private TextField orcamentoPreco;
	@FXML private Button cadastrarButton;
	@FXML private Button cancelButton;
	@FXML private Button homeButton;
		private OrcamentoBO bo = new OrcamentoBO();
		
		public void cadastrar() {
			OrcamentoDTO dto = new OrcamentoDTO();
			dto.setValor(Integer.parseInt(orcamentoPreco.toString()));
			bo.inserir(dto);
			Telas.telaPesquisaAutomovel();
		}
}
