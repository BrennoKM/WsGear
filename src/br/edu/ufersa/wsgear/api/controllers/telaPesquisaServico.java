package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.api.dto.ServicoDTO;
import br.edu.ufersa.wsgear.model.service.ServicoBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaPesquisaServico {
	@FXML private TableView<ServicoDTO> tabelaServico;
	@FXML private TableColumn<ServicoDTO, String> idServicoColumn;
	@FXML private TableColumn<ServicoDTO, String> NomeColumn;
	@FXML private TableColumn<ServicoDTO, String> DataServicoColumn;
	@FXML private TableColumn<ServicoDTO, String> PrecoColumn;
	@FXML private TableColumn<ServicoDTO, String> StatusColumn;
	
	private ServicoBO bo = new ServicoBO();
    private ObservableList<ServicoDTO> listaDeServicos;
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarServicos();
	}
	public void listarServicos() {
		List<ServicoDTO> servicos = bo.listar();
		listaDeServicos = FXCollections.observableArrayList(servicos);
		StatusColumn.setCellValueFactory(new PropertyValueFactory<>("idServico"));
		NomeColumn.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		DataServicoColumn.setCellValueFactory(new PropertyValueFactory<>("Data Inicial"));
		PrecoColumn.setCellValueFactory(new PropertyValueFactory<>("Pre�o"));
		StatusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
		tabelaServico.setItems(listaDeServicos);
		
	}
}