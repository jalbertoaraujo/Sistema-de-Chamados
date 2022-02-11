package Controller;

import java.util.ArrayList;
import java.util.List;

public class DadosDBCadastro3 {
	
	private String num_chamado;
	private String num_historico;
	private String historico;
	private String datahistorico;
	private String responsavel;
	
	public String getNum_chamado() {
		return num_chamado;
	}
	public void setNum_chamado(String num_chamado) {
		this.num_chamado = num_chamado;
	}
	public String getNum_historico() {
		return num_historico;
	}
	public void setNum_historico(String num_historico) {
		this.num_historico = num_historico;
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
	public String getresponsavel() {
		return responsavel;
	}
	public void setresponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public DadosDBCadastro3(String num_chamado, String num_historico, String historico, String datahistorico, String responsavel) {
		super();
		this.num_chamado = num_chamado;
		this.num_historico = num_historico;
		this.historico = historico;
		this.datahistorico = datahistorico;
		this.responsavel = responsavel;
	}
	
	@Override
	public String toString() {
		return "DadosDBCadastro3 [num_chamado=" + num_chamado + ", num_historico=" + num_historico + ", historico="
				+ historico + ", datahistorico=" + datahistorico + ", responsavel="+ responsavel +"]";
	}	
}
