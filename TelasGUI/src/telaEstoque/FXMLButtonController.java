package telaEstoque;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import parteEstoque.Alimento;
import parteEstoque.Estoque;

public class FXMLButtonController implements Initializable {

	Estoque estoquePrincipal = new Estoque();
	@FXML
	ListView<Alimento> alimentosList = new ListView<>();
	@FXML
	Text retiradaEstoque;
	@FXML
	Text qtdAtual;
	@FXML
	Text descQteAtual;
	@FXML
	TextField qtdASerRetirada;
	@FXML
	Text destaqueAlimento;
	@FXML
	Text AlimentoEscolhido;
	@FXML
	Text relTxtEstoque;
	@FXML
	Text descQtdProduto;
	@FXML
	Text descCodigo;
	@FXML
	Text descData;
	@FXML
	Text descNome;
	@FXML
	TextField NomeDoAlimento;
	@FXML
	TextField DataDeVencimento;
	@FXML
	TextField CodigoDeBarra;
	@FXML
	TextField QteDoProduto;
	@FXML
	Button botaoGerarProduto;
	@FXML
	Button botaoRetirada;
	@FXML
	SplitPane PaneSplit;
	@FXML
	Button btAjuda;
	@FXML
	TableView<Alimento> Tabela;
	@FXML
	TableColumn<Alimento, String> nomeAlimen = new TableColumn<Alimento, String>("nomeProduto");
	@FXML
	TableColumn<Alimento, LocalDate> vencimentoAlimen = new TableColumn<Alimento, LocalDate>("dataVencimento");
	@FXML
	TableColumn<Alimento, String> codigoAlimen = new TableColumn<Alimento, String>("codigoBarra");
	@FXML
	TableColumn<Alimento, Integer> qteAlimen = new TableColumn<Alimento, Integer>("qtdProduto");
	@FXML
	TextField fieldRelDataVencimento;
	@FXML
	TextField fieldRelMinEstoque;

