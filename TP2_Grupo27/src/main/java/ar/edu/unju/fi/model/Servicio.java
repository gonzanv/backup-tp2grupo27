package ar.edu.unju.fi.model;

public class Servicio {
	private int id;
	private String tipo;
	private String encargado;
	private String horario;
	private String dias;
	
	public Servicio() {
		
	}

	public Servicio(int id, String tipo, String encargado, String horario,String dias) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.encargado = encargado;
		this.horario = horario;
		this.dias=dias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}
	
	
}
