module PrimeiroJavaFx {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens questao4b to javafx.graphics, javafx.fxml;
	opens questao4a to javafx.graphics, javafx.fxml;
	opens telaEstoque to javafx.graphics, javafx.fxml;
	opens sistema.parteEstoque to javafx.base;
}
