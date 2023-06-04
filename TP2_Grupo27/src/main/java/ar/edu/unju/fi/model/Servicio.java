package ar.edu.unju.fi.model;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.*;

@Component
public class Servicio {
	private int id;
	@Size(min=5,message="Asegurese de que el tipo contenga al menos 5 caracteres")
	private String tipo;
	@Size(min=8,message="Asegurese de que el encargado contenga al menos 8 caracteres, colocar nombre y apellido")
	private String encargado;
	@Size(min=8,message="Asegurese de que el horario contenga al menos 8 caracteres")
	private String horario;
	@Size(min=5,message="Asegurese de que los dias del servicio contenga al menos 5 caracteres")
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
