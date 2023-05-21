package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.listas.ListaConsejos;
import ar.edu.unju.fi.model.Consejo;

@Controller
@RequestMapping("/consejosalud")
public class consejosaludController {

	ListaConsejos listaconsejos=new ListaConsejos();
	
	@GetMapping("/listado")
	public String getListaConsejosPage(Model model) {
		model.addAttribute("consejos",listaconsejos.getConsejos());
		return "consejosalud";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model){
		boolean edicion=false;
		Consejo conse=new Consejo();
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
	public ModelAndView getGuardarConsejoPage(@ModelAttribute("consejo")Consejo consejo) {
		ModelAndView modelView = new ModelAndView("consejosalud");
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
	public String modificarConsejo(@ModelAttribute("consejo")Consejo consejo)
	{
		for(Consejo conse:listaconsejos.getConsejos()) {
			if(conse.getId()==consejo.getId())
			{
				conse.setTitulo(consejo.getTitulo());
				conse.setDescripcion(consejo.getDescripcion());
				conse.setImagen(consejo.getImagen());
				break;
			}
		}
		return "redirect:/consejosalud/listado";
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
		return "redirect:/consejosalud/listado";
	}
}
