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
		testeTela();
	}
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	// exemplo gadelha																						//
	public static void testeTela() {																//
		try {																								//
			Parent root = FXMLLoader.load(Telas.class.getResource("view/resources/pesquisaScreen.fxml"));			//
			Scene scene = new Scene (root);																	//
			stage.setScene(scene);																			//
			stage.setTitle("Teste");													//
			stage.show();			
			//teste
		}																									//
		catch(Exception e) {																				//
			e.printStackTrace();																			//
		}																									//
	}																										//
																								//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
}
