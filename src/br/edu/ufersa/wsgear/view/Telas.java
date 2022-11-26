package br.edu.ufersa.wsgear.view;

import br.edu.ufersa.wsgear.api.dto.AutomovelDTO;
import br.edu.ufersa.wsgear.api.dto.ClienteDTO;
import br.edu.ufersa.wsgear.api.dto.EnderecoDTO;
import br.edu.ufersa.wsgear.api.dto.OrcamentoDTO;
import br.edu.ufersa.wsgear.api.dto.PecaDTO;
import br.edu.ufersa.wsgear.api.dto.ServicoDTO;
import br.edu.ufersa.wsgear.model.dao.ClienteDAO;
import br.edu.ufersa.wsgear.model.entity.Cliente;
import br.edu.ufersa.wsgear.model.entity.Endereco;
import br.edu.ufersa.wsgear.model.entity.Peca;
import br.edu.ufersa.wsgear.model.entity.Servico;
import br.edu.ufersa.wsgear.model.service.AutomovelBO;
import br.edu.ufersa.wsgear.model.service.ClienteBO;
import br.edu.ufersa.wsgear.model.service.EnderecoBO;
import br.edu.ufersa.wsgear.model.service.OrcamentoBO;
import br.edu.ufersa.wsgear.model.service.PecaBO;
import br.edu.ufersa.wsgear.model.service.ServicoBO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
	private static Stage stage;

	public static void main(String args[]) {
		/*
		 * EnderecoDTO e = new EnderecoDTO(); e.setBairro("bairrwo j");
		 * e.setCep("222322"); e.setComplemento("wdaa"); e.setCpf_morador("666");
		 * EnderecoBO bo = new EnderecoBO(); bo.inserir(e);
		 * 
		 * 
		 * //bo.alterar(c);
		 * 
		 * //bo.deletar(c);
		 * 
		 * ClienteDTO c = new ClienteDTO(); c.setCpf("221.263.333-01");
		 * c.setNome("Galdino 3"); c.setTelefone("192299");
		 * //c.setEndereco(Endereco.converter(e));
		 * 
		 * ClienteBO cBO = new ClienteBO(); cBO.inserir(c); //cBO.deletar(c);
		 * 
		 * AutomovelDTO a = new AutomovelDTO(); AutomovelBO aBO = new AutomovelBO();
		 * 
		 * a.setAno(2010); a.setCor("vermelho"); a.setCpfDono(c.getCpf());
		 * a.setMarca("Tesla"); a.setModelo("modelo 8"); a.setPlaca("2121J11");
		 * a.setIdDono(cBO.buscarIdCliente(c));
		 * 
		 * aBO.inserir(a);
		 * 
		 * PecaDTO peDTO = new PecaDTO(); //PecaBO peBO = new PecaBO();
		 * 
		 * peDTO.setFab("valve"); peDTO.setNome("Motor"); peDTO.setPreco(10.0);
		 * 
		 * //peBO.inserir(peDTO);
		 * 
		 * 
		 * ServicoDTO seDTO = new ServicoDTO(); //ServicoBO seBO = new ServicoBO();
		 * 
		 * seDTO.setNome("Trocar motor"); seDTO.setPreco(5.0);
		 * seDTO.setStatus("Em espera"); seDTO.setDataInicialServico();
		 * //seBO.inserir(seDTO);
		 * 
		 * 
		 * OrcamentoDTO orDTO = new OrcamentoDTO(); OrcamentoBO orBO = new
		 * OrcamentoBO();
		 * 
		 * orDTO.setIdAutomovel(10); //orDTO.setIdAutomovel(aBO.buscarIdAutomovel(a));
		 * orDTO.setIdPeca(10); //orDTO.setIdPeca(peBO.buscarIdPeca(peDTO));
		 * orDTO.setIdServico(10); //orDTO.setIdServico(seBO.buscarIdServico(seDTO));
		 * orDTO.setPeca(Peca.converter(peDTO));
		 * orDTO.setServico(Servico.converter(seDTO));
		 * 
		 * orBO.inserir(orDTO);
		 */

		//telaPesquisaAutomovel();
		//telaPesquisaPeca();
		launch();
	}

	private void setStage(Stage st) {
		stage = st;
	}

	public void start(Stage arg0) throws Exception {
		setStage(arg0);
		arg0.setTitle("Ws");
		// telaCadastroAutomovel();
		// telaCadastroCliente();
		telaPrincipal();
	}

	public static void telaPrincipal() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/mainScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Main");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaPesquisa() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/pesquisarScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Pesquisa");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaPesquisaPeca() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/pesquisarPecaScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Pesquisa de Pe�as");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaPesquisaAutomovel() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/pesquisarAutomovelScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Pesquisa de Automoveis");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaPesquisaServico() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/pesquisarServicoScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Pesquisa de Servi�os");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaCadastroAutomovel() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroAutomovelScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Cadastro de Automovel");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaCadastroCliente() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroClienteScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Cadastro de Cliente");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaCadastroPeca() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroPecaScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Cadastro de Peca");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaCadastroServico() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroServicoScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Cadastro de Servico");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaCadastroOrcamento() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroOrcamentoScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Cadastro de Orcamento");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void telaPesquisaOrcamento() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/pesquisarOrcamentoScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Pesquisa de Orcamentos");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaPesquisaCliente() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/pesquisarClienteScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Pesquisa de Clientes");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaAtualizarPeca() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/atualizarPecaScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Atualizar Peca");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaAtualizarServico() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/atualizarServicoScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Atualizar Servico");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaAtualizarCliente() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/atualizarClienteScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Atualizar Cliente");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaAtualizarAutomovel() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/atualizarAutomovelScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Atualizar Automovel");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void telaAtualizarOrcamento() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/atualizarOrcamentoScreen.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Atualizar Orcamento");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
