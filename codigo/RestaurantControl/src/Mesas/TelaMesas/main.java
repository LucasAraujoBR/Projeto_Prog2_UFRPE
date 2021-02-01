package TelaMesas;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class main extends Application {
	
	private static Scene sceneNovasMesas,sceneMesas;
	private static Stage primaryStage;
	
@Override
public void start(Stage stage) throws IOException{
	
	  FXMLLoader primeira = new FXMLLoader(getClass().getResource("FXMLMesas.fxml"));
	  FXMLLoader novasMesas = new FXMLLoader(getClass().getResource("FXMLNovasMesas.fxml"));
	  
	  primaryStage = stage;
	  
	  Parent parentNovasMesas = novasMesas.load();
	  Parent parentMesas = primeira.load();
	  
	  sceneNovasMesas = new Scene(parentNovasMesas,293.0,143.0);
	  sceneMesas = new Scene(parentMesas,600,600);
	  
	  stage.setScene(sceneMesas);
	  stage.show();
	
		/*Pane root = FXMLLoader.load(getClass().getResource("FXMLMesas.fxml"));
		Scene scene = new Scene(root,600,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("RURADEVS Restaurant Control");*/
		
		
	
}

public static void mudarJanela(int opcao) {
	switch(opcao) {
	case 1:
		primaryStage.setScene(sceneMesas);
		break;
	case 2:
		primaryStage.setScene(sceneNovasMesas);
		break;
	}
}



public static void main(String[] args) {
	launch(args);
}
}
