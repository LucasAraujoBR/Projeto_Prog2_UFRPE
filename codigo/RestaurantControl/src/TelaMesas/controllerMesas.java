package TelaMesas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Mesas.ControleMesa;
import Mesas.Mesa;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class controllerMesas {
	
	private static boolean clicou = false;
	
	public static boolean isClicou() {
		return clicou;
	}

	public static void setClicou(boolean clicou) {
		controllerMesas.clicou = clicou;
	}

	private static Scene sceneNovasMesas;
	
    private static Stage cena2  = new Stage();
    private static Mesa mesa = new Mesa(0,0);
    
    

	 public static Mesa getMesa() {
		return mesa;
	}

	public static void setMesa(Mesa mesa) {
		controllerMesas.mesa = mesa;
	}
	
	private static int controlador = 1;
	
	

	public static int getControlador() {
		return controlador;
	}

	public static void setControlador(int controlador) {
		controllerMesas.controlador = controlador;
	}

	@FXML
    void colocarReserva(ActionEvent event) throws IOException {
		System.out.println("apertei essa merda");
		
		
		if(tabela.getSelectionModel().isEmpty()) {
			Alert cuidado = new Alert(Alert.AlertType.ERROR);
			cuidado.setTitle("Erro");
			cuidado.setHeaderText("Selecione uma mesa para colocar a reserva");
			cuidado.show();
		}else if(!listaDeMesas.get(tabela.getSelectionModel().getSelectedIndex()).getDisponivel()){
			Alert cuidado = new Alert(Alert.AlertType.ERROR);
			cuidado.setTitle("Erro");
			cuidado.setHeaderText("Essa Mesa ja possui uma reserva");
			cuidado.show();
		}else {
			FXMLLoader novasMesas = new FXMLLoader(getClass().getResource("FXMLReserva.fxml"));
	        Parent parentNovasMesas = novasMesas.load();
	        
	        sceneNovasMesas = new Scene(parentNovasMesas,293.0,143.0);
	       cena2.setTitle("Reserva");
	       cena2.setScene(sceneNovasMesas);
	       controllerMesas.setMesa(null);
	       controllerMesas.setMesa(listaDeMesas.get(tabela.getSelectionModel().getSelectedIndex()));
	       
	       cena2.showAndWait();
	       
	       listaDeMesas.set(tabela.getSelectionModel().getSelectedIndex(), mesa);
		}
		
   
    }
	
	@FXML
    void removeMesa(ActionEvent event) {
		if(tabela.getSelectionModel().isEmpty()) {
			Alert cuidado = new Alert(Alert.AlertType.ERROR);
			cuidado.setTitle("Erro");
			cuidado.setHeaderText("Selecione uma mesa para remover");
			cuidado.show();
		}else {
	    teste.removerMesa(tabela.getSelectionModel().getSelectedItem());
		listaDeMesas.remove(tabela.getSelectionModel().getSelectedItem());
		
		}
			
		}

	
    
	 
	 
     private TableColumn<Mesa, String> taNome  = new TableColumn<Mesa,String>();
	 
	 @FXML
	    private TableView<Mesa> tabela = new TableView<Mesa>();
	 
	 
	   private TableColumn<Mesa, Integer> taCodigo= new TableColumn<Mesa, Integer>("Codigo");

	   
	  private TableColumn<Mesa, Integer> taNumero= new TableColumn<Mesa, Integer>("Capacidade");
	  private TableColumn<Mesa, Boolean> taDisponibilidade= new TableColumn<Mesa, Boolean>("Disponibilidade");
	  private TableColumn<Mesa, Boolean> taNomeReserva= new TableColumn<Mesa, Boolean>("Nome");
	  @SuppressWarnings("rawtypes")
	private TableColumn taReserva = new TableColumn("Reserva");
	  @SuppressWarnings( "rawtypes")
	private TableColumn taInfo= new TableColumn("Informação Da Mesa");
	  private TableColumn<Mesa, Integer> taNumPessoas= new TableColumn<Mesa, Integer>("Pessoas");

	    ObservableList<Mesa> listaDeMesas = FXCollections.observableArrayList();
	    

	    @FXML
	    void novaMesa(ActionEvent event) throws IOException {
	    	System.out.println("apertei");
	           
	 
	         FXMLLoader novasMesas = new FXMLLoader(getClass().getResource("FXMLNovasMesas.fxml"));
	         Parent parentNovasMesas = novasMesas.load();
	         
	        sceneNovasMesas = new Scene(parentNovasMesas,293.0,143.0);
	        cena2.setTitle("Mesas");
	        cena2.setScene(sceneNovasMesas);
	        cena2.showAndWait();
	        if(controlador == 0) {
	        listaDeMesas.add(mesa);
	        controlador = 1;
	        }
	    
	       
	    }
	    
 
	static void adicionarMesa() {
	    	cena2.close();
	    }
	
	
		
		
	    @SuppressWarnings("unchecked")
	    @FXML
		void initialize() {
		    tabela.setItems(listaDeMesas);
	    	taNome.setCellValueFactory(new PropertyValueFactory<Mesa, String>("nomeMesa"));
	    	taCodigo.setCellValueFactory(new PropertyValueFactory<Mesa, Integer>("numeroDaMesa"));
	    	taNumero.setCellValueFactory(new PropertyValueFactory<Mesa, Integer>("numeroPessoas"));
	    	taNomeReserva.setCellValueFactory(new PropertyValueFactory<Mesa, Boolean>("nomeReserva"));
	    	taDisponibilidade.setCellValueFactory(new PropertyValueFactory<Mesa, Boolean>("disponivel"));
	    	taNumPessoas.setCellValueFactory(new PropertyValueFactory<Mesa, Integer>("numeroReservas"));
	    	taNome.setPrefWidth(50);
	    	taDisponibilidade.setPrefWidth(102);
	    	taInfo.getColumns().addAll(taCodigo,taNumero);
	    	taReserva.getColumns().addAll(taDisponibilidade,taNomeReserva,taNumPessoas);
	    	tabela.getColumns().addAll(taNome,taInfo,taReserva);
	    }
	   
	    	
	    
	    
		
		@FXML
	    private TextField txtCodigo;

	    @FXML
	    private TextField txtQtd;
	    
	    private static ControleMesa teste = new ControleMesa();
	    
	    @FXML
	    void criarMesa(ActionEvent event) {
	    	if(txtQtd == null) {
	    		
	    	}else {
	    		try {
	    		 
	    		 Mesa nova = new Mesa(Integer.parseInt(txtQtd.getText().trim()), Integer.parseInt(txtCodigo.getText().trim()));
	    		 
	    		 if(teste.cadrastarMesas(nova)) {
	    		 adicionarMesa();
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