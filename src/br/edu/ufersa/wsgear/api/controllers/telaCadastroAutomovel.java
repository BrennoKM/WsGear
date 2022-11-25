package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.model.service.AutomovelBO;
import br.edu.ufersa.wsgear.model.service.ClienteBO;
import br.edu.ufersa.wsgear.api.dto.AutomovelDTO;
import br.edu.ufersa.wsgear.api.dto.ClienteDTO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class telaCadastroAutomovel {
	@FXML private TextField automovelDonoCpf;
	@FXML private TextField automovelMarca;
	@FXML private TextField automovelModelo;
	@FXML private TextField automovelCor;
	@FXML private TextField automovelPlaca;
	@FXML private TextField automovelAno;
	@FXML private Button cadastrarButton;
	@FXML private Button cancelButton;
	@FXML private Button homeButton;
		private AutomovelBO bo = new AutomovelBO();
		private ClienteBO cBO = new ClienteBO();
		
		public void cadastrar() {
			AutomovelDTO dto = new AutomovelDTO();
			ClienteDTO cDTO = new ClienteDTO();
			dto.setCpfDono(automovelDonoCpf.getText());
			dto.setMarca(automovelMarca.getText());
			dto.setModelo(automovelModelo.getText());
			dto.setCor(automovelCor.getText());
			dto.setPlaca(automovelPlaca.getText());
			dto.setAno(Integer.parseInt(automovelAno.getText()));
			cDTO.setCpf(dto.getCpfDono());
			dto.setIdDono(cBO.buscarIdClienteAutomovel(cDTO));
			
			bo.inserir(dto);
			//Telas.telaPesquisaAutomovel();
		}
		
		public void chamarTelaPrincipal() {
			Telas.telaPrincipal();
		}
		public void voltarMainScreen() {
			chamarTelaPrincipal();
		}
}
