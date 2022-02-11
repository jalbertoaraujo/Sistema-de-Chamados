package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.alterarchamado;


public class salvarHistorico {
	
	public void salvahistorico(){
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.254.13/NovoChamado",
					"postgres", "admin");
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO historico (num_chamado,historico,datahistorico,responsavel) VALUES(?,?,?,?)");
									
			stmt.setString(1, (String) alterarchamado.tfnumchamado.getText());
			stmt.setString(2, (String) alterarchamado.tfinfochamado.getText());
			stmt.setString(3, (String) alterarchamado.tfinfodatahora.getText());
			stmt.setString(4, (String) alterarchamado.tfinforesponsavel.getText());
			stmt.execute();
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null,
					"Nova Situação Cadastrada com Sucesso");	
			alterarchamado.tfinfochamado.setText("");
			alterarchamado.tfinforesponsavel.setText("");
			
	}catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		JOptionPane
				.showMessageDialog(null, "Erro ao Cadastrar a Nova Situação " + e);
		}
	 }	
}
