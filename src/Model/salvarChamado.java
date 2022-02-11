package Model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import View.novochamado;
import sun.awt.RequestFocusController;
import uteis.Som;


public class salvarChamado {
	
	public void salvachamado(){
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.254.13/NovoChamado",
					"postgres", "admin");
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO chamado (setor,datachamado,colaborador,departamento,assunto,descricao,situacao,prioridade,status,periodo) VALUES(?,?,?,?,?,?,?,?,?,?)");
									
			stmt.setString(1, (String) novochamado.tfsetordestinochamado.getText());
			stmt.setString(2, (String) novochamado.tfdatahora.getText());
			stmt.setString(3, (String) novochamado.tfcolaborador.getText());
			stmt.setString(4, (String) novochamado.tfdepartamento.getText());
			stmt.setString(5, (String) novochamado.tfassunto.getText());
			stmt.setString(6, (String) novochamado.tfdescricao.getText());
			stmt.setString(7, (String) novochamado.cbsituacao.getSelectedItem());
			stmt.setString(8, (String) novochamado.cbprioridade.getSelectedItem());	
			stmt.setString(9, (String) novochamado.tfstatus.getText());	
			stmt.setString(10, (String) novochamado.tfperiodo.getText());
			stmt.execute();
			stmt.close();
			con.close();
			
			File som = new File("//192.168.254.13/Chamados/mensagem.wav");
			Som playSom = new Som();
			playSom.playwav(som);
			
			JOptionPane.showMessageDialog(null,
					"Chamado Cadastrado com Sucesso com Número : "+novochamado.tfnumchamado.getText());				
			 novochamado.tfcolaborador.setText("");			
			 novochamado.tfassunto.setText("");
			 novochamado.tfdescricao.setText("");
			 novochamado.tfcolaborador.requestFocus();	
	}catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		JOptionPane
				.showMessageDialog(null, "Erro ao Cadastrar a Licitação" + e);
		}
	 }
	
	public void numchamado() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery(
					"select num_chamado from chamado'"
							);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				novochamado.tfnumchamado.setText(rs.getString(0));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void retornanumero() {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select num_chamado from chamado order by num_chamado desc limit 1");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				int ult = rs.getInt("num_chamado") + 1;
				novochamado.tfnumchamado.setText("" + ult);
			}
			con.close();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro");
		}
	
	}
}
