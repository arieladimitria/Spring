package com.meublog.blogariela.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "post")
public class Postagens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull
	@Size(min = 10, max = 1000, message = "O atributo titulo deve ter no mínimo 5 e no máximo 50 caracteres!")
	private String titulo; 
	
	
	@NotNull
	@Size(min = 50, max = 1000, message = "O atributo post deve ter no mínimo 50 e no máximo 1000 caracteres!")
	private String post; 
	
	@UpdateTimestamp
	private LocalDateTime data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	} 

}