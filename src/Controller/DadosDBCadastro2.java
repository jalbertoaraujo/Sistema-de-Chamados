package Controller;

import java.util.ArrayList;
import java.util.List;

public class DadosDBCadastro2 {
	
	private Integer num_sugestao;
	private String indentificador;
	private String sugestao;
	
		
	public Integer getNum_sugestao() {
		return num_sugestao;
	}
	public void setNum_sugestao(Integer num_sugestao) {
		this.num_sugestao = num_sugestao;
	}
	public String getIdentificador() {
		return indentificador;
	}
	public void setIdentificador(String identificador) {
		this.indentificador = identificador;
	}
	public String getSugestao() {
		return sugestao;
	}
	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	
	public DadosDBCadastro2(Integer num_sugestao, String identificador, String sugestao) {
		super();
		this.num_sugestao = num_sugestao;
		this.indentificador = identificador;
		this.sugestao = sugestao;
	}
	
	
	@Override
	public String toString() {
		return "DadosDBCadastro2 [num_sugestao=" + num_sugestao + ", identificador=" + indentificador + ", sugestao="
				+ sugestao + "]";
	}	
	
}
