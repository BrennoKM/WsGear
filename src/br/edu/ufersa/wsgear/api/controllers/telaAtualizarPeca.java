package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.PecaDTO;
import br.edu.ufersa.wsgear.model.service.PecaBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class telaAtualizarPeca {

    @FXML
    private TextField pecaFabricante;

    @FXML
    private TextField pecaNome;

    @FXML
    private TextField pecaPreco;
    
    private static int idPeca;
    PecaBO bo = new PecaBO();
    
    public static void telaAtualizar(PecaDTO dto) {
    	idPeca = dto.getIdPeca();
    	Telas.telaAtualizarPeca();
    }
    
    @FXML
    void cadastrar() {
    	PecaDTO dto = new PecaDTO();
		dto.setNome(pecaNome.getText());
		dto.setFab(pecaFabricante.getText());
		dto.setPreco(Double.parseDouble(pecaPreco.getText()));
		dto.setIdPeca(idPeca);
		bo.alterar(dto);
		Telas.telaPesquisaPeca();
    }

    @FXML
    void chamarTelaPrincipal() {
    	Telas.telaPrincipal();
    }

    @FXML
    void voltarTelaPesquisaPeca() {
    	Telas.telaPesquisaPeca();
    }

}
