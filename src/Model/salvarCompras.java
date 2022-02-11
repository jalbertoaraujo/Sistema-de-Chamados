package Model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.Compras;
import View.TelaCompras;
import uteis.Som;


public class salvarCompras {
	
	public void salvacompras(){
		
		TelaCompras.tfidpedido.setText(TelaCompras.tfnumsolicitacao.getText()); 
		
		if(TelaCompras.tfsolicitacompra.getText().equals("") || TelaCompras.tfdestinocompra.getText().equals("") || TelaCompras.tfdescricao.getText().equals("") ||TelaCompras.tfnecessidade.getText().equals("") || TelaCompras.tfreferencia.getText().equals("") ||  TelaCompras.tfaplicacao.getText().equals("") ||
		 TelaCompras.tftamanho.getText().equals("")|| TelaCompras.tfquantidade.getText().equals("")|| TelaCompras.tfobs.getText().equals("")){
			JOptionPane
				.showMessageDialog(null, "Preencha Todos os Campos Para Salvar uma Nova Solicitação de Compras");
				 }else{
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.254.13/NovoChamado",
					"postgres", "admin");
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO compras (situacao,solicitante,datasolicita,departamento,destino,descricao,necessidade,referencias,aplicacao,tamanho,quantidade,obs,status,id_pedido,setor) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
									
			stmt.setString(1, (String) TelaCompras.cbsituacaosolicita.getSelectedItem());
			stmt.setString(2, (String) TelaCompras.tfsolicitacompra.getText());
			stmt.setString(3, (String) TelaCompras.tfdatacompra.getText());
			stmt.setString(4, (String) TelaCompras.tfdepcompras.getText());
			stmt.setString(5, (String) TelaCompras.tfdestinocompra.getText());
			stmt.setString(6, (String) TelaCompras.tfdescricao.getText());
			stmt.setString(7, (String) TelaCompras.tfnecessidade.getText());
			stmt.setString(8, (String) TelaCompras.tfreferencia.getText());
			stmt.setString(9, (String) TelaCompras.tfaplicacao.getText());
			stmt.setString(10, (String) TelaCompras.tftamanho.getText());	
			stmt.setString(11, (String) TelaCompras.tfquantidade.getText());	
			stmt.setString(12, (String) TelaCompras.tfobs.getText());	
			stmt.setString(13, (String) TelaCompras.tfstatus.getText());
			stmt.setString(14, (String) TelaCompras.tfidpedido.getText());
			stmt.setString(15, (String) TelaCompras.tfsetorcompras.getText());
			stmt.execute();
			stmt.close();
			con.close();
			
			File som = new File("C:\\mensagem.wav");
			Som playSom = new Som();
			playSom.playwav(som);
			
			JOptionPane.showMessageDialog(null,
					"Sua Solicitação de Compras de Número " +TelaCompras.tfnumsolicitacao.getText()+ " Foi Efetuada com Sucesso");				 
			 TelaCompras.tfdescricao.setText("");
			 TelaCompras.tfnecessidade.setText("");
			 TelaCompras.tfreferencia.setText("");
			 TelaCompras.tfaplicacao.setText("");
			 TelaCompras.tftamanho.setText("");
			 TelaCompras.tfquantidade.setText("");
			 TelaCompras.tfobs.setText("");
			 TelaCompras.tfdescricao.requestFocus();	
			
	}catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		JOptionPane
				.showMessageDialog(null, "Erro ao Cadastrar Pedido de Compras" + e);
	}
		}
	 }
	public void numchamado() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery(
					"select num_solicita from compras'"
							);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Compras.tfnumsolicitacao.setText(rs.getString(0));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void retornanumero() {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select num_solicita from compras order by num_solicita desc limit 1");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				int ult = rs.getInt("num_solicita") + 1;				
				TelaCompras.tfnumsolicitacao.setText("" + ult);
			}
			con.close();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro");
		}

	
	}
}
