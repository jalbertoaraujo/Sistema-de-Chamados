package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaHistorico extends JFrame {

	private JPanel contentPane;
	public static JTextField tfhistoricodatahora;
	public static JTextField tfhistoricoresponsavel;
	public static JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHistorico frame = new TelaHistorico();
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
	public TelaHistorico() {
		setTitle(" HIST\u00D3RICO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaHistorico.class.getResource("/Imagem/suporte.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataHora = new JLabel("Data / Hora :");
		lblDataHora.setBounds(10, 11, 84, 14);
		contentPane.add(lblDataHora);
		
		JLabel lblResponsvel = new JLabel("Respons\u00E1vel : ");
		lblResponsvel.setBounds(10, 51, 84, 14);
		contentPane.add(lblResponsvel);
		
		JLabel lblHistricoDoChamado = new JLabel("Hist\u00F3rico do Chamado :");
		lblHistricoDoChamado.setBounds(10, 90, 121, 14);
		contentPane.add(lblHistricoDoChamado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 414, 136);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		tfhistoricodatahora = new JTextField();
		tfhistoricodatahora.setEditable(false);
		tfhistoricodatahora.setBounds(125, 8, 299, 20);
		contentPane.add(tfhistoricodatahora);
		tfhistoricodatahora.setColumns(10);
		
		tfhistoricoresponsavel = new JTextField();
		tfhistoricoresponsavel.setEditable(false);
		tfhistoricoresponsavel.setBounds(125, 48, 299, 20);
		contentPane.add(tfhistoricoresponsavel);
		tfhistoricoresponsavel.setColumns(10);
	}
}
