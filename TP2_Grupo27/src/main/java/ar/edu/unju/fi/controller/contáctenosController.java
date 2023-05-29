package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class contáctenosController {

	@GetMapping("/contáctenos")
	public String getContacenosPage() {
		return "contáctenos";
	}
	
	@GetMapping("/submit-mensaje")
	public String getBubmitPage() {
		return "mensajesubido";
	}
}
