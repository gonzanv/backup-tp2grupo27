package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactanosController {

	@GetMapping("/contactanos")
	public String getContacenosPage() {
		return "contactanos";
	}
	
	@GetMapping("/submit-mensaje")
	public String getBubmitPage() {
		return "mensaje_subido";
	}
}
