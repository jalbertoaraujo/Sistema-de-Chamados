package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DadosDBCadastro3;
import Model.Metodo;
import Model.alterarChamado;
import Model.listarChamado;
import Model.salvarHistorico;
import uteis.AbrirTela;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class alterarchamado extends JFrame {

	private JPanel contentPane;
	public static JTextField tfnumchamado;
	public static JTextField tfdatahora;
	public static JTextField tfcolaborador;
	public static JTextField tfdepartamento;
	public static JTextField tfassunto;
	public static JTextField tfinfochamado;
	public static JTable table;
	public static JTextField tfinfodatahora;
	public static JComboBox cbprioridade;
	public static JComboBox cbsituacao;
	public static JComboBox cbstatus;
	public static JTextField tfinforesponsavel;
	public static JButton btnInserir;
	public static JButton btnLimpar;
	public static JButton btnAlterarChamado;

	public static JButton btn;
	private JScrollPane scrollPane_1;
	public static JTextArea tfdescricao;

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
					alterarchamado frame = new alterarchamado();
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
	public alterarchamado() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(alterarchamado.class.getResource("/Imagem/suporte.png")));
		setTitle("  ABRIR NOVO CHAMADOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 36, 740, 2);
		contentPane.add(separator);

		JLabel lblNDoChamado = new JLabel("N\u00BA do Chamado :");
		lblNDoChamado.setBounds(10, 10, 86, 14);
		contentPane.add(lblNDoChamado);

		tfnumchamado = new JTextField();
		tfnumchamado.setEditable(false);
		tfnumchamado.setBounds(98, 7, 86, 20);
		contentPane.add(tfnumchamado);
		tfnumchamado.setColumns(10);

		JLabel lblDataHora = new JLabel("Data / Hora do Chamado :");
		lblDataHora.setBounds(10, 51, 129, 14);
		contentPane.add(lblDataHora);

		tfdatahora = new JTextField();
		tfdatahora.setEditable(false);
		tfdatahora.setBounds(144, 46, 124, 20);
		contentPane.add(tfdatahora);
		tfdatahora.setColumns(10);

		JLabel lblColaborador = new JLabel("Colaborador : ");
		lblColaborador.setBounds(293, 51, 77, 14);
		contentPane.add(lblColaborador);

		tfcolaborador = new JTextField();
		tfcolaborador.setEnabled(false);
		tfcolaborador.setBounds(366, 48, 86, 20);
		contentPane.add(tfcolaborador);
		tfcolaborador.setColumns(10);
		tfcolaborador.setDocument(new UpperCaseDocument());

		JLabel lblDepartamento = new JLabel("Departamento :");
		lblDepartamento.setBounds(477, 51, 86, 14);
		contentPane.add(lblDepartamento);

		tfdepartamento = new JTextField();
		tfdepartamento.setEnabled(false);
		tfdepartamento.setBounds(560, 48, 170, 20);
		contentPane.add(tfdepartamento);
		tfdepartamento.setColumns(10);
		tfdepartamento.setDocument(new UpperCaseDocument());

		JLabel lblNewLabel = new JLabel("Assunto : ");
		lblNewLabel.setBounds(10, 86, 54, 14);
		contentPane.add(lblNewLabel);

		tfassunto = new JTextField();
		tfassunto.setEnabled(false);
		tfassunto.setBounds(64, 83, 86, 20);
		contentPane.add(tfassunto);
		tfassunto.setColumns(10);
		tfassunto.setDocument(new UpperCaseDocument());

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o : ");
		lblDescrio.setBounds(172, 86, 61, 14);
		contentPane.add(lblDescrio);

		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o : ");
		lblSituao.setBounds(185, 235, 54, 14);
		contentPane.add(lblSituao);

		JLabel lblPrioridade = new JLabel("Prioridade : ");
		lblPrioridade.setBounds(10, 127, 61, 14);
		contentPane.add(lblPrioridade);

		cbprioridade = new JComboBox();
		cbprioridade.setEnabled(false);
		cbprioridade.setModel(new DefaultComboBoxModel(new String[] { "NORMAL", "BAIXA", "ALTA" }));
		cbprioridade.setBounds(75, 123, 86, 22);
		contentPane.add(cbprioridade);

		cbsituacao = new JComboBox();
		cbsituacao.setModel(new DefaultComboBoxModel(new String[] {"ABERTO", "FECHADO", "EM ANDAMENTO", "ENCERRADO"}));
		cbsituacao.setBounds(242, 231, 117, 22);
		contentPane.add(cbsituacao);

		JLabel lblInformao = new JLabel("Informa\u00E7\u00F5es do Chamado : ");
		lblInformao.setBounds(10, 279, 145, 14);
		contentPane.add(lblInformao);

		tfinfochamado = new JTextField();
		tfinfochamado.setBounds(10, 296, 467, 20);
		contentPane.add(tfinfochamado);
		tfinfochamado.setColumns(10);
		tfinfochamado.setDocument(new UpperCaseDocument());

		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfinfochamado.getText().equals("") || tfinforesponsavel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha Todos os Campos de Informação do Chamado");
				} else {
					salvarHistorico hist = new salvarHistorico();
					hist.salvahistorico();
					listarChamado historico = new listarChamado();
					historico.listarhistorico();
					listarChamado listasituacao = new listarChamado();
					listasituacao.listachamadosituacao();
				}
			}
		});
		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInserir.setBackground(new Color(102, 205, 170));
		btnInserir.setBounds(544, 322, 91, 23);
		contentPane.add(btnInserir);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBackground(new Color(100, 149, 237));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tfinfochamado.setText("");
				tfinforesponsavel.setText("");
				tfinfochamado.requestFocus();

			}
		});
		btnLimpar.setBounds(639, 322, 91, 23);
		contentPane.add(btnLimpar);

		btnAlterarChamado = new JButton("Alterar ");
		btnAlterarChamado.setBackground(new Color(102, 205, 170));
		btnAlterarChamado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				alterarChamado alterar = new alterarChamado();
				alterar.alterarchamado();
				Metodo met1 = new Metodo();
				met1.lbchamadoaberto();
				Metodo met2 = new Metodo();
				met2.lbchamadoencerrado();
				Metodo met3 = new Metodo();
				met3.lbchamadoemandamento();
				Metodo met4 = new Metodo();
				met4.lbchamadofechado();
			}
		});
		btnAlterarChamado.setBounds(369, 230, 361, 23);
		contentPane.add(btnAlterarChamado);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 265, 740, 2);
		contentPane.add(separator_1);

		JLabel lblHistoricoDoChamado = new JLabel("Historico do Chamado :");
		lblHistoricoDoChamado.setBounds(10, 329, 117, 14);
		contentPane.add(lblHistoricoDoChamado);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 358, 722, 213);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				AbrirTela abr = new AbrirTela();
				abr.abrehistorico();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Hist\u00F3rico do Chamado", "Data / Hora", "Respons\u00E1vel"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(552);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(118);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);//manter menu da tabela fixo

		JLabel lblStatusDoChamado = new JLabel("Status de valida\u00E7\u00E3o do Chamado : ");
		lblStatusDoChamado.setBounds(305, 14, 182, 14);
		contentPane.add(lblStatusDoChamado);

		cbstatus = new JComboBox();
		cbstatus.setModel(new DefaultComboBoxModel(new String[] {"AGUARDANDO FECHAMENTO DO CHAMADO", "ENCERRADO PELO COLABORADOR", "ABERTO PELO COLABORADOR", "FECHADO PELO ATENDENTE"}));
		cbstatus.setBounds(477, 7, 253, 22);
		contentPane.add(cbstatus);

		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss", local);
		tfinfodatahora = new JTextField();
		tfinfodatahora.setEditable(false);
		tfinfodatahora.setBounds(606, 295, 124, 20);
		contentPane.add(tfinfodatahora);
		tfinfodatahora.setColumns(10);
		tfinfodatahora.setText(sdf.format(d));
		// tfinfodatahora.setText(new SimpleDateFormat("HH:mm:ss").format(new
		// Date(System.currentTimeMillis()))); // exibe hora atualizada do
		// sistema ao salvar

		JLabel lblDataHora_1 = new JLabel("Data / Hora :");
		lblDataHora_1.setBounds(608, 279, 68, 14);
		contentPane.add(lblDataHora_1);

		tfinforesponsavel = new JTextField();
		tfinforesponsavel.setBounds(480, 296, 124, 20);
		contentPane.add(tfinforesponsavel);
		tfinforesponsavel.setColumns(10);
		tfinforesponsavel.setDocument(new UpperCaseDocument());

		JLabel lblResponsvel = new JLabel("Respons\u00E1vel :");
		lblResponsvel.setBounds(483, 280, 77, 14);
		contentPane.add(lblResponsvel);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(236, 82, 495, 135);
		contentPane.add(scrollPane_1);
		
		tfdescricao = new JTextArea();
		tfdescricao.setEditable(false);
		tfdescricao.setLineWrap(true);
		scrollPane_1.setViewportView(tfdescricao);
		setLocationRelativeTo(null); // tela sempre no centro		
		
	}
}
