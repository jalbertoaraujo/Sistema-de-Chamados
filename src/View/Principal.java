package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Metodo;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;
	public static JLabel lbqtdechamado;
	public static JLabel lbqtdechamadoencerrado;
	public static JLabel lbqtdechamadoemandamento;
	public static JLabel lbqtdechamadofechado;

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
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagem/suporte.png")));
		setResizable(false);
		setTitle(" SISTEMA DE CHAMADOS ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro

		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/Imagem/entrar.png")));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setVerticalTextPosition (SwingConstants.BOTTOM);
		btnNewButton.setHorizontalTextPosition (SwingConstants.CENTER);		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				listarchamado frame = new listarchamado();
				frame.setVisible(true);
			}
		});

		JButton btnNovaSugesto = new JButton("SUGEST\u00C3O");
		btnNovaSugesto.setIcon(new ImageIcon(Principal.class.getResource("/Imagem/sugestao.png")));
		btnNovaSugesto.setForeground(Color.BLACK);
		btnNovaSugesto.setBackground(UIManager.getColor("Button.background"));
		btnNovaSugesto.setVerticalTextPosition (SwingConstants.BOTTOM);
		btnNovaSugesto.setHorizontalTextPosition (SwingConstants.CENTER);	
		btnNovaSugesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sugestao sugest = new sugestao();
				sugest.setVisible(true);
			}
		});
		
		JButton btnReserva = new JButton("RESERVA");
		btnReserva.setIcon(new ImageIcon(Principal.class.getResource("/Imagem/projetor.png")));
		btnReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Reserva frame = new Reserva();
				frame.setVisible(true);
			}
		});
		btnReserva.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReserva.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReserva.setForeground(Color.BLACK);
		btnReserva.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReserva.setBackground(UIManager.getColor("Button.background"));
		btnReserva.setBounds(381, 357, 133, 107);
		contentPane.add(btnReserva);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Principal.class.getResource("/Imagem/Logosoll sem fun - C\u00F3pia.png")));
		lblNewLabel_2.setBounds(280, 73, 499, 234);
		contentPane.add(lblNewLabel_2);

		JLabel lblBemVindoAo = new JLabel("BEM VINDO AO SISTEMA DE CHAMADOS ");
		lblBemVindoAo.setForeground(Color.DARK_GRAY);
		lblBemVindoAo.setFont(new Font("Arial", Font.BOLD, 38));
		lblBemVindoAo.setBounds(17, 11, 776, 44);
		contentPane.add(lblBemVindoAo);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 472, 794, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		lbqtdechamado = new JLabel("");
		lbqtdechamado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbqtdechamado.setForeground(new Color(0, 128, 128));
		lbqtdechamado.setFont(new Font("Arial", Font.BOLD, 16));
		lbqtdechamado.setBounds(83, 22, 70, 25);
		panel.add(lbqtdechamado);

		JLabel lblChamadosAbertos = new JLabel("ABERTOS");
		lblChamadosAbertos.setForeground(new Color(34, 139, 34));
		lblChamadosAbertos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChamadosAbertos.setBounds(10, 29, 75, 14);
		panel.add(lblChamadosAbertos);

		JLabel lblChamadosFechados = new JLabel("ENCERRADOS");
		lblChamadosFechados.setForeground(new Color(255, 0, 0));
		lblChamadosFechados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChamadosFechados.setBounds(615, 29, 104, 14);
		panel.add(lblChamadosFechados);

		lbqtdechamadoencerrado = new JLabel("");
		lbqtdechamadoencerrado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbqtdechamadoencerrado.setForeground(Color.RED);
		lbqtdechamadoencerrado.setFont(new Font("Arial", Font.BOLD, 16));
		lbqtdechamadoencerrado.setBounds(717, 22, 70, 25);
		panel.add(lbqtdechamadoencerrado);

		JLabel lblChamadosEmAndamento = new JLabel("EM ANDAMENTO");
		lblChamadosEmAndamento.setForeground(new Color(255, 215, 0));
		lblChamadosEmAndamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChamadosEmAndamento.setBounds(386, 29, 124, 14);
		panel.add(lblChamadosEmAndamento);

		lbqtdechamadoemandamento = new JLabel("");
		lbqtdechamadoemandamento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbqtdechamadoemandamento.setForeground(new Color(255, 215, 0));
		lbqtdechamadoemandamento.setFont(new Font("Arial", Font.BOLD, 16));
		lbqtdechamadoemandamento.setBounds(509, 22, 70, 25);
		panel.add(lbqtdechamadoemandamento);
		
		JLabel lblFechados = new JLabel("FECHADOS");
		lblFechados.setForeground(new Color(30, 144, 255));
		lblFechados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechados.setBounds(193, 28, 84, 14);
		panel.add(lblFechados);
		
		lbqtdechamadofechado = new JLabel("");
		lbqtdechamadofechado.setForeground(new Color(0, 128, 128));
		lbqtdechamadofechado.setFont(new Font("Arial", Font.BOLD, 16));
		lbqtdechamadofechado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbqtdechamadofechado.setBounds(276, 22, 70, 25);
		panel.add(lbqtdechamadofechado);
		
		JLabel label = new JLabel("Situa\u00E7\u00E3o dos Chamados Para o T.I.");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(5, 5, 203, 14);
		panel.add(label);
		btnNovaSugesto.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNovaSugesto.setBounds(651, 357, 133, 106);
		contentPane.add(btnNovaSugesto);
		btnNewButton.setBounds(516, 357, 133, 107);
		contentPane.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 520, 794, 22);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblDesenvolvidoPorJorge = new JLabel("Desenvolvido por Jorge Alberto");
		lblDesenvolvidoPorJorge.setForeground(new Color(255, 255, 255));
		lblDesenvolvidoPorJorge.setFont(new Font("Arial", Font.BOLD, 9));
		lblDesenvolvidoPorJorge.setBounds(641, 5, 150, 14);
		panel_1.add(lblDesenvolvidoPorJorge);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Imagem/suporte-tecnico.png")));
		lblNewLabel.setBounds(2, 133, 335, 350);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/Imagem/plano.jpg")));
		lblNewLabel_1.setBounds(0, 0, 794, 471);
		contentPane.add(lblNewLabel_1);

		Metodo met = new Metodo();
		met.lbchamadoaberto();
		met.lbchamadoencerrado();
		met.lbchamadoemandamento();
		met.lbchamadofechado();
	}
}
