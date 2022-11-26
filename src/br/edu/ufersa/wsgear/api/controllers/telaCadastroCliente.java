package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.ClienteDTO;
import br.edu.ufersa.wsgear.api.dto.EnderecoDTO;
import br.edu.ufersa.wsgear.model.service.ClienteBO;
import br.edu.ufersa.wsgear.model.service.EnderecoBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class telaCadastroCliente {
	@FXML private TextField clienteCpf;
	@FXML private TextField clienteNome;
	@FXML private TextField clienteTelefone;
	@FXML private TextField enderecoCep;
	@FXML private TextField enderecoRua;
	@FXML private TextField enderecoBairro;
	@FXML private TextField enderecoNumero;
	@FXML private TextField enderecoComplemento;
		private ClienteBO boC = new ClienteBO();
		private EnderecoBO boE = new EnderecoBO();
		
		public void cadastrar() {
			ClienteDTO dtoC = new ClienteDTO();
			dtoC.setCpf(clienteCpf.getText());
			dtoC.setNome(clienteNome.getText());
			dtoC.setTelefone(clienteTelefone.getText());
			boC.inserir(dtoC);
			
			EnderecoDTO dtoE = new EnderecoDTO();
			dtoE.setCep(enderecoCep.getText());
			dtoE.setRua(enderecoRua.getText());
			dtoE.setBairro(enderecoBairro.getText());
			dtoE.setNumero(Integer.parseInt(enderecoNumero.getText()));
			dtoE.setComplemento(enderecoComplemento.getText());
			dtoE.setCpf_morador(dtoC.getCpf());
			boE.inserir(dtoE);
			Telas.telaPesquisaCliente();
		}
		
		public void chamarTelaPrincipal() {
			Telas.telaPrincipal();
		}
		public void voltarTelaPesquisaCliente() {
			Telas.telaPesquisaCliente();
		}
}
