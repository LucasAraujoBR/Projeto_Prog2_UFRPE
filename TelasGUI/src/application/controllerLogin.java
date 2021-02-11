package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import parteFuncionario.FunCAD;
import parteFuncionario.Funcionario;
import TelaCadastro.ControllerTelaCadastro;
import TelaMesas.controllerMesas;

/*OBS: SISTEMA DE VALIDAÇÃO DO LOGIN COM CODIGO AINDA NÃO DISCUTIDO*/
public class controllerLogin implements Initializable {
	@FXML
	private Button BTM01;
	@FXML
	private TextField CodTXT;
	
	public static FunCAD cad = new FunCAD();
	ArrayList<String> codigo = controllerLogin.cad.listarCodFuncionario();
	
	private static String codigoTeste;
	
	public static String getCodigoTeste() {
		return codigoTeste;
	}

	public static void setCodigoTeste(String codigoTeste) {
		controllerLogin.codigoTeste = codigoTeste;
	}

	@FXML
	private TextField senhaTXT;

	@FXML
	private Button BTMCadastrar;
	
	ArrayList<String> codFuncionario2 = new ArrayList<String>();

	@FXML
	void acaBTMCadastrar(ActionEvent event) {
		String senha = senhaTXT.getText();
		String codigo = CodTXT.getText();

		if (senha.equals("1234") && codigo.equals("gerente159")) {
			Main.changeScreen("Cadastro");
			CodTXT.clear();
			senhaTXT.clear();
		} else {
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setTitle("Erro");
			alerta.setHeaderText(null);
			alerta.setContentText("Somente o gerente pode acessar,favor informar Codigo e senha!");
			alerta.show();

		}
	}

	@FXML
	void acaoBotao(ActionEvent event) throws IOException {
		String codigoFuncionario = CodTXT.getText();
		String senhaGerente = senhaTXT.getText();
		if (codigoFuncionario.length() == 0) {
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setTitle("Alerta");
			alerta.setHeaderText(null);
			alerta.setContentText("Favor,informar o campo <Código de usuário>");
			alerta.show();
		}
		
		if (codigoFuncionario.length() != 0 && senhaGerente.length() == 0) {
			// testa se o codigo ja está cadastrado da arrayList codFuncionario2
			System.out.println(codFuncionario2);
			boolean tem = false;
			for (String c : cad.listarCodFuncionario()) {
				if (c.equals(codigoFuncionario)) {
					controllerMesas.setControlador(100);
					tem = true;
					for(Funcionario d :cad.listarFuncionario()) {
						if(c == d.getCodFuncionario()) {
							controllerLogin.setCodigoTeste(d.getCargo());
							controllerMesas.setControlador(100);
						}
					}
					
					
					}
			}
			if (tem == true) {
				Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
				alerta.setTitle("Login realizado com sucesso!");
				alerta.setHeaderText(null);
				alerta.setContentText("Clique em OK para continuar");
				alerta.show();
				Main.changeScreen("Mesas");
				CodTXT.clear();
				senhaTXT.clear();
			} else {
				Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
				alerta.setTitle("Código de funcionário inválido!");
				alerta.setHeaderText(null);
				alerta.setContentText("insira novamente o código");
				alerta.show();
				CodTXT.clear();
				senhaTXT.clear();
			}

		} else {
			Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
			alerta.setTitle("Código de funcionário inválido!");
			alerta.setHeaderText(null);
			alerta.setContentText("insira novamente o código");
			alerta.show();
			CodTXT.clear();
			senhaTXT.clear();
		}
		int senhaG = Integer.parseInt(senhaGerente);
		if (codigoFuncionario.length() != 0 && senhaG == 1234) {
			Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
			alerta.setTitle("Login realizado com sucesso!");
			alerta.setHeaderText(null);
			alerta.setContentText("Bem vindo Gerente, clique em OK para continuar");
			alerta.show();
			Main.changeScreen("Mesas");
			CodTXT.clear();
			senhaTXT.clear();
			for(Funcionario d :retornaCad().listarFuncionario()) {
				if("gerente159" == d.getCodFuncionario()) {
					System.out.println("alou");
					controllerMesas.setControlador(100);
					controllerLogin.setCodigoTeste(d.getCargo());
				
				}
			}
		}

		if (senhaG != 1234) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setTitle("Alerta");
			alerta.setHeaderText(null);
			alerta.setContentText("Senha errada!");
			alerta.show();

		}

	}
	public FunCAD retornaCad() {
		return controllerLogin.cad;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		codFuncionario2.addAll(cad.listarCodFuncionario());
		codFuncionario2.add("123");     //Garçom
		codFuncionario2.add("012");		//Caixa
		codFuncionario2.add("001");		//Cozinha
		codFuncionario2.add("gerente159");		//Funcionário Mesa
		ArrayList<String> codFuncionario = cad.listarCodFuncionario();
		cad.cadrastarCodFuncionario(codFuncionario2);
		
	//	cad.cadrastarCodFuncionario(codFuncionario);
		System.out.println("Código de Funcionário: "+cad.listarCodFuncionario());
		System.out.println("Código de Gerente: gerente159 , Senha do Gerente: 1234");
	}
}
