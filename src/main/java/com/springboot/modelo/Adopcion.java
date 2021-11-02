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

@Entity
@Table(name="adopcion")
public class Adopcion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idadopcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idanimal")
	private Animal animal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idadoptante")
	private Adoptante adoptante;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idenvio")
	private Envio envio;
	
	private String fechaenvio;
	private String mensaje;
	
	public int getIdadopcion() {
		return idadopcion;
	}
	public void setIdadopcion(int idadopcion) {
		this.idadopcion = idadopcion;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Adoptante getAdoptante() {
		return adoptante;
	}
	public void setAdoptante(Adoptante adoptante) {
		this.adoptante = adoptante;
	}
	public Envio getEnvio() {
		return envio;
	}
	public void setEnvio(Envio envio) {
		this.envio = envio;
	}
	public String getFechaenvio() {
		return fechaenvio;
	}
	public void setFechaenvio(String fechaenvio) {
		this.fechaenvio = fechaenvio;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	@Override
	public String toString() {
		return "Adopcion [idadopcion=" + idadopcion + ", animal=" + animal + ", adoptante=" + adoptante + ", envio="
				+ envio + ", fechaenvio=" + fechaenvio + ", mensaje=" + mensaje + "]";
	}
	
	

}
