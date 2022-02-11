package uteis;

import View.TelaHistorico;
import View.alterarchamado;
import View.listarchamado;

public class AbrirTela {
	
	public void abretela(){
		
		alterarchamado alt = new alterarchamado();
		alt.setVisible(true);
		
		int indiceLinha = listarchamado.table.getSelectedRow();				
		
		alt.tfnumchamado.setText(listarchamado.table.getValueAt(indiceLinha, 0).toString());				
		alt.tfdatahora.setText(listarchamado.table.getValueAt(indiceLinha, 1).toString());
		alt.tfcolaborador.setText(listarchamado.table.getValueAt(indiceLinha, 2).toString());
		alt.tfdepartamento.setText(listarchamado.table.getValueAt(indiceLinha, 3).toString());
		alt.tfassunto.setText(listarchamado.table.getValueAt(indiceLinha, 4).toString());
		alt.tfdescricao.setText(listarchamado.table.getValueAt(indiceLinha, 5).toString());
		alt.cbsituacao.setSelectedItem(listarchamado.table.getValueAt(indiceLinha, 6).toString());				
		alt.cbprioridade.setSelectedItem(listarchamado.table.getValueAt(indiceLinha, 7).toString());
		alt.cbstatus.setSelectedItem(listarchamado.table.getValueAt(indiceLinha, 9).toString());
		
		if(alt.cbsituacao.getSelectedItem().equals("ENCERRADO")){
			alt.tfinfochamado.setEditable(false);
			alt.tfinforesponsavel.setEditable(false);
			alt.btnInserir.setEnabled(false);
			alt.btnLimpar.setEnabled(false);
			alt.cbstatus.setEnabled(false);
			alt.cbsituacao.setEnabled(false);
			alt.btnAlterarChamado.setEnabled(false);
			alt.tfnumchamado.setEnabled(false);
			alt.tfdatahora.setEnabled(false);
			alt.tfinfodatahora.setEnabled(false);
			alt.table.setEnabled(false);
		}
		
	}
	
	public void abrehistorico(){
		
		TelaHistorico tel = new TelaHistorico();
		tel.setVisible(true);
		
		int indiceLinha2 = alterarchamado.table.getSelectedRow();
		
		tel.tfhistoricodatahora.setText(alterarchamado.table.getValueAt(indiceLinha2, 1).toString());
		tel.tfhistoricoresponsavel.setText(alterarchamado.table.getValueAt(indiceLinha2, 2).toString());
		tel.textArea.setText(alterarchamado.table.getValueAt(indiceLinha2, 0).toString());
		
	}

}
