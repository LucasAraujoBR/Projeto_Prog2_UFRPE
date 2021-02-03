package TelaMesas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ControllerReservas {
	   @FXML
	    private TextField txtNomeReserva;

	    @FXML
	    private TextField txtQtdPesoas;

	    @FXML
	    void criarReserva(ActionEvent event) {
	    	try {
	    	if(controllerMesas.getMesa().getNumeroPessoas() < Integer.parseInt(txtQtdPesoas.getText().trim())){
	    		Alert cuidado = new Alert(Alert.AlertType.WARNING);
    			cuidado.setTitle("Alerta");
    			cuidado.setHeaderText("O numero de pessoas execede a quantidade");
    			cuidado.setContentText("Por favor escolha outra mesa");
    			cuidado.show();
	    	}else {
	    		
	    	controllerMesas.getMesa().setNomeReserva(txtNomeReserva.getText());
	    	controllerMesas.getMesa().setDisponivel(false);
	    	controllerMesas.getMesa().setNumeroReservas(Integer.parseInt(txtQtdPesoas.getText().trim()));
	    	controllerMesas.adicionarMesa();
	    	
	    	}
	    	}catch(NumberFormatException nfe) {
	    		Alert cuidado = new Alert(Alert.AlertType.WARNING);
    			cuidado.setTitle("Alerta");
    			cuidado.setHeaderText("Por favor, informe os dados corretamente");
    			cuidado.show();
	    	}
	    	

	     }
}
