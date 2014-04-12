package org.upiita.spring.jdbc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


// JPA se calco de Hibernate

// Mapea la clase usuario con la tabla usuario
@Entity(name = "usuario")
public class Usuario {

	// Definir campos
	
	@Id
	@Column(name = "usuario_id") 
	private Integer usuarioId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nombre")
	private String nombre;

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Id: " + usuarioId + 
				"\nPassword " + password +
				"\nEmail: " + email + 
				"\nNombre: " + nombre;
	}
	
}//Fin class Usuario
