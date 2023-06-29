package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private Producto produ;
	@Autowired
	private ListaProducto listaproductos;
	
	@GetMapping("/listado")
	public String getListaProductosPage(Model model) {
		model.addAttribute("productos",listaproductos.getProductos());
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model){
		boolean edicion=false;
		int aux;
		aux=listaproductos.getProductos().size()-1;
		if(aux==-1)
			produ.setCodigo(1);
		else
		produ.setCodigo(listaproductos.getProductos().get(aux).getCodigo()+1);
		model.addAttribute("producto",produ);
		model.addAttribute("edicion",edicion);
		return "nuevo_producto";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto")Producto producto, BindingResult result) {
		ModelAndView modelView = new ModelAndView("productos");
		if(result.hasErrors())
		{
			modelView.setViewName("nuevo_producto");
			modelView.addObject("producto",producto);
			return modelView;
		}
		listaproductos.getProductos().add(producto);
		modelView.addObject("productos",listaproductos.getProductos());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarProductoPage(Model model, @PathVariable(value="codigo")int codigo)
	{
		boolean edicion=true;
		Producto productoencontrado = new Producto();
		for(Producto produ:listaproductos.getProductos()) {
			if(produ.getCodigo()==codigo)
			{
				productoencontrado=produ;
				break;
			}
		}
		model.addAttribute("producto",productoencontrado);
		model.addAttribute("edicion",edicion);
		return "nuevo_producto";
	}
	
	@PostMapping("/modificar")
	public String modificarProducto(@ModelAttribute("producto")Producto producto)
	{
		for(Producto produ:listaproductos.getProductos()) {
			if(produ.getCodigo()==producto.getCodigo())
			{
				produ.setNombre(producto.getNombre());
				produ.setCategoria(producto.getCategoria());
				produ.setPrecio(producto.getPrecio());
				produ.setDescuento(producto.getDescuento());
				produ.setImagen(producto.getImagen());
				break;
			}
		}
		return "redirect:/productos/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarProducto(@PathVariable(value="codigo")int codigo) {
		for(Producto produ:listaproductos.getProductos()) {
			if(produ.getCodigo()==codigo) 
			{
				listaproductos.getProductos().remove(produ);
				break;
			}
		}
		return "redirect:/productos/listado";
	}
}
