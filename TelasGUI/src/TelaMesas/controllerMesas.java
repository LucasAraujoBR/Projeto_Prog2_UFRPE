package TelaMesas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Mesas.ControleMesa;
import Mesas.Mesa;
import application.Main;
import application.controllerLogin;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

public class controllerMesas implements Initializable{
	private static Scene sceneNovasMesas;
	
    private static Stage cena2  = new Stage();
    private static Mesa mesa = new Mesa(0,0);
    
    

	 public static Mesa getMesa() {
		return mesa;
	}

	public static void setMesa(Mesa mesa) {
		controllerMesas.mesa = mesa;
	}
	
	private static int controlador = 100;
	
	

	public static int getControlador() {
		return controlador;
	}

	public static void setControlador(int controlador) {
		controllerMesas.controlador = controlador;
	}
// Para cadastrar reserva
	@FXML
    void colocarReserva(ActionEvent event) throws IOException {
		
		
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
//Remove Reserva 
	@FXML
    void removeReserva(ActionEvent event) {
		if(tabela.getSelectionModel().isEmpty()) {
			Alert cuidado = new Alert(Alert.AlertType.ERROR);
			cuidado.setTitle("Erro");
			cuidado.setHeaderText("Selecione uma mesa para remover");
			cuidado.show();
		}else if(listaDeMesas.get(tabela.getSelectionModel().getSelectedIndex()).getDisponivel()){
			Alert cuidado = new Alert(Alert.AlertType.ERROR);
			cuidado.setTitle("Erro");
			cuidado.setHeaderText("Essa Mesa não possui nenhuma reserva");
			cuidado.show();
			
			
			
		}else {
			controllerMesas.setMesa(null);
			controllerMesas.setMesa(listaDeMesas.get(tabela.getSelectionModel().getSelectedIndex()));
			mesa.setDisponivel(true);
			mesa.setNomeReserva(null);
			mesa.setNumeroReservas(0);
			listaDeMesas.set(tabela.getSelectionModel().getSelectedIndex(), mesa);
		}
			
		}   
	 
	 //tabelas e colunas
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
	    
 // Para cadastrar Mesas
	    @FXML
	    void novaMesa(ActionEvent event) throws IOException {
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
	    
// fechar as janelas 
	static void fecharJanela() {
	    	cena2.close();
	    }
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initi();
	}
	
	
	
	
		
//inicializando algumas coisas		
	    @SuppressWarnings("unchecked")
	   
		public void initi() {
	    	
	    	System.out.println("teste100");
		    tabela.setItems(listaDeMesas);
	    	taNome.setCellValueFactory(new PropertyValueFactory<Mesa, String>("nomeMesa"));
	    	taCodigo.setCellValueFactory(new PropertyValueFactory<Mesa, Integer>("numeroDaMesa"));
	    	taNumero.setCellValueFactory(new PropertyValueFactory<Mesa, Integer>("numeroPessoas"));
	    	taNomeReserva.setCellValueFactory(new PropertyValueFactory<Mesa, Boolean>("nomeReserva"));
	    	taDisponibilidade.setCellValueFactory(new PropertyValueFactory<Mesa, Boolean>("dis"));
	    	taNumPessoas.setCellValueFactory(new PropertyValueFactory<Mesa, Integer>("numeroReservas"));
	    	taNome.setPrefWidth(50);
	    	taDisponibilidade.setPrefWidth(102);
	    	taInfo.getColumns().addAll(taCodigo,taNumero, taDisponibilidade);
	    	taReserva.getColumns().addAll(taNomeReserva,taNumPessoas);
	    	tabela.getColumns().addAll(taNome,taInfo,taReserva);
	    
	    	
	    }
	   
	    @FXML
	    private Label cargo = new Label();
	    
	    
		
		
	    
	    static ControleMesa teste = new ControleMesa();
	    
	    @FXML
	    private Button BTMInter;
// botao de interrogacao para ajudar nas info	    
	    @FXML
		void acaoBTMInter(ActionEvent event) {
			Alert alerta = new Alert(Alert.AlertType.INFORMATION);
	    	alerta.setTitle("Ajuda");
	    	alerta.setHeaderText(null);
	    	alerta.setContentText("Mesas\nNova Mesa: inicia uma mesa a lista\nReserva: Adiciona uma reserva à mesa\n"
	    			+ "Remover: Remove a reserva da mesa selecionada\nFechar Mesas: Encerra a conta das mesas.");
	    	alerta.show();
		}
	    
	    @FXML
		void acaoBTMFechar(ActionEvent event) {
	    	
	    	if(tabela.getSelectionModel().isEmpty()) {
				Alert cuidado = new Alert(Alert.AlertType.ERROR);
				cuidado.setTitle("Erro");
				cuidado.setHeaderText("Selecione uma mesa para colocar os pedidos");
				cuidado.show();
			}else {
				controlador = 100;
		    	controllerMesas.setMesaSelecionada(tabela.getSelectionModel().getSelectedItem());
				Main.changeScreen("Caixa");
			}
	    	
		}
	    
	    @FXML
		void BTMEditarMesa(ActionEvent event) {
	    	/*ABRIR TELA COM PEDIDOS E TOTAL PARCIAL DESSA MESA,
			 * NESSA TELA TEM QUE TER A OPÇÃO DE ADICIONAR PEDIDOS OU REMOVER PEDIDOS*/
	    	
	    	if(tabela.getSelectionModel().isEmpty()) {
				Alert cuidado = new Alert(Alert.AlertType.ERROR);
				cuidado.setTitle("Erro");
				cuidado.setHeaderText("Selecione uma mesa para colocar os pedidos");
				cuidado.show();
			}else {
				controllerMesas.setMesaSelecionada(tabela.getSelectionModel().getSelectedItem());
				Main.changeScreen("Pedidos");
				controlador = 100;
			}
			
			
		}
       
	    
	    public static Mesa mesaSelecionada;
		
		
		public static Mesa getMesaSelecionada() {
			return mesaSelecionada;
		}

		public static void setMesaSelecionada(Mesa mesaSelecionada) {
			controllerMesas.mesaSelecionada = mesaSelecionada;
		}

		@FXML
	    void setOnKeyPressed(MouseEvent event) {
			if(controlador == 100) {
				System.out.println("alo");
				cargo.setText(controllerLogin.getCodigoTeste());
				controlador = 1;
			}
			
	    }
		
	 
		
	   
}