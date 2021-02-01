package application;

import java.io.IOException;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

/*OBS: SISTEMA DE VALIDAÇÃO DO LOGIN COM CODIGO AINDA NÃO DISCUTIDO*/
public class controllerLogin {
	@FXML
	private Button BTM01;
	@FXML
	private TextField CodTXT;

	@FXML
	private TextField senhaTXT;

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
			Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
			alerta.setTitle("Login realizado com sucesso!");
			alerta.setHeaderText(null);
			alerta.setContentText("Clique em OK para continuar");
			alerta.show();
			Main.changeScreen("Mesas");
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
}
