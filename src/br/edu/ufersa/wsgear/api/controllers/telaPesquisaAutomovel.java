package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.api.dto.AutomovelDTO;
import br.edu.ufersa.wsgear.model.service.AutomovelBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaPesquisaAutomovel implements Initializable{
	@FXML private TableView<AutomovelDTO> tabelaAutomovel;
	@FXML private TableColumn<AutomovelDTO, String> idAutomovelColumn;
	@FXML private TableColumn<AutomovelDTO, String> idDonoColumn;
	@FXML private TableColumn<AutomovelDTO, String> CPFDonoColumn;
	@FXML private TableColumn<AutomovelDTO, String> MarcaColumn;
	@FXML private TableColumn<AutomovelDTO, String> ModeloColumn;
	@FXML private TableColumn<AutomovelDTO, String> CorColumn;
	@FXML private TableColumn<AutomovelDTO, String> PlacaColumn;
	@FXML private TableColumn<AutomovelDTO, String> AnoColumn;
	@FXML private ChoiceBox<String> tipoBox;
	@FXML private TextField pesquisaContent;
	
	
	private String opcoes[]= {"Placa", "CPFDono"};
	private AutomovelBO bo = new AutomovelBO();
    private ObservableList<AutomovelDTO> listaDeAutomoveis;
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		tipoBox.getItems().addAll(opcoes);
		//pesquisar();
		listarAutomoveis();
	}
	public void listarAutomoveis() {
		List<AutomovelDTO> automoveis = bo.listar();
		listaDeAutomoveis = FXCollections.observableArrayList(automoveis);
		idAutomovelColumn.setCellValueFactory(new PropertyValueFactory<>("idAutomovel"));
		idDonoColumn.setCellValueFactory(new PropertyValueFactory<>("idDono"));
		CPFDonoColumn.setCellValueFactory(new PropertyValueFactory<>("cpfDono"));
		MarcaColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));
		ModeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		CorColumn.setCellValueFactory(new PropertyValueFactory<>("cor"));
		PlacaColumn.setCellValueFactory(new PropertyValueFactory<>("placa"));
		AnoColumn.setCellValueFactory(new PropertyValueFactory<>("ano"));
		tabelaAutomovel.setItems(listaDeAutomoveis);
		
	}
	
	public void listarAutomoveisBusca(AutomovelDTO a, String tipo) {
		List<AutomovelDTO> automoveis = bo.listarBusca(a, tipo);
		
		
		
		listaDeAutomoveis = FXCollections.observableArrayList(automoveis);
		idAutomovelColumn.setCellValueFactory(new PropertyValueFactory<>("idAutomovel"));
		idDonoColumn.setCellValueFactory(new PropertyValueFactory<>("idDono"));
		CPFDonoColumn.setCellValueFactory(new PropertyValueFactory<>("cpfDono"));
		MarcaColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));
		ModeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		CorColumn.setCellValueFactory(new PropertyValueFactory<>("cor"));
		PlacaColumn.setCellValueFactory(new PropertyValueFactory<>("placa"));
		AnoColumn.setCellValueFactory(new PropertyValueFactory<>("ano"));
		tabelaAutomovel.setItems(listaDeAutomoveis);
		
	}
	
	public void pesquisar() {
		if(pesquisaContent.getText().equals("")) {
			listarAutomoveis();
		} else {
			AutomovelDTO a = new AutomovelDTO();
			switch(tipoBox.getValue()) {
				case "Placa":
					a.setPlaca(pesquisaContent.getText());
					listarAutomoveisBusca(a, "Placa");
					break;
				case "CPFDono":
					a.setCpfDono(pesquisaContent.getText());
					listarAutomoveisBusca(a, "CPFDono");
					break;
			}
		}
	}
	public void chamarTelaPrincipal() {
		Telas.telaPrincipal();
	}

	public void cadastrar() {
		Telas.telaCadastroAutomovel();
	}

	public void excluir() {
		AutomovelDTO a = new AutomovelDTO();
		a.setIdAutomovel(tabelaAutomovel.getSelectionModel().getSelectedItem().getIdAutomovel());
		bo.deletar(a);
		listarAutomoveis();
	}

	public void editar() {
		AutomovelDTO a = new AutomovelDTO();
		a.setIdAutomovel(tabelaAutomovel.getSelectionModel().getSelectedItem().getIdAutomovel());
		telaAtualizarAutomovel.telaAtualizar(a);
	}

}
