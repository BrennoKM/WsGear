package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class telaPrincipal implements Initializable {
	@FXML
	private ChoiceBox<String> tiposBox;
	@FXML
	private ChoiceBox<String> editarTipoBox;

	private String opcoes[] = { "Automovel", "Cliente", "Orcamento", "Peca", "Servico" };

	public void initialize(URL arg0, ResourceBundle arg1) {
		editarTipoBox.getItems().addAll(opcoes);
	}

	public void telaConcluirServico() {

	}

	public void telaGerarRelatorio() {

	}

	public void telaPesquisar() {
		switch (editarTipoBox.getValue()) {
		case "Automovel":
			Telas.telaPesquisaAutomovel();
			break;
		case "Cliente":
			Telas.telaPesquisaCliente();
			break;
		case "Peca":
			Telas.telaPesquisaPeca();
			break;
		case "Servico":
			Telas.telaPesquisaServico();
			break;
		case "Orcamento":
			Telas.telaPesquisaOrcamento();
			break;
		}
	}
}
