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
import javax.swing.KeyStroke;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DadosDBCadastro3;
import Model.listarChamado;
import Model.salvarChamado;
import View.Compras;
import uteis.Som;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;

public class novochamado extends JFrame {

	private JPanel contentPane;
	public static JTextField tfnumchamado;
	public static JTextField tfdatahora;
	public static JTextField tfcolaborador;
	public static JTextField tfassunto;
	public static JComboBox cbprioridade;
	public static JComboBox cbsituacao;
	public static JTextField tfstatus;
	public static JTextField tfdepartamento;
	public static JButton btnSalvarChamado;
	public static JTextField tfsetordestinochamado;
	public static JTextArea tfdescricao;
	public static JTextField tfperiodo;
	

	/**
	 * Launch the application.
	 */
	
	static void disableKeys(InputMap im,String[] keystrokeNames) {      //desabilitar a tecla enter        
        for (int i = 0; i < keystrokeNames.length; ++i)
            im.put(KeyStroke.getKeyStroke(keystrokeNames[i]), "none");
    }

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual
																									// do
																									// Windows
					novochamado frame = new novochamado();
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
	public novochamado() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(novochamado.class.getResource("/Imagem/suporte.png")));
		setTitle("  ABRIR NOVO CHAMADOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 305);
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

		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss", local);
		tfdatahora = new JTextField();
		tfdatahora.setEditable(false);
		tfdatahora.setBounds(140, 48, 117, 20);
		contentPane.add(tfdatahora);
		tfdatahora.setColumns(10);
		tfdatahora.setText(sdf.format(d));
		// tfdatahora.setText(new SimpleDateFormat("HH:mm:ss").format(new
		// Date(System.currentTimeMillis()))); // exibe hora atualizada do
		// sistema ao salvar

		JLabel lblColaborador = new JLabel("Colaborador : ");
		lblColaborador.setBounds(267, 51, 77, 14);
		contentPane.add(lblColaborador);

		tfcolaborador = new JTextField();
		tfcolaborador.setBounds(339, 48, 86, 20);
		contentPane.add(tfcolaborador);
		tfcolaborador.setColumns(10);
		tfcolaborador.setDocument(new UpperCaseDocument());

		JLabel lblNewLabel = new JLabel("Assunto : ");
		lblNewLabel.setBounds(10, 86, 54, 14);
		contentPane.add(lblNewLabel);

		tfassunto = new JTextField();
		tfassunto.setBounds(75, 83, 120, 20);
		contentPane.add(tfassunto);
		tfassunto.setColumns(10);
		tfassunto.setDocument(new UpperCaseDocument());

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o : ");
		lblDescrio.setBounds(214, 86, 61, 14);
		contentPane.add(lblDescrio);

		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o : ");
		lblSituao.setBounds(10, 123, 54, 14);
		contentPane.add(lblSituao);

		JLabel lblPrioridade = new JLabel("Prioridade : ");
		lblPrioridade.setBounds(10, 161, 61, 14);
		contentPane.add(lblPrioridade);

		cbprioridade = new JComboBox();
		cbprioridade.setModel(new DefaultComboBoxModel(new String[] { "NORMAL", "BAIXA", "ALTA" }));
		cbprioridade.setBounds(77, 157, 107, 22);
		contentPane.add(cbprioridade);

		cbsituacao = new JComboBox();
		cbsituacao.setEnabled(false);
		cbsituacao.setModel(new DefaultComboBoxModel(new String[] { "ABERTO", "FECHADO", "EM ANDAMENTO" }));
		cbsituacao.setBounds(76, 119, 117, 22);
		contentPane.add(cbsituacao);

		btnSalvarChamado = new JButton("Salvar Chamado");
		btnSalvarChamado.setBackground(new Color(102, 205, 170));
		btnSalvarChamado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfcolaborador.getText().equals("") || tfassunto.getText().equals("")						
						|| tfdescricao.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha Todos os Campos ");
				} else {
					JOptionPane.showMessageDialog(null, "Cadastrando Novo Chamado ");
					salvarChamado salve = new salvarChamado();
					salve.salvachamado();
					listarChamado lista = new listarChamado();
					lista.listachamado();
					dispose();
				}
			}
		});
		btnSalvarChamado.setBounds(369, 231, 176, 23);
		contentPane.add(btnSalvarChamado);

		JButton btnLimpar_1 = new JButton("Limpar");
		btnLimpar_1.setBackground(new Color(100, 149, 237));
		btnLimpar_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tfcolaborador.setText("");				
				tfassunto.setText("");
				tfdescricao.setText("");
				cbsituacao.setSelectedIndex(0);
				cbprioridade.setSelectedIndex(0);
				tfcolaborador.requestFocus();
			}
		});
		btnLimpar_1.setBounds(548, 231, 182, 23);
		contentPane.add(btnLimpar_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 268, 740, 2);
		contentPane.add(separator_1);

		JLabel lblDepartamento = new JLabel("Dpto :");
		lblDepartamento.setBounds(432, 51, 36, 14);
		contentPane.add(lblDepartamento);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(10, 196, 46, 14);
		contentPane.add(lblStatus);
		
		tfstatus = new JTextField();
		tfstatus.setEditable(false);
		tfstatus.setText("ABERTO PELO COLABORADOR");
		tfstatus.setBounds(77, 194, 160, 20);
		contentPane.add(tfstatus);
		tfstatus.setColumns(10);
		
		tfdepartamento = new JTextField();
		tfdepartamento.setEditable(false);
		tfdepartamento.setBounds(473, 48, 259, 20);
		contentPane.add(tfdepartamento);
		tfdepartamento.setColumns(10);
		tfdepartamento.setText(listarchamado.tfdepacesso.getText());
		
		JLabel label = new JLabel("Setor Destino do Chamado :");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(396, 9, 182, 14);
		contentPane.add(label);
		
		tfsetordestinochamado = new JTextField();
		tfsetordestinochamado.setText((String) null);
		tfsetordestinochamado.setForeground(Color.RED);
		tfsetordestinochamado.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfsetordestinochamado.setEditable(false);
		tfsetordestinochamado.setColumns(10);
		tfsetordestinochamado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfsetordestinochamado.setBounds(578, 7, 153, 20);
		tfsetordestinochamado.setText(listarchamado.cbsetorlista.getSelectedItem().toString());
		contentPane.add(tfsetordestinochamado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(277, 83, 452, 133);
		contentPane.add(scrollPane);
		
		tfdescricao = new JTextArea();
		tfdescricao.setLineWrap(true);
		scrollPane.setViewportView(tfdescricao);
		tfdescricao.setDocument(new UpperCaseDocument());
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo :");
		lblPerodo.setBounds(9, 233, 46, 14);
		contentPane.add(lblPerodo);
		
		Date d1 = new Date();

		Locale local1 = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM/yy", local1);
		tfperiodo = new JTextField();
		tfperiodo.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfperiodo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfperiodo.setEditable(false);
		tfperiodo.setBounds(76, 228, 161, 20);
		contentPane.add(tfperiodo);
		tfperiodo.setColumns(10);
		tfperiodo.setDocument(new UpperCaseDocument());
		tfperiodo.setText(sdf1.format(d1));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				
				File som = new File("//192.168.254.17/Chamados/mensagem.wav");
				Som playSom = new Som();
				playSom.playwav(som);
			}});
		btnNewButton.setBounds(263, 230, 89, 23);
		contentPane.add(btnNewButton);
		
		setLocationRelativeTo(null); // tela sempre no centro
		
		salvarChamado retorna = new salvarChamado();
		retorna.retornanumero();
		
		disableKeys(tfdescricao.getInputMap(),new String[]{"ENTER"}); //desabilitar a tecla enter

	}
}
