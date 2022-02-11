package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controller.DadosDBCadastro4;
import View.Compras;
import View.alterarchamado;
import View.listarchamado;

public class listarCompras {

	public void listarnumcompras() {

		ArrayList<DadosDBCadastro4> dados = new ArrayList();

		DefaultTableModel model = (DefaultTableModel) Compras.table.getModel();

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select * from compras where departamento = '" + listarchamado.tfdepacesso.getText()
					+ "' and departamento = '" + listarchamado.cbsetorlista.getSelectedItem() + "' order by num_solicita");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				dados.add(new DadosDBCadastro4(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
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

		for (DadosDBCadastro4 temp : dados) {
			Object[] linha = { temp.getNum_solicita(), temp.getSituacao(), temp.getSolicitante(),
					temp.getDatasolicita(), temp.getDepartamento(), temp.getDestino(), temp.getDescricao(),
					temp.getNecessidade(), temp.getSreferencias(), temp.getAplicacao(), temp.getTamanho(),
					temp.getQuantidade(), temp.getObs() };
			model.addRow(linha);
		}
	}

}
