package uteis;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import View.Reserva;
import View.alterarchamado;

public class ColorirTabela3 extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @Override public Component getTableCellRendererComponent(JTable table,
	 * Object value, boolean isSelected, boolean hasFocus, int row, int column)
	 * { JLabel label = (JLabel) super.getTableCellRendererComponent(table,
	 * value, isSelected, hasFocus, row, column); Color c = Color.WHITE; Object
	 * text = table.getValueAt(row, 3); if (text != null &&
	 * "VERMELHO".equals(text.toString())) c = Color.RED;
	 * label.setBackground(c); return label; }
	 */

	@Override
	public Component getTableCellRendererComponent(JTable tabelareserva, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		Component renderer = (JLabel) super.getTableCellRendererComponent(tabelareserva, value, isSelected, hasFocus,
				row, column);

		Color fundo = null;
		Color fonte = null;

		Object text = tabelareserva.getValueAt(row, 10);

		if (text != null && text.equals("ATENDIDO")) {

			fundo = Color.GRAY;
			fonte = Color.WHITE;

		} else if (text != null && text.equals("CANCELADO")) {

			fundo = Color.GRAY;
			fonte = Color.WHITE;

		} else if (text != null && text.equals("EM ESPERA")) {

			fundo = Color.GREEN;
			fonte = Color.BLACK;

		} else {

			fundo = Color.RED;
			fonte = Color.WHITE;

		}
		if (isSelected) {

			fundo = Color.BLUE;
			fonte = Color.WHITE;
		}

		renderer.setBackground(fundo);
		renderer.setForeground(fonte);

		return renderer;
	}

}
