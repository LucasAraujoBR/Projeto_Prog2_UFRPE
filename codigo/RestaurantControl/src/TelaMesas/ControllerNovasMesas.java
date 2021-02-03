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
	
	
	private int contador = 0;
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
	    		contador++;
	    		if (contador>1) System.out.println("erro");
	    	}else {
	    		try {
	    		 
	    		 controllerMesas teste = new controllerMesas();
	    		 Mesa nova = new Mesa(Integer.parseInt(txtQtd.getText().trim()), Integer.parseInt(txtCodigo.getText().trim()));
	    		 controllerMesas.adicionarMesa();
	    		// teste.addMesas(nova);
	    		 teste.listaDeMesas.add(new Mesa(nova.getNumeroDaMesa(),nova.getNumeroPessoas()));
	    		 System.out.println(teste.listaDeMesas);
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
