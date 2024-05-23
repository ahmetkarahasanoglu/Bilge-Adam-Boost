package pckge;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Postgresql ile bir Jdbc bağlantısı oluştururken şunlara ihtiyacımız var:
 * 1- Driver
 * 2- url adresi
 * 3- username
 * 4- password
 * 
 * How to Add the Jdbc Driver to this Project: (this is the way to add dependency without using Gradle or Maven) 
 * Right click on the project folder -> Build Path
 * -> Configure Build Path -> Click on 'Classpath' 
 * -> Press 'Add External Jars' button -> Select 
 * the Postgresql Jdbc Driver that you downloaded 
 * -> 'Apply and Close' button
 */
public class Test {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/northwind";
		String password = "root";
		String username = "postgres";
		Connection connection = null;		
		
		try {
			Driver.class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Bağlantı başarılı.");
			String sql = "insert into categories(category_id, category_name) values(17, 'Eclipse')";
			PreparedStatement ps = connection.prepareStatement(sql);
			int count = ps.executeUpdate();
			System.out.println("number of rows affected: " + count);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}

	}//MAIN ENDS HERE -----

}//CLASS ENDS HERE ----
