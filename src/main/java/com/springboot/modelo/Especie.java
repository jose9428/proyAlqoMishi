package com.springboot.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="especie")
public class Especie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idespecie;
	private String especie;
	public int getIdespecie() {
		return idespecie;
	}
	public void setIdespecie(int idespecie) {
		this.idespecie = idespecie;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	@Override
	public String toString() {
		return "Especie [idespecie=" + idespecie + ", especie=" + especie + "]";
	}
}
