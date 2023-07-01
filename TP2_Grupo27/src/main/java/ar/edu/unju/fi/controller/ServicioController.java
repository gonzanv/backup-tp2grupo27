package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	private Servicio servi;
	@Autowired
	private ListaServicio listaservicios;
	@GetMapping("/listado")
	public String getListaServiciosPage(Model model) {
		model.addAttribute("servicios", listaservicios.getServicios());
		return "servicios";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoServicioPage(Model model){
		boolean edicion=false;
		int aux;
		aux=listaservicios.getServicios().size()-1;
		if(aux==-1)
			servi.setId(1);
		else
			servi.setId(listaservicios.getServicios().get(aux).getId()+1);
		model.addAttribute("servicio",servi);
		model.addAttribute("edicion",edicion);
		return "nuevo_servicio";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarServicioPage(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result) {
		ModelAndView modelView = new ModelAndView("servicios");
		if(result.hasErrors())
		{
			modelView.setViewName("nuevo_servicio");
			modelView.addObject("servicio",servicio);
			return modelView;
		}
		listaservicios.getServicios().add(servicio);
		modelView.addObject("servicios",listaservicios.getServicios());
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarServicioPage(Model model, @PathVariable(value="id")int id)
	{
		boolean edicion=true;
		Servicio servicioencontrado = new Servicio();
		for(Servicio servi:listaservicios.getServicios()) {
			if(servi.getId()==id)
			{
				servicioencontrado=servi;
				break;
			}
		}
		model.addAttribute("servicio",servicioencontrado);
		model.addAttribute("edicion",edicion);
		return "nuevo_servicio";
	}
	
	@PostMapping("/modificar")
	public ModelAndView modificarServicio(@Valid @ModelAttribute("servicio")Servicio servicio, BindingResult result)
	{
		ModelAndView modelView = new ModelAndView("redirect:/servicios/listado");
		if(result.hasErrors())
		{
			modelView.setViewName("nuevo_servicio");
			modelView.addObject("servicio",servicio);
			modelView.addObject("edicion",true);
			return modelView;
		}
		for(Servicio servi:listaservicios.getServicios()) {
			if(servi.getId()==servicio.getId())
			{
				servi.setTipo(servicio.getTipo());
				servi.setEncargado(servicio.getEncargado());
				servi.setHorario(servicio.getHorario());
				servi.setDias(servicio.getDias());
				break;
			}
		}
		return modelView;
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarServicio(@PathVariable(value="id")int id) {
		for(Servicio servi:listaservicios.getServicios()) {
			if(servi.getId()==id) 
			{
				listaservicios.getServicios().remove(servi);
				break;
			}
		}
		return "redirect:/servicios/listado";
	}
}

