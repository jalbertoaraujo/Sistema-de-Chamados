package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.DadosReserva;
import View.novochamado;

public class salvarReserva {
	
	public void salvarreserva(){
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.254.13/NovoChamado",
					"postgres", "admin");
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO reserva (dia,mes,periodo,hora,departamento,local,nome,note,caixa,atendido) VALUES(?,?,?,?,?,?,?,?,?,?)");
									
			stmt.setString(1, (String) DadosReserva.tfdiareserva.getText());
			stmt.setString(2, (String) DadosReserva.tfmesreserva.getText());
			stmt.setString(3, (String) DadosReserva.tfperiodoreserva.getText());
			stmt.setString(4, (String) DadosReserva.tfhorareserva.getText());
			stmt.setString(5, (String) DadosReserva.tfdepreserva.getText());
			stmt.setString(6, (String) DadosReserva.tflocalreserva.getText());
			stmt.setString(7, (String) DadosReserva.tfnomereserva.getText());
			stmt.setString(8, (String) DadosReserva.cbnotereserva.getSelectedItem());
			stmt.setString(9, (String) DadosReserva.cbcxreserva.getSelectedItem());
			stmt.setString(10, (String) DadosReserva.tfatendido.getText());
			stmt.execute();
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null,"Reserva Realizada com Sucesso");	
			
	}catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		JOptionPane
				.showMessageDialog(null, "Erro ao Cadastrar a Reserva" + e);
		}
	}
}
