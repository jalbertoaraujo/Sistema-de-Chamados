package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.alterarchamado;

public class alterarChamado {

	public void alterarchamado() {

		if (alterarchamado.cbsituacao.getSelectedItem().equals("ENCERRADO")) {

			alterarchamado.cbstatus.setSelectedItem("ENCERRADO PELO COLABORADOR");

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres", "admin");
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE chamado set situacao = '" + alterarchamado.cbsituacao.getSelectedItem()
						+ "',status = '" + alterarchamado.cbstatus.getSelectedItem() + "'where num_chamado ='"
						+ alterarchamado.tfnumchamado.getText() + "'");
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Alteração Efetuada Com Sucesso");
				alterarchamado.cbsituacao.setSelectedIndex(0);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao Alterar " + e);
				e.printStackTrace();
			}
			;

		} else if (alterarchamado.cbsituacao.getSelectedItem().equals("FECHADO")) {

			alterarchamado.cbstatus.setSelectedItem("FECHADO PELO ATENDENTE");

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres", "admin");
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE chamado set situacao = '" + alterarchamado.cbsituacao.getSelectedItem()
						+ "',status = '" + alterarchamado.cbstatus.getSelectedItem() + "'where num_chamado ='"
						+ alterarchamado.tfnumchamado.getText() + "'");
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Alteração Efetuada Com Sucesso");
				alterarchamado.cbsituacao.setSelectedIndex(0);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao Alterar " + e);
				e.printStackTrace();
			}
			;

		} else if (alterarchamado.cbsituacao.getSelectedItem().equals("ABERTO")) {

			alterarchamado.cbstatus.setSelectedItem("ABERTO PELO COLABORADOR");

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres", "admin");
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE chamado set situacao = '" + alterarchamado.cbsituacao.getSelectedItem()
						+ "',status = '" + alterarchamado.cbstatus.getSelectedItem() + "'where num_chamado ='"
						+ alterarchamado.tfnumchamado.getText() + "'");
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Alteração Efetuada Com Sucesso");
				alterarchamado.cbsituacao.setSelectedIndex(0);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao Alterar " + e);
				e.printStackTrace();
			}
			;

		} else if (alterarchamado.cbsituacao.getSelectedItem().equals("EM ANDAMENTO")) {

			alterarchamado.cbstatus.setSelectedItem("AGUARDANDO FECHAMENTO DO CHAMADO");

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres", "admin");
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE chamado set situacao = '" + alterarchamado.cbsituacao.getSelectedItem()
						+ "',status = '" + alterarchamado.cbstatus.getSelectedItem() + "'where num_chamado ='"
						+ alterarchamado.tfnumchamado.getText() + "'");
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Alteração Efetuada Com Sucesso");
				alterarchamado.cbsituacao.setSelectedIndex(0);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao Alterar " + e);
				e.printStackTrace();
			}
			;
		}
	}
}
