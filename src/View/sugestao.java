package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Controller.Indentificador;
import Model.salvaSugestao;
import java.awt.Toolkit;
import java.awt.SystemColor;


public class sugestao extends JFrame {

	private JPanel contentPane;
	public static JTextArea tasugestao;
	public static JTextField tfindentificador;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//Visual do Windows
					sugestao frame = new sugestao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public sugestao() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(sugestao.class.getResource("/Imagem/suporte.png")));
		setTitle(" ENVIAR NOVA SUGEST\u00C3O");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalvarChamado = new JButton("ENVIAR SUGEST\u00C3O");
		btnSalvarChamado.setBackground(new Color(102, 205, 170));
		btnSalvarChamado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		if(tasugestao.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Preencha o Campo Para Enviar Uma Nova Sugestão");
		}else{
			Indentificador id = new Indentificador();
			id.indentifica();
			salvaSugestao salva = new salvaSugestao();
			salva.salvarsugestao();				
			}				
		}
		});
		btnSalvarChamado.setBounds(554, 169, 176, 23);
		contentPane.add(btnSalvarChamado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 720, 147);
		contentPane.add(scrollPane);
		
		tasugestao = new JTextArea();
		tasugestao.setLineWrap(true);
		tasugestao.setFont(new Font("Arial", Font.BOLD, 14));
		scrollPane.setViewportView(tasugestao);
		tasugestao.setDocument(new UpperCaseDocument());
		
		tfindentificador = new JTextField();
		tfindentificador.setBounds(10, 170, 86, 20);
		contentPane.add(tfindentificador);
		tfindentificador.setColumns(10);
		
		JButton btnListarSugesto = new JButton("LISTAR SUGEST\u00C3O");
		btnListarSugesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				senha sen = new senha();
				sen.setVisible(true);
			}
		});
		btnListarSugesto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListarSugesto.setBackground(SystemColor.desktop);
		btnListarSugesto.setBounds(374, 169, 176, 23);
		contentPane.add(btnListarSugesto);
		tfindentificador.setVisible(true);
		setLocationRelativeTo(null);  // tela sempre no centro
		
		Indentificador id = new Indentificador();
		id.indentifica();
		
	}
}
