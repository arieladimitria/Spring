package com.meublog.blogariela.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "O atributo nome é obrigatório!")
	@Size(min = 3, max = 100, message = "O tamanho mínimo é 3, e o máximo 10 caractéres!")
	private String nome;

	@NotNull
    @Email(message = "O atributo usuário é obrigatório e deve ser válido!")
	private String usuario;

	@NotBlank(message = "A senha é obrigatória!")
	@Size(min = 8, message = "A senha deve conter, no mínimo, 8 caracteres!")
	private String senha;

	private String foto;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagens> post;

	public Usuario(long id, String nome, String usuario, String senha, String foto) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
	}
	
	public Usuario() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Postagens> getPost() {
		return post;
	}

	public void setPost(List<Postagens> post) {
		this.post = post;
	}

}