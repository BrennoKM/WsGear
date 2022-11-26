package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.OrcamentoDTO;
import br.edu.ufersa.wsgear.model.service.OrcamentoBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class telaAtualizarOrcamento {

    @FXML
    private TextField orcamentoIdAutomovel;

    @FXML
    private TextField orcamentoIdServico;

    @FXML
    private TextField orcamentoPreco;

    private static int idOrcamento;
    OrcamentoBO bo = new OrcamentoBO();
    
    public static void telaAtualizar(OrcamentoDTO dto) {
    	idOrcamento = dto.getIdOrcamento();
    	Telas.telaAtualizarOrcamento();
    }
    
    @FXML
    void cadastrar(ActionEvent event) {
    	OrcamentoDTO dto = new OrcamentoDTO();
    	dto.setIdOrcamento(idOrcamento);
		dto.setIdAutomovel(Integer.parseInt(orcamentoIdAutomovel.getText()));
		dto.setIdServico(Integer.parseInt(orcamentoIdServico.getText()));
		dto.setValor(Double.parseDouble(orcamentoPreco.getText()));
		bo.alterar(dto);
		Telas.telaPesquisaPeca();
    }

    @FXML
    void chamarTelaPrincipal(ActionEvent event) {
    	Telas.telaPrincipal();
    }

    @FXML
    void voltarTelaPesquisaOrcamento(ActionEvent event) {
    	Telas.telaPesquisaOrcamento();
    }

}
