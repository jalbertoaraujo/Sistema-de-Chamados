package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

public class Info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual do Windows
					Info frame = new Info();
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
	public Info() {
		setResizable(false);
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Info.class.getResource("/Imagem/exclamacao.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 261, 209);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Info.class.getResource("/Imagem/excla.png")));
		lblNewLabel.setBounds(152, 71, 91, 101);
		contentPane.add(lblNewLabel);
		
		JLabel lblAteno = new JLabel("ATEN\u00C7\u00C3O");
		lblAteno.setForeground(Color.RED);
		lblAteno.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAteno.setBounds(153, 40, 90, 35);
		contentPane.add(lblAteno);
		
		JLabel lblOProjetorSeguir = new JLabel("O PROJETOR SEGUIR\u00C1 COM OS ITENS :");
		lblOProjetorSeguir.setForeground(Color.BLACK);
		lblOProjetorSeguir.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOProjetorSeguir.setBounds(10, 0, 243, 25);
		contentPane.add(lblOProjetorSeguir);
		
		JLabel lblProjetor = new JLabel("- PROJETOR");
		lblProjetor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProjetor.setForeground(Color.BLACK);
		lblProjetor.setBounds(10, 39, 73, 14);
		contentPane.add(lblProjetor);
		
		JLabel lblCaboDe = new JLabel("- CABO DE FOR\u00C7A");
		lblCaboDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCaboDe.setForeground(Color.BLACK);
		lblCaboDe.setBounds(11, 64, 107, 14);
		contentPane.add(lblCaboDe);
		
		JLabel lblCaboVga = new JLabel("- CABO VGA");
		lblCaboVga.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCaboVga.setForeground(Color.BLACK);
		lblCaboVga.setBounds(11, 89, 73, 14);
		contentPane.add(lblCaboVga);
		
		JLabel lblCaboHdmi = new JLabel("- CABO HDMI");
		lblCaboHdmi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCaboHdmi.setForeground(Color.BLACK);
		lblCaboHdmi.setBounds(11, 114, 90, 14);
		contentPane.add(lblCaboHdmi);
		
		JLabel lblExtenoBranca = new JLabel("- EXTENS\u00C3O BRANCA");
		lblExtenoBranca.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExtenoBranca.setForeground(Color.BLACK);
		lblExtenoBranca.setBounds(11, 139, 125, 14);
		contentPane.add(lblExtenoBranca);
		
		JLabel lblFiltroDe = new JLabel("- FILTRO DE LINHA");
		lblFiltroDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFiltroDe.setForeground(Color.BLACK);
		lblFiltroDe.setBounds(11, 164, 107, 14);
		contentPane.add(lblFiltroDe);
	}
}
