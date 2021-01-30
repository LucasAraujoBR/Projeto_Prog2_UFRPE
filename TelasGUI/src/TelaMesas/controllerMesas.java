package TelaMesas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class controllerMesas {

	@FXML
	private Button BTMfecharMesas;
	@FXML
    private Button BTMEditarMesas;
	@FXML
	private Button BTMabrirMesas;
	@FXML
    private Button BTMInter;
	@FXML
	private ListView<?> listMesas;
	
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
	void acaoBTMFechar() {
		/*IMPLEMENTAR AÇÃO DO BOTÃO FECHAR MESA*/
	}
	@FXML
	void acaoBTMAbrir() {
		/*IMPLEMENTAR AÇÃO DO BOTÃO ABRIR MESA*/
	}
	@FXML
	void listarMesas() {
		/*IMPLEMENTAR LISTAGEM DE MESAS*/
	}
	@FXML
	void BTMEditarMesa() {
		/*ABRIR TELA COM PEDIDOS E TOTAL PARCIAL DESSA MESA,
		 * NESSA TELA TEM QUE TER A OPÇÃO DE ADICIONAR PEDIDOS OU REMOVER PEDIDOS*/
	}

}
