package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.ServicoDTO;
import br.edu.ufersa.wsgear.model.service.ServicoBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class telaCadastroServico {
	@FXML private TextField pecaNome;
	@FXML private TextField servicoPreco;
	@FXML private TextField servicoStatus;
	@FXML private DatePicker servicoDataInicio;
	@FXML private Button cadastrarButton;
	@FXML private Button cancelButton;
	@FXML private Button homeButton;
		private ServicoBO bo = new ServicoBO();
		
		public void cadastrar() {
			ServicoDTO dto = new ServicoDTO();
			dto.setNome(pecaNome.getText());
			dto.setPreco(Double.parseDouble(servicoPreco.getText()));
			dto.setStatus(servicoStatus.getText());
			dto.setDataServico(servicoDataInicio.getConverter().fromString(servicoDataInicio.getEditor().getText()));
			bo.inserir(dto);
			//Telas.telaPesquisaServico();
		}
		
		public void chamarTelaPrincipal() {
			Telas.telaPrincipal();
		}
		public void voltarMainScreen() {
			chamarTelaPrincipal();
		}
}
