package TelaCaixa;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class controllerCaixa implements Initializable{

    @FXML
    private Button BTMfecharConta;

    @FXML
    private Button BTMfecharCaixa;
    /*SUBSTITUIR STRING PELA CLASSE CONTAS*/
    @FXML
    private ListView<String> listContasAbertas;
    @FXML
    private Button BTMInter;
    
    @FXML
    void acaBTMInter(ActionEvent event) {
    	Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    	alerta.setTitle("Ajuda");
    	alerta.setHeaderText(null);
    	alerta.setContentText("Caixa\nFechar Conta: abrirá tela de pagamento e removerá a conta da lista\nFechar Caixa: finaliza o caixa e exibe tela com contas do dia\n");
    	alerta.show();
    }
    @FXML
	void listarContas(ActionEvent event) {
		
		listContasAbertas.getItems().addAll("Conta 01","Conta 02","Conta 03");
		listContasAbertas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
    @FXML
	void acaoBTMFecharConta(ActionEvent event) {
		String sele = listContasAbertas.getSelectionModel().getSelectedItem();
    	
    	if(sele==null||sele.isEmpty()) {
    		Alert alerta = new Alert(Alert.AlertType.WARNING);
        	alerta.setTitle("ERRO");
        	alerta.setHeaderText(null);
        	alerta.setContentText("Favor selecionar uma Conta para executar");
        	alerta.show();
    	}
	}
	@FXML
	void acaoBTMFecharCaixa() {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    	alerta.setTitle("Fechar caixa");
    	alerta.setHeaderText(null);
    	alerta.setContentText("Clique em OK para encerrar o caixa");
    	alerta.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarContas(null);
		
	}

}
