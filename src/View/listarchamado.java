package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.DadosDBCadastro;
import Controller.DadosDBCadastro4;
import Model.listarChamado;

import uteis.AbrirTela;
import uteis.AbrirTelaAlterarCompras;
import uteis.ColorirTabela;
import uteis.ColorirTabela2;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.CardLayout;

public class listarchamado extends JFrame {

	private JPanel contentPane;
	public static JTextField tfbuscapornumero;
	public static JTable table;
	public static JComboBox cblistarsituacao;
	public static JComboBox cbsetorlista;
	private ArrayList<DadosDBCadastro> RelatorioBD = new ArrayList<DadosDBCadastro>();
	private ArrayList<DadosDBCadastro4> RelatorioBD4 = new ArrayList<DadosDBCadastro4>();
	public static JTextField tfdepacesso;
	public static JPanel panel_principal;
	public static JPanel panel_TI;
	public static JPanel panel_COMPRAS;
	public static JTable table_1;
	public static Object cbbuscadepartamento;

	public List<DadosDBCadastro> getRelatorioBD() {
		return RelatorioBD;
	}

	public void setRelatorioBD(ArrayList<DadosDBCadastro> relatorioBD) {
		RelatorioBD = relatorioBD;
	}
	
	public List<DadosDBCadastro4> getRelatorioBD4() {
		return RelatorioBD4;
	}

