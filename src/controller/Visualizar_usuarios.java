package controller;

import java.util.ArrayList;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Usuario;
import models.UsuarioDao;

public class Visualizar_usuarios {

	@FXML TableColumn colunaNome;
	@FXML TableColumn colunaCpf;
	@FXML TableColumn colunaSalario;
	@FXML TableColumn colunaNivel;

	@FXML TableView tblFuncionario;

	UsuarioDao dao;

	public void iniciar(){

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


}
