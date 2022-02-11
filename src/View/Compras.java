package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.Conectar;
import Model.listarChamado;
import Model.listarCompras;
import Model.salvarChamado;
import Model.salvarCompras;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Compras extends JFrame {

	private JPanel contentPane;
	public static JTable table;
	public static JTextField tfsolicitacompra;
	public static JTextField tfdatacompra;
	public static JTextField tfdestinocompra;
	public static JTextField tfdepcompras;
	public static JTextField tfnumsolicitacao;
	public static JComboBox cbsituacaosolicita;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual do Windows
					Compras frame = new Compras();
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
	public Compras() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Compras.class.getResource("/Imagem/suporte.png")));
		setTitle(" SOLICITA\u00C7\u00C3O DE COMPRAS  -  Formul\u00E1rio de Solicita\u00E7\u00E3o Para Cota\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 918, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 36, 912, 2);
		contentPane.add(separator);
		
		JLabel lblSolicitante = new JLabel("Solicitante :");
		lblSolicitante.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSolicitante.setBounds(10, 46, 82, 14);
		contentPane.add(lblSolicitante);
		
		JLabel lblData = new JLabel("Data :");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setBounds(187, 46, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblDepartamento = new JLabel("Departamento :");
		lblDepartamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartamento.setBounds(307, 46, 96, 14);
		contentPane.add(lblDepartamento);
		
		JLabel lblDestinoDaMercadoria = new JLabel("Destino da Mercadoria / Servi\u00E7o :");
		lblDestinoDaMercadoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDestinoDaMercadoria.setBounds(590, 46, 193, 14);
		contentPane.add(lblDestinoDaMercadoria);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 71, 912, 2);
		contentPane.add(separator_1);
		
		JLabel lblDadosDoProduto = new JLabel("DADOS DO PRODUTO / SERVI\u00C7O");
		lblDadosDoProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosDoProduto.setBounds(365, 84, 198, 14);
		contentPane.add(lblDadosDoProduto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 892, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00BA Pedido", "Descri\u00E7\u00E3o do Produto / Servi\u00E7o", "Necessidade", "Referencias", "Aplica\u00E7\u00E3o", "Tamanho", "Quantidade", "Obs."
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(181);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(51);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(58);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(55);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(48);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(153);
		scrollPane.setViewportView(table);		
		
		JLabel lblInformativo = new JLabel("INFORMATIVO");
		lblInformativo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInformativo.setBounds(10, 470, 98, 16);
		contentPane.add(lblInformativo);
		
		JTextArea txtrTodaSolicitaoTer = new JTextArea();
		txtrTodaSolicitaoTer.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtrTodaSolicitaoTer.setLineWrap(true);
		txtrTodaSolicitaoTer.setText("Toda solicita\u00E7\u00E3o ter\u00E1 que ter todas as informa\u00E7\u00F5es poss\u00EDveis para que a cota\u00E7\u00E3o seja precisa. EX: PARA SOLICITA\u00C7\u00C3O DE UM REFRIGERANTE , VOC\u00CA PRECISA INFORMAR: MARCA, SABOR, TAMANHO, QUANTIDADE.");
		txtrTodaSolicitaoTer.setEditable(false);
		txtrTodaSolicitaoTer.setBounds(118, 467, 638, 59);
		contentPane.add(txtrTodaSolicitaoTer);
		
		tfsolicitacompra = new JTextField();
		tfsolicitacompra.setBounds(85, 44, 86, 20);
		contentPane.add(tfsolicitacompra);
		tfsolicitacompra.setColumns(10);
		
		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);
		tfdatacompra = new JTextField();
		tfdatacompra.setBounds(226, 44, 65, 20);
		contentPane.add(tfdatacompra);
		tfdatacompra.setColumns(10);
		tfdatacompra.setText(sdf.format(d));
		
		tfdestinocompra = new JTextField();
		tfdestinocompra.setBounds(783, 44, 119, 20);
		contentPane.add(tfdestinocompra);
		tfdestinocompra.setColumns(10);
		
		JButton btnNewButton = new JButton("Inserir Linha");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel nada = (DefaultTableModel) table.getModel();

				 nada.addRow(new Object[]{null,null});
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(616, 83, 140, 23);
		contentPane.add(btnNewButton);
		
		tfdepcompras = new JTextField();
		tfdepcompras.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfdepcompras.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfdepcompras.setEditable(false);
		tfdepcompras.setBounds(404, 43, 176, 20);
		contentPane.add(tfdepcompras);
		tfdepcompras.setColumns(10);
		tfdepcompras.setText(acessar.cbdepacessar.getSelectedItem().toString());
		
		JLabel lblNmeroDaSolicitao = new JLabel("N\u00FAmero da Solicita\u00E7\u00E3o : ");
		lblNmeroDaSolicitao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNmeroDaSolicitao.setBounds(10, 11, 140, 14);
		contentPane.add(lblNmeroDaSolicitao);
		
		tfnumsolicitacao = new JTextField();
		tfnumsolicitacao.setEditable(false);
		tfnumsolicitacao.setBounds(153, 8, 86, 20);
		contentPane.add(tfnumsolicitacao);
		tfnumsolicitacao.setColumns(10);
		
		JButton btnRemover = new JButton("Remover Linha");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		        if (table.getSelectedRow() >= 0){
		            dtm.removeRow(table.getSelectedRow());
		            table.setModel(dtm);
		        }else{
		            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
		        }
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBounds(762, 83, 140, 23);
		contentPane.add(btnRemover);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o :");
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(281, 11, 65, 14);
		contentPane.add(lblSituao);
		
		cbsituacaosolicita = new JComboBox();
		cbsituacaosolicita.setModel(new DefaultComboBoxModel(new String[] {"ABERTO", "FECHADO", "EM ANDAMENTO"}));
		cbsituacaosolicita.setBounds(345, 8, 119, 20);
		contentPane.add(cbsituacaosolicita);
		
		JButton btnNewButton_1 = new JButton("<html><center>SALVAR<br/>SOLICITA\u00C7\u00C3O</center></html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tfdatacompra.getText().equals("") || tfdepcompras.getText().equals("")						
						|| tfdestinocompra.getText().equals("") || tfsolicitacompra.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha Todos os Campos ");
				} else {
					JOptionPane.showMessageDialog(null, "Cadastrando Nova Solicitação de Compras ");
					salvarCompras solicita = new salvarCompras();
					solicita.salvacompras();
//					listarChamado lista = new listarChamado();
//					lista.listachamado();
					dispose();			
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(766, 467, 136, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listarCompras list = new listarCompras();
				list.listarnumcompras();
			}
		});
		btnNewButton_2.setBounds(20, 81, 89, 23);
		contentPane.add(btnNewButton_2);
		
		salvarCompras solicita = new salvarCompras();
		solicita.retornanumero();
		
		listarCompras list = new listarCompras();
		list.listarnumcompras();
	}
}