	public void setRelatorioBD4(ArrayList<DadosDBCadastro4> relatorioBD4) {
		RelatorioBD4 = relatorioBD4;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual do Windows
					listarchamado frame = new listarchamado();
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
	public listarchamado() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(listarchamado.class.getResource("/Imagem/suporte.png")));
		setTitle(" LISTAR CHAMADOS ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1151, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1145, 539);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(

				"PESQUISA"));
		panel_1.setBounds(400, 83, 191, 60);
		panel.add(panel_1);

		JButton button = new JButton("   BUSCA GERAL ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listarChamado lista = new listarChamado();
				lista.listachamado();
			}
		});
		button.setToolTipText("Clique Para Atualuizar a Tabela de Forma Geral");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(10, 20, 170, 25);
		panel_1.add(button);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(

				"PESQUISA POR NÚMERO DO CHAMADO"));
		panel_2.setBounds(601, 83, 234, 60);
		panel.add(panel_2);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				listarChamado listanumero = new listarChamado();
				listanumero.listachamadopornumero();
				
			}
		});
		btnBuscar.setToolTipText("Informe o N\u00FAmero do Chamado e Clique Aqui Para Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(101, 22, 122, 25);
		panel_2.add(btnBuscar);

		tfbuscapornumero = new JTextField();
		tfbuscapornumero.setBounds(9, 25, 86, 20);
		panel_2.add(tfbuscapornumero);
		tfbuscapornumero.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(

				"PESQUISA POR DEPARTAMENTO E SITUAÇÃO"));
		panel_3.setBounds(845, 83, 289, 60);
		panel.add(panel_3);

		JButton button_1 = new JButton("BUSCAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listarChamado listasituacao = new listarChamado();
				listasituacao.listachamadosituacao();
			}
		});
		button_1.setToolTipText("Informe a Situa\u00E7\u00E3o do Chamado Para Realizar a Busca");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(155, 22, 122, 25);
		panel_3.add(button_1);

		cblistarsituacao = new JComboBox();
		cblistarsituacao.setModel(new DefaultComboBoxModel(new String[] {"SITUA\u00C7\u00C3O", "--------------------", "ABERTO", "FECHADO", "EM ANDAMENTO", "ENCERRADO"}));
		cblistarsituacao.setBounds(13, 24, 133, 22);
		panel_3.add(cblistarsituacao);

		JSeparator separator = new JSeparator();
		separator.setBounds(1, 74, 1144, 2);
		panel.add(separator);

		JButton btnNovoChamado = new JButton("Novo Chamado");
		btnNovoChamado.setBackground(new Color(102, 204, 255));
		btnNovoChamado.setToolTipText("Clique Para Abrir o Formul\u00E1rio Para um Novo Chamado");
		btnNovoChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(cbsetorlista.getSelectedItem().equals("ESCOLHA UMA OPÇÃO")){
					JOptionPane.showMessageDialog(null,"ESCOLHA UM SETOR DESTINO DO CHAMADO VÁLIDO");
				}
				else if(cbsetorlista.getSelectedItem().equals("COMPRAS")){
					TelaCompras frame = new TelaCompras();
					frame.setVisible(true);
				}else{				
				novochamado frame = new novochamado();
				frame.setVisible(true);
				}
			}
		});
		btnNovoChamado.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNovoChamado.setBounds(966, 41, 168, 25);
		panel.add(btnNovoChamado);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(

				"LEGENDA DA TABELA"));
		panel_4.setBounds(6, 6, 632, 58);
		panel.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(50, 205, 50));
		panel_5.setBounds(10, 18, 148, 24);
		panel_4.add(panel_5);

		JLabel lblAberto = new JLabel("ABERTO");
		lblAberto.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblAberto);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.YELLOW);
		panel_7.setBounds(164, 18, 148, 24);
		panel_4.add(panel_7);

		JLabel lblEmAndamento = new JLabel("EM ANDAMENTO");
		lblEmAndamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_7.add(lblEmAndamento);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.CYAN);
		panel_8.setBounds(318, 19, 148, 23);
		panel_4.add(panel_8);
		
		JLabel lblFechado_1 = new JLabel("FECHADO");
		lblFechado_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_8.add(lblFechado_1);
		
				JPanel panel_6 = new JPanel();
				panel_6.setBounds(474, 19, 148, 24);
				panel_4.add(panel_6);
				panel_6.setBackground(Color.RED);
				
						JLabel lblFechado = new JLabel("ENCERRADO");
						lblFechado.setFont(new Font("Tahoma", Font.BOLD, 12));
						panel_6.add(lblFechado);
		
		JLabel lblSetor = new JLabel("Setor Destino do Chamado :");
		lblSetor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSetor.setForeground(Color.BLUE);
		lblSetor.setBounds(779, 14, 180, 14);
		panel.add(lblSetor);
		
		cbsetorlista = new JComboBox();
		cbsetorlista.setToolTipText("Escolha o Setor de Destino do Chamado Para Listar os Chamados");
		cbsetorlista.setModel(new DefaultComboBoxModel(new String[] {"ESCOLHA UMA OP\u00C7\u00C3O", "T.I.", "MANUTEN\u00C7\u00C3O PREDIAL", "COMPRAS"}));
		cbsetorlista.setBounds(966, 11, 168, 22);
		panel.add(cbsetorlista);
		setLocationRelativeTo(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(
		
						"VOCÊ ESTÁ EM :"));
		panel_9.setBounds(11, 83, 289, 60);
		panel.add(panel_9);
		
		tfdepacesso = new JTextField();
		tfdepacesso.setForeground(Color.BLUE);
		tfdepacesso.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfdepacesso.setBounds(10, 26, 268, 23);
		panel_9.add(tfdepacesso);
		tfdepacesso.setEditable(false);
		tfdepacesso.setColumns(10);
		tfdepacesso.setText(acessar.cbdepacessar.getSelectedItem().toString());
		
		panel_principal = new JPanel();
		panel_principal.setBounds(10, 154, 1125, 385);
		panel.add(panel_principal);
		panel_principal.setLayout(new CardLayout(0, 0));
		
		panel_TI = new JPanel();
		panel_principal.add(panel_TI, "name_183686764025232");
		panel_TI.setLayout(null);
		
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 1125, 385);
				panel_TI.add(scrollPane);
				
						table = new JTable();
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {

								AbrirTela abrir = new AbrirTela();
								abrir.abretela();
								listarChamado historico = new listarChamado();
								historico.listarhistorico();
							}
						});
						table.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"N\u00BA Chamado", "Data / Hora", "Colaborador", "Dpto.", "Assunto", "Descri\u00E7\u00E3o", "Situa\u00E7\u00E3o", "Prioridade", "Setor", "Status"
							}
						) {
							Class[] columnTypes = new Class[] {
								String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class, String.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
						table.getColumnModel().getColumn(0).setResizable(false);
						table.getColumnModel().getColumn(0).setPreferredWidth(25);
						table.getColumnModel().getColumn(1).setResizable(false);
						table.getColumnModel().getColumn(1).setPreferredWidth(48);
						table.getColumnModel().getColumn(2).setResizable(false);
						table.getColumnModel().getColumn(2).setPreferredWidth(47);
						table.getColumnModel().getColumn(3).setResizable(false);
						table.getColumnModel().getColumn(3).setPreferredWidth(24);
						table.getColumnModel().getColumn(4).setPreferredWidth(37);
						table.getColumnModel().getColumn(5).setResizable(false);
						table.getColumnModel().getColumn(5).setPreferredWidth(316);
						table.getColumnModel().getColumn(6).setResizable(false);
						table.getColumnModel().getColumn(7).setResizable(false);
						table.getColumnModel().getColumn(7).setPreferredWidth(41);
						table.getColumnModel().getColumn(8).setResizable(false);
						table.getColumnModel().getColumn(8).setPreferredWidth(67);
						table.getColumnModel().getColumn(9).setResizable(false);
						table.getColumnModel().getColumn(9).setPreferredWidth(187);
						scrollPane.setViewportView(table);
						
								table.setDefaultRenderer(Object.class, new ColorirTabela());
								table.getTableHeader().setReorderingAllowed(false);//manter menu da tabela fixo
										
		panel_COMPRAS = new JPanel();
		panel_principal.add(panel_COMPRAS, "name_183745740275631");
		panel_COMPRAS.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1125, 385);
		panel_COMPRAS.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AbrirTelaAlterarCompras aacom= new AbrirTelaAlterarCompras();
				aacom.abrealterarcompras();
				listarChamado hist = new listarChamado();
				hist.listarhistoricocompras();
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00BA Solicita\u00E7\u00E3o", "Situa\u00E7\u00E3o", "Solicitante", "Data", "Departamento", "Destino", "Descri\u00E7\u00E3o", "Necessidade", "Refer\u00EAncias", "Aplica\u00E7\u00E3o", "Tamanho", "Quantidade", "Obs.", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(4).setPreferredWidth(86);
		scrollPane_1.setViewportView(table_1);		
		
		table_1.setDefaultRenderer(Object.class, new ColorirTabela2());
		table_1.getTableHeader().setReorderingAllowed(false);//manter menu da tabela fixo
		
	}
}
