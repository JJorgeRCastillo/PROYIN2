package com.proyin.entidades;

public class CIIU {

	private String idCiiu;
	private String descripcion;
	
	public CIIU(){
		
	}
	
	public CIIU(String idCiiu, String descripcion) {
		this.idCiiu = idCiiu;
		this.descripcion = descripcion;
	}

	public String getIdCiiu() {
		return idCiiu;
	}
	public void setIdCiiu(String idCiiu) {
		this.idCiiu = idCiiu;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
