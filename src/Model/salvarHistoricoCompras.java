package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.AlterarCompras;
import View.alterarchamado;


public class salvarHistoricoCompras {
	
	public void salvahistoricocompras(){
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.254.13/NovoChamado",
					"postgres", "admin");
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO historicocompras (num_solicita,historico,datahistorico,responsavel) VALUES(?,?,?,?)");
									
			stmt.setString(1, (String) AlterarCompras.tfalterarnumsolicita.getText());
			stmt.setString(2, (String) AlterarCompras.tfalterarinformacoes.getText());
			stmt.setString(3, (String) AlterarCompras.tfdataalterarfechamento.getText());
			stmt.setString(4, (String) AlterarCompras.tfalterarresponsavel.getText());
			stmt.execute();
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null,
					"Nova Situação Cadastrada com Sucesso");	
			AlterarCompras.tfalterarinformacoes.setText("");
			AlterarCompras.tfalterarresponsavel.setText("");
			
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
