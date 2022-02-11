package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DadosDBCadastro2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.salvaSugestao;
import java.awt.Toolkit;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class listarsugestao extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual
																									// do
																									// Windows
					listarsugestao frame = new listarsugestao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public listarsugestao() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(listarsugestao.class.getResource("/Imagem/suporte.png")));
		setTitle(" LISTAR SUGEST\u00C3O");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 976, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 968, 539);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(

				""));
		panel_1.setBounds(767, 11, 191, 60);
		panel.add(panel_1);

		JButton btnListar = new JButton("ATUALIZAR TABELA");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<DadosDBCadastro2> dados = new ArrayList();

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				try {
					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.17/NovoChamado",
							"postgres", "admin");
					java.sql.Statement st = con.createStatement();
					st.executeQuery("select * from sugestao order by num_sugestao");
					ResultSet rs = st.getResultSet();
					while (rs.next()) {
						dados.add(new DadosDBCadastro2(rs.getInt(1), rs.getString(2), rs.getString(3)));
					}
					con.close();
				} catch (ClassNotFoundException e11) {
					// TODO Auto-generated catch block
					e11.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao Preencher a Tabela");
				}

				for (; model.getRowCount() > 0;)
					model.removeRow(0);

				for (DadosDBCadastro2 temp : dados) {
					Object[] linha = { temp.getSugestao() };
					model.addRow(linha);
				}
			}

		});
		btnListar.setToolTipText("Clique Para Atualuizar a Tabela de Forma Geral");
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListar.setBounds(10, 11, 170, 38);
		panel_1.add(btnListar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 948, 446);
		panel.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Sugest\u00E3o" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(548);
		scrollPane.setViewportView(table);
		setLocationRelativeTo(null);

		ArrayList<DadosDBCadastro2> dados = new ArrayList();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.17/NovoChamado", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select * from sugestao order by num_sugestao");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				dados.add(new DadosDBCadastro2(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			con.close();
		} catch (ClassNotFoundException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Preencher a Tabela");
		}
		for (; model.getRowCount() > 0;)
			model.removeRow(0);

		for (DadosDBCadastro2 temp : dados) {
			Object[] linha = { temp.getSugestao() };
			model.addRow(linha);
		}
	}
}
