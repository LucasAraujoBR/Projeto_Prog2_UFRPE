package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application {
	private static Stage stage;
	private static Scene Login;
	private static Scene TelaCaixa;
	private static Scene TelaMesas;
	private static Scene TelaPedidos;

	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		primaryStage.setTitle("RURADEVS Restaurant Control");
		Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
		Login = new Scene(root, 600, 600);

		Parent caixa = FXMLLoader.load(getClass().getResource("../TelaCaixa/FXMLCaixa.fxml"));
		TelaCaixa = new Scene(caixa, 600, 600);
		
		Parent pedidos = FXMLLoader.load(getClass().getResource("../TelaPedido/FXMLPedido.fxml"));
		TelaPedidos = new Scene(pedidos, 600, 600);
		
		Parent mesa = FXMLLoader.load(getClass().getResource("../TelaMesas/FXMLMesas.fxml"));
		TelaMesas = new Scene(mesa,600,600);
		
		primaryStage.setScene(Login);
		primaryStage.show();
	}

	public static void changeScreen(String scr) {
		switch (scr) {
		case "Login":
			stage.setScene(Login);
			break;
		case "Caixa":
			stage.setScene(TelaCaixa);
			break;
		case "Mesas":
			stage.setScene(TelaMesas);
			break;
		case "Pedidos":
			stage.setScene(TelaPedidos);
			break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
