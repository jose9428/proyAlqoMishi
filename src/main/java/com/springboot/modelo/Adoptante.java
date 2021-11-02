package com.springboot.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adoptante")
public class Adoptante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idadoptante;
	private String nombreadop;
	private String apellidos;
	private String fechanac;
	private String direccion;
	private String correo;
	private String dni;
	private String ciudad;
	private String codigopostal;
	private String telefono;
	
	
	
	public int getIdadoptante() {
		return idadoptante;
	}
	public void setIdadoptante(int idadoptante) {
		this.idadoptante = idadoptante;
	}
	public String getNombreadop() {
		return nombreadop;
	}
	public void setNombreadop(String nombreadop) {
		this.nombreadop = nombreadop;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFechanac() {
		return fechanac;
	}
	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodigopostal() {
		return codigopostal;
	}
	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Adoptante [idadoptante=" + idadoptante + ", nombreadop=" + nombreadop + ", apellidos=" + apellidos
				+ ", fechanac=" + fechanac + ", direccion=" + direccion + ", correo=" + correo + ", dni=" + dni
				+ ", ciudad=" + ciudad + ", codigopostal=" + codigopostal + ", telefono=" + telefono + "]";
	}
	
	

}
