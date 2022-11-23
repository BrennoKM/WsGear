package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.api.dto.PecaDTO;
import br.edu.ufersa.wsgear.model.service.PecaBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaPesquisaPeca {
	@FXML private TableView<PecaDTO> tabelaPeca;
	@FXML private TableColumn<PecaDTO, String> idPecaColumn;
	@FXML private TableColumn<PecaDTO, String> NomeColumn;
	@FXML private TableColumn<PecaDTO, String> FabricanteColumn;
	@FXML private TableColumn<PecaDTO, String> PrecoColumn;
	
	private PecaBO bo = new PecaBO();
    private ObservableList<PecaDTO> listaDePecas;
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarPecas();
	}
	public void listarPecas() {
		List<PecaDTO> pecas = bo.listar();
		listaDePecas = FXCollections.observableArrayList(pecas);
		idPecaColumn.setCellValueFactory(new PropertyValueFactory<>("idPeca"));
		NomeColumn.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		FabricanteColumn.setCellValueFactory(new PropertyValueFactory<>("Fabricante"));
		PrecoColumn.setCellValueFactory(new PropertyValueFactory<>("Preço"));
		tabelaPeca.setItems(listaDePecas);
		
	}
}
