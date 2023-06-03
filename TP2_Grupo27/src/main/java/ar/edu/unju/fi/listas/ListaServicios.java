package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import ar.edu.unju.fi.model.Servicio;

@Component
public class ListaServicios {
	private List<Servicio> servicios;
	
	public ListaServicios(){
		servicios=new ArrayList<Servicio>();
		servicios.add(new Servicio(1,"Paseador","Juan Perez","9 a 12 - 16 a 18","Lunes y Miercoles"));
		servicios.add(new Servicio(2,"Paseador","Lucas Diaz","9 a 12 - 16 a 18","Martes y Viernes"));
		servicios.add(new Servicio(3,"Paseador","María Gomez","9 a 12 - 16 a 18","Jueves"));
		servicios.add(new Servicio(4,"Paseador","Roberto Vazquez","9 a 12 - 16 a 18","Sabado"));
	}
	
	public List<Servicio> getServicios(){
		return servicios;
	}
	
	public void setServicios(List<Servicio> servicios) {
		this.servicios=servicios;
	}
}
