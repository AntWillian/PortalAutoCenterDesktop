package views;


import controller.controller_Usuario;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import models.Usuario;
import models.UsuarioDao;
import views.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	@FXML TextField txtUsuario;
	@FXML TextField txtSenha;

	String nomeUser;
	String senha;

	static Stage primaryStage;


	@Override
	public void start(Stage primaryStage) {

		Main.primaryStage = primaryStage;
		abrirTela("Autenticacao");

	}

	public static void abrirTela(String fileName){
		//Abrir tela:
		Parent tela;

		try{

			//carregar o arquivo XML
			tela = FXMLLoader.load(Main.class.getResource(fileName+".fxml"));


			//Criando a cena
			Scene sc = new Scene(tela);

			//Exibindo a cena no stage principal
			primaryStage.setScene(sc);
			primaryStage.show();





		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void abrirTela(String fileName, Object controller){
		//Abrir tela:
		Parent tela;

		try{

			FXMLLoader loader = new FXMLLoader(Main.class.getResource(fileName+".fxml"));

			//definindo controller
			loader.setController(controller);

			//carregar o arquivo XML
			tela = loader.load();


			//Criando a cena
			Scene sc = new Scene(tela);

			//Exibindo a cena no stage principal
			primaryStage.setScene(sc);
			primaryStage.show();



		}catch(Exception ex){
			ex.printStackTrace();
		}
	}



	@FXML public void Entrar() {



		UsuarioDao user_class = new UsuarioDao();


		nomeUser=(txtUsuario.getText());
		senha=(txtSenha.getText());

		System.out.println(nomeUser +" " + senha);

		user_class.loginUser(nomeUser, senha);

		if(user_class.loginUser(nomeUser, senha)){
			abrirTela("Home");
		}else{
			System.out.println("nao Logado");
		}

		//abrirTela("controller_Usuario",controller);
	}


	public static void main(String[] args) {
		launch(args);
	}

}
