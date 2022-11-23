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
		telaCadastroAluno();
	}
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	// exemplo gadelha																						//
	public static void telaCadastroAluno() {																//
		try {																								//
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/mainScreen.fxml"));			//
			Scene scene = new Scene (root);																	//
			stage.setScene(scene);																			//
			stage.setTitle("Tela de Cadastro");													//
			stage.show();																					//
		}																									//
		catch(Exception e) {																				//
			e.printStackTrace();																			//
		}																									//
	}																										//
	public static void listarAlunos() {																		//
		try {																								//
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/listarAluno.fxml"));			//
			Scene scene = new Scene (root);																	//
			stage.setScene(scene);																			//
			stage.setTitle("Alunos");																		//
			stage.show();																					//
		}																									//
		catch(Exception e) {																				//
			e.printStackTrace();																			//
		}																									//
	}																										//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
}
