package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Usuario;
import models.UsuarioDao;
import views.Main;
import javafx.scene.control.TableColumn;

public class cadastro_funcionarioController {
	@FXML
	private Pane Novo_funcionario;
	@FXML
	private TableView tblFuncionario;
	@FXML
	private TableColumn colunaNome;
	@FXML
	private TableColumn colunaCpf;
	@FXML
	private TableColumn colunaSalario;
	@FXML
	private TableColumn colunaNivel;
	@FXML
	private Button novo;

	@FXML
	private Button editar;





	UsuarioDao dao;

	@FXML public void initialize(){

		dao = new UsuarioDao();

		colunaNome.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
		colunaCpf.setCellValueFactory(new PropertyValueFactory<Usuario, String>("cpf"));
		colunaSalario.setCellValueFactory(new PropertyValueFactory<Usuario, Float>("salario"));
		colunaNivel.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("idNivelAcesso"));

		ArrayList<Usuario> lstUsuario = dao.obterTodos();

		tblFuncionario.setItems(
				FXCollections.observableArrayList(lstUsuario)
				);


		System.out.println("inicialização ");
	}


	public static void abrirTela( Object controller){
		Stage primaryStage = new Stage();

		//System.out.println("Clicado ");
		//System.out.println(cadastro_funcionarioController.class.getResource("../views/Novo_funcionario.fxml"));
		System.out.println("essa e a " +controller);
		Parent tela ;

		try{
			//System.out.println("Ta no try ");

			//carregar o arquivo XML
			FXMLLoader loader =new FXMLLoader(cadastro_funcionarioController.class.getResource("../views/Novo_funcionario.fxml"));



			loader.setController(controller);
			tela = loader.load();

			//Criando a cena
			Scene sc = new Scene(tela);

			//Exibindo a cena no stage principal
			primaryStage.setScene(sc);
			primaryStage.show();





		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("erro "+ex.getMessage());

		}


	}

	@FXML public void novo(){

		Novo_funcionarioController controller = new Novo_funcionarioController();
		abrirTela(controller);

	}

	@FXML public void editar(){
		Usuario u = (Usuario)tblFuncionario.getSelectionModel().getSelectedItem();

		if(u == null){
			JOptionPane.showConfirmDialog(null, "ATENÇÃO", "Nenhun registro selecionado", JOptionPane.WARNING_MESSAGE);
		}else{

			Novo_funcionarioController controller = new Novo_funcionarioController();
			controller.atualizaUser = u ;

			abrirTela(controller);

			System.out.println(u.nome + " selecionado");
		}
	}
}


