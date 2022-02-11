package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controller.DadosDBCadastro;
import Controller.DadosDBCadastro3;
import Controller.DadosDBCadastro4;
import Controller.DadosDBCadastro5;
import View.AlterarCompras;
import View.Compras;
import View.alterarchamado;
import View.listarchamado;

public class listarChamado {

	public void listachamado() {

		ArrayList<DadosDBCadastro> dados = new ArrayList();

		DefaultTableModel tab = (DefaultTableModel) listarchamado.table.getModel();

		ArrayList<DadosDBCadastro4> dados1 = new ArrayList();

		DefaultTableModel model = (DefaultTableModel) listarchamado.table_1.getModel();

		if (listarchamado.cbsetorlista.getSelectedItem().equals("T.I.")) {
			listarchamado.panel_principal.removeAll();
			listarchamado.panel_principal.add(listarchamado.panel_TI);
			listarchamado.panel_principal.repaint();
			listarchamado.panel_principal.revalidate();

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select * from chamado where departamento = '"+listarchamado.tfdepacesso.getText().toString()+"'and setor = '" + listarchamado.cbsetorlista.getSelectedItem() + "' order by num_chamado");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					dados.add(new DadosDBCadastro(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(2)));
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

			for (DadosDBCadastro temp : dados) {
				Object[] linha = { temp.getNumerochamado(), temp.getDatahora(), temp.getColaborador(),
						temp.getDepartamento(), temp.getAssunto(), temp.getDescricao(), temp.getSituacao(),
						temp.getPrioridade(), temp.getSetor(), temp.getStatus() };
				tab.addRow(linha);
			}
		} else if (listarchamado.cbsetorlista.getSelectedItem().equals("MANUTENÇÃO PREDIAL")) {
			listarchamado.panel_principal.removeAll();
			listarchamado.panel_principal.add(listarchamado.panel_TI);
			listarchamado.panel_principal.repaint();
			listarchamado.panel_principal.revalidate();

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select * from chamado where departamento = '" + listarchamado.tfdepacesso.getText()
						+ "' and setor = '" + listarchamado.cbsetorlista.getSelectedItem() + "' order by num_chamado");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					dados.add(new DadosDBCadastro(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(2)));
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

			for (DadosDBCadastro temp : dados) {
				Object[] linha = { temp.getNumerochamado(), temp.getDatahora(), temp.getColaborador(),
						temp.getDepartamento(), temp.getAssunto(), temp.getDescricao(), temp.getSituacao(),
						temp.getPrioridade(), temp.getSetor(), temp.getStatus() };
				tab.addRow(linha);
			}
		} else {
			listarchamado.panel_principal.removeAll();
			listarchamado.panel_principal.add(listarchamado.panel_COMPRAS);
			listarchamado.panel_principal.repaint();
			listarchamado.panel_principal.revalidate();

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select * from compras where departamento = '" + listarchamado.tfdepacesso.getText()
						+ "'and setor = '" + listarchamado.cbsetorlista.getSelectedItem().toString()
						+ "' order by num_solicita");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					dados1.add(new DadosDBCadastro4(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
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

			for (; model.getRowCount() > 0;)
				model.removeRow(0);

			for (DadosDBCadastro4 temp : dados1) {
				Object[] linha = { temp.getNum_solicita(), temp.getSituacao(), temp.getSolicitante(),
						temp.getDatasolicita(), temp.getDepartamento(), temp.getDestino(), temp.getDescricao(),
						temp.getNecessidade(), temp.getSreferencias(), temp.getAplicacao(), temp.getTamanho(),
						temp.getQuantidade(), temp.getObs(), temp.getStatus() };
				model.addRow(linha);
			}
		}

	}

	public void listachamadopornumero() {

		ArrayList<DadosDBCadastro> dados = new ArrayList();

		DefaultTableModel tab = (DefaultTableModel) listarchamado.table.getModel();

		if (listarchamado.cbsetorlista.getSelectedItem().equals("T.I.")) {
			listarchamado.panel_principal.removeAll();
			listarchamado.panel_principal.add(listarchamado.panel_TI);
			listarchamado.panel_principal.repaint();
			listarchamado.panel_principal.revalidate();
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select * from chamado where num_chamado = '" + listarchamado.tfbuscapornumero.getText()
						+ "' and setor= '" + listarchamado.cbsetorlista.getSelectedItem().toString() + "'and departamento = '"+listarchamado.tfdepacesso.getText().toString()+"'order by num_chamado");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					dados.add(new DadosDBCadastro(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(2)));
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

			for (DadosDBCadastro temp : dados) {
				Object[] linha = { temp.getNumerochamado(), temp.getDatahora(), temp.getColaborador(),
						temp.getDepartamento(), temp.getAssunto(), temp.getDescricao(), temp.getSituacao(),
						temp.getPrioridade(), temp.getSetor(), temp.getStatus() };
				tab.addRow(linha);
			}
			if (dados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não Existe Chamado Com Este Número!");
				listarchamado.tfbuscapornumero.setText("");
				listarchamado.tfbuscapornumero.requestFocus();
			}

		} else if (listarchamado.cbsetorlista.getSelectedItem().equals("MANUTENÇÃO PREDIAL")) {

			ArrayList<DadosDBCadastro> dados2 = new ArrayList();

			DefaultTableModel tab2 = (DefaultTableModel) listarchamado.table.getModel();

			listarchamado.panel_principal.removeAll();
			listarchamado.panel_principal.add(listarchamado.panel_TI);
			listarchamado.panel_principal.repaint();
			listarchamado.panel_principal.revalidate();
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select * from chamado where num_chamado = '" + listarchamado.tfbuscapornumero.getText()
						+ "' and setor= '" + listarchamado.cbsetorlista.getSelectedItem().toString() + "'and departamento = '"+listarchamado.tfdepacesso.getText().toString()+"' order by num_chamado");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					dados2.add(new DadosDBCadastro(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(2)));
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

			for (; tab2.getRowCount() > 0;)
				tab2.removeRow(0);

