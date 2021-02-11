package TelaCadastro;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.controllerLogin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import parteFuncionario.FunCAD;
import parteFuncionario.Funcionario;

public class ControllerTelaCadastro implements Initializable {

	@FXML
	private TextField nomeTXT;

	@FXML
	private TextField cpfTXT;

	@FXML
	private TextField emailTXT;

	@FXML
	private TextField telefoneTXT;

	@FXML
	private ListView<Funcionario> listViewCadastro;

	ObservableList<String> list = FXCollections.observableArrayList("Gerente: gerente159   |   Senha: 1234");

	@FXML
	private Button adicionarBTM;
	@FXML
	private TextField cargoTXT;

	@FXML
	private Button removerBTM;

	@FXML
	private TextField codFuncionarioTXT;
	/*
	 * private String cod = codFuncionarioTXT.getText(); public String getCod() {
	 * return cod; }
	 * 
	 * public void setCod(String cod) { this.cod = cod; }
	 */

	@FXML
	private Button interBTM;
	
	@FXML
	private Button voltaBTM;
	@SuppressWarnings("unchecked")
	ArrayList<String> codFun = new ArrayList<String>();

	@FXML
	void acaoAdicionarBTM(ActionEvent event) {

		String nomeF = nomeTXT.getText();
		String cpfF = cpfTXT.getText();
		String emailF = emailTXT.getText();
		String telefoneF = telefoneTXT.getText();
		String codF = codFuncionarioTXT.getText();
		String cargoF = cargoTXT.getText();
		if (nomeF.length() == 0 || cpfF.length() == 0 || emailF.length() == 0 || telefoneF.length() == 0
				|| codF.length() == 0 || cargoF.length() == 0) {
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setTitle("Alerta");
			alerta.setHeaderText(null);
			alerta.setContentText("Favor,informar todos os campos!");
			alerta.show();
		} else {

			Funcionario f = new Funcionario(nomeF, cpfF, telefoneF, emailF, codF, cargoF);
			controllerLogin.cad.cadrastarFuncionario(f);
			codFun.add(codF);
			controllerLogin.cad.cadrastarCodFuncionario(codFun);
			System.out.println("CodFuncionario:" + controllerLogin.cad.listarCodFuncionario());
			if (controllerLogin.cad.isJaCadastrado() == false) {
				listViewCadastro.getItems().addAll(f);
				nomeTXT.clear();
				cpfTXT.clear();
				emailTXT.clear();
				telefoneTXT.clear();
				codFuncionarioTXT.clear();
				cargoTXT.clear();
			} else {
				Alert alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setTitle("Erro");
				alerta.setHeaderText(null);
				alerta.setContentText("Funcionário já cadastrado,favor checar os dados");
				alerta.show();
				nomeTXT.clear();
				cpfTXT.clear();
				emailTXT.clear();
				telefoneTXT.clear();
				codFuncionarioTXT.clear();
				cargoTXT.clear();
			}
		}

	}

	@FXML
	void listarFuncionarios(ActionEvent event) {
		
		listViewCadastro.getItems().addAll(controllerLogin.cad.listarFuncionario());
		listViewCadastro.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

	@FXML
	void acaoRemoverBTM(ActionEvent event) {
		// Sistema não implementado!
		Alert alerta = new Alert(Alert.AlertType.WARNING);
		alerta.setTitle("Alerta");
		alerta.setHeaderText(null);
		alerta.setContentText("Sistema não implementado!");
		alerta.show();
	}

	@FXML
	void acaoBTMInter(ActionEvent event) {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("Ajuda");
		alerta.setHeaderText(null);
		alerta.setContentText(
				"Tela de cadastro:\n Você deve preencher as informações do novo funcionário\nVoltar: volta para tela de Login\n"
						+ "Cadastrar: cadastra o novo funcionario\n Remover: remove o funcionario do sistema");
		alerta.show();

	}

	@FXML
	void acaoBTMVoltar(ActionEvent event) {
		Main.changeScreen("Login");
	}
	public FunCAD retornaCad() {
		return controllerLogin.cad;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Funcionario f1 = new Funcionario("João", "845.965.852-65", "(81)98888-5959","Joaofsm@gmail.com", "123", "Garçom");
		Funcionario f2 = new Funcionario("Arthur", "585.905.152-05", "(81)97778-5959","Arthurfsm@gmail.com", "012", "Caixa");
		Funcionario f3 = new Funcionario("Pedro", "125.102.152-00", "(81)97788-5959", "Pedrofsm@gmail.com", "001", "Cozinha");
		Funcionario f4 = new Funcionario("Carlos", "159.987.845-15", "(81)97788-0408", "Carlosfsm@gmail.com", "gerente159", "Gerente");
		Funcionario gerente = new Funcionario("Gerente","107","gerente@gmail.com","819999999","1234","Gerente");
		controllerLogin.cad.cadrastarFuncionario(f4);
		controllerLogin.cad.cadrastarFuncionario(f3);
		controllerLogin.cad.cadrastarFuncionario(f2);
		controllerLogin.cad.cadrastarFuncionario(f1);
		controllerLogin.cad.cadrastarFuncionario(gerente);
		controllerLogin.cad.cadrastarCodFuncionario(codFun);
		listarFuncionarios(null);
		

		
		
		

	}
}
