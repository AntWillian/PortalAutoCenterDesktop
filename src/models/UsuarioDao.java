package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

    			u.setIdUsuario(rs.getInt("idFuncionario"));
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


}
