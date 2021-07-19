package model;

import java.util.Date; 

public class PacienteDAO {
	private String id;
	private String nome;
	private String sus;
	private String tipo;
	private String data_nasc;
	private String fone;
	
	public PacienteDAO(String id, String nome, String sus, String tipo, String data_nasc, String fone) {
		super();
		this.id = id;
		this.nome = nome;
		this.sus = sus;
		this.tipo = tipo;
		this.data_nasc = data_nasc;
		this.fone = fone;
	}

	public PacienteDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSus() {
		return sus;
	}
	public void setSus(String sus) {
		this.sus = sus;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	

}
