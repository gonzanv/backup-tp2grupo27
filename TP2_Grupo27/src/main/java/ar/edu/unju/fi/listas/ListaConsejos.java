package ar.edu.unju.fi.listas;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Consejo;

@Component
public class ListaConsejos {
	private List<Consejo> consejos;
	
	public ListaConsejos() {
		consejos=new ArrayList<Consejo>();
		consejos.add(new Consejo(1,"Visita regularmente al veterinario","El veterinario nos orientará y diseñará un plan de prevención de las innumerables enfermedades que atacan a los animales de compañía, enseñándonos a cuidar de la mejor manera posible a nuestro compañero.En la primera visita de nuestro perro o gato al veterinario, éste se encargará de revisar su estado de salud y descartar cualquier patología, además de establecer el plan vacunal y de escoger las vacunas más adecuadas para cada animal según el riesgo de exposición a ciertas enfermedades y la zona de residencia. Por este motivo no existe un calendario de vacunación único.","/images/salud1.jpg"));
		consejos.add(new Consejo(2,"Desparasita con frecuencia a tu mascota","La desparasitación de las mascotas debe llevarse a cabo antes de iniciar el suministro de las vacuna, porque además de eliminar los parásitos, el antiparasitario estimula las defensas y ayuda a que la vacuna produzca un mejor efecto inmune en los animales.","/images/salud2.jpg"));
		consejos.add(new Consejo(3,"Proporciónale una alimentación sana","Utiliza alimentos saludables, que cubran todas las necesidades nutricionales de tu mascota, aportando todos los elementos necesarios para un correcto crecimiento y desarrollo de la mascota, desde sus primeros años de vida hasta su etapa adulta. Ten en cuenta que las necesidades de tu mascota van cambiando a lo largo de su vida, por lo que proporciona lo que el animal necesite dependiendo de su estado fisiológico. Además es aconsejable repartir las comidas para evitar sobrecargar al animal y que tenga así mejores digestiones. Ten siempre a su disposición agua fresca y limpia, para que pueda hidratarse con regularidad.","/images/salud3.jpg"));
		consejos.add(new Consejo(4,"No descuides su limpieza","Para huir de los parásitos externos (pulgas, garrapatas, piojos…) y de las enfermedades de la piel, el primer paso está en la prevención mediante un aseo periódico de tu mascota, de esta manera podremos detectar y tomar las medidas necesarias.","/images/salud4.jpg"));
		consejos.add(new Consejo(5,"Limpia sus dientes con frecuencia","La higiene bucal es una práctica necesaria para evitar problemas en la boca, dientes y encías. Unos dientes y una boca sanos previenen de enfermedades, además de ser necesarios para una perfecta masticación interviniendo directamente en la correcta nutrición de la mascota. Por lo tanto cuida la boca de tu mascota, cepilla sus dientes o proporciona alimentos específicos para la limpieza bucal, previniendo de esta manera la aparición de caries, sarro, placa dental y mal aliento. No olvides visitar a tu veterinario para que valore el estado dental de tu mascota.","/images/salud5.png"));
		consejos.add(new Consejo(6,"Haz que realice ejercicio con frecuencia","Realizar dos paseos al día, salir a correr o jugar con tu mascota son ejercicios que no podemos olvidar para mantener el correcto estado de salud de tu mascota, y que esta pueda tener una vida plena, sana y feliz. De esta forma mejorarás el correcto funcionamiento intestinal y cardiovascular, y además prevendrás la obesidad de tu mascota.","/images/salud6.jpg"));
	}
	
	public List<Consejo> getConsejos(){
		return consejos;
	}
	
	public void setConsejos(List<Consejo> consejos) {
		this.consejos=consejos;
	}
}
