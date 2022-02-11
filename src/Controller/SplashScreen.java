package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import View.acessar;

public class SplashScreen extends JWindow {

	private int duration;

	public SplashScreen(int d) {
		duration = d;
	}

	// Este é um método simples para mostrar uma tela de apresentção

	// no centro da tela durante a quantidade de tempo passada no construtor



	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Color.YELLOW);

		// Configura a posição e o tamanho da janela
		int width = 500;
		int height = 715;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		// Constrói o splash screen
		JLabel label = new JLabel(new ImageIcon("Imagem/splash2.jpg"));
		JLabel copyrt = new JLabel("<html><CENTER>ENCERRE<br>SEUS<br>CHAMADOS<br>FECHADOS<br>O<br>DEPARTAMENTO<br>DE<br>T.I.<br>AGRADECE !<br><br><CENTER></html>", JLabel.CENTER);
		copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 48));
		content.add(label, BorderLayout.CENTER);
		content.add(copyrt, BorderLayout.SOUTH);
		Color oraRed = new Color(0, 0, 0);
		content.setBorder(BorderFactory.createLineBorder(oraRed, 10));
		// Torna visível
		setVisible(true);

		// Espera ate que os recursos estejam carregados
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}
		setVisible(false);
	}

	public void showSplashAndExit() {
		showSplash();
		dispose();
		acessar acesso = new acessar();
		acesso.setVisible(true);
	}

	public static void main(String[] args) {
		// Mostra uma imagem com o título da aplicação
		SplashScreen splash = new SplashScreen(10000);
		splash.showSplashAndExit();		
	}
}