package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.ServicoDTO;
import br.edu.ufersa.wsgear.model.service.ServicoBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class telaCadastroServico {
	@FXML private TextField pecaNome;
	@FXML private TextField servicoPreco;
	@FXML private TextField servicoStatus;
	@FXML private DatePicker servicoDataInicio;
		private ServicoBO bo = new ServicoBO();
		
		public void cadastrar() {
			ServicoDTO dto = new ServicoDTO();
			dto.setNome(pecaNome.toString());
			dto.setPreco(Double.parseDouble(servicoPreco.toString()));
			dto.setStatus(servicoStatus.toString());
			dto.setDataServico(servicoDataInicio.toString());
			bo.inserir(dto);
		}
}
