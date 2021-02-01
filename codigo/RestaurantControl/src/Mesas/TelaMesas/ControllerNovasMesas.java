package TelaMesas;

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
           main.mudarJanela(1);
	    }

}
