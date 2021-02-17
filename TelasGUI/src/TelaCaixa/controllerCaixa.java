package TelaCaixa;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Mesas.Mesa;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import parteCaixa.Caixa;
import partePedidos.pedCAD;
import TelaMesas.controllerMesas;

public class controllerCaixa implements Initializable{
	
   private static Scene sceneNovasMesas;
	
    private static Stage cena2  = new Stage();
	private Caixa caixa = new Caixa();
	
	private static ArrayList<Mesa> ContasDodia = new ArrayList<>();
	
	public static ArrayList<Mesa> listaContas(){
		return ContasDodia;
	}
	public static void  addContas(Mesa m){
		ContasDodia.add(m);
	}
	public static void  limparContas(){
		ContasDodia.clear();
	}
	@FXML
    private Label valorDaMesa = new Label();
	
	@FXML
    private Button BTMfecharConta;
	
	private Mesa mesa = new Mesa(0,0);

    public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	
	@FXML
    private Button BTMfecharCaixa;
    /*SUBSTITUIR STRING PELA CLASSE CONTAS*/
    @FXML
    private ListView<pedCAD> lvPedidosDaMesa;
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
	void acaoBTMFecharConta(ActionEvent event) throws IOException {
    	//controllerMesas.setControlador(101);
    	mesa.setNomeReserva(controllerMesas.getMesaSelecionada().getNomeReserva());
    	mesa.setNumeroDaMesa(controllerMesas.getMesaSelecionada().getNumeroDaMesa());
    	for(pedCAD p : controllerMesas.getMesaSelecionada().getPedidos()) {
    		mesa.cadastrarPedido(p);
    	}
    	addContas(mesa);
		caixa.setClienteDaMesa(controllerMesas.getMesaSelecionada());
		caixa.receberDinheiro();
		//lvPedidosDaMesa.getItems().clear();
		
    	
    	FXMLLoader novasMesas = new FXMLLoader(getClass().getResource("FXMLNota.fxml"));
        Parent parentNovasMesas = novasMesas.load();
        sceneNovasMesas = new Scene(parentNovasMesas,293.0,230.0+controllerMesas.getMesaSelecionada().getPedidos().size() * 30);
        cena2.setTitle("Nota Fiscal");
        cena2.setScene(sceneNovasMesas);
        cena2.showAndWait();
        setMesa(new Mesa(0,0));
        lvPedidosDaMesa.getItems().clear();
        controllerMesas.setControlador(100);
    	Main.changeScreen("Mesas");
	}
    
    @FXML
    private Label textoCupom;
    
    @FXML
    void mouseMoved(MouseEvent event) {
    	if(controllerMesas.getControlador()== 1) {
    	textoCupom.setText(caixa.cupomFiscal(controllerMesas.getMesaSelecionada().getPedidos()));
    	controllerMesas.setControlador(2);
    	}
         
    }
    
    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	
	 @FXML
	    void mouseAtt(MouseEvent event) {

		   if(controllerMesas.getControlador() == 100) {
			   caixa.setContaMesa(controllerMesas.getMesaSelecionada().getPreco());
			   caixa.setClienteDaMesa(controllerMesas.getMesaSelecionada());
			   valorDaMesa.setText("R$ "+controllerMesas.getMesaSelecionada().getPreco());
			   
			   lvPedidosDaMesa.getItems().addAll(controllerMesas.getMesaSelecionada().getPedidos());
			   controllerMesas.setControlador(1);
			}
		
	    }

}
