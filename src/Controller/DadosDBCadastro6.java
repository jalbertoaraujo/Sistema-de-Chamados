package Controller;

public class DadosDBCadastro6 {
	
	private int id_reserva;
	private String dia;
	private String mes;
	private String periodo;
	private String hora; 
	private String departamento;
	private String local;
	private String nome;
	private String note;
	private String cxsom;
	private String atendido;
	
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCxsom() {
		return cxsom;
	}
	public void setCxsom(String cxsom) {
		this.cxsom = cxsom;
	}
	public String getAtendido() {
		return atendido;
	}
	public void setAtendido(String atendido) {
		this.atendido = atendido;
	}
	
	public DadosDBCadastro6(int id_reserva, String dia, String mes, String periodo, String hora, String departamento,
			String local, String nome, String note, String cxsom, String atendido) {
		super();
		this.id_reserva = id_reserva;
		this.dia = dia;
		this.mes = mes;
		this.periodo = periodo;
		this.hora = hora;
		this.departamento = departamento;
		this.local = local;
		this.nome = nome;
		this.note = note;
		this.cxsom = cxsom;
		this.atendido = atendido;
	}
	
	@Override
	public String toString() {
		return "DadosDBCadastro6 [id_reserva=" + id_reserva + ", dia=" + dia + ", mes=" + mes + ", periodo=" + periodo
				+ ", hora=" + hora + ", departamento=" + departamento + ", local=" + local + ", nome=" + nome
				+ ", note=" + note + ", cxsom=" + cxsom + ", atendido=" + atendido + "]";
	}	
	
}
