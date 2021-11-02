package com.springboot.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;


@Entity
@Table(name="animal")
public class Animal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idanimal;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String descripcion;
	
	private String imagen;
	@NotNull
	private int estado;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="idespecie")
	private Especie especie;

	public int getIdanimal() {
		return idanimal;
	}

	public void setIdanimal(int idanimal) {
		this.idanimal = idanimal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "Animal [idanimal=" + idanimal + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", estado=" + estado + ", especie=" + especie + "]";
	}

	

}