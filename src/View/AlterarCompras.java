package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.alterarChamadoCompras;
import Model.listarChamado;
import Model.salvarHistorico;
import Model.salvarHistoricoCompras;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AlterarCompras extends JFrame {

	private JPanel contentPane;
	public static JTextField tfalterarnumsolicita;
	public static JTextField tfalterarstatus;
	public static JTextField tfalterarsolicitante;
	public static JTextField tfalterardata;
	public static JTextField tfalterardepartamento;
	public static JTextField tfalterardestino;
	public static JTextField tfalterardescricao;
	public static JTextField tfalterarnecessidade;
	public static JTextField tfalterarreferencia;
	public static JTextField tfalteraraplicacao;
	public static JTextField tfalterartamanho;
	public static JTextField tfalterarquantidade;
	public static JTextField tfalterarobs;
	public static JComboBox cbalterarsolicita;
	public static JTextField tfalterarinformacoes;
	public static JTextField tfalterarresponsavel;
	public static JTextField tfdataalterarfechamento;
	public static JTable tablehistcomp;
	public static JComboBox cbstatuscompras;
	public static JButton btnalterarstatus;
	public static JButton btnatualizahiscompras;
	public static JButton btnlimpahistcomp;
	public static JButton btninserirhistcomp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarCompras frame = new AlterarCompras();
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
	public AlterarCompras() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlterarCompras.class.getResource("/Imagem/suporte.png")));
		setTitle(" Alterar SOLICITA\u00C7\u00C3O DE COMPRAS  -  Formul\u00E1rio de Solicita\u00E7\u00E3o Para Cota\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 919, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("N\u00FAmero da Solicita\u00E7\u00E3o : ");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 14, 140, 14);
		contentPane.add(label);
		
		tfalterarnumsolicita = new JTextField();
		tfalterarnumsolicita.setEditable(false);
		tfalterarnumsolicita.setColumns(10);
		tfalterarnumsolicita.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfalterarnumsolicita.setBounds(151, 11, 86, 20);
		contentPane.add(tfalterarnumsolicita);
		
		JLabel label_2 = new JLabel("Status :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(257, 14, 46, 14);
		contentPane.add(label_2);
		
		tfalterarstatus = new JTextField();		
		tfalterarstatus.setEditable(false);
		tfalterarstatus.setColumns(10);
		tfalterarstatus.setBounds(304, 12, 160, 20);
		contentPane.add(tfalterarstatus);
		
		JLabel label_4 = new JLabel("Solicitante :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 49, 82, 14);
		contentPane.add(label_4);
		
		tfalterarsolicitante = new JTextField();
		tfalterarsolicitante.setEditable(false);
		tfalterarsolicitante.setColumns(10);
		tfalterarsolicitante.setBounds(85, 47, 86, 20);
		contentPane.add(tfalterarsolicitante);
		
		JLabel label_5 = new JLabel("Data :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(187, 49, 46, 14);
		contentPane.add(label_5);
		
		tfalterardata = new JTextField();		
		tfalterardata.setEditable(false);
		tfalterardata.setColumns(10);
		tfalterardata.setBounds(226, 47, 65, 20);
		contentPane.add(tfalterardata);
		
		JLabel label_6 = new JLabel("Departamento :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(307, 49, 96, 14);
		contentPane.add(label_6);
		
		tfalterardepartamento = new JTextField();
		tfalterardepartamento.setText((String) null);
		tfalterardepartamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfalterardepartamento.setEditable(false);
		tfalterardepartamento.setColumns(10);
		tfalterardepartamento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfalterardepartamento.setBounds(404, 46, 176, 20);
		contentPane.add(tfalterardepartamento);
		
		JLabel label_7 = new JLabel("Destino da Mercadoria / Servi\u00E7o :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(590, 49, 193, 14);
		contentPane.add(label_7);
		
		tfalterardestino = new JTextField();
		tfalterardestino.setEditable(false);
		tfalterardestino.setColumns(10);
		tfalterardestino.setBounds(783, 47, 119, 20);
		contentPane.add(tfalterardestino);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 75, 912, 2);
		contentPane.add(separator);
		
		JLabel label_8 = new JLabel("DADOS DO PRODUTO / SERVI\u00C7O");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(222, 86, 198, 14);
		contentPane.add(label_8);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 350, 912, 2);
		contentPane.add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 111, 622, 201);
		contentPane.add(panel);
		
		JLabel label_9 = new JLabel("Descri\u00E7\u00E3o do Produto / Servi\u00E7o :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(10, 13, 207, 14);
		panel.add(label_9);
		
		tfalterardescricao = new JTextField();
		tfalterardescricao.setEditable(false);
		tfalterardescricao.setColumns(10);
		tfalterardescricao.setBounds(220, 11, 388, 20);
		panel.add(tfalterardescricao);
		
		JLabel label_10 = new JLabel("Necessidade  :");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(124, 40, 86, 14);
		panel.add(label_10);
		
		tfalterarnecessidade = new JTextField();
		tfalterarnecessidade.setEditable(false);
		tfalterarnecessidade.setColumns(10);
		tfalterarnecessidade.setBounds(220, 37, 388, 20);
		panel.add(tfalterarnecessidade);
		
		JLabel label_11 = new JLabel("Refer\u00EAncias :");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(130, 66, 86, 14);
		panel.add(label_11);
		
		tfalterarreferencia = new JTextField();
		tfalterarreferencia.setEditable(false);
		tfalterarreferencia.setColumns(10);
		tfalterarreferencia.setBounds(220, 63, 388, 20);
		panel.add(tfalterarreferencia);
		
		JLabel label_12 = new JLabel("Aplica\u00E7\u00E3o :");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(145, 91, 72, 14);
		panel.add(label_12);
		
		tfalteraraplicacao = new JTextField();
		tfalteraraplicacao.setEditable(false);
		tfalteraraplicacao.setColumns(10);
		tfalteraraplicacao.setBounds(220, 89, 388, 20);
		panel.add(tfalteraraplicacao);
		
		JLabel label_13 = new JLabel("Tamanho :");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(145, 118, 65, 14);
		panel.add(label_13);
		
		tfalterartamanho = new JTextField();
		tfalterartamanho.setEditable(false);
		tfalterartamanho.setColumns(10);
		tfalterartamanho.setBounds(220, 115, 388, 20);
		panel.add(tfalterartamanho);
		
		JLabel label_14 = new JLabel("Quantidade :");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(130, 144, 82, 14);
		panel.add(label_14);
		
		tfalterarquantidade = new JTextField();
		tfalterarquantidade.setEditable(false);
		tfalterarquantidade.setColumns(10);
		tfalterarquantidade.setBounds(220, 141, 388, 20);
		panel.add(tfalterarquantidade);
		
		JLabel label_15 = new JLabel("Obs.:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(177, 169, 38, 14);
		panel.add(label_15);
		
		tfalterarobs = new JTextField();
		tfalterarobs.setEditable(false);
		tfalterarobs.setColumns(10);
		tfalterarobs.setBounds(220, 167, 388, 20);
		panel.add(tfalterarobs);
		
		JLabel lblInformaesDaSolicitao = new JLabel("Informa\u00E7\u00F5es da Solicita\u00E7\u00E3o : ");
		lblInformaesDaSolicitao.setBounds(10, 363, 145, 14);
		contentPane.add(lblInformaesDaSolicitao);
		
		tfalterarinformacoes = new JTextField();
		tfalterarinformacoes.setColumns(10);
		tfalterarinformacoes.setBounds(10, 380, 639, 20);
		contentPane.add(tfalterarinformacoes);
		tfalterarinformacoes.setDocument(new UpperCaseDocument());
		
		tfalterarresponsavel = new JTextField();
		tfalterarresponsavel.setColumns(10);
		tfalterarresponsavel.setBounds(652, 380, 124, 20);
		contentPane.add(tfalterarresponsavel);
		tfalterarresponsavel.setDocument(new UpperCaseDocument());
		
		JLabel label_16 = new JLabel("Respons\u00E1vel :");
		label_16.setBounds(655, 364, 77, 14);
		contentPane.add(label_16);
		
		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);
		
		tfdataalterarfechamento = new JTextField();		
		tfdataalterarfechamento.setEditable(false);
		tfdataalterarfechamento.setColumns(10);
		tfdataalterarfechamento.setBounds(778, 379, 124, 20);
		contentPane.add(tfdataalterarfechamento);
		tfdataalterarfechamento.setText(sdf.format(d));
		
		JLabel label_17 = new JLabel("Data / Hora :");
		label_17.setBounds(780, 363, 68, 14);
		contentPane.add(label_17);
		
		btninserirhistcomp = new JButton("Inserir");
		btninserirhistcomp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tfalterarinformacoes.getText().equals("")||tfalterarresponsavel.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha Todos os Campos de Informação da Solicitação");
			} else {
				salvarHistoricoCompras histcomp = new salvarHistoricoCompras();
				histcomp.salvahistoricocompras();
				listarChamado historico = new listarChamado();
				historico.listarhistoricocompras();;
			}}
		});
		btninserirhistcomp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btninserirhistcomp.setBackground(new Color(102, 205, 170));
		btninserirhistcomp.setBounds(716, 406, 91, 23);
		contentPane.add(btninserirhistcomp);
		
		btnlimpahistcomp = new JButton("Limpar");
		btnlimpahistcomp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tfalterarinformacoes.setText("");
				tfalterarresponsavel.setText("");
				tfalterarinformacoes.requestFocus();
			}
		});
		btnlimpahistcomp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnlimpahistcomp.setBackground(new Color(100, 149, 237));
		btnlimpahistcomp.setBounds(811, 406, 91, 23);
		contentPane.add(btnlimpahistcomp);
		
		JLabel label_18 = new JLabel("Status de valida\u00E7\u00E3o do Chamado : ");
		label_18.setBounds(478, 14, 167, 14);
		contentPane.add(label_18);
		
		cbstatuscompras = new JComboBox();
		cbstatuscompras.setModel(new DefaultComboBoxModel(new String[] {"AGUARDANDO FECHAMENTO DO CHAMADO", "ENCERRADO PELO COLABORADOR", "ABERTO PELO COLABORADOR", "FECHADO PELO ATENDENTE"}));
		cbstatuscompras.setBounds(650, 10, 253, 22);
		contentPane.add(cbstatuscompras);
		
		JLabel label_3 = new JLabel("Historico do Chamado :");
		label_3.setBounds(10, 410, 117, 14);
		contentPane.add(label_3);
		
		btnatualizahiscompras = new JButton("Atualizar");
		btnatualizahiscompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listarChamado historico = new listarChamado();
				historico.listarhistoricocompras();
			}
		});
		btnatualizahiscompras.setBounds(132, 406, 91, 23);
		contentPane.add(btnatualizahiscompras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 437, 892, 138);
		contentPane.add(scrollPane);
		
		tablehistcomp = new JTable();
		tablehistcomp.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Informa\u00E7\u00F5es da Solicita\u00E7\u00E3o", "Data / Hora", "Respons\u00E1vel"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablehistcomp.getColumnModel().getColumn(0).setResizable(false);
		tablehistcomp.getColumnModel().getColumn(0).setPreferredWidth(524);
		tablehistcomp.getColumnModel().getColumn(1).setResizable(false);
		tablehistcomp.getColumnModel().getColumn(1).setPreferredWidth(49);
		tablehistcomp.getColumnModel().getColumn(2).setResizable(false);
		tablehistcomp.getColumnModel().getColumn(2).setPreferredWidth(50);
		scrollPane.setViewportView(tablehistcomp);
		tablehistcomp.getTableHeader().setReorderingAllowed(false);//manter menu da tabela fixo
		
		JLabel label_1 = new JLabel("Situa\u00E7\u00E3o :");
		label_1.setBounds(687, 174, 65, 14);
		contentPane.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		cbalterarsolicita = new JComboBox();
		cbalterarsolicita.setBounds(751, 171, 119, 20);
		contentPane.add(cbalterarsolicita);
		cbalterarsolicita.setModel(new DefaultComboBoxModel(new String[] {"ABERTO", "FECHADO", "EM ANDAMENTO", "ENCERRADO"}));		
		
		btnalterarstatus = new JButton("Alterar Status");
		btnalterarstatus.setBounds(687, 208, 183, 23);
		contentPane.add(btnalterarstatus);
		btnalterarstatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				alterarChamadoCompras altcomp = new alterarChamadoCompras();
				altcomp.alterarchamado();
				
			}		
			
		});
	}
}
