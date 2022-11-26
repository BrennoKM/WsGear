package br.edu.ufersa.wsgear.api.controllers;

import br.edu.ufersa.wsgear.api.dto.AutomovelDTO;
import br.edu.ufersa.wsgear.model.service.AutomovelBO;
import br.edu.ufersa.wsgear.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class telaAtualizarAutomovel {

    @FXML
    private TextField automovelAno;

    @FXML
    private TextField automovelCor;

    @FXML
    private TextField automovelDonoCpf;

    @FXML
    private TextField automovelMarca;

    @FXML
    private TextField automovelModelo;

    @FXML
    private TextField automovelPlaca;

    private static int idAutomovel;
    AutomovelBO bo = new AutomovelBO();
    
    public static void telaAtualizar(AutomovelDTO dto) {
    	idAutomovel = dto.getIdAutomovel();
    	Telas.telaAtualizarAutomovel();
    }
    
    @FXML
    void cadastrar(ActionEvent event) {
    	AutomovelDTO dto = new AutomovelDTO();
    	dto.setIdAutomovel(idAutomovel);
		dto.setAno(Integer.parseInt(automovelAno.getText()));
		dto.setCor(automovelCor.getText());
		dto.setMarca(automovelMarca.getText());
		dto.setModelo(automovelModelo.getText());
		dto.setPlaca(automovelPlaca.getText());
		dto.setCpfDono(automovelDonoCpf.getText());
		bo.alterar(dto);
		Telas.telaPesquisaAutomovel();
    }

    @FXML
    void chamarTelaPrincipal(ActionEvent event) {
    	Telas.telaPrincipal();
    }

    @FXML
    void voltarMainScreen(ActionEvent event) {
    	Telas.telaPesquisaAutomovel();
    }

}

