package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class senha extends JFrame {

	private JPanel contentPane;
	private JTextField tfusuario;
	private JPasswordField tfsenha;

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
					senha frame = new senha();
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
	public senha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(senha.class.getResource("/Imagem/suporte.png")));
		setResizable(false);
		setTitle(" ACESSO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 190, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 164, 116);
		panel.setBorder(new TitledBorder(

				""));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio :");
		lblUsurio.setBounds(10, 14, 46, 14);
		panel.add(lblUsurio);

		tfusuario = new JTextField();
		tfusuario.setBounds(66, 11, 86, 20);
		panel.add(tfusuario);
		tfusuario.setColumns(10);
		tfusuario.setDocument(new UpperCaseDocument());

		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(10, 45, 46, 14);
		panel.add(lblSenha);

		tfsenha = new JPasswordField();
		tfsenha.setBounds(66, 45, 86, 20);
		panel.add(tfsenha);

		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setBounds(10, 80, 142, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usuario = "RH";
				String senha = "@dmin";
				if (tfusuario.getText().equals(usuario) && tfsenha.getText().equals(senha)) {
					JOptionPane.showMessageDialog(null, "Dados Corretos, Abrindo a Lista de Sugestões!");
					listarsugestao lista = new listarsugestao();
					lista.setVisible(true);
					tfusuario.setText("");
					tfsenha.setText("");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Dados Incorretos, Favor Informar os Dados Corretos ");
					tfusuario.setText("");
					tfsenha.setText("");
					tfusuario.requestFocus();
				}
			}
		});
	}
}
