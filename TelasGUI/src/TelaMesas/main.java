package TelaMesas;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class main extends Application {
	
	
@Override
public void start(Stage primaryStage) throws IOException{
	
	Pane root = FXMLLoader.load(getClass().getResource("FXMLMesas.fxml"));
	Scene scene = new Scene(root,600,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	primaryStage.setTitle("RURADEVS Restaurant Control ");
		
		
	
}



public static void main(String[] args) {
	launch(args);
}
}
