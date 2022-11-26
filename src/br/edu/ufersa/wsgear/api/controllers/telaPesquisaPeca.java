package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.api.dto.PecaDTO;
import br.edu.ufersa.wsgear.model.service.PecaBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaPesquisaPeca implements Initializable {
	@FXML private TableView<PecaDTO> tabelaPeca;
	@FXML private TableColumn<PecaDTO, String> idPecaColumn;
	@FXML private TableColumn<PecaDTO, String> NomeColumn;
	@FXML private TableColumn<PecaDTO, String> FabricanteColumn;
	@FXML private TableColumn<PecaDTO, String> PrecoColumn;
	@FXML private ChoiceBox<String> tipoBox;
	
	private String opcoes[]= {"idPeca", "Nome", "Fabricante"};
	private PecaBO bo = new PecaBO();
    private ObservableList<PecaDTO> listaDePecas;
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		tipoBox.getItems().addAll(opcoes);
		pesquisar();
	}
	public void listarPecas() {
		List<PecaDTO> pecas = bo.listar();
		listaDePecas = FXCollections.observableArrayList(pecas);
		idPecaColumn.setCellValueFactory(new PropertyValueFactory<>("idPeca"));
		NomeColumn.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		FabricanteColumn.setCellValueFactory(new PropertyValueFactory<>("fab"));
		PrecoColumn.setCellValueFactory(new PropertyValueFactory<>("Preco"));
		tabelaPeca.setItems(listaDePecas);
		
	}
	
	public void pesquisar() {
		listarPecas();
	}
	public void chamarTelaPrincipal() {
		Telas.telaPrincipal();
	}

	public void cadastrar() {
		Telas.telaCadastroPeca();
	}

	public void excluir() {
		PecaDTO p = new PecaDTO();
		
		p.setFab(tabelaPeca.getSelectionModel().getSelectedItem().getFab());
		p.setIdPeca(tabelaPeca.getSelectionModel().getSelectedItem().getIdPeca());
		p.setNome(tabelaPeca.getSelectionModel().getSelectedItem().getNome());
		p.setPreco(tabelaPeca.getSelectionModel().getSelectedItem().getPreco());
		
		bo.deletar(p);
		listarPecas();
	}

	public void editar() {
		PecaDTO dto = new PecaDTO();
		
		dto.setIdPeca(tabelaPeca.getSelectionModel().getSelectedItem().getIdPeca());
		telaAtualizarPeca.telaAtualizar(dto);
	}
}
