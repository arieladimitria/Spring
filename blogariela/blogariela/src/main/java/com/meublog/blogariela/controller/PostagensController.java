package com.meublog.blogariela.controller;

import java.util.List;

import com.meublog.blogariela.model.Postagens;
import com.meublog.blogariela.repository.PostagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagensController {
	
	@Autowired
	private PostagensRepository postagensRepository; 
	
	@GetMapping
	public ResponseEntity<List<Postagens>> getAll(){
		return ResponseEntity.ok(postagensRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagens> getById(@PathVariable long id){
		return postagensRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagens>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagensRepository.findAllByTituloContainingIgnoreCase(titulo));

	}
	
	@PostMapping
	public ResponseEntity<Postagens> postPostagens(@RequestBody Postagens post){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagensRepository.save(post));
	}
	
	@PutMapping
	public ResponseEntity<Postagens> putPostagens(@RequestBody Postagens post){
		return ResponseEntity.status(HttpStatus.OK).body(postagensRepository.save(post));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable long id){
		return postagensRepository.findById(id)
				.map(res -> {postagensRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
}
