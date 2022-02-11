package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Controller.SplashScreen;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class acessar extends JFrame {

	private JPanel contentPane;
	public static JComboBox cbdepacessar;
	private JPasswordField tfsenhaacesso;
	private JLabel lblDepartamento;
	private JLabel lblSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// Visual do Windows
					acessar frame = new acessar();
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
	public acessar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(acessar.class.getResource("/Imagem/suporte.png")));
		setTitle(" ACESSO");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 287, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro
		
		JButton btnAcessar = new JButton("ACESSAR");
		btnAcessar.setToolTipText("Para Acessar o Sistema Informar Departamento e Senha ");
		btnAcessar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cbdepacessar.getSelectedItem().equals("ESCOLHA UM DEPARTAMENTO")){
					JOptionPane.showMessageDialog(null, "ESCOLHA UM DEPARTAMENTO VÁLIDO");
					tfsenhaacesso.setText("");
				}
				else if(tfsenhaacesso.getText().equals(cbdepacessar.getSelectedItem())){					
					Principal frame = new Principal();
					frame.setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Digite a Senha Correta");
					tfsenhaacesso.setText("");
					tfsenhaacesso.requestFocus();					
				}				
			}
		});
		btnAcessar.setBounds(10, 312, 261, 23);
		contentPane.add(btnAcessar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setIcon(new ImageIcon(acessar.class.getResource("/Imagem/acesso.png")));
		lblNewLabel.setBounds(10, 12, 261, 194);
		contentPane.add(lblNewLabel);
		
		cbdepacessar = new JComboBox();
		cbdepacessar.setToolTipText("Informe Seu Departamento Para Acessar o Sistema");
		cbdepacessar.setModel(new DefaultComboBoxModel(new String[] {"ESCOLHA UM DEPARTAMENTO", "RECEP\u00C7\u00C3O", "SEG. TRABALHO", "DP", "LOGISTICA", "COMPRAS", "PCONTAS", "OPERACIONAL", "FARDAMENTO", "FINANCEIRO", "ADMINISTRATIVO", "PRESIDENCIA", "COMERCIAL", "OPERACIONAL ESTADOS", "ATENDIMENTO", "RH", "ARQUIVO", "JURIDICO", "PONTO"}));
		cbdepacessar.setBounds(10, 236, 261, 20);
		contentPane.add(cbdepacessar);
		
		tfsenhaacesso = new JPasswordField();
		tfsenhaacesso.setToolTipText("Repetir o Departamento Escolhido");
		tfsenhaacesso.setBounds(10, 281, 261, 20);
		tfsenhaacesso.setDocument(new UpperCaseDocument());
		contentPane.add(tfsenhaacesso);
		
		lblDepartamento = new JLabel("Departamento :");
		lblDepartamento.setBounds(10, 217, 81, 14);
		contentPane.add(lblDepartamento);
		
		lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(10, 263, 46, 14);
		contentPane.add(lblSenha);
	}
}
