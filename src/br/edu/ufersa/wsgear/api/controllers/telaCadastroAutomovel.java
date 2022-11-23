package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.model.service.AutomovelBO;
import br.edu.ufersa.wsgear.api.dto.AutomovelDTO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class telaCadastroAutomovel {
	@FXML private TextField automovelDonoCpf;
	@FXML private TextField automovelMarca;
	@FXML private TextField automovelModelo;
	@FXML private TextField automovelCor;
	@FXML private TextField automovelPlaca;
	@FXML private TextField automovelAno;
		private AutomovelBO bo = new AutomovelBO();
		
		public void cadastrar() {
			AutomovelDTO dto = new AutomovelDTO();
			dto.setCpfDono(automovelDonoCpf.toString());
			dto.setMarca(automovelMarca.toString());
			dto.setModelo(automovelModelo.toString());
			dto.setCor(automovelCor.toString());
			dto.setPlaca(automovelPlaca.toString());
			dto.setAno(Integer.parseInt(automovelAno.toString()));
			bo.inserir(dto);
			Telas.telaPesquisaAutomovel();
		}
}
