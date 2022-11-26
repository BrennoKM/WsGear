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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaPesquisaOrcamento implements Initializable{
	@FXML private TableView<OrcamentoDTO> tabelaOrcamento;
	@FXML private TableColumn<OrcamentoDTO, String> idPecaColumn;
	@FXML private TableColumn<OrcamentoDTO, String> idServicoColumn;
	@FXML private TableColumn<OrcamentoDTO, String> idAutomovelColumn;
	@FXML private TableColumn<OrcamentoDTO, String> PrecoColumn;
	
	private OrcamentoBO bo = new OrcamentoBO();
    private ObservableList<OrcamentoDTO> listaDeOrcamentos;
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		pesquisar();
	}
	public void listarOrcamentos() {
		List<OrcamentoDTO> orcamentos = bo.listar();
		listaDeOrcamentos = FXCollections.observableArrayList(orcamentos);
		idPecaColumn.setCellValueFactory(new PropertyValueFactory<>("idPeca"));
		idServicoColumn.setCellValueFactory(new PropertyValueFactory<>("idServico"));
		idAutomovelColumn.setCellValueFactory(new PropertyValueFactory<>("orcIdAutomovel"));
		PrecoColumn.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		tabelaOrcamento.setItems(listaDeOrcamentos);
		
	}
	public void pesquisar() {
		listarOrcamentos();
	}
	public void chamarTelaPrincipal() {
		Telas.telaPrincipal();
	}
	
}
