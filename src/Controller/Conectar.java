package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

public class Conectar {

	public static Connection getConnection(){
		
		try {
			
			return DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres", "admin");
		
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
	}

	public Object executeSQL;
	public ResultSet resultset;

	public void executeSQL(String string) {
		// TODO Auto-generated method stub
		
	}

	public PreparedStatement preparestatment(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public Statement getStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	public void executaInsert(String sql) {
		// TODO Auto-generated method stub
		
	}
}
