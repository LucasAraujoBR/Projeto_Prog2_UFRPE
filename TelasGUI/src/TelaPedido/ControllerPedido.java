package TelaPedido;

import java.net.URL;
import java.util.ResourceBundle;

import Mesas.Mesa;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import partePedidos.Pedidos;
import partePedidos.PedidosCRUD;

public class ControllerPedido implements Initializable {

	@FXML
	private ListView<Pedidos> listViewPedidos;

	@FXML
	private Button BTMADDPedidos;

	@FXML
	private Button BTMVoltar;
	@FXML
    private Button BTMRemover;

    @FXML
    private Label labelMesaSelecionada;
    @FXML
    void acaoBTMRemover(ActionEvent event) {

    }
	@FXML
	void addPedidoBTM(ActionEvent event) {
		
		
		

	}

	@FXML
	void BTMInterAcao(ActionEvent event) {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("Ajuda");
		alerta.setHeaderText(null);
		alerta.setContentText("Mesas\nAdicionar pedido: colocara um pedido a mesa\nVoltar: voltará para tela de Mesas\nRemover: remove um pedido");
		alerta.show();
	}

	@FXML
	void listarMesasPedidos(ActionEvent event) {
		PedidosCRUD ped = new PedidosCRUD();
		Pedidos p = new Pedidos(111, "Pizza", 100, 22.5, true);
		Pedidos p2 = new Pedidos(222, "Hamburguer", 100, 12.5, true);
		Pedidos p3 = new Pedidos(333, "Bolo", 100, 8.5, true);
		Pedidos p4 = new Pedidos(444, "Coca-Cola", 100, 6.5, true);
		Pedidos p5 = new Pedidos(555, "Pastel", 100, 8.5, true);
		Pedidos p6 = new Pedidos(666, "Batata Frita", 100, 12.5, true);
		Pedidos p7 = new Pedidos(777, "Sorvete", 100, 4.5, true);
		Pedidos p8 = new Pedidos(888, "Biscoito", 100, 1.5, true);
		Pedidos p9 = new Pedidos(999, "Pão de alho", 100, 3.5, true);
		Pedidos p10 = new Pedidos(211, "Self-Service", 100, 15.5, true);
		ped.cadrastarPedidos(p);
		ped.cadrastarPedidos(p2);
		ped.cadrastarPedidos(p3);
		ped.cadrastarPedidos(p4);
		ped.cadrastarPedidos(p5);
		ped.cadrastarPedidos(p6);
		ped.cadrastarPedidos(p7);
		ped.cadrastarPedidos(p8);
		ped.cadrastarPedidos(p9);
		ped.cadrastarPedidos(p10);
		listViewPedidos.getItems().addAll(ped.listarCardapio());
		listViewPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	@FXML
	void voltarBTM(ActionEvent event) {
		Main.changeScreen("Mesas");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarMesasPedidos(null);

	}

}