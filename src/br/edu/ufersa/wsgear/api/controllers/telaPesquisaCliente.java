package br.edu.ufersa.wsgear.api.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ufersa.wsgear.api.dto.ClienteDTO;
import br.edu.ufersa.wsgear.model.service.ClienteBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaPesquisaCliente implements Initializable{
	@FXML private TableView<ClienteDTO> tabelaCliente;
	@FXML private TableColumn<ClienteDTO, String> idClienteColumn;
	@FXML private TableColumn<ClienteDTO, String> CPFColumn;
	@FXML private TableColumn<ClienteDTO, String> NomeColumn;
	@FXML private TableColumn<ClienteDTO, String> TelefoneColumn;
	//@FXML private TableColumn<EnderecoDTO, String> CEPColumn;
	//@FXML private TableColumn<EnderecoDTO, String> RuaColumn;
	//@FXML private TableColumn<EnderecoDTO, String> BairroColumn;
	//@FXML private TableColumn<EnderecoDTO, String> ComplementoColumn;
	//@FXML private TableColumn<EnderecoDTO, String> NumeroColumn;
	@FXML private ChoiceBox<String> tipoBox;
	
	private String opcoes[]= {"CPF", "idCliente", "Nome"};
	private ClienteBO bo = new ClienteBO();
	//private EnderecoBO eBO = new EnderecoBO();
    private ObservableList<ClienteDTO> listaDeClientes;
    //private ObservableList<EnderecoDTO> listaDeEnderecos;
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		tipoBox.getItems().addAll(opcoes);
		//pesquisar();
		listarClientes();
	}
	public void listarClientes() {
		List<ClienteDTO> clientes = bo.listar();
		//List<EnderecoDTO> enderecos = eBO.listar();
		listaDeClientes = FXCollections.observableArrayList(clientes);
		//listaDeEnderecos = FXCollections.observableArrayList(enderecos);
		
		idClienteColumn.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
		CPFColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		NomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
		TelefoneColumn.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		//CEPColumn.setCellValueFactory(new PropertyValueFactory<>("cep"));
		//RuaColumn.setCellValueFactory(new PropertyValueFactory<>("rua"));
		//BairroColumn.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		//ComplementoColumn.setCellValueFactory(new PropertyValueFactory<>("complemento"));
		//NumeroColumn.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tabelaCliente.setItems(listaDeClientes);
		
	}
	public void pesquisar() {
		listarClientes();
	}
	public void chamarTelaPrincipal() {
		Telas.telaPrincipal();
	}

	public void cadastrar() {
		Telas.telaCadastroCliente();
	}

	public void excluir() {

	}

	public void editar() {

	}
}
