package com.springboot.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="metodoenvio")
public class Envio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idenvio;
	private String nombreenvio;
	public int getIdenvio() {
		return idenvio;
	}
	public void setIdenvio(int idenvio) {
		this.idenvio = idenvio;
	}
	public String getNombreenvio() {
		return nombreenvio;
	}
	public void setNombreenvio(String nombreenvio) {
		this.nombreenvio = nombreenvio;
	}
	@Override
	public String toString() {
		return "Envio [idenvio=" + idenvio + ", nombreenvio=" + nombreenvio + "]";
	}
	
	
	

}
