package com.springboot.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="metodopago")
public class Pago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpago;
	private String nombrepago;
	
	public int getIdpago() {
		return idpago;
	}
	public void setIdpago(int idpago) {
		this.idpago = idpago;
	}
	public String getNombrepago() {
		return nombrepago;
	}
	public void setNombrepago(String nombrepago) {
		this.nombrepago = nombrepago;
	}
	@Override
	public String toString() {
		return "Pago [idpago=" + idpago + ", nombrepago=" + nombrepago + "]";
	}
	
	

}
