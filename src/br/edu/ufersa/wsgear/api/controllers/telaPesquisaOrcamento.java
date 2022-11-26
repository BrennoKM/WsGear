package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.api.dto.OrcamentoDTO;
import br.edu.ufersa.wsgear.model.service.OrcamentoBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaPesquisaOrcamento implements Initializable {
	@FXML private TableView<OrcamentoDTO> tabelaOrcamento;
	@FXML private TableColumn<OrcamentoDTO, String> idOrcamentoColumn;
	@FXML private TableColumn<OrcamentoDTO, String> idPecaColumn;
	@FXML private TableColumn<OrcamentoDTO, String> idServicoColumn;
	@FXML private TableColumn<OrcamentoDTO, String> idAutomovelColumn;
	@FXML private TableColumn<OrcamentoDTO, String> PrecoColumn;
	@FXML private ChoiceBox<String> tipoBox;
	@FXML private TextField pesquisaContent;
	@FXML private Button pesquisaButton;
	@FXML private Button editarButton;
	@FXML private Button cadastrarButton;
	@FXML private Button excluirButton;

	private String opcoes[]= {"idAutomovel"};
	private OrcamentoBO bo = new OrcamentoBO();
	private ObservableList<OrcamentoDTO> listaDeOrcamentos;

	public void initialize(URL arg0, ResourceBundle arg1) {
		tipoBox.getItems().addAll(opcoes);
		listarOrcamentos();
	}

	public void listarOrcamentos() {
		List<OrcamentoDTO> orcamentos = bo.listar();
		listaDeOrcamentos = FXCollections.observableArrayList(orcamentos);
		idOrcamentoColumn.setCellValueFactory(new PropertyValueFactory<>("idOrcamento"));
		idPecaColumn.setCellValueFactory(new PropertyValueFactory<>("idPeca"));
		idServicoColumn.setCellValueFactory(new PropertyValueFactory<>("idServico"));
		idAutomovelColumn.setCellValueFactory(new PropertyValueFactory<>("idAutomovel"));
		PrecoColumn.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		tabelaOrcamento.setItems(listaDeOrcamentos);

	}

	public void chamarTelaPrincipal() {
		Telas.telaPrincipal();
	}
	
	public void pesquisar() {
		listarOrcamentos();
	}
	
	public void cadastrar() {
		Telas.telaCadastroOrcamento();
	}

	public void excluir() {
		OrcamentoDTO o = new OrcamentoDTO();
		o.setIdOrcamento(tabelaOrcamento.getSelectionModel().getSelectedItem().getIdOrcamento());
		bo.deletar(o);
		listarOrcamentos();
	}

	public void editar() {
		OrcamentoDTO o = new OrcamentoDTO();
		o.setIdOrcamento(tabelaOrcamento.getSelectionModel().getSelectedItem().getIdOrcamento());
		telaAtualizarOrcamento.telaAtualizar(o);
	}

}
