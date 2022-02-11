package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.sugestao;

public class salvaSugestao {
	
	
	public void salvarsugestao(){
	
	try {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://192.168.254.13/NovoChamado",
				"postgres", "admin");
		PreparedStatement stmt = con
				.prepareStatement("INSERT INTO sugestao (indentificador,sugestao) VALUES(?,?)");
								
		stmt.setString(1, (String) sugestao.tfindentificador.getText());
		stmt.setString(2, (String) sugestao.tasugestao.getText());
		stmt.execute();
		stmt.close();
		con.close();
		JOptionPane.showMessageDialog(null,
				"Sugestão Cadastrada com Sucesso");	
		sugestao.tasugestao.setText("");
		sugestao.tfindentificador.setText("");
}catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	// e.printStackTrace();
	JOptionPane
			.showMessageDialog(null, "Erro ao Cadastrar a Sugestão" + e);
	}
 }
}
