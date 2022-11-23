package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.PecaDTO;
import br.edu.ufersa.wsgear.model.service.PecaBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class telaCadastroPeca {
	@FXML private TextField pecaNome;
	@FXML private TextField pecaFabricante;
	@FXML private TextField pecaPreco;
		private PecaBO bo = new PecaBO();
		
		public void cadastrar() {
			PecaDTO dto = new PecaDTO();
			dto.setNome(pecaNome.toString());
			dto.setFab(pecaFabricante.toString());
			dto.setPreco(Double.parseDouble(pecaPreco.toString()));
			bo.inserir(dto);
			Telas.telaPesquisaPeca();
		}
}
