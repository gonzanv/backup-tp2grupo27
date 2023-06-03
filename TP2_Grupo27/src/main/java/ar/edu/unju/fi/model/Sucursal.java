package ar.edu.unju.fi.model;
import org.springframework.stereotype.Component;

@Component
public class Sucursal {
	private int id;
	private String nombre;
	private String provincia;
	private String ubicacion;
	private String email;
	
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
