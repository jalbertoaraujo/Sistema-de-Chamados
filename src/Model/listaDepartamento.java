package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controller.DadosDBCadastro;
import View.listarchamado;


public class listaDepartamento {

	ArrayList<DadosDBCadastro> dados = new ArrayList();

	DefaultTableModel tab = (DefaultTableModel) listarchamado.table.getModel();

	public void listachamado() {
		ArrayList<DadosDBCadastro> dados = new ArrayList();

		DefaultTableModel tab = (DefaultTableModel) listarchamado.table.getModel();
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select * from chamado where departamento = '"
					+ ((JComboBox) listarchamado.cbbuscadepartamento).getSelectedItem() + "'and setor = '"
					+ listarchamado.cbsetorlista.getSelectedItem() + "' order by num_chamado");
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
	}
}
