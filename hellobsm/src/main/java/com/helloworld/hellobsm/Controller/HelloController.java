package com.helloworld.hellobsm.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hellobsm")
public class HelloController {
	
	@GetMapping
	public String hello() {
		return "As BSMs que utilizei nessa atividade foram: Atenção aos detalhes; Persistência e Responsabilidade pessoal.";  
	}

}	