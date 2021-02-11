package TelaCaixa;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.input.MouseEvent;
import parteCaixa.Caixa;
import partePedidos.pedCAD;
import TelaMesas.controllerMesas;

public class controllerCaixa implements Initializable{
	
   
	private Caixa caixa = new Caixa();
	private List<Mesa> contasDoDia = new ArrayList<>();
	@FXML
    private Label valorDaMesa = new Label();
	
	@FXML
    private Button BTMfecharConta;

    @FXML
    private Button BTMfecharCaixa;
    /*SUBSTITUIR STRING PELA CLASSE CONTAS*/
    @FXML
    private ListView<pedCAD> lvPedidosDaMesa;
    @FXML
    private Button BTMInter;
    public static int b = 0;
    
    @FXML
    void acaBTMInter(ActionEvent event) {
    	Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    	alerta.setTitle("Ajuda");
    	alerta.setHeaderText(null);
    	alerta.setContentText("Caixa\nFechar Conta: abrirá tela de pagamento e removerá a conta da lista\nFechar Caixa: finaliza o caixa e exibe tela com contas do dia\n");
    	alerta.show();
    }
    
    @FXML
	void acaoBTMFecharConta(ActionEvent event) {
    	controllerMesas.setControlador(100);
		contasDoDia.add(controllerMesas.getMesaSelecionada());
		caixa.setClienteDaMesa(controllerMesas.getMesaSelecionada());
		caixa.receberDinheiro();
		lvPedidosDaMesa.getItems().clear();
		
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    	alerta.setTitle("Pagando Conta");
    	alerta.setHeaderText(null);
    	alerta.setContentText("Cupom fiscal impresso no Console!");
    	alerta.show();
    	
		
    	Main.changeScreen("Mesas");
	}
	@FXML
	void acaoBTMFecharCaixa() {
		
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    	alerta.setTitle("Fechar caixa");
    	alerta.setHeaderText(null);
    	alerta.setContentText("Caixa encerrado!");
    	alerta.show();
    	Main.changeScreen("Login");
    	lvPedidosDaMesa.getItems().clear();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	
	 @FXML
	    void mouseAtt(MouseEvent event) {

		   if(controllerMesas.getControlador() == 100) {
			   caixa.setContaMesa(controllerMesas.getMesaSelecionada().getPreco());
			   valorDaMesa.setText("R$ "+controllerMesas.getMesaSelecionada().getPreco());
			   
			   lvPedidosDaMesa.getItems().addAll(controllerMesas.getMesaSelecionada().getPedidos());
			   controllerMesas.setControlador(1);
			}
		
	    }

}
