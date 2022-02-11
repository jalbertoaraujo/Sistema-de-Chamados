package Controller;

public class DadosDBCadastro4 {
	
	private Integer num_solicita;
	private String situacao;
	private String solicitante;
	private String datasolicita;
	private String departamento;
	private String destino;	
	private String descricao;
	private String necessidade;
	private String sreferencias;
	private String aplicacao;
	private String tamanho;
	private String quantidade;
	private String obs;
	private String status;
	
	public Integer getNum_solicita() {
		return num_solicita;
	}
	public void setNum_solicita(Integer num_solicita) {
		this.num_solicita = num_solicita;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getDatasolicita() {
		return datasolicita;
	}
	public void setDatasolicita(String datasolicita) {
		this.datasolicita = datasolicita;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNecessidade() {
		return necessidade;
	}
	public void setNecessidade(String necessidade) {
		this.necessidade = necessidade;
	}
	public String getSreferencias() {
		return sreferencias;
	}
	public void setSreferencias(String sreferencias) {
		this.sreferencias = sreferencias;
	}
	public String getAplicacao() {
		return aplicacao;
	}
	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public DadosDBCadastro4(Integer num_solicita, String situacao, String solicitante, String datasolicita,
			String departamento, String destino, String descricao, String necessidade, String sreferencias,
			String aplicacao, String tamanho, String quantidade, String obs, String status) {
		super();
		this.num_solicita = num_solicita;
		this.situacao = situacao;
		this.solicitante = solicitante;
		this.datasolicita = datasolicita;
		this.departamento = departamento;
		this.destino = destino;
		this.descricao = descricao;
		this.necessidade = necessidade;
		this.sreferencias = sreferencias;
		this.aplicacao = aplicacao;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
		this.obs = obs;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "DadosDBCadastro4 [num_solicita=" + num_solicita + ", situacao=" + situacao + ", solicitante="
				+ solicitante + ", datasolicita=" + datasolicita + ", departamento=" + departamento + ", destino="
				+ destino + ", descricao=" + descricao + ", necessidade=" + necessidade + ", sreferencias="
				+ sreferencias + ", aplicacao=" + aplicacao + ", tamanho=" + tamanho + ", quantidade=" + quantidade
				+ ", obs=" + obs + ", status=" + status + "]";
	}	
	

}
