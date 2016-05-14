package com.proyin.entidades;

import java.util.ArrayList;
import java.util.List;


public class Area {

	private String idArea;
	private String nombre;
	private String tipoArea; // A, D
	private List<Puesto> lstPuesto;
	
	public Area(){
		this.lstPuesto = new ArrayList<Puesto>();
	}
	
	public Area(String idArea, String nombre, String tipoArea){
		this.idArea = idArea;
		this.nombre = nombre;
		this.tipoArea = tipoArea;
	}
	
	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoArea() {
		return tipoArea;
	}

	public void setTipoArea(String tipoArea) {
		this.tipoArea = tipoArea;
	}

	public List<Puesto> getLstPuesto() {
		return lstPuesto;
	}

	public void setLstPuesto(List<Puesto> lstPuesto) {
		this.lstPuesto = lstPuesto;
	}
}
