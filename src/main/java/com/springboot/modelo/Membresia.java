package com.springboot.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="membresias")
public class Membresia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmembresia;
	private String nombrememb;
	private String imgmemb;
	private double montomemb;
	private String descripcionmemb;
	private String tipomemb;
	
	public int getIdmembresia() {
		return idmembresia;
	}
	public void setIdmembresia(int idmembresia) {
		this.idmembresia = idmembresia;
	}
	public String getNombrememb() {
		return nombrememb;
	}
	public void setNombrememb(String nombrememb) {
		this.nombrememb = nombrememb;
	}
	public String getImgmemb() {
		return imgmemb;
	}
	public void setImgmemb(String imgmemb) {
		this.imgmemb = imgmemb;
	}
	public double getMontomemb() {
		return montomemb;
	}
	public void setMontomemb(double montomemb) {
		this.montomemb = montomemb;
	}
	public String getDescripcionmemb() {
		return descripcionmemb;
	}
	public void setDescripcionmemb(String descripcionmemb) {
		this.descripcionmemb = descripcionmemb;
	}
	public String getTipomemb() {
		return tipomemb;
	}
	public void setTipomemb(String tipomemb) {
		this.tipomemb = tipomemb;
	}
	@Override
	public String toString() {
		return "Membresia [idmembresia=" + idmembresia + ", nombrememb=" + nombrememb + ", imgmemb=" + imgmemb
				+ ", montomemb=" + montomemb + ", descripcionmemb=" + descripcionmemb + ", tipomemb=" + tipomemb + "]";
	}
	
	
	
	
	

}
