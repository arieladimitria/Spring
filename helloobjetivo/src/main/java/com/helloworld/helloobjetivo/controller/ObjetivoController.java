package com.helloworld.helloobjetivo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloobjetivo")
public class ObjetivoController {
	
	@GetMapping
	public String helloobjetivo() {
		return "Os objetivos de aprendizagem dessa semana é Spring e depoisn aprender a fazer uma CRUD.";  
	}

}	