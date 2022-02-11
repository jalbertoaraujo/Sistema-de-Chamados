package uteis;

import javax.swing.JOptionPane;

import View.AlterarCompras;
import View.listarchamado;



public class AbrirTelaAlterarCompras {
	
	public void abrealterarcompras(){	
		
		AlterarCompras altcomp = new AlterarCompras();
		altcomp.setVisible(true);		
		
		int indiceLinha1 = listarchamado.table_1.getSelectedRow();				
		
		altcomp.tfalterarnumsolicita.setText(listarchamado.table_1.getValueAt(indiceLinha1, 0).toString());				
		altcomp.cbalterarsolicita.setSelectedItem(listarchamado.table_1.getValueAt(indiceLinha1, 1).toString());
		altcomp.tfalterarstatus.setText(listarchamado.table_1.getValueAt(indiceLinha1, 13).toString());
		altcomp.tfalterarsolicitante.setText(listarchamado.table_1.getValueAt(indiceLinha1, 2).toString());
		altcomp.tfalterardata.setText(listarchamado.table_1.getValueAt(indiceLinha1, 3).toString());
		altcomp.tfalterardepartamento.setText(listarchamado.table_1.getValueAt(indiceLinha1, 4).toString());
		altcomp.tfalterardestino.setText(listarchamado.table_1.getValueAt(indiceLinha1, 5).toString());
		altcomp.tfalterardescricao.setText(listarchamado.table_1.getValueAt(indiceLinha1, 6).toString());	
		altcomp.tfalterarnecessidade.setText(listarchamado.table_1.getValueAt(indiceLinha1, 7).toString());		
		altcomp.tfalterarreferencia.setText(listarchamado.table_1.getValueAt(indiceLinha1, 8).toString());
		altcomp.tfalteraraplicacao.setText(listarchamado.table_1.getValueAt(indiceLinha1, 9).toString());	
		altcomp.tfalterartamanho.setText(listarchamado.table_1.getValueAt(indiceLinha1, 10).toString());	
		altcomp.tfalterarquantidade.setText(listarchamado.table_1.getValueAt(indiceLinha1, 11).toString());
		altcomp.tfalterarobs.setText(listarchamado.table_1.getValueAt(indiceLinha1, 12).toString());	

		
		if(altcomp.cbalterarsolicita.getSelectedItem().equals("ENCERRADO")){
			altcomp.cbstatuscompras.setSelectedItem("ENCERRADO PELO COLABORADOR");
			altcomp.cbstatuscompras.setEnabled(false);
			altcomp.tfalterarnumsolicita.setEditable(false);
			altcomp.cbalterarsolicita.setEnabled(false);
			altcomp.tfalterarstatus.setEnabled(false);
			altcomp.tfalterarsolicitante.setEnabled(false);
			altcomp.tfalterardata.setEnabled(false);
			altcomp.tfalterardepartamento.setEnabled(false);
			altcomp.tfalterardestino.setEnabled(false);
			altcomp.tfalterardescricao.setEnabled(false);
			altcomp.tfalterarnecessidade.setEnabled(false);
			altcomp.tfalterarreferencia.setEnabled(false);
			altcomp.tfalteraraplicacao.setEnabled(false);
			altcomp.tfalterartamanho.setEnabled(false);
			altcomp.tfalterarquantidade.setEnabled(false);
			altcomp.tfalterarobs.setEnabled(false);
			altcomp.tablehistcomp.setEnabled(false);
			altcomp.btnalterarstatus.setEnabled(false);
			altcomp.btnatualizahiscompras.setEnabled(false);
			altcomp.btninserirhistcomp.setEnabled(false);
			altcomp.btnlimpahistcomp.setEnabled(false);
			altcomp.tfalterarinformacoes.setEnabled(false);
			altcomp.tfalterarresponsavel.setEnabled(false);
		}
		
	}

}
