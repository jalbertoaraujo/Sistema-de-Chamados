package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.listaReserva;
import Model.listaReservaPeriodo;
import uteis.ColorirTabela2;
import uteis.ColorirTabela3;
import uteis.UpperCaseDocument;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Reserva extends JFrame {

	private JPanel contentPane;
	public static JComboBox cbperiodoescolha;
	public static JComboBox cbmesreserva;
	public static JComboBox cbdiareserva;
	public static JTable tabelareserva;

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
					Reserva frame = new Reserva();
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
	public Reserva() {
		setResizable(false);
		setTitle(" RESERVA PROJETOR");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reserva.class.getResource("/Imagem/suporte.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1049, 635);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd", local);

		Date d1 = new Date();

		Locale local1 = new Locale("pt", "BR"); // Para internacionalizar a
												// data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM", local1);

		Date d2 = new Date();

		Locale local2 = new Locale("pt", "BR"); // Para internacionalizar a
												// data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf2 = new SimpleDateFormat("MMMM", local2);
		
		
		Date d3 = new Date();

		Locale local3 = new Locale("pt", "BR"); // Para internacionalizar a
												// data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf3 = new SimpleDateFormat("dd", local3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "INFORME OS DADOS PARA RESERVAR", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(8, 11, 309, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
				cbperiodoescolha = new JComboBox();	
				cbperiodoescolha.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						listaReservaPeriodo lrp = new listaReservaPeriodo();
						lrp.listareserva();
					}
				});
				cbperiodoescolha.setBounds(10, 37, 92, 20);
				panel.add(cbperiodoescolha);
				cbperiodoescolha.setForeground(new Color(0, 0, 204));
				cbperiodoescolha.setFont(new Font("Tahoma", Font.BOLD, 12));
				cbperiodoescolha.setModel(new DefaultComboBoxModel(new String[] {"MANH\u00C3", "TARDE", "INTEGRAL"}));
				cbdiareserva = new JComboBox();
				cbdiareserva.setBounds(112, 37, 42, 20);
				panel.add(cbdiareserva);
				cbdiareserva.setForeground(new Color(0, 0, 205));
				cbdiareserva.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				cbdiareserva.setFont(new Font("Tahoma", Font.BOLD, 12));
				cbdiareserva.setSelectedItem(sdf3.format(d3));
				
				JLabel lblDia = new JLabel("DIA");
				lblDia.setBounds(112, 20, 29, 14);
				panel.add(lblDia);
				lblDia.setForeground(Color.BLACK);
				lblDia.setFont(new Font("Tahoma", Font.BOLD, 12));
				cbmesreserva = new JComboBox();
				cbmesreserva.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						listaReserva lr = new listaReserva();
						lr.listareserva();
					}
				});
				cbmesreserva.setBounds(164, 37, 89, 20);
				panel.add(cbmesreserva);
				cbmesreserva.setForeground(new Color(0, 0, 204));
				cbmesreserva.setFont(new Font("Tahoma", Font.BOLD, 12));
				cbmesreserva.setModel(new DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril",
						"Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
				cbmesreserva.setSelectedItem(sdf2.format(d2));
				
						JLabel lblMs = new JLabel("M\u00CAS");
						lblMs.setBounds(164, 20, 29, 14);
						panel.add(lblMs);
						lblMs.setForeground(Color.BLACK);
						lblMs.setFont(new Font("Tahoma", Font.BOLD, 12));
						
						JLabel lblPerodo = new JLabel("PER\u00CDODO");
						lblPerodo.setForeground(Color.BLACK);
						lblPerodo.setFont(new Font("Tahoma", Font.BOLD, 12));
						lblPerodo.setBounds(10, 20, 63, 14);
						panel.add(lblPerodo);
						
								JButton btnNewButton = new JButton("");
								btnNewButton.setBounds(259, 20, 38, 36);
								panel.add(btnNewButton);
								btnNewButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {

										DadosReserva dr = new DadosReserva();
										dr.setVisible(true);
//				ListaReserva frame = new ListaReserva();
//				frame.setVisible(true);
									}
								});
								btnNewButton.setIcon(new ImageIcon(Reserva.class.getResource("/Imagem/rel.png")));
								btnNewButton.setToolTipText("HIST\u00D3RICO");
								
								JScrollPane scrollPane = new JScrollPane();
								scrollPane.setBounds(7, 87, 1026, 514);
								contentPane.add(scrollPane);
								
								tabelareserva = new JTable();
								tabelareserva.setFont(new Font("Tahoma", Font.BOLD, 11));
								tabelareserva.setModel(new DefaultTableModel(
									new Object[][] {
									},
									new String[] {
										"ID", "DIA", "M\u00CAS", "PER\u00CDODO", "HORA", "DEPARTAMENTO", "LOCAL DE UTILIZA\u00C7\u00C3O", "NOME", "NOTEBOOK", "CX. DE SOM", "ATENDIDO"
									}
								) {
									Class[] columnTypes = new Class[] {
										String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
									};
									public Class getColumnClass(int columnIndex) {
										return columnTypes[columnIndex];
									}
								});
								tabelareserva.getColumnModel().getColumn(0).setResizable(false);
								tabelareserva.getColumnModel().getColumn(0).setPreferredWidth(15);
								tabelareserva.getColumnModel().getColumn(1).setResizable(false);
								tabelareserva.getColumnModel().getColumn(1).setPreferredWidth(15);
								tabelareserva.getColumnModel().getColumn(2).setResizable(false);
								tabelareserva.getColumnModel().getColumn(2).setPreferredWidth(40);
								tabelareserva.getColumnModel().getColumn(3).setResizable(false);
								tabelareserva.getColumnModel().getColumn(3).setPreferredWidth(40);
								tabelareserva.getColumnModel().getColumn(4).setResizable(false);
								tabelareserva.getColumnModel().getColumn(4).setPreferredWidth(30);
								tabelareserva.getColumnModel().getColumn(5).setResizable(false);
								tabelareserva.getColumnModel().getColumn(5).setPreferredWidth(120);
								tabelareserva.getColumnModel().getColumn(6).setResizable(false);
								tabelareserva.getColumnModel().getColumn(6).setPreferredWidth(140);
								tabelareserva.getColumnModel().getColumn(7).setResizable(false);
								tabelareserva.getColumnModel().getColumn(7).setPreferredWidth(130);
								tabelareserva.getColumnModel().getColumn(8).setResizable(false);
								tabelareserva.getColumnModel().getColumn(8).setPreferredWidth(50);
								tabelareserva.getColumnModel().getColumn(9).setResizable(false);
								tabelareserva.getColumnModel().getColumn(9).setPreferredWidth(50);
								tabelareserva.getColumnModel().getColumn(10).setResizable(false);
								tabelareserva.getColumnModel().getColumn(10).setPreferredWidth(80);
								scrollPane.setViewportView(tabelareserva);
								
								tabelareserva.setDefaultRenderer(Object.class, new ColorirTabela3());
								tabelareserva.getTableHeader().setReorderingAllowed(false);// manter menu da tabelafixo	
								
								listaReserva lr = new listaReserva();
								lr.listareserva();
	
	}
}
