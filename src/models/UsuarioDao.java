package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;



public class UsuarioDao {



    Connection con;
    public UsuarioDao(){
    	con = DbUtils.getConnection();
    }


    public boolean loginUser(String nomeUser,String senha){
    	boolean verifica = false;
    	int idFuncionario = 0;

    	String sql ="select * FROM tbl_funcionario Where usuario=? and senha=?;";

    	try{

    		PreparedStatement st = con.prepareStatement(sql);
    		st.setString(1, nomeUser);
    		st.setString(2, senha);

    		ResultSet rs = st.executeQuery();
    		//String sql2 ="select @_idFuncionario as idFuncionario;";



    		//ResultSet rs2 =executeQuery(sql2);

    		while(rs.next()){

    			Usuario u = new Usuario();

    			u.setIdFuncionario(rs.getInt("idFuncionario"));
    			//idFuncionario = (rs.getInt(idFuncionario));


    			verifica = true;
    		}



    	}catch(Exception ex){
			ex.printStackTrace();
    	}
		return verifica;



    }


	private ResultSet executeQuery(String sql2) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Usuario> obterTodos(){

		ArrayList<Usuario> usuario=  new ArrayList<>();


		String SQL ="select * from tbl_funcionario;";

		try{

			PreparedStatement ps = con.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){


				Usuario u = new Usuario();
				u.setIdFuncionario(rs.getInt("idFuncionario"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setUsuario(rs.getString("usuario"));
				u.setCpf(rs.getString("cpf"));
				u.setSalario(rs.getFloat("salario"));
				u.setDtNasc(rs.getString("dtNasc"));
				u.setSexo(rs.getString("sexo"));
				u.setCargo(rs.getString("cargo"));
				u.setSetor(rs.getString("setor"));
				u.setDtAdimissao(rs.getString("dtAdimissao"));

				u.setIdNivelAcesso(rs.getInt("idNivelAcesso"));
				u.setNumCarteiraTrabalho(rs.getString("numCarteiraTrabalho"));
				u.setTelefone(rs.getString("telefone"));
				u.setAtivo(rs.getInt("ativo"));


				System.out.println(u.getNome());



				usuario.add(u);
			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		return usuario;

	}

	public Usuario obterPorId(int idFuncionario){
		Usuario usuario = null;

		String SQL ="select * from tbl_funcionario where idFuncionario = ?;";


		try{

			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, idFuncionario); //passando o ID pro select

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				usuario = new Usuario();
				usuario.setIdFuncionario(rs.getInt("idFuncionario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setSalario(rs.getFloat("salario"));
				usuario.setDtNasc(rs.getString("dtNasc"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setCargo(rs.getString("cargo"));
				usuario.setSetor(rs.getString("setor"));
				usuario.setDtAdimissao(rs.getString("dtAdimissao"));
				usuario.setIdEnderecoFuncionario(rs.getInt("idEnderecoFuncionario"));
				usuario.setIdNivelAcesso(rs.getInt("idNivelAcesso"));
				usuario.setIdNivelAcesso(rs.getInt("numCarteiraTrabalho"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setAtivo(rs.getInt("ativo"));

			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		return usuario;
	}

	public void inserir(Usuario...funcionario){
		for (Usuario u : funcionario) {

			String sql = "INSERT INTO tbl_funcionario set  "
					+ "nome =?, "
					+ " senha = ? ,"
					+ "usuario = ?,"
					+ "cpf = ?, "
					+ "salario = ?, "
					+ "dtNasc = ?, "
					+ "sexo = ?, "
					+ "cargo = ?, "
					+ "setor = ?, "
					+ "dtAdimissao = ?, "
					+ "idNivelAcesso = ?, "
					+ "numCarteiraTrabalho = ?, "
					+ "telefone = ?, "
					+ "ativo = ? ;";


			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, u.getNome());
				ps.setString(2, u.getSenha());
				ps.setString(3, u.getUsuario());
				ps.setString(4, u.getCpf());
				ps.setFloat(5, u.getSalario());
				ps.setString(6, u.getDtNasc());
				ps.setString(7, u.getSexo());
				ps.setString(8, u.getCargo());
				ps.setString(9, u.getSetor());
				ps.setString(10, u.getDtAdimissao());
				ps.setInt(11, u.getIdNivelAcesso());
				ps.setString(12, u.getNumCarteiraTrabalho());
				ps.setString(13, u.getTelefone());
				ps.setInt(14, u.getAtivo());


				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}








		}
	}



}
