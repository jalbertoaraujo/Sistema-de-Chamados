package Controller;

import java.util.ArrayList;
import java.util.List;

public class DadosDBCadastro {
	
	private Integer numerochamado;
	private String datahora;
	private String colaborador;
	private String departamento;
	private String assunto;
	private String descricao;
	private String situacao;
	private String prioridade;
	private String status;
	private String setor;
	
	public Integer getNumerochamado() {
		return numerochamado;
	}
	public void setNumerochamado(Integer numerochamado) {
		this.numerochamado = numerochamado;
	}
	public String getDatahora() {
		return datahora;
	}
	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}
	public String getColaborador() {
		return colaborador;
	}
	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public DadosDBCadastro(Integer numerochamado, String datahora, String colaborador, String departamento,
			String assunto, String descricao, String situacao, String prioridade, String status, String setor) {
		super();
		this.numerochamado = numerochamado;
		this.datahora = datahora;
		this.colaborador = colaborador;
		this.departamento = departamento;
		this.assunto = assunto;
		this.descricao = descricao;
		this.situacao = situacao;
		this.prioridade = prioridade;
		this.status = status;
		this.setor = setor;
	}
	
	@Override
	public String toString() {
		return "DadosDBCadastro [numerochamado=" + numerochamado + ", datahora=" + datahora + ", colaborador="
				+ colaborador + ", departamento=" + departamento + ", assunto=" + assunto + ", descricao=" + descricao
				+ ", situacao=" + situacao + ", prioridade=" + prioridade + ", status=" + status + ", setor="+ setor +"]";
	}
	
}
