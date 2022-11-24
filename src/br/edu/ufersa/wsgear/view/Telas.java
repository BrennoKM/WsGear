package br.edu.ufersa.wsgear.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{
	private static Stage stage;
	public static void main (String args[]) {
		launch();
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
			stage.setTitle("Pesquisa de Pe�as");													
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
			stage.setTitle("Pesquisa de Servi�os");													
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
			stage.setTitle("Cadastro de Pe�a");													
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
			stage.setTitle("Cadastro de Pe�a");													
			stage.show();
		}																									
		catch(Exception e) {																				
			e.printStackTrace();																			
		}																									
	}
}