	public void detalharAlimento(ActionEvent event) {
		Alimento alimento = alimentosList.getSelectionModel().getSelectedItem();
		if (alimento == null) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			String mensagemInformacao = String.format("Selecione um alimento na lista");
			alerta.setTitle("Alimento não selecionado");
			alerta.setContentText(null);
			alerta.setContentText(mensagemInformacao);
			alerta.show();
		} else {
			AlimentoEscolhido.setText(alimento.toString());
			telaAdicionar(true, false, true, false, true);
			NomeDoAlimento.setText(alimento.getNomeProduto());
			DataDeVencimento.setText(alimento.getDataVencimento().format(estoquePrincipal.getFormatador()));
			CodigoDeBarra.setText(alimento.getCodigoBarra());
			QteDoProduto.setText(Integer.toString(alimento.getQtdProduto()));

		}
	}

	@FXML
	public void gerarNovoAlimento(ActionEvent event) {
		try {
			boolean adicionado = estoquePrincipal.adicionarAlimentoEstoque(NomeDoAlimento.getText(),
					DataDeVencimento.getText(), CodigoDeBarra.getText(), Integer.parseInt(QteDoProduto.getText()));
			if (adicionado == true) {
				Alimento alimento = new Alimento(NomeDoAlimento.getText(), CodigoDeBarra.getText(),
						DataDeVencimento.getText(), Integer.parseInt(QteDoProduto.getText()));
				alimentosList.getItems().add(alimento);
				telaAdicionar(false, false, false, false, false);
			}
		} catch (Exception e) {
			gerarAlertaCadastrar();
		}
	}

	public void gerarAlertaCadastrar() {
		if (NomeDoAlimento.getText().isEmpty() || DataDeVencimento.getText().isEmpty()
				|| CodigoDeBarra.getText().isEmpty() || QteDoProduto.getText().isEmpty()) {
			String camposVazios = "";
			boolean controleVirgula = false;
			if (NomeDoAlimento.getText().isEmpty()) {
				camposVazios += "<Nome Do Alimento>";
				controleVirgula = true;
			}
			if (controleVirgula) {
				camposVazios += ", ";
			}
			controleVirgula = false;
			if (DataDeVencimento.getText().isEmpty()) {
				camposVazios += "<Data de Vencimento>";
				controleVirgula = true;
			}
			if (controleVirgula) {
				camposVazios += ", ";
			}
			if (CodigoDeBarra.getText().isEmpty()) {
				camposVazios += "<Código de barra>";
			}
			if (QteDoProduto.getText().isEmpty()) {
				camposVazios += "<Quantidade>";
			}
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setTitle("Alerta");
			String informacaoAlerta = "Favor, informar o campo " + camposVazios;
			alerta.setContentText(informacaoAlerta);
			alerta.show();
		}
	}

	public void setarlista() {
		alimentosList.getItems().removeAll();
		Alimento a = new Alimento("Feijão", "123456", "10/12/2021", 15);
		Alimento b = new Alimento("Café", "123654", "08/11/2021", 10);
		Alimento c = new Alimento("Arroz", "456321", "20/05/2022", 12);
		Alimento d = new Alimento("Açucar", "456123", "27/09/2021", 20);
		estoquePrincipal.getAlimentos().add(a);
		estoquePrincipal.getAlimentos().add(b);
		estoquePrincipal.getAlimentos().add(c);
		estoquePrincipal.getAlimentos().add(d);

		alimentosList.getItems().addAll(estoquePrincipal.getAlimentos());
	}

	@SuppressWarnings("unused")
	private void adicionarAlimentoLista() {
		estoquePrincipal.adicionarAlimentoEstoque(NomeDoAlimento.getText(), DataDeVencimento.getText(),
				CodigoDeBarra.getText(), Integer.parseInt(QteDoProduto.getText()));
		alimentosList.getItems().add(new Alimento(NomeDoAlimento.getText(), DataDeVencimento.getText(),
				CodigoDeBarra.getText(), Integer.parseInt(QteDoProduto.getText())));

	}

	public void RetirarUnidades() {
		Alimento alimento = alimentosList.getSelectionModel().getSelectedItem();
		if (alimento == null) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			String mensagemInformacao = String.format("Selecione um alimento na lista");
			alerta.setTitle("Alimento não selecionado");
			alerta.setContentText(null);
			alerta.setContentText(mensagemInformacao);
			alerta.show();
		} else {
			telaAdicionar(false, false, true, true, false);
			qtdAtual.setText(Integer.toString(alimento.getQtdProduto()));
			AlimentoEscolhido.setText(alimento.getNomeProduto());
		}
	}

	public void confirmarRetiradaDeUnidades(ActionEvent event) {
		Alimento alimento = alimentosList.getSelectionModel().getSelectedItem();
		try {
			estoquePrincipal.decrementarEstoque(alimento.getCodigoBarra(), Integer.parseInt(qtdASerRetirada.getText()));
		} catch (Exception e) {
			Alert alerta = new Alert(Alert.AlertType.INFORMATION);
			String mensagemInformacao = String.format("O estoque do %s ficará abaixo do mínimo.",
					alimento.getNomeProduto());
			alerta.setTitle("Mensagem");
			alerta.setContentText(null);
			alerta.setContentText(mensagemInformacao);
			alerta.show();
		}
		telaAdicionar(false, false, false, false, false);
	}

	@FXML
	public void gerarRelatorio() {
		Tabela.setVisible(true);
		btAjuda.setLayoutX(520);
		nomeAlimen.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
		vencimentoAlimen.setCellValueFactory(new PropertyValueFactory<>("dataVencimento"));
		codigoAlimen.setCellValueFactory(new PropertyValueFactory<>("codigoBarra"));
		qteAlimen.setCellValueFactory(new PropertyValueFactory<>("qtdProduto"));
		PaneSplit.setDividerPositions(0.0);
		ObservableList<Alimento> alimentoDados = FXCollections.observableList(estoquePrincipal.getAlimentos());
		Tabela.setItems(alimentoDados);
		telaAdicionar(false, false, false, false, false);
		relTxtEstoque.setVisible(true);
	}

	@FXML
	private void alterarAlimento(ActionEvent event) {
		telaAdicionar(true, true, false, false, false);
	}

	@FXML
	public void removerAlimento(ActionEvent event) {
		Alimento alimentoEscolhido = alimentosList.getSelectionModel().getSelectedItem();
		if (alimentoEscolhido == null) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			String mensagemInformacao = String.format("Selecione um alimento na lista");
			alerta.setTitle("Alimento não selecionado");
			alerta.setContentText(null);
			alerta.setContentText(mensagemInformacao);
			alerta.show();
		} else {
			for (int i = 0; i < estoquePrincipal.getAlimentos().size(); i++) {
				if (alimentoEscolhido.equals(estoquePrincipal.getAlimentos().get(i))) {
					alimentosList.getItems().remove(i);
					estoquePrincipal.getAlimentos().remove(i);
				}
			}
		}
	}

	public void voltarTela() {
		relTxtEstoque.setVisible(false);
		btAjuda.setLayoutX(230);
		Tabela.setVisible(false);
		PaneSplit.setDividerPositions(0.51);
	}

	public void printEstoque() {
		estoquePrincipal.relatorioEstoque();
	}

	public void atualizarTabela() {
		if (fieldRelMinEstoque.getText().isEmpty() && fieldRelDataVencimento.getText().isEmpty()) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);

			String mensagemInformacao = String.format("Complete ao menos um campo acima!");

			alerta.setTitle("Campos Vazios!");
			alerta.setContentText(null);
			alerta.setContentText(mensagemInformacao);
			alerta.show();
		} else if (fieldRelMinEstoque.getText().isEmpty() && !fieldRelDataVencimento.getText().isEmpty()) {
			nomeAlimen.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
			vencimentoAlimen.setCellValueFactory(new PropertyValueFactory<>("dataVencimento"));
			codigoAlimen.setCellValueFactory(new PropertyValueFactory<>("codigoBarra"));
			qteAlimen.setCellValueFactory(new PropertyValueFactory<>("qtdProduto"));
			ObservableList<Alimento> alimentoDados = FXCollections.observableList(estoquePrincipal.pertoDeVencer(
					LocalDate.parse(fieldRelDataVencimento.getText(), estoquePrincipal.getFormatador())));
			Tabela.setItems(alimentoDados);
		} else if (!fieldRelMinEstoque.getText().isEmpty() && fieldRelDataVencimento.getText().isEmpty()) {
			nomeAlimen.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
			vencimentoAlimen.setCellValueFactory(new PropertyValueFactory<>("dataVencimento"));
			codigoAlimen.setCellValueFactory(new PropertyValueFactory<>("codigoBarra"));
			qteAlimen.setCellValueFactory(new PropertyValueFactory<>("qtdProduto"));
			ObservableList<Alimento> alimentoDados = FXCollections
					.observableList(estoquePrincipal.estoqueEmBaixa(Integer.parseInt(fieldRelMinEstoque.getText())));
			Tabela.setItems(alimentoDados);
		}

	}

	public void btinterrogacao() {
		if (btAjuda.getLayoutX() < 500 && botaoGerarProduto.isVisible()) {
			Alert alerta = new Alert(Alert.AlertType.INFORMATION);

			String mensagemInformacao = String.format(
					"Cadastre cada dado do alimento e clique em salvar, logo em seguida esse novo alimento será cadastrado no estoque!");

			alerta.setTitle("Ajuda Gerar Novo Alimento");
			alerta.setContentText(null);
			alerta.setContentText(mensagemInformacao);
			alerta.show();
		} else if (btAjuda.getLayoutX() < 500 && descQteAtual.isVisible()) {
			Alert alerta = new Alert(Alert.AlertType.INFORMATION);

			String mensagemInformacao = String.format("Coloque o valor que será retirado e clique em salvar!");

			alerta.setTitle("Ajuda Retirar Alimentos Do Estoque");
			alerta.setContentText(null);
			alerta.setContentText(mensagemInformacao);
			alerta.show();
		} else if (btAjuda.getLayoutX() < 500 && botaoGerarProduto.isVisible() == false
				&& descQteAtual.isVisible() == false) {
			Alert alerta = new Alert(Alert.AlertType.INFORMATION);

			String mensagemInformacao = String.format(
					"O botão Adicionar cadastra um novo alimento, Para remover o alimento clique no nome dele que está na lista e em remover. Para ver relatórios de estoque clique em relatórios e para retirar uma certa quantidade de unidades de um alimento clique no alimento na lista e logo em seguida clique em Dar Baixa. Para detalhar o alimento clique nele na lista e logo em seguida clique em DETALHAR");

			alerta.setTitle("Ajuda Tela Principal Estoque");
			alerta.setContentText(null);
			alerta.setContentText(mensagemInformacao);
			alerta.show();

		} else if (btAjuda.getLayoutX() > 500) {
			Alert alerta = new Alert(Alert.AlertType.INFORMATION);

			String mensagemInformacao = String.format(
					"Digite a data limite ou a quantidade mínima em estoque e clique em visualizar e você verá que a tabela atualizará os alimentos presentes no estoque. Clique em print para obter um relatório impresso. E clique em voltar para voltar para a tela principal do estoque.");

			alerta.setTitle("Ajuda Tela Relatórios Estoque");
			alerta.setContentText(null);
			alerta.setContentText(mensagemInformacao);
			alerta.show();
		}
	}

	public void voltarTelaAnterior() {
		Main.changeScreen("Cadastro");

	}

	public void initialize(URL location, ResourceBundle resources) {
		setarlista();
	}

	public void telaAdicionar(boolean estado, boolean botao, boolean alimentoEscolhido, boolean darBaixa,
			boolean detalharAlimento) {

		NomeDoAlimento.setVisible(estado);
		DataDeVencimento.setVisible(estado);
		CodigoDeBarra.setVisible(estado);
		QteDoProduto.setVisible(estado);
		descQtdProduto.setVisible(estado);
		descCodigo.setVisible(estado);
		descData.setVisible(estado);
		descNome.setVisible(estado);
		botaoGerarProduto.setVisible(botao);
		AlimentoEscolhido.setVisible(alimentoEscolhido);
		NomeDoAlimento.setText("");
		DataDeVencimento.setText("");
		CodigoDeBarra.setText("");
		QteDoProduto.setText("");
		qtdASerRetirada.setText("");
		descQteAtual.setVisible(darBaixa);
		qtdAtual.setVisible(darBaixa);
		retiradaEstoque.setVisible(darBaixa);
		qtdASerRetirada.setVisible(darBaixa);
		botaoRetirada.setVisible(darBaixa);
		destaqueAlimento.setVisible(darBaixa || detalharAlimento);
	}

}