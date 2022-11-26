package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.ServicoDTO;
import br.edu.ufersa.wsgear.model.service.ServicoBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class telaAtualizarServico {

    @FXML
    private TextField pecaNome;

    @FXML
    private DatePicker servicoDataInicio;

    @FXML
    private TextField servicoPreco;

    @FXML
    private TextField servicoStatus;

    private static int idServico;
    ServicoBO bo = new ServicoBO();
    
    public static void telaAtualizar(ServicoDTO dto) {
    	idServico = dto.getIdServico();
    	Telas.telaAtualizarServico();
    }
    
    @FXML
    void cadastrar(ActionEvent event) {
    	ServicoDTO dto = new ServicoDTO();
    	dto.setIdServico(idServico);
		dto.setNome(pecaNome.getText());
		dto.setPreco(Double.parseDouble(servicoPreco.getText()));
		dto.setStatus(servicoStatus.getText());
		dto.setDataServico(servicoDataInicio.getConverter().fromString(servicoDataInicio.getEditor().getText()));
		bo.alterar(dto);
		Telas.telaPesquisaServico();
    }

    @FXML
    void chamarTelaPrincipal(ActionEvent event) {
    	Telas.telaPrincipal();
    }

    @FXML
    void voltarTelaPesquisaServico(ActionEvent event) {
    	Telas.telaPesquisaServico();
    }

}
