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
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejos_salud")
public class ConsejoSaludController {

	@Autowired
	private Consejo conse;
	@Autowired
	private ListaConsejo listaconsejos;
	
	@GetMapping("/listado")
	public String getListaConsejosPage(Model model) {
		model.addAttribute("consejos",listaconsejos.getConsejos());
		return "consejos_salud";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model){
		boolean edicion=false;
		int aux;
		aux=listaconsejos.getConsejos().size()-1;
		if(aux==-1)
			conse.setId(1);
		else
		conse.setId(listaconsejos.getConsejos().get(aux).getId()+1);
		model.addAttribute("consejo",conse);
		model.addAttribute("edicion",edicion);
		return "nuevo_consejo";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result) {
		ModelAndView modelView = new ModelAndView("consejos_salud");
		if(result.hasErrors())
		{
			modelView.setViewName("nuevo_consejo");
			modelView.addObject("consejo",consejo);
			return modelView;
		}
		listaconsejos.getConsejos().add(consejo);
		modelView.addObject("consejos",listaconsejos.getConsejos());
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarConsejoPage(Model model, @PathVariable(value="id")int id)
	{
		boolean edicion=true;
		Consejo consejoencontrado = new Consejo();
		for(Consejo conse:listaconsejos.getConsejos()) {
			if(conse.getId()==id)
			{
				consejoencontrado=conse;
				break;
			}
		}
		model.addAttribute("consejo",consejoencontrado);
		model.addAttribute("edicion",edicion);
		return "nuevo_consejo";
	}
	
	@PostMapping("/modificar")
	public ModelAndView modificarConsejo(@Valid @ModelAttribute("consejo")Consejo consejo, BindingResult result)
	{
		ModelAndView modelView = new ModelAndView("redirect:/consejos_salud/listado");
		if(result.hasErrors())
		{
			modelView.setViewName("nuevo_consejo");
			modelView.addObject("consejo",consejo);
			modelView.addObject("edicion",true);
			return modelView;
		}
		for(Consejo conse:listaconsejos.getConsejos()) {
			if(conse.getId()==consejo.getId())
			{
				conse.setTitulo(consejo.getTitulo());
				conse.setDescripcion(consejo.getDescripcion());
				conse.setImagen(consejo.getImagen());
				break;
			}
		}
		return modelView;
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarConsejo(@PathVariable(value="id")int id) {
		for(Consejo conse:listaconsejos.getConsejos()) {
			if(conse.getId()==id) 
			{
				listaconsejos.getConsejos().remove(conse);
				break;
			}
		}
		return "redirect:/consejos_salud/listado";
	}
}
