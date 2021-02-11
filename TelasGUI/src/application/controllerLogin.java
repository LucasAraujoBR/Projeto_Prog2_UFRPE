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

/*OBS: SISTEMA DE VALIDAÇÃO DO LOGIN COM CODIGO AINDA NÃO DISCUTIDO*/
public class controllerLogin implements Initializable {
	FunCAD cadLogin = new FunCAD();
	@FXML
	private Button BTM01;
	@FXML
	private TextField CodTXT;

	@FXML
	private TextField senhaTXT;

	@FXML
	private Button BTMCadastrar;

	ArrayList<String> codFuncionario2 = new ArrayList<String>();

	public String retornaCodF() {
		String cod = CodTXT.getText();
		return cod;
		/*
		 * 123 Garçom 012 Caixa 011 Cozinha gerente159 Gerente
		 */

	}

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
			codFuncionario2.addAll(cadLogin.listarCodFuncionario()); // tentativa de pegar os codigos cadastrados
			System.out.println(codFuncionario2);
			boolean tem = false;
			for (String c : codFuncionario2) {
				if (c.equals(codigoFuncionario)) {
					tem = true;
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
		}

		if (senhaG != 1234) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setTitle("Alerta");
			alerta.setHeaderText(null);
			alerta.setContentText("Senha errada!");
			alerta.show();

		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		codFuncionario2.addAll(cadLogin.listarCodFuncionario());
		codFuncionario2.add("123"); // Garçom
		codFuncionario2.add("012"); // Caixa
		codFuncionario2.add("001"); // Cozinha
		codFuncionario2.add("gerente159"); // Gerente
		cadLogin.cadrastarCodFuncionario(codFuncionario2);
		System.out.println("Código de Funcionário: " + cadLogin.listarCodFuncionario());
		System.out.println("Código de Gerente: gerente159 , Senha do Gerente: 1234");

	}
}
