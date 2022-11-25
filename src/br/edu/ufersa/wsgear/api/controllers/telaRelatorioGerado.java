package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.api.dto.OrcamentoDTO;
import br.edu.ufersa.wsgear.model.service.OrcamentoBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaRelatorioGerado {
	@FXML private Button homeButton;
	@FXML private TableView<OrcamentoDTO> tabelaRelatorio;
	@FXML private TableColumn<OrcamentoDTO, String> idOrcamentoColumn;
	@FXML private TableColumn<OrcamentoDTO, String> dataInicioColumn;
	@FXML private TableColumn<OrcamentoDTO, String> valorPecaColumn;
	@FXML private TableColumn<OrcamentoDTO, String> valorServicoColumn;
	@FXML private TableColumn<OrcamentoDTO, String> valorTotalColumn;
	@FXML private TableColumn<OrcamentoDTO, String> statusColumn;
	
	private OrcamentoBO bo = new OrcamentoBO();
    private ObservableList<OrcamentoDTO> listaRelatorio;
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	exibirRelatorio();
	}
	public void exibirRelatorio() {
		List<OrcamentoDTO> relatorio = bo.listar();
		listaRelatorio = FXCollections.observableArrayList(relatorio);
		idOrcamentoColumn.setCellValueFactory(new PropertyValueFactory<>(""));
		dataInicioColumn.setCellValueFactory(new PropertyValueFactory<>(""));
		valorPecaColumn.setCellValueFactory(new PropertyValueFactory<>(""));
		valorServicoColumn.setCellValueFactory(new PropertyValueFactory<>(""));
		valorTotalColumn.setCellValueFactory(new PropertyValueFactory<>(""));
		statusColumn.setCellValueFactory(new PropertyValueFactory<>(""));
		tabelaRelatorio.setItems(relatorio);
	}
    
}
