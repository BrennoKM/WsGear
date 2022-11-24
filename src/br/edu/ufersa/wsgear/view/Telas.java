package br.edu.ufersa.wsgear.view;

import br.edu.ufersa.wsgear.api.dto.AutomovelDTO;
import br.edu.ufersa.wsgear.api.dto.ClienteDTO;
import br.edu.ufersa.wsgear.api.dto.EnderecoDTO;
import br.edu.ufersa.wsgear.model.entity.Endereco;
import br.edu.ufersa.wsgear.model.service.AutomovelBO;
import br.edu.ufersa.wsgear.model.service.ClienteBO;
import br.edu.ufersa.wsgear.model.service.EnderecoBO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{
	private static Stage stage;
	public static void main (String args[]) {
		
		EnderecoDTO e = new EnderecoDTO();
		e.setBairro("bairro x");
		e.setCep("2222222");
		e.setComplemento("wd");
		e.setCpf_morador("242");
		EnderecoBO bo = new EnderecoBO();
		bo.inserir(e);
		
		e.setCep("33333");
		
		//bo.alterar(c);
		
		//bo.deletar(c);
		
		ClienteDTO c = new ClienteDTO();
		c.setCpf("00023133299");
		c.setNome("Lucas");
		c.setTelefone("92299");
		//c.setEndereco(Endereco.converter(e));
		
		ClienteBO cBO = new ClienteBO();
		
		cBO.inserir(c);
		//cBO.deletar(c);
		cBO.buscarId(c);
		
		AutomovelDTO a = new AutomovelDTO();
		AutomovelBO aBO = new AutomovelBO();
		
		a.setAno(2010);
		a.setCor("vermelho");
		a.setCpfDono("999.888.777-66");
		a.setMarca("Tesla");
		a.setModelo("modelo 2");
		a.setPlaca("ABC7J23");
		a.setIdDono(c.getIdCliente());

		aBO.inserir(a);
		
		//launch();
	}
	private void setStage(Stage st) {
		stage =st;
	}
	public void start(Stage arg0) throws Exception {
		setStage(arg0);
		arg0.setTitle("Teste");
		telaPrincipal();
	}
	
	public static void telaPrincipal() {																
		try {																								
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/mainScreen.fxml"));			
			Scene scene = new Scene (root);																	
			stage.setScene(scene);																			
			stage.setTitle("Main");													
			stage.show();
		}																									
		catch(Exception e) {																				
			e.printStackTrace();																			
		}																									
	}
	
	public static void telaPesquisa() {																
		try {																								
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/pesquisaScreen.fxml"));			
			Scene scene = new Scene (root);																	
			stage.setScene(scene);																			
			stage.setTitle("Pesquisa");													
			stage.show();
		}																									
		catch(Exception e) {																				
			e.printStackTrace();																			
		}																									
	}
	
	public static void telaPesquisaPeca() {																
		try {																								
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/pesquisaPecaScreen.fxml"));			
			Scene scene = new Scene (root);																	
			stage.setScene(scene);																			
			stage.setTitle("Pesquisa de Peças");													
			stage.show();
		}																									
		catch(Exception e) {																				
			e.printStackTrace();																			
		}																									
	}
	
	public static void telaPesquisaAutomovel() {																
		try {																								
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/pesquisaAutomovelScreen.fxml"));			
			Scene scene = new Scene (root);																	
			stage.setScene(scene);																			
			stage.setTitle("Pesquisa de Automoveis");													
			stage.show();
		}																									
		catch(Exception e) {																				
			e.printStackTrace();																			
		}																									
	}
	
	public static void telaPesquisaServico() {																
		try {																								
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/pesquisaServicoScreen.fxml"));			
			Scene scene = new Scene (root);																	
			stage.setScene(scene);																			
			stage.setTitle("Pesquisa de Serviços");													
			stage.show();
		}																									
		catch(Exception e) {																				
			e.printStackTrace();																			
		}																									
	}
	
	public static void telaCadastroAutomovel() {																
		try {																								
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroAutomovelScreen.fxml"));			
			Scene scene = new Scene (root);																	
			stage.setScene(scene);																			
			stage.setTitle("Cadastro de Automovel");													
			stage.show();
		}																									
		catch(Exception e) {																				
			e.printStackTrace();																			
		}																									
	}
	
	public static void telaCadastroCliente() {																
		try {																								
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroClienteScreen.fxml"));			
			Scene scene = new Scene (root);																	
			stage.setScene(scene);																			
			stage.setTitle("Cadastro de Cliente");													
			stage.show();
		}																									
		catch(Exception e) {																				
			e.printStackTrace();																			
		}																									
	}
	
	public static void telaCadastroPeca() {																
		try {																								
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroPecaScreen.fxml"));			
			Scene scene = new Scene (root);																	
			stage.setScene(scene);																			
			stage.setTitle("Cadastro de Peça");													
			stage.show();
		}																									
		catch(Exception e) {																				
			e.printStackTrace();																			
		}																									
	}
	
	public static void telaCadastroServico() {																
		try {																								
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/cadastroServicoScreen.fxml"));			
			Scene scene = new Scene (root);																	
			stage.setScene(scene);																			
			stage.setTitle("Cadastro de Peça");													
			stage.show();
		}																									
		catch(Exception e) {																				
			e.printStackTrace();																			
		}																									
	}
}
