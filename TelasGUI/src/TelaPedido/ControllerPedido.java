package TelaPedido;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import partePedidos.Pedidos;
import partePedidos.PedidosCRUD;
import partePedidos.pedCAD;

public class ControllerPedido implements Initializable {
	PedidosCRUD ped = new PedidosCRUD();
	ArrayList<pedCAD> listP = ped.listarCadPed();
	
	@FXML
	private ListView<Pedidos> listViewPedidos;

	@FXML
	private Button BTMVoltar;

	@FXML
	private Button BTMInter;

	@FXML
	private Button BTMRemover;
	
	@FXML
	private Label mesaLabel;

	@FXML
	private TextField codPedidoTXT;

	@FXML
	private Button BTMAdicionar;

	@FXML
	private TextField quantidadeTXT;

	@FXML
	private ListView<pedCAD> listaCadPedidos;

	@FXML
	void acaoAddPedido(ActionEvent event) {
		listP.removeAll(ped.listarCadPed());
		int codigo = Integer.parseInt(codPedidoTXT.getText());
		int quantidade = Integer.parseInt(quantidadeTXT.getText());
		if(codigo == 0 || quantidade == 0) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setTitle("Erro");
			alerta.setHeaderText(null);
			alerta.setContentText("Preencha todos os campos!");
			alerta.show();
			quantidadeTXT.clear();
			codPedidoTXT.clear();
		}
		if(codigo == 1) {
			pedCAD p = new pedCAD("Pizza",quantidade,22.5);
			ped.cadPED(p);
			listaCadPedidos.getItems().addAll(listP);
			listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			}else if(codigo == 2) {
				pedCAD p = new pedCAD("Hamburguer",quantidade,12.5);
				ped.cadPED(p);
				listaCadPedidos.getItems().addAll(listP);
				listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			}else if(codigo == 3) {
				pedCAD p = new pedCAD("Bolo",quantidade,8.5);
				ped.cadPED(p);
				listaCadPedidos.getItems().addAll(listP);
				listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			}else if(codigo == 4) {
				pedCAD p = new pedCAD("Coca-Cola",quantidade,6.5);
				ped.cadPED(p);
				listaCadPedidos.getItems().addAll(listP);
				listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			}else if(codigo == 5) {
				pedCAD p = new pedCAD("Coca-Cola",quantidade,6.5);
				ped.cadPED(p);
				listaCadPedidos.getItems().addAll(listP);
				listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			}else if(codigo == 6) {
				pedCAD p = new pedCAD("Batata Frita",quantidade,12.5);
				ped.cadPED(p);
				listaCadPedidos.getItems().addAll(listP);
				listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			}else if(codigo == 7) {
				pedCAD p = new pedCAD("Sorvete",quantidade,4.5);
				ped.cadPED(p);
				listaCadPedidos.getItems().addAll(listP);
				listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			}else if(codigo == 8) {
				pedCAD p = new pedCAD("Biscoito",quantidade,1.5);
				ped.cadPED(p);
				listaCadPedidos.getItems().addAll(listP);
				listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			}else if(codigo == 9) {
				pedCAD p = new pedCAD("Pão de alho",quantidade,3.5);
				ped.cadPED(p);
				listaCadPedidos.getItems().addAll(listP);
				listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			}else if(codigo == 10) {
				pedCAD p = new pedCAD("Self-Service",quantidade,15.5);
				ped.cadPED(p);
				listaCadPedidos.getItems().addAll(listP);
				listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			}else {
				Alert alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setTitle("Erro");
				alerta.setHeaderText(null);
				alerta.setContentText("Código inválido, Digite um válido!");
				alerta.show();
				quantidadeTXT.clear();
				codPedidoTXT.clear();
			}
		quantidadeTXT.clear();
		codPedidoTXT.clear();

	}

	@FXML
	void acaoRemoverPedido(ActionEvent event) {
		int itemSelecionado = listaCadPedidos.getSelectionModel().getSelectedIndex();
		listaCadPedidos.getItems().remove(itemSelecionado);

	}

	@FXML
	void acaoListarCadPedidos(ActionEvent event) {
		listaCadPedidos.getItems().addAll(ped.listarCadPed());
		listaCadPedidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		

	}

	@FXML
	void BTMInterAcao(ActionEvent event) {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("Ajuda");
		alerta.setHeaderText(null);
		alerta.setContentText(
				"Mesas\nAdicionar pedido: colocara um pedido a mesa\nVoltar: voltará para tela de Mesas\nRemover: remove um pedido");
		alerta.show();
	}

	@FXML
	void listarMesasPedidos(ActionEvent event) {
		Pedidos p = new Pedidos(1,"Pizza",22.5);
		Pedidos p2 = new Pedidos(2,"Hamburguer",12.5);
		Pedidos p3 = new Pedidos(3,"Bolo",8.5);
		Pedidos p4 = new Pedidos(4,"Coca-Cola",6.5);
		Pedidos p5 = new Pedidos(5,"Pastel",8.5);
		Pedidos p6 = new Pedidos(6,"Batata Frita",12.5);
		Pedidos p7 = new Pedidos(7,"Sorvete",4.5);
		Pedidos p8 = new Pedidos(8,"Biscoito",1.5);
		Pedidos p9 = new Pedidos(9,"Pão de alho",3.5);
		Pedidos p10 = new Pedidos(10,"Self-Service",15.5);
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