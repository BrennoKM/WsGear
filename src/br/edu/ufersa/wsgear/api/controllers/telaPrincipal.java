package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class telaPrincipal implements Initializable{
	@FXML private ChoiceBox<String> tiposBox;
	@FXML private ChoiceBox<String> editarTipoBox;
	@FXML private Button concluirervicoButton;
	@FXML private Button relatorioButton;
	@FXML private Button pesquisarButton;
	@FXML private Button editarButton;
	
	private String opcoes[]= {"Automovel", "Cliente", "Orcamento", "Peca", "Servico"};
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		tiposBox.getItems().addAll(opcoes);
		editarTipoBox.getItems().addAll(opcoes);
	}
	
	public void telaCadastrar() {
		switch (tiposBox.getValue()) {
			case "Automovel":
				Telas.telaCadastroAutomovel();
				break;
			case "Cliente":
				Telas.telaCadastroCliente();
				break;
			case "Peca":
				Telas.telaCadastroPeca();
				break;
			case "Servico":
				Telas.telaCadastroServico();
				break;
			case "Orcamento":
				Telas.telaCadastroOrcamento();
				break;
		}
	}
	
	public void telaConcluirServico() {
		
	}
	
	public void telaRelatorio() {
		
	}
	
	public void telaPesquisar() {
		switch (editarTipoBox.getValue()) {
		case "Automovel":
			Telas.telaPesquisaAutomovel();
			break;
		case "Cliente":
			//Telas.telaPesquisaPeca();
			break;
		case "Peca":
			Telas.telaPesquisaPeca();
			break;
		case "Servico":
			Telas.telaPesquisaServico();
			break;
		case "Orcamento":
			//Telas.telaPes
			break;
	}
	}
}
