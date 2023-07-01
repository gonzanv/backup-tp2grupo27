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
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {
	
	@Autowired
	private Sucursal sucu;
	
	@Autowired
	private ListaSucursal listasucursales;
	
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales",listasucursales.getSucursales());
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model){
		boolean edicion=false;
		int aux;
		aux=listasucursales.getSucursales().size()-1;
		if(aux==-1)
			sucu.setId(1);
		else
			sucu.setId(listasucursales.getSucursales().get(aux).getId()+1);
		model.addAttribute("sucursal",sucu);
		model.addAttribute("edicion",edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
		ModelAndView modelView = new ModelAndView("sucursales");
		if(result.hasErrors())
		{
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("sucursal",sucursal);
			return modelView;
		}
		listasucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales",listasucursales.getSucursales());
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarSucursalPage(Model model, @PathVariable(value="id")int id)
	{
		boolean edicion=true;
		Sucursal sucursalencontrada = new Sucursal();
		for(Sucursal sucu:listasucursales.getSucursales()) {
			if(sucu.getId()==id)
			{
				sucursalencontrada=sucu;
				break;
			}
		}
		model.addAttribute("sucursal",sucursalencontrada);
		model.addAttribute("edicion",edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/modificar")
	public ModelAndView modificarServicio(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result)
	{
		ModelAndView modelView = new ModelAndView("redirect:/sucursales/listado");
		if(result.hasErrors())
		{
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("producto",sucursal);
			modelView.addObject("edicion",true);
			return modelView;
		}
		for(Sucursal sucu:listasucursales.getSucursales()) {
			if(sucu.getId()==sucursal.getId())
			{
				sucu.setNombre(sucursal.getNombre());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setUbicacion(sucursal.getUbicacion());
				sucu.setEmail(sucursal.getEmail());
				break;
			}
		}
		return modelView;
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarSucursales(@PathVariable(value="id")int id) {
		for(Sucursal sucu:listasucursales.getSucursales()) {
			if(sucu.getId()==id) 
			{
				listasucursales.getSucursales().remove(sucu);
				break;
			}
		}
		return "redirect:/sucursales/listado";
	}
}