			for (DadosDBCadastro temp : dados2) {
				Object[] linha = { temp.getNumerochamado(), temp.getDatahora(), temp.getColaborador(),
						temp.getDepartamento(), temp.getAssunto(), temp.getDescricao(), temp.getSituacao(),
						temp.getPrioridade(), temp.getSetor(), temp.getStatus() };
				tab2.addRow(linha);
			}
			if (dados2.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não Existe Chamado Com Este Número!");
				listarchamado.tfbuscapornumero.setText("");
				listarchamado.tfbuscapornumero.requestFocus();
			}
		} else {
			ArrayList<DadosDBCadastro4> dados1 = new ArrayList();

			DefaultTableModel model = (DefaultTableModel) listarchamado.table_1.getModel();

			listarchamado.panel_principal.removeAll();
			listarchamado.panel_principal.add(listarchamado.panel_COMPRAS);
			listarchamado.panel_principal.repaint();
			listarchamado.panel_principal.revalidate();

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery(
						"select * from compras where num_solicita = '" + listarchamado.tfbuscapornumero.getText()
								+ "' and departamento = '" + listarchamado.tfdepacesso.getText() + "'and setor = '"
								+ listarchamado.cbsetorlista.getSelectedItem().toString() + "' order by num_solicita");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					dados1.add(new DadosDBCadastro4(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
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

			for (; model.getRowCount() > 0;)
				model.removeRow(0);

			for (DadosDBCadastro4 temp : dados1) {
				Object[] linha = { temp.getNum_solicita(), temp.getSituacao(), temp.getSolicitante(),
						temp.getDatasolicita(), temp.getDepartamento(), temp.getDestino(), temp.getDescricao(),
						temp.getNecessidade(), temp.getSreferencias(), temp.getAplicacao(), temp.getTamanho(),
						temp.getQuantidade(), temp.getObs(), temp.getStatus() };
				model.addRow(linha);
			}
		}
		if (dados.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não Existe Chamado Com Este Número!");
			listarchamado.tfbuscapornumero.setText("");
			listarchamado.tfbuscapornumero.requestFocus();
		}

	}

	public void listachamadosituacao() {

		ArrayList<DadosDBCadastro> dados = new ArrayList();

		DefaultTableModel tab = (DefaultTableModel) listarchamado.table.getModel();

		if (listarchamado.cbsetorlista.getSelectedItem().equals("T.I.")) {
			listarchamado.panel_principal.removeAll();
			listarchamado.panel_principal.add(listarchamado.panel_TI);
			listarchamado.panel_principal.repaint();
			listarchamado.panel_principal.revalidate();
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select * from chamado where departamento = '" + listarchamado.tfdepacesso.getText()
						+ "' and situacao = '" + listarchamado.cblistarsituacao.getSelectedItem() + "' and setor= '"
						+ listarchamado.cbsetorlista.getSelectedItem().toString() + "'order by num_chamado");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					dados.add(new DadosDBCadastro(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(2)));
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

			for (DadosDBCadastro temp : dados) {
				Object[] linha = { temp.getNumerochamado(), temp.getDatahora(), temp.getColaborador(),
						temp.getDepartamento(), temp.getAssunto(), temp.getDescricao(), temp.getSituacao(),
						temp.getPrioridade(), temp.getSetor(), temp.getStatus() };
				tab.addRow(linha);
			}
			if (dados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não Existe Chamado Com Os Dados Informados !!");
			}

		} else if (listarchamado.cbsetorlista.getSelectedItem().equals("MANUTENÇÃO PREDIAL")) {

			ArrayList<DadosDBCadastro> dados2 = new ArrayList();

			DefaultTableModel tab2 = (DefaultTableModel) listarchamado.table.getModel();

			listarchamado.panel_principal.removeAll();
			listarchamado.panel_principal.add(listarchamado.panel_TI);
			listarchamado.panel_principal.repaint();
			listarchamado.panel_principal.revalidate();
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select * from chamado where departamento = '" + listarchamado.tfdepacesso.getText()
						+ "' and situacao = '" + listarchamado.cblistarsituacao.getSelectedItem() + "' and setor= '"
						+ listarchamado.cbsetorlista.getSelectedItem().toString() + "'order by num_chamado");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					dados.add(new DadosDBCadastro(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(2)));
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

			for (DadosDBCadastro temp : dados) {
				Object[] linha = { temp.getNumerochamado(), temp.getDatahora(), temp.getColaborador(),
						temp.getDepartamento(), temp.getAssunto(), temp.getDescricao(), temp.getSituacao(),
						temp.getPrioridade(), temp.getSetor(), temp.getStatus() };
				tab.addRow(linha);
			}
			if (dados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não Existe Chamado Com Os Dados Informados !!");
			}
		} else {
			ArrayList<DadosDBCadastro4> dados1 = new ArrayList();

			DefaultTableModel model = (DefaultTableModel) listarchamado.table_1.getModel();

			listarchamado.panel_principal.removeAll();
			listarchamado.panel_principal.add(listarchamado.panel_COMPRAS);
			listarchamado.panel_principal.repaint();
			listarchamado.panel_principal.revalidate();

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select * from compras where departamento = '" + listarchamado.tfdepacesso.getText()
						+ "' and situacao = '" + listarchamado.cblistarsituacao.getSelectedItem() + "' and setor= '"
						+ listarchamado.cbsetorlista.getSelectedItem().toString() + "'order by num_solicita");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					dados1.add(new DadosDBCadastro4(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
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

			for (; model.getRowCount() > 0;)
				model.removeRow(0);

			for (DadosDBCadastro4 temp : dados1) {
				Object[] linha = { temp.getNum_solicita(), temp.getSituacao(), temp.getSolicitante(),
						temp.getDatasolicita(), temp.getDepartamento(), temp.getDestino(), temp.getDescricao(),
						temp.getNecessidade(), temp.getSreferencias(), temp.getAplicacao(), temp.getTamanho(),
						temp.getQuantidade(), temp.getObs(), temp.getStatus() };
				model.addRow(linha);
			}
			if (dados1.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não Existe Chamado Com Os Dados Informados !!");
			}
		}
	}

	public void listarhistorico() {

		ArrayList<DadosDBCadastro3> dados = new ArrayList();

		DefaultTableModel model = (DefaultTableModel) alterarchamado.table.getModel();

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select * from historico where num_chamado='" + alterarchamado.tfnumchamado.getText()
					+ "' order by num_historico");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				dados.add(new DadosDBCadastro3(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
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

		for (; model.getRowCount() > 0;)
			model.removeRow(0);

		for (DadosDBCadastro3 temp : dados) {
			Object[] linha = { temp.getHistorico(), temp.getDatahistorico(), temp.getresponsavel(),
					temp.getNum_chamado(), temp.getNum_historico() };
			model.addRow(linha);
		}
	}

	public void listarhistoricocompras() {

		ArrayList<DadosDBCadastro5> dados = new ArrayList();

		DefaultTableModel model = (DefaultTableModel) AlterarCompras.tablehistcomp.getModel();

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select * from historicocompras where num_solicita='"
					+ AlterarCompras.tfalterarnumsolicita.getText() + "' order by num_historicocompras");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				dados.add(new DadosDBCadastro5(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
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

		for (; model.getRowCount() > 0;)
			model.removeRow(0);

		for (DadosDBCadastro5 temp : dados) {
			Object[] linha = { temp.getHistorico(), temp.getDatahistorico(), temp.getResponsavel() };
			model.addRow(linha);
		}
	}
}
