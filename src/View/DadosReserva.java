package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.listaReserva;

import Model.salvarReserva;
import uteis.UpperCaseDocument;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DadosReserva extends JFrame {

	private JPanel contentPane;
	public static JTextField tfdiareserva;
	public static JTextField tfhorareserva;
	public static JTextField tfnomereserva;
	public static JTextField tflocalreserva;
	public static JTextField tfmesreserva;
	public static JComboBox cbnotereserva;
	public static JComboBox cbcxreserva;
	public static JTextField tfperiodoreserva;
	public static JTextField tfatendido;
	public static JTextField tfdepreserva;

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
					DadosReserva frame = new DadosReserva();
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
	public DadosReserva() {
		setTitle(" DADOS PARA RESERVA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DadosReserva.class.getResource("/Imagem/suporte.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 323, 310);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro

		JLabel lblDia = new JLabel("PER\u00CDODO");
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDia.setBounds(10, 58, 56, 14);
		contentPane.add(lblDia);

		JLabel lblData = new JLabel("DIA");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setBounds(10, 8, 46, 14);
		contentPane.add(lblData);

		JLabel lblHora = new JLabel("HORA");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHora.setBounds(10, 83, 46, 14);
		contentPane.add(lblHora);

		JLabel lblDepartamento = new JLabel("DEPARTAMENTO");
		lblDepartamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartamento.setBounds(10, 108, 95, 14);
		contentPane.add(lblDepartamento);

		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 158, 46, 14);
		contentPane.add(lblNome);

		tfdiareserva = new JTextField();
		tfdiareserva.setEditable(false);
		tfdiareserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfdiareserva.setBounds(115, 5, 145, 20);
		contentPane.add(tfdiareserva);
		tfdiareserva.setColumns(10);
		tfdiareserva.setText(Reserva.cbdiareserva.getSelectedItem().toString());
		// tfdiareserva.setDocument(new UpperCaseDocument());

		try {
			javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("##:##");
			tfhorareserva = new javax.swing.JFormattedTextField(mask);
		} catch (Exception e) {
		}
		// tfhorareserva = new JTextField();
		tfhorareserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfhorareserva.setBounds(115, 80, 145, 20);
		contentPane.add(tfhorareserva);
		tfhorareserva.setColumns(10);
		tfhorareserva.setDocument(new UpperCaseDocument());

		tfnomereserva = new JTextField();
		tfnomereserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfnomereserva.setBounds(115, 155, 196, 20);
		contentPane.add(tfnomereserva);
		tfnomereserva.setColumns(10);
		tfnomereserva.setDocument(new UpperCaseDocument());

		JButton btnNewButton = new JButton("LIMPAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tfnomereserva.setText("");
				
			}
		});
		btnNewButton.setBounds(115, 253, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("SALVAR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbnotereserva.getSelectedItem().equals("ESCOLHA A OPÇÃO")
						|| cbnotereserva.getSelectedItem().equals("-------------------")
						|| cbcxreserva.getSelectedItem().equals("ESCOLHA A OPÇÃO")
						|| cbcxreserva.getSelectedItem().equals("-------------------")) {
					JOptionPane.showMessageDialog(null, "INFORME OPÇÃO VÁLIDA");
				} else {
					salvarReserva sr = new salvarReserva();
					sr.salvarreserva();
					listaReserva lsr = new listaReserva();
					lsr.listareserva();
					Info info = new Info();
					info.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBounds(214, 253, 97, 23);
		contentPane.add(btnNewButton_1);

		tflocalreserva = new JTextField();
		tflocalreserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		tflocalreserva.setBounds(115, 130, 145, 20);
		contentPane.add(tflocalreserva);
		tflocalreserva.setColumns(10);
		tflocalreserva.setDocument(new UpperCaseDocument());

		JLabel lblLocal = new JLabel("LOCAL");
		lblLocal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLocal.setBounds(10, 133, 46, 14);
		contentPane.add(lblLocal);

		tfmesreserva = new JTextField();
		tfmesreserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfmesreserva.setEditable(false);
		tfmesreserva.setBounds(115, 30, 145, 20);
		contentPane.add(tfmesreserva);
		tfmesreserva.setColumns(10);
		tfmesreserva.setText(Reserva.cbmesreserva.getSelectedItem().toString());

		JLabel lblMs = new JLabel("M\u00CAS");
		lblMs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMs.setBounds(10, 33, 46, 14);
		contentPane.add(lblMs);

		JLabel lblNotebook = new JLabel("NOTEBOOK");
		lblNotebook.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotebook.setBounds(10, 183, 76, 14);
		contentPane.add(lblNotebook);

		cbnotereserva = new JComboBox();
		cbnotereserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbnotereserva.setModel(new DefaultComboBoxModel(
				new String[] { "ESCOLHA A OP\u00C7\u00C3O", "-------------------", "SIM", "N\u00C3O" }));
		cbnotereserva.setBounds(115, 180, 145, 20);
		contentPane.add(cbnotereserva);

		JLabel lblCxDeSom = new JLabel("CX. DE SOM");
		lblCxDeSom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCxDeSom.setBounds(10, 208, 76, 14);
		contentPane.add(lblCxDeSom);

		cbcxreserva = new JComboBox();
		cbcxreserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbcxreserva.setModel(new DefaultComboBoxModel(
				new String[] { "ESCOLHA A OP\u00C7\u00C3O", "-------------------", "SIM", "N\u00C3O" }));
		cbcxreserva.setBounds(115, 205, 145, 20);
		contentPane.add(cbcxreserva);

		tfperiodoreserva = new JTextField();
		tfperiodoreserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfperiodoreserva.setEditable(false);
		tfperiodoreserva.setBounds(115, 55, 145, 20);
		contentPane.add(tfperiodoreserva);
		tfperiodoreserva.setColumns(10);
		tfperiodoreserva.setText(Reserva.cbperiodoescolha.getSelectedItem().toString());

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Info info = new Info();
				info.setVisible(true);
			}
		});
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setIcon(new ImageIcon(DadosReserva.class.getResource("/Imagem/exclamacao.png")));
		btnNewButton_2.setBounds(282, 4, 32, 33);
		contentPane.add(btnNewButton_2);

		tfatendido = new JTextField();
		tfatendido.setEditable(false);
		tfatendido.setText("EM ESPERA");
		tfatendido.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfatendido.setColumns(10);
		tfatendido.setBounds(115, 229, 145, 20);
		contentPane.add(tfatendido);

		JLabel lblAtendido = new JLabel("ATENDIDO");
		lblAtendido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAtendido.setBounds(9, 232, 76, 14);
		contentPane.add(lblAtendido);
		
		tfdepreserva = new JTextField();
		tfdepreserva.setEditable(false);
		tfdepreserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfdepreserva.setBounds(115, 105, 196, 20);
		contentPane.add(tfdepreserva);
		tfdepreserva.setColumns(10);
		tfdepreserva.setText(acessar.cbdepacessar.getSelectedItem().toString());

	}
}
