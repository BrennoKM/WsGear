package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.api.dto.ServicoDTO;
import br.edu.ufersa.wsgear.model.service.ServicoBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaPesquisaServico implements Initializable{
	@FXML private TableView<ServicoDTO> tabelaServico;
	@FXML private TableColumn<ServicoDTO, String> idServicoColumn;
	@FXML private TableColumn<ServicoDTO, String> NomeColumn;
	@FXML private TableColumn<ServicoDTO, String> DataServicoColumn;
	@FXML private TableColumn<ServicoDTO, String> PrecoColumn;
	@FXML private TableColumn<ServicoDTO, String> StatusColumn;
	@FXML private ChoiceBox<String> tipoBox;
	
	private String opcoes[]= {"idServico", "Nome"};
	
	private ServicoBO bo = new ServicoBO();
    private ObservableList<ServicoDTO> listaDeServicos;
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		tipoBox.getItems().addAll(opcoes);
		listarServicos();
	}
	public void listarServicos() {
		List<ServicoDTO> servicos = bo.listar();
		listaDeServicos = FXCollections.observableArrayList(servicos);
		idServicoColumn.setCellValueFactory(new PropertyValueFactory<>("idServico"));
		NomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
		DataServicoColumn.setCellValueFactory(new PropertyValueFactory<>("dataServico"));
		PrecoColumn.setCellValueFactory(new PropertyValueFactory<>("preco"));
		StatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
		tabelaServico.setItems(listaDeServicos);
	}
	public void pesquisar() {
		listarServicos();
	}
	public void chamarTelaPrincipal() {
		Telas.telaPrincipal();
	}

	public void cadastrar() {
		Telas.telaCadastroServico();
	}

	public void excluir() {

	}

	public void editar() {

	}

}
