package ar.edu.unju.fi.model;
import java.text.DecimalFormat;
import org.springframework.stereotype.Component;

@Component
public class Producto {
	private String nombre;
	private int codigo;
	private double precio;
	private String categoria;
	private int descuento;
	private String imagen;
	
	public Producto() {
		
	}

	public Producto(String nombre, int codigo, double precio, String categoria, int descuento,String imagen) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
		this.imagen=imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String calcularDescuento()
	{	
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(precio-(precio*((double)descuento/100))); // se divide el descuento por 100, lo que equivale al numero a  descuento%
	}
}

