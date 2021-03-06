package com.proyin.entidades;

public class Documento {

	private String idDocumento;
	private String nombreDocumento;
	private String abreviado;
	private String parametro;
	
	public Documento(){}
	
	public Documento(String idDocumento, String nombreDocumento,
			String abreviado, String parametro) {
		this.idDocumento = idDocumento;
		this.nombreDocumento = nombreDocumento;
		this.abreviado = abreviado;
		this.parametro = parametro;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public String getAbreviado() {
		return abreviado;
	}

	public void setAbreviado(String abreviado) {
		this.abreviado = abreviado;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
}
