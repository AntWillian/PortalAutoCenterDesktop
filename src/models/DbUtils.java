package models;

import java.sql.Connection;
import java.sql.DriverManager;

	public class DbUtils {

		static Connection con = null;

		private static String host ="10.107.144.17";
		private static String user ="root";
		private static String password ="bcd127";
		private static String dbName ="db_portal";

		public static Connection getConnection(){


			if(con == null){


				try{

					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(
							String.format("jdbc:mysql://%s/%s?useSSL=false", host,dbName),
							user, password);

					return con;
				}catch(Exception ex){
					ex.printStackTrace();
				}

			}

			return con;

		}
}