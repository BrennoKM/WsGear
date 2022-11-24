package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class telaPesquisa implements Initializable {
	@FXML private TextField pesquisaContent;
	@FXML private ChoiceBox<String> pesquisaTipoBox;
	@FXML private Button botaoPesquisa;
	@FXML private Button homeButton;
	@FXML private DatePicker periodo0;
	@FXML private DatePicker periodo1;
	
	private String opcoes[]= {"Automovel - Placa", "Automovel - Cliente", "Orcamento - ID do Veiculo", "Orcamento - ID do Cliente", "Orcamento - Periodo", "Peca - Nome", "Peca - Fabricante", "Peca - Automovel", "Servico - Nome"};
	
	
	public void pesquisar() {
		switch (pesquisaTipoBox.getValue()) {
			case "Automovel - Placa":
				Telas.telaPesquisaAutomovel();
				break;
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		pesquisaTipoBox.getItems().addAll(opcoes);
		
	}
	
	public void chamarTelaPrincipal() {
		Telas.telaPrincipal();
	}
}
