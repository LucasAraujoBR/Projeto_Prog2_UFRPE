package TelaMesas;

import java.util.ArrayList;

import Mesas.ControleMesa;
import Mesas.Mesa;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControllerNovasMesas {
	
	 @FXML
	    private TextField txtCodigo;

	    @FXML
	    private TextField txtQtd;

	    @FXML
	    void criarMesa(ActionEvent event) {
	    	if(txtQtd == null) {
	    		System.out.println("erro");
	    	}else {
	    		 System.out.println(txtQtd.getText());
	    	}
	    	
          
		
           
          
          
           
	    }

}
