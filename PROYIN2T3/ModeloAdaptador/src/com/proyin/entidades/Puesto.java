package com.proyin.entidades;

import java.util.ArrayList;
import java.util.List;

public class Puesto {

	private String idPuesto;
	private String nombre;
	private List<Area> lstArea;
	
	public Puesto(){
		this.lstArea = new ArrayList<Area>();
	}
	
	public Puesto(String idPuesto, String nombre){
		this.idPuesto = idPuesto;
		this.nombre = nombre;
	}

	public String getIdPuesto() {
		return idPuesto;
	}

	public void setIdPuesto(String idPuesto) {
		this.idPuesto = idPuesto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Area> getLstArea() {
		return lstArea;
	}

	public void setLstArea(List<Area> lstArea) {
		this.lstArea = lstArea;
	}
}
