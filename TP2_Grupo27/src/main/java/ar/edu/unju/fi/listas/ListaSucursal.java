package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import ar.edu.unju.fi.model.Sucursal;

@Component
public class ListaSucursal {
	private List<Sucursal> sucursales;
	
	public ListaSucursal() {
		sucursales=new ArrayList<Sucursal>();
		sucursales.add(new Sucursal(1,"Grupo 27 1","Jujuy","Av. Exodo 386","grupo271@gmail.com"));
		sucursales.add(new Sucursal(2,"Grupo 27 2","Jujuy","Alto Comedero barrio 127 viviendas","grupo272@gmail.com"));
		sucursales.add(new Sucursal(3,"Grupo 27 3","Jujuy","Barrio San Pedrito calle Parroco marshke al 700","grupo273@gmail.com"));
	}
	
	public List<Sucursal> getSucursales(){
		return sucursales;
	}
	
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales=sucursales;
	}
}
