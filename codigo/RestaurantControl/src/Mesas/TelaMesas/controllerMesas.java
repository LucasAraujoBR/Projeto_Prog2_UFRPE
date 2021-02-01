package TelaMesas;

import Mesas.ControleMesa;
import Mesas.Mesa;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class controllerMesas {

	 @FXML
	    private Button BTMfecharMesas;
	 
	 @FXML
	    private TableView<ControleMesa> tabela;
	 
	 @FXML
	    private TextField txtCodigo;

	    @FXML
	    private TextField txtQtd;

	    @FXML
	    void novaMesa(ActionEvent event) {
              
	    }
	
	    @SuppressWarnings("unchecked")
		@FXML
	    void initialize() {
	    	Mesa mesa01 = new Mesa(4,1);
	    	
	    	ControleMesa mesa = new ControleMesa();
	    	
	    	mesa.cadrastarMesas(mesa01);
	    	
	    	TableColumn<ControleMesa, String> taNome = new TableColumn<ControleMesa, String>("");
	    	taNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().listarMesas().get(0).getNomeMesa()));
	    	
	    	TableColumn<ControleMesa, Integer> taMesa = new TableColumn<ControleMesa, Integer>("Codigo");
	    	taMesa.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().listarMesas().get(0).getNumeroDaMesa()).asObject());
	    	
	    	
	    	tabela.getColumns().addAll(taNome,taMesa);
	    	
	    	tabela.getItems().addAll(mesa);
	    	
	    	
	    }
	    
	    @FXML
	    void criarMesa(ActionEvent event) {

	    }
	    
	
	

}
