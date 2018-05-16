package controller;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import models.Usuario;
import models.UsuarioDao;
import views.HomeController;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

public class Novo_funcionarioController {
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtDtNasc;
	@FXML
	private TextField txtCpf;
	@FXML
	private TextField txtUsuario;
	@FXML
	private TextField txtSenha;
	@FXML
	private TextField txtSalario;
	@FXML
	private TextField txtCargo;
	@FXML
	private TextField txtSetor;
	@FXML
	private TextField txtDtAdmisao;
	@FXML
	private TextField txtCarteira;
	@FXML
	private TextField txtTelefone;
	@FXML
	private ComboBox conboNivel;

	Usuario atualizaUser;

	private boolean atualizacao=false;

	UsuarioDao dao = new UsuarioDao();

	public void initialize(){

		if (atualizaUser != null){
			txtNome.setText(atualizaUser.getNome());
			txtSenha.setText(atualizaUser.getSenha());
			txtUsuario.setText(atualizaUser.getUsuario());
			txtCpf.setText(atualizaUser.getCpf());
			//txtSalario. setText(atualizaUser.getSalario());
			txtCargo.setText(atualizaUser.getCargo());
			txtSetor.setText(atualizaUser.getSetor());
			txtDtAdmisao.setText(atualizaUser.getDtAdimissao());
			txtCarteira.setText(atualizaUser.getNumCarteiraTrabalho());
			txtTelefone.setText(atualizaUser.getTelefone());
			txtDtNasc.setText(atualizaUser.getDtNasc());


			atualizacao = true;
		}
	}

//	public Novo_funcionarioController(Usuario usrObj)
//	{
//		this.atualizaUser = usrObj;
//	}







	// Event Listener on Button.onAction
	@FXML
	public void salvar() {
		System.out.println("Clicou");

		if(atualizaUser != null){

			atualizaUser.setNome(txtNome.getText());
			atualizaUser.setSenha(txtSenha.getText());
			atualizaUser.setUsuario(txtUsuario.getText());
			atualizaUser.setCpf(txtCpf.getText());
			//atualizaUser.setSalario(Float.parseFloat(txtSalario.getText()));
			atualizaUser.setCargo(txtCargo.getText());
			atualizaUser.setSetor(txtSetor.getText());
			atualizaUser.setDtAdimissao(txtDtAdmisao.getText());
			atualizaUser.setDtNasc(txtDtNasc.getText());

			atualizaUser.setNumCarteiraTrabalho(txtCarteira.getText());
			atualizaUser.setTelefone(txtTelefone.getText());

		}

		Usuario u = new Usuario();

		  u.setNome(txtNome.getText());
		  u.setSenha(txtSenha.getText());
		  u.setUsuario(txtUsuario.getText());
		  u.setCpf(txtCpf.getText());
		  u.setSalario(Float.parseFloat(txtSalario.getText()));
		  u.setDtNasc(txtDtNasc.getText());
		  u.setSexo("m");
		  u.setCargo(txtCargo.getText());
		  u.setSetor(txtSetor.getText());
		  u.setDtAdimissao(txtDtAdmisao.getText());
		  u.setIdNivelAcesso(1);
		  u.setNumCarteiraTrabalho(txtCarteira.getText());
		  u.setTelefone(txtTelefone.getText());
		  u.setAtivo(1);

		  dao.inserir(u);

		  Novo_funcionarioController.close();

		 // HomeController.loadUI("cadastro_funcionario");

	}

private static void close() {
	// TODO Auto-generated method stub

}
}
