package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Metodo;
import Model.salvarChamado;
import Model.salvarCompras;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCompras extends JFrame {

	private JPanel contentPane;
	public static JTextField tfnumsolicitacao;
	public static JTextField tfsolicitacompra;
	public static JTextField tfdatacompra;
	public static JTextField tfdepcompras;
	public static JTextField tfdestinocompra;
	public static JTextField tfdescricao;
	public static JTextField tfnecessidade;
	public static JTextField tfreferencia;
	public static JTextField tfaplicacao;
	public static JTextField tftamanho;
	public static JTextField tfquantidade;
	public static JTextField tfobs;
	public static JComboBox cbsituacaosolicita;
	public static JTextField tfstatus;
	public static JPanel panel;
	public static JTextField tfidpedido;
	public static JTextField tfsetorcompras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual do Windows
					TelaCompras frame = new TelaCompras();
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
	public TelaCompras() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCompras.class.getResource("/Imagem/suporte.png")));
		setTitle("  SOLICITA\u00C7\u00C3O DE COMPRAS  -  Formul\u00E1rio de Solicita\u00E7\u00E3o Para Cota\u00E7\u00E3o");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 919, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(145, 111, 622, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDescrioDoProduto = new JLabel("Descri\u00E7\u00E3o do Produto / Servi\u00E7o :");
		lblDescrioDoProduto.setBounds(10, 13, 207, 14);
		panel.add(lblDescrioDoProduto);
		lblDescrioDoProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfdescricao = new JTextField();
		tfdescricao.setBounds(220, 11, 388, 20);
		panel.add(tfdescricao);
		tfdescricao.setColumns(10);
		tfdescricao.setDocument(new UpperCaseDocument());
		
		JLabel lblNecessidade = new JLabel("Necessidade  :");
		lblNecessidade.setBounds(124, 40, 86, 14);
		panel.add(lblNecessidade);
		lblNecessidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfnecessidade = new JTextField();
		tfnecessidade.setBounds(220, 37, 388, 20);
		panel.add(tfnecessidade);
		tfnecessidade.setColumns(10);
		tfnecessidade.setDocument(new UpperCaseDocument());
		
		JLabel lblReferncias = new JLabel("Refer\u00EAncias :");
		lblReferncias.setBounds(130, 66, 86, 14);
		panel.add(lblReferncias);
		lblReferncias.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfreferencia = new JTextField();
		tfreferencia.setBounds(220, 63, 388, 20);
		panel.add(tfreferencia);
		tfreferencia.setColumns(10);
		tfreferencia.setDocument(new UpperCaseDocument());
		
		JLabel lblAplicao = new JLabel("Aplica\u00E7\u00E3o :");
		lblAplicao.setBounds(145, 91, 72, 14);
		panel.add(lblAplicao);
		lblAplicao.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfaplicacao = new JTextField();
		tfaplicacao.setBounds(220, 89, 388, 20);
		panel.add(tfaplicacao);
		tfaplicacao.setColumns(10);
		tfaplicacao.setDocument(new UpperCaseDocument());
		
		JLabel lblTamanho = new JLabel("Tamanho :");
		lblTamanho.setBounds(145, 118, 65, 14);
		panel.add(lblTamanho);
		lblTamanho.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tftamanho = new JTextField();
		tftamanho.setBounds(220, 115, 388, 20);
		panel.add(tftamanho);
		tftamanho.setColumns(10);
		tftamanho.setDocument(new UpperCaseDocument());
		
		JLabel lblQuantidade = new JLabel("Quantidade :");
		lblQuantidade.setBounds(130, 144, 82, 14);
		panel.add(lblQuantidade);
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfquantidade = new JTextField();
		tfquantidade.setBounds(220, 141, 388, 20);
		panel.add(tfquantidade);
		tfquantidade.setColumns(10);
		tfquantidade.setDocument(new UpperCaseDocument());
		
		JLabel lblObs = new JLabel("Obs.:");
		lblObs.setBounds(177, 169, 38, 14);
		panel.add(lblObs);
		lblObs.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tfobs = new JTextField();
		tfobs.setBounds(220, 167, 388, 20);
		panel.add(tfobs);
		tfobs.setColumns(10);
		tfobs.setDocument(new UpperCaseDocument());
		
		JLabel label = new JLabel("N\u00FAmero da Solicita\u00E7\u00E3o : ");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 14, 140, 14);
		contentPane.add(label);
		
		tfnumsolicitacao = new JTextField();
		tfnumsolicitacao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfnumsolicitacao.setEditable(false);
		tfnumsolicitacao.setColumns(10);
		tfnumsolicitacao.setBounds(151, 11, 86, 20);
		contentPane.add(tfnumsolicitacao);
		
		JLabel label_1 = new JLabel("Situa\u00E7\u00E3o :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(281, 14, 65, 14);
		contentPane.add(label_1);
		
		cbsituacaosolicita = new JComboBox();
		cbsituacaosolicita.setModel(new DefaultComboBoxModel(new String[] {"ABERTO", "FECHADO", "EM ANDAMENTO"}));
		cbsituacaosolicita.setBounds(345, 11, 119, 20);
		contentPane.add(cbsituacaosolicita);
		
		JLabel label_2 = new JLabel("Solicitante :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 49, 82, 14);
		contentPane.add(label_2);
		
		tfsolicitacompra = new JTextField();
		tfsolicitacompra.setColumns(10);
		tfsolicitacompra.setBounds(85, 47, 86, 20);
		contentPane.add(tfsolicitacompra);
		tfsolicitacompra.setDocument(new UpperCaseDocument());
		
		JLabel label_3 = new JLabel("Data :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(187, 49, 46, 14);
		contentPane.add(label_3);
		
		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);
		
		tfdatacompra = new JTextField();
		tfdatacompra.setEditable(false);
		tfdatacompra.setColumns(10);
		tfdatacompra.setBounds(226, 47, 65, 20);
		contentPane.add(tfdatacompra);
		tfdatacompra.setText(sdf.format(d));
		
		JLabel label_4 = new JLabel("Departamento :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(307, 49, 96, 14);
		contentPane.add(label_4);
		
		tfdepcompras = new JTextField();
		tfdepcompras.setText((String) null);
		tfdepcompras.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfdepcompras.setEditable(false);
		tfdepcompras.setColumns(10);
		tfdepcompras.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfdepcompras.setBounds(404, 46, 176, 20);
		contentPane.add(tfdepcompras);
		tfdepcompras.setText(acessar.cbdepacessar.getSelectedItem().toString());
		
		JLabel label_5 = new JLabel("Destino da Mercadoria / Servi\u00E7o :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(590, 49, 193, 14);
		contentPane.add(label_5);
		
		tfdestinocompra = new JTextField();
		tfdestinocompra.setColumns(10);
		tfdestinocompra.setBounds(783, 47, 119, 20);
		contentPane.add(tfdestinocompra);
		tfdestinocompra.setDocument(new UpperCaseDocument());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 75, 912, 2);
		contentPane.add(separator);
		
		JLabel label_6 = new JLabel("DADOS DO PRODUTO / SERVI\u00C7O");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(361, 86, 198, 14);
		contentPane.add(label_6);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 369, 912, 2);
		contentPane.add(separator_1);
		
		JButton btnsalvar = new JButton("Salvar");
		btnsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				salvarCompras salvar = new salvarCompras();
				salvar.salvacompras();
			}
		});
		btnsalvar.setBounds(666, 324, 89, 23);
		contentPane.add(btnsalvar);
		
		JButton btnlimpar = new JButton("Limpar");
		btnlimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 TelaCompras.tfdescricao.setText("");
				 TelaCompras.tfnecessidade.setText("");
				 TelaCompras.tfreferencia.setText("");
				 TelaCompras.tfaplicacao.setText("");
				 TelaCompras.tftamanho.setText("");
				 TelaCompras.tfquantidade.setText("");
				 TelaCompras.tfobs.setText("");	
				 TelaCompras.tfdescricao.requestFocus();
				
			}
		});
		btnlimpar.setBounds(567, 324, 89, 23);
		contentPane.add(btnlimpar);
		
		JLabel label_7 = new JLabel("Status :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(511, 14, 46, 14);
		contentPane.add(label_7);
		
		tfstatus = new JTextField();
		tfstatus.setText("ABERTO PELO COLABORADOR");
		tfstatus.setEditable(false);
		tfstatus.setColumns(10);
		tfstatus.setBounds(558, 12, 160, 20);
		contentPane.add(tfstatus);
		
		tfidpedido = new JTextField();
		tfidpedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfidpedido.setEditable(false);
		tfidpedido.setBounds(804, 88, 86, 20);
		contentPane.add(tfidpedido);
		tfidpedido.setColumns(10);
		
		tfsetorcompras = new JTextField();
		tfsetorcompras.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfsetorcompras.setFont(new Font("Tahoma", Font.PLAIN, 8));
		tfsetorcompras.setEditable(false);
		tfsetorcompras.setBounds(804, 11, 98, 20);
		contentPane.add(tfsetorcompras);
		tfsetorcompras.setColumns(10);
		tfsetorcompras.setText(listarchamado.cbsetorlista.getSelectedItem().toString());
		
		JLabel lblSetor = new JLabel("Setor :");
		lblSetor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSetor.setBounds(760, 14, 46, 14);
		contentPane.add(lblSetor);
		tfidpedido.setVisible(false);
		
		salvarCompras retorna = new salvarCompras();
		retorna.retornanumero();
		
//		Metodo met = new Metodo();
//		met.cbdescricaoproduto();		
		
	}
}
