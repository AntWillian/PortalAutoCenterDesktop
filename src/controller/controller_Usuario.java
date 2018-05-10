package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.Usuario;
import models.UsuarioDao;

public class controller_Usuario {

	Usuario user;

	UsuarioDao user_class = new UsuarioDao();

	@FXML TextField txtUsuario;
	@FXML TextField txtSenha;

	String nomeUser;
	String senha;

	@FXML public void entrar() {

		nomeUser=(txtUsuario.getText());
		senha=(txtSenha.getText());

		System.out.println(nomeUser +" " + senha);

		user_class.loginUser(nomeUser, senha);




	}



}
