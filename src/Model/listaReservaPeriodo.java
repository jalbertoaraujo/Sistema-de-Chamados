package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controller.DadosDBCadastro;
import Controller.DadosDBCadastro6;

import View.Reserva;
import View.listarchamado;

public class listaReservaPeriodo {

	public void listareserva() {

		ArrayList<DadosDBCadastro6> dados = new ArrayList();

		DefaultTableModel tab = (DefaultTableModel) Reserva.tabelareserva.getModel();

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select * from reserva where periodo = '" + Reserva.cbperiodoescolha.getSelectedItem() + "' order by dia");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				dados.add(new DadosDBCadastro6(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
			}
			con.close();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Preencher a Tabela");
		}

		for (; tab.getRowCount() > 0;)
			tab.removeRow(0);

		for (DadosDBCadastro6 temp : dados) {
			Object[] linha = { temp.getId_reserva(), temp.getDia(), temp.getMes(), temp.getPeriodo(), temp.getHora(), temp.getDepartamento(),
					temp.getLocal(), temp.getNome(), temp.getNote(), temp.getCxsom(), temp.getAtendido() };
			tab.addRow(linha);

		}
	}
}
