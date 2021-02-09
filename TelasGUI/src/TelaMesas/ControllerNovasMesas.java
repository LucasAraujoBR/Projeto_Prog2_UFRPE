package TelaMesas;

import java.util.ArrayList;

import Mesas.ControleMesa;
import Mesas.Mesa;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ControllerNovasMesas {
	
	public TextField getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(TextField txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public String getTxtQtd() {
		return txtQtd.getText();
	}

	public void setTxtQtd(TextField txtQtd) {
		this.txtQtd = txtQtd;
	}

	@FXML
	    private TextField txtCodigo;

	    @FXML
	    private TextField txtQtd;
	    
	    @FXML
	    void criarMesa(ActionEvent event) {
	    	if(txtQtd == null) {
	    		
	    	}else {
	    		try {
	    		 
	    		 Mesa nova = new Mesa(Integer.parseInt(txtQtd.getText().trim()), Integer.parseInt(txtCodigo.getText().trim()));
	    		 
	    		 if(controllerMesas.teste.cadrastarMesas(nova)) {
	    			 controllerMesas.fecharJanela();
	    		 controllerMesas.setMesa(nova);
	    		 controllerMesas.setControlador(0);
	    		 }else {
	    			 Alert cuidado = new Alert(Alert.AlertType.WARNING);
		    			cuidado.setTitle("Alerta");
		    			cuidado.setHeaderText("Esta mesa ja existe");
		    			cuidado.setContentText("Por favor digitar outro codigo");
		    			cuidado.show();
	    		 }
	    		}
	    		
	    		catch(NumberFormatException nfe) {
	    			Alert cuidado = new Alert(Alert.AlertType.WARNING);
	    			cuidado.setTitle("Alerta");
	    			cuidado.setHeaderText("Favor,informar os campos com os dados certos");
	    			cuidado.show();
	    		}
	    	}
	    	
}
	    

}
