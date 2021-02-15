module PrimeiroJavaFx {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens telaEstoque to javafx.graphics, javafx.fxml;
	opens TelaCadastro to javafx.graphics, javafx.fxml;
	opens TelaCaixa to javafx.graphics, javafx.fxml;
	opens TelaMesas to javafx.graphics, javafx.fxml;
	opens TelaPedido to javafx.graphics, javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
	opens sistema.parteEstoque to javafx.base;
}
