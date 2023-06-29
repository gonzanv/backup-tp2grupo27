package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import ar.edu.unju.fi.model.Producto;

@Component
public class ListaProducto {
	private List<Producto> productos;
	
	public ListaProducto(){
		productos = new ArrayList<Producto>();
		productos.add(new Producto("Bolso Transportador Liso MB",1,2999.99,"Bolsos",30,"/images/bolso1.jpg"));
		productos.add(new Producto("Corral Hexagonal",2,1799.99,"Corrales",20,"/images/corral.png"));
		productos.add(new Producto("Bolso Portacan",3,2499.99,"Bolsos",0,"/images/can.png"));
	}
	
	public List<Producto> getProductos(){
		return productos;
	}
	
	public void setProductos(List<Producto> productos) {
		this.productos=productos;
	}
}
