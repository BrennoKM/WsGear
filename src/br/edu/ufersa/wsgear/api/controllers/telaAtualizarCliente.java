package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.AutomovelDTO;
import br.edu.ufersa.wsgear.api.dto.ClienteDTO;
import br.edu.ufersa.wsgear.model.service.ClienteBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class telaAtualizarCliente {

    @FXML
    private TextField clienteCpf;

    @FXML
    private TextField clienteNome;

    @FXML
    private TextField clienteTelefone;

    @FXML
    private TextField enderecoBairro;

    @FXML
    private TextField enderecoCep;

    @FXML
    private TextField enderecoComplemento;

    @FXML
    private TextField enderecoNumero;

    @FXML
    private TextField enderecoRua;

    private static int idCliente;
    ClienteBO bo = new ClienteBO();
    
    public static void telaAtualizar(ClienteDTO dto) {
    	idCliente = dto.getIdCliente();
    	Telas.telaAtualizarCliente();
    }
    
    @FXML
    void cadastrar(ActionEvent event) {
    	ClienteDTO dto = new ClienteDTO();
    	dto.setIdCliente(idCliente);
		dto.setCpf(clienteCpf.getText());
		dto.setNome(clienteNome.getText());
		dto.setTelefone(clienteTelefone.getText());
		dto.setCep(enderecoCep.getText());
		dto.setRua(enderecoRua.getText());
		dto.setBairro(enderecoBairro.getText());
		dto.setComplemento(enderecoComplemento.getText());
		dto.setNumero(Integer.parseInt(enderecoNumero.getText()));
		bo.alterar(dto);
		Telas.telaPesquisaCliente();
    }

    @FXML
    void chamarTelaPrincipal(ActionEvent event) {
    	Telas.telaPrincipal();
    }

    @FXML
    void voltarTelaPesquisaCliente(ActionEvent event) {
    	Telas.telaPesquisaCliente();
    }

}
