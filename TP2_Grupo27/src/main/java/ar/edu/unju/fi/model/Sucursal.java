package ar.edu.unju.fi.model;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.*;

@Component
public class Sucursal {
	private int id;
	@NotEmpty(message="Asegurese de completar este campo")
	private String nombre;
	@NotBlank(message="Asegurese de seleccionar una provincia")
	private String provincia;
	@Size(min=5,message="Asegurese de que la ubicación ocupe al menos 5 caracteres")
	private String ubicacion;
	@NotEmpty(message="Este campo es obligatorio")
	private String email; //no utilizo @Email xq el mismo form de html ya controla  la validacion del correo
	
	public Sucursal() {
		
	}

	public Sucursal(int id, String nombre, String provincia, String ubicacion, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.ubicacion = ubicacion;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
