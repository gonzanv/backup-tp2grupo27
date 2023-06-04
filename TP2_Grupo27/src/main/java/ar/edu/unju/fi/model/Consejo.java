package ar.edu.unju.fi.model;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.*;

@Component
public class Consejo {
	private int id;
	@Size(min=8,message="Asegurese de que el título contenga al menos 8 caracteres")
	private String titulo;
	@Size(min=20,message="Asegurese de que la descripción contenga al menos 20 caracteres")
	private String descripcion;
	@NotEmpty(message="Es necesario vincular una imagen para el consejo")
	private String imagen;
	
	public Consejo() {
		
	}

	public Consejo(int id, String titulo, String descripcion, String imagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
