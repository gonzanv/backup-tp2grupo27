package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class sucursalesController {

	@GetMapping("/sucursales")
	public String getindex() {
		return "sucursales";
	}
}
