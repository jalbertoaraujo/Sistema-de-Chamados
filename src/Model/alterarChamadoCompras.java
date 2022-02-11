package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.AlterarCompras;
import View.alterarchamado;

public class alterarChamadoCompras {

	public void alterarchamado() {

		if (AlterarCompras.cbalterarsolicita.getSelectedItem().equals("ENCERRADO")) {

			AlterarCompras.cbstatuscompras.setSelectedItem("ENCERRADO PELO COLABORADOR");

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres", "admin");
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE compras set situacao = '" + AlterarCompras.cbalterarsolicita.getSelectedItem()
						+ "',status = '" + AlterarCompras.cbstatuscompras.getSelectedItem() + "'where num_solicita ='"
						+ AlterarCompras.tfalterarnumsolicita.getText() + "'");
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Alteração Efetuada Com Sucesso");
				AlterarCompras.cbalterarsolicita.setSelectedIndex(0);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao Alterar " + e);
				e.printStackTrace();
			}
			;

		} else if (AlterarCompras.cbalterarsolicita.getSelectedItem().equals("FECHADO")) {

			AlterarCompras.cbstatuscompras.setSelectedItem("FECHADO PELO ATENDENTE");

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres", "admin");
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE compras set situacao = '" + AlterarCompras.cbalterarsolicita.getSelectedItem()
						+ "',status = '" + AlterarCompras.cbstatuscompras.getSelectedItem() + "'where num_solicita ='"
						+ AlterarCompras.tfalterarnumsolicita.getText() + "'");
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Alteração Efetuada Com Sucesso");
				AlterarCompras.cbalterarsolicita.setSelectedIndex(0);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao Alterar " + e);
				e.printStackTrace();
			}
			;

		} else if (AlterarCompras.cbalterarsolicita.getSelectedItem().equals("ABERTO")) {

			AlterarCompras.cbstatuscompras.setSelectedItem("ABERTO PELO COLABORADOR");

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres", "admin");
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE compras set situacao = '" + AlterarCompras.cbalterarsolicita.getSelectedItem()
						+ "',status = '" + AlterarCompras.cbstatuscompras.getSelectedItem() + "'where num_solicita ='"
						+ AlterarCompras.tfalterarnumsolicita.getText() + "'");
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Alteração Efetuada Com Sucesso");
				AlterarCompras.cbalterarsolicita.setSelectedIndex(0);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao Alterar " + e);
				e.printStackTrace();
			}
			;

		} else if (AlterarCompras.cbalterarsolicita.getSelectedItem().equals("EM ANDAMENTO")) {

			AlterarCompras.cbstatuscompras.setSelectedItem("AGUARDANDO FECHAMENTO DO CHAMADO");

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres", "admin");
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate("UPDATE compras set situacao = '" + AlterarCompras.cbalterarsolicita.getSelectedItem()
						+ "',status = '" + AlterarCompras.cbstatuscompras.getSelectedItem() + "'where num_solicita ='"
						+ AlterarCompras.tfalterarnumsolicita.getText() + "'");
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Alteração Efetuada Com Sucesso");
				AlterarCompras.cbalterarsolicita.setSelectedIndex(0);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao Alterar " + e);
				e.printStackTrace();
			}
			;
		}
	}
}
