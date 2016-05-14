package com.proyin.entidades;

import java.util.ArrayList;
import java.util.List;


public class Oficina {

	private String idOficina;
	private String nombre;
	private String nombreAbreviado;
	private String direccion;
	private String distrito;
	private String distritoAbreviado;
	private List<Area> lstArea;
	
	public Oficina(){
		this.lstArea = new ArrayList<Area>();
	}
	
	public Oficina(String idOficina, String nombre, String direccion, String nombreAbreviado, String distrito, String distritoAbreviado) {
		this.idOficina = idOficina;
		this.nombre = nombre;
		this.direccion = direccion;
		this.nombreAbreviado = nombreAbreviado;
		this.distrito = distrito;
		this.distritoAbreviado = distritoAbreviado;
	}

	public String getIdOficina() {
		return idOficina;
	}
	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreAbreviado() {
		return nombreAbreviado;
	}

	public void setNombreAbreviado(String nombreAbreviado) {
		this.nombreAbreviado = nombreAbreviado;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getDistritoAbreviado() {
		return distritoAbreviado;
	}
	public void setDistritoAbreviado(String distritoAbreviado) {
		this.distritoAbreviado = distritoAbreviado;
	}

	public List<Area> getLstArea() {
		return lstArea;
	}

	public void setLstArea(List<Area> lstArea) {
		this.lstArea = lstArea;
	}
}
