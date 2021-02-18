package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage stage;
	private static Scene Login;
	private static Scene TelaCaixa;
	private static Scene TelaMesas;
	private static Scene TelaPedidos;
	private static Scene TelaCadastro;
	private static Scene TelaEstoque;
	private static Scene TelaFecharCaixa;

	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		primaryStage.setTitle("RURADEVS Restaurant Control");
		Parent login = FXMLLoader.load(getClass().getResource("../application/FXMLLogin.fxml"));
		Login = new Scene(login, 408, 320);

		Parent caixa = FXMLLoader.load(getClass().getResource("../TelasCaixaView/FXMLCaixa.fxml"));
		TelaCaixa = new Scene(caixa, 600, 600);

		Parent pedidos = FXMLLoader.load(getClass().getResource("../TelasPedidoView/FXMLPedido.fxml"));
		TelaPedidos = new Scene(pedidos, 711, 600);

		Parent mesa = FXMLLoader.load(getClass().getResource("../TelasMesasView/FXMLMesas.fxml"));
		TelaMesas = new Scene(mesa, 600, 600);

		Parent cadastro = FXMLLoader.load(getClass().getResource("../TelasCadastroView/FXMLCadastro.fxml"));
		TelaCadastro = new Scene(cadastro, 600, 600);

		Parent estoque = FXMLLoader.load(getClass().getResource("../TelasEstoqueView/FXMLTela.fxml"));
		TelaEstoque = new Scene(estoque, 600, 600);

		Parent fecharCaixa = FXMLLoader.load(getClass().getResource("../TelasMesasView/FXMLFecharCaixa.fxml"));
		TelaFecharCaixa = new Scene(fecharCaixa, 600, 600);

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
		case "Estoque":
			stage.setScene(TelaEstoque);
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
