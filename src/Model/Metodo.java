package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import View.Principal;
import View.TelaCompras;

public class Metodo {	
		
		public void lbchamadoaberto() {

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select count (situacao) as quantidade from chamado where situacao = 'ABERTO' and setor ='T.I.'");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					Principal.lbqtdechamado.setText(rs.getString("quantidade"));
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void lbchamadoencerrado() {

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select count (situacao) as quantidade from chamado where situacao = 'ENCERRADO' and setor ='T.I.'");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					Principal.lbqtdechamadoencerrado.setText(rs.getString("quantidade"));
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void lbchamadoemandamento() {

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select count (situacao) as quantidade from chamado where situacao = 'EM ANDAMENTO' and setor ='T.I.'");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					Principal.lbqtdechamadoemandamento.setText(rs.getString("quantidade"));
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void lbchamadofechado() {

			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/NovoChamado", "postgres",
						"admin");
				java.sql.Statement st = con.createStatement();
				st.executeQuery("select count (situacao) as quantidade from chamado where situacao = 'FECHADO' and setor ='T.I.'");
				ResultSet rs = st.getResultSet();
				while (rs.next()) {
					Principal.lbqtdechamadofechado.setText(rs.getString("quantidade"));
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		public void cbdescricaoproduto() {
//			
//			try {
//				Class.forName("org.postgresql.Driver");
//				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NovoChamado", "postgres",
//						"admin");
//				java.sql.Statement st = con.createStatement();
//				st.executeQuery("select distinct produto from produto order by produto");								
//				ResultSet rs = st.getResultSet();
//				while (rs.next()) {
//					TelaCompras.cbdescricaoproduto.addItem(rs.getString("produto"));
//				}
//
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}		

	}


