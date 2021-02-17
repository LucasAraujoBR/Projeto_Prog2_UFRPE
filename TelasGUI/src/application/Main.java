package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	private static Stage stage;
	private static Scene Login;
	private static Scene TelaCaixa;
	private static Scene TelaMesas;
	private static Scene TelaPedidos;
	private static Scene TelaCadastro;
	private static Scene TelaFecharCaixa;

	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		primaryStage.setTitle("RURADEVS Restaurant Control");
		Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
		Login = new Scene(root, 408, 320);

		Parent caixa = FXMLLoader.load(getClass().getResource("../TelaCaixa/FXMLCaixa.fxml"));
		TelaCaixa = new Scene(caixa, 600, 600);
		
		Parent pedidos = FXMLLoader.load(getClass().getResource("../TelaPedido/FXMLPedido.fxml"));
		TelaPedidos = new Scene(pedidos, 711, 600);
		
		Parent mesa = FXMLLoader.load(getClass().getResource("../TelaMesas/FXMLMesas.fxml"));
		TelaMesas = new Scene(mesa,600,600);
		
		Parent cadastro = FXMLLoader.load(getClass().getResource("../TelaCadastro/FXMLCadastro.fxml"));
		TelaCadastro = new Scene(cadastro,600,600);
		
		Parent fecharCaixa = FXMLLoader.load(getClass().getResource("../TelaMesas/FXMLFecharCaixa.fxml"));
		TelaFecharCaixa = new Scene(fecharCaixa,600,600);
		
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
		case "Cadastro":
			stage.setScene(TelaCadastro);
			break;
		case "Fechar":
			stage.setScene(TelaFecharCaixa);
			break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
