package TelaMesas;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Mesas.Mesa;
import Mesas.ReservaMesa;
import Mesas.ControleMesa;
import Mesas.Mesa;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class controllerMesas implements Initializable {

	@FXML
	private Button BTMfecharMesas;
	@FXML
    private Button BTMEditarMesas;
	@FXML
	private Button BTMabrirMesas;
	@FXML
    private Button BTMInter;
	@FXML
	private ListView<Mesa> listMesas;
	
	@FXML
	void acaoBTMInter(ActionEvent event) {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    	alerta.setTitle("Ajuda");
    	alerta.setHeaderText(null);
    	alerta.setContentText("Mesas\nAbrir Mesas: iniciara uma mesa a lista\nEditar Mesas: Abrirá a tela de inserir pedidos e remover pedidos\n"
    			+ "Fechar Mesas: Fechara a mesa selecionada");
    	alerta.show();
	}
	
	@FXML
	void acaoBTMFechar(ActionEvent event) {
		Main.changeScreen("Caixa");
	}
	@FXML
	void acaoBTMAbrir(ActionEvent event) {
		ControleMesa mesa = new ControleMesa();
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    	alerta.setTitle("Atenção");
    	alerta.setHeaderText(null);
    	alerta.setContentText("Sistema ainda não implementado");
    	alerta.show();
	}
	@FXML
	void listarMesas(ActionEvent event) {
		ControleMesa mesa = new ControleMesa();
		ArrayList<Mesa> mesaLista = mesa.listarMesas();
		listMesas.getItems().addAll(mesaLista);
		listMesas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	@FXML
	void BTMEditarMesa(ActionEvent event) {
		/*ABRIR TELA COM PEDIDOS E TOTAL PARCIAL DESSA MESA,
		 * NESSA TELA TEM QUE TER A OPÇÃO DE ADICIONAR PEDIDOS OU REMOVER PEDIDOS*/
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    	alerta.setTitle("Atenção");
    	alerta.setHeaderText(null);
    	alerta.setContentText("Sistema ainda não implementado");
    	alerta.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarMesas(null);
		
	}

}
