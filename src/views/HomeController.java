package views;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.BorderPane;

public class HomeController {
	@FXML
	private BorderPane borderPane;

	// Event Listener on Button.onMouseClicked
	@FXML
	public void clear(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ui1(MouseEvent event) {
		loadUI("cadastro_funcionario");
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void ui2(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onMouseClicked
	 @FXML
	public void ui3(MouseEvent event) {
		// TODO Autogenerated
	}

	public void loadUI(String ui){

		Parent abrirTela = null;

		try {
			abrirTela = FXMLLoader.load(getClass().getResource(ui+".fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		borderPane.setCenter(abrirTela);
	}
}
