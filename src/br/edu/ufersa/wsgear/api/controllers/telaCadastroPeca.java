package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.PecaDTO;
import br.edu.ufersa.wsgear.model.service.PecaBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class telaCadastroPeca {
	@FXML private TextField pecaNome;
	@FXML private TextField pecaFabricante;
	@FXML private TextField pecaPreco;
	@FXML private Button cadastrarButton;
	@FXML private Button cancelButton;
	@FXML private Button homeButton;
		private PecaBO bo = new PecaBO();
		
		public void cadastrar() {
			PecaDTO dto = new PecaDTO();
			dto.setNome(pecaNome.getText());
			dto.setFab(pecaFabricante.getText());
			dto.setPreco(Double.parseDouble(pecaPreco.getText()));
			bo.inserir(dto);
			//Telas.telaPesquisaPeca();
		}
		
		public void chamarTelaPrincipal() {
			Telas.telaPrincipal();
		}
		public void voltarMainScreen() {
			chamarTelaPrincipal();
		}
}
