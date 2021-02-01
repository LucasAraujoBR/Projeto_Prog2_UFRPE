package TelaMesas;

import java.io.IOException;

import Mesas.ControleMesa;
import Mesas.Mesa;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controllerMesas {
	
	private static Scene sceneNovasMesas;

	 @FXML
	    private Button BTMfecharMesas;
	 
	 @FXML
	    private TableView<ControleMesa> tabela;
	 
	 @FXML
	    private TextField txtCodigo;

	    @FXML
	    private TextField txtQtd;

	    @FXML
	    void novaMesa(ActionEvent event) throws IOException {
	    	System.out.println("aprteu");
	           
	        
	         FXMLLoader novasMesas = new FXMLLoader(getClass().getResource("FXMLNovasMesas.fxml"));
	         Parent parentNovasMesas = novasMesas.load();
	         
	        sceneNovasMesas = new Scene(parentNovasMesas,293.0,143.0);
	        Stage teste = new Stage();
	        teste.setScene(sceneNovasMesas);
	        teste.show();
	           
	    }
	
	    @SuppressWarnings("unchecked")
		@FXML
	    void initialize() {
	    	
	    	ControllerNovasMesas teste = new ControllerNovasMesas();
	    	
	    	teste.criarMesa(null);
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
	    
	    
	
	

}
