package Controller;

import java.util.ArrayList;
import java.util.List;

public class DadosDBCadastro5 {
	
	private String num_historicocompras;
	private String num_solicita;
	private String historico;
	private String datahistorico;
	private String responsavel;
	
	
	public String getNum_historicocompras() {
		return num_historicocompras;
	}
	public void setNum_historicocompras(String num_historicocompras) {
		this.num_historicocompras = num_historicocompras;
	}
	public String getNum_solicita() {
		return num_solicita;
	}
	public void setNum_solicita(String num_solicita) {
		this.num_solicita = num_solicita;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	public String getDatahistorico() {
		return datahistorico;
	}
	public void setDatahistorico(String datahistorico) {
		this.datahistorico = datahistorico;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	
	public DadosDBCadastro5(String num_historicocompras, String num_solicita, String historico, String datahistorico,
			String responsavel) {
		super();
		this.num_historicocompras = num_historicocompras;
		this.num_solicita = num_solicita;
		this.historico = historico;
		this.datahistorico = datahistorico;
		this.responsavel = responsavel;
	}
	
	
	@Override
	public String toString() {
		return "DadosDBCadastro5 [num_historicocompras=" + num_historicocompras + ", num_solicita=" + num_solicita
				+ ", historico=" + historico + ", datahistorico=" + datahistorico + ", responsavel=" + responsavel
				+ "]";
	}
	
	
	
}