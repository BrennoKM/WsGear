package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.ResourceBundle;

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
	@FXML private DatePicker periodo0;
	@FXML private DatePicker periodo1;
	
	private String opcoes[]= {"Automóvel - Placa", "Automóvel - Cliente", "Orçamento - ID do Veículo", "Orçamento - ID do Cliente", "Orçamento - Período", "Peça - Nome", "Peça - Fabricante", "Peça - Automóvel", "Serviço - Nome"};
	
	
	public void pesquisar() {
		//Implementa a pesquisa aqui
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pesquisaTipoBox.getItems().addAll(opcoes);
		
	}
}
