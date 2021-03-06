package com.proyin.entidades;

import com.proyin.adaptadores.IDTO;

public class Operacion implements IDTO{

	private String idOperacion;
	private String nombreOperacion;
	private TipoOperacion objTipoOperacion;
	private String activo;
	private String mostrar;
	private Usuario objUsuario;
	private String nroOrden;
	private String elemento;
	private String idOperacionExtorno; // Operacion de Extorno
	private String idOperacionAnterior; // Operacion Anterior
	private String idOperacionExtornoAnterior; // Operacion Extorno Anterior
	private int orden;
	
	public Operacion(){}
	
	public Operacion(String idOperacion, String nombreOperacion,
			TipoOperacion objTipoOperacion, String activo, String mostrar,
			Usuario objUsuario, String nroOrden, String elemento,
			String idOperacionExtorno, String idOperacionAnterior,
			String idOperacionExtornoAnterior, int orden) {
		this.idOperacion = idOperacion;
		this.nombreOperacion = nombreOperacion;
		this.objTipoOperacion = objTipoOperacion;
		this.activo = activo;
		this.mostrar = mostrar;
		this.objUsuario = objUsuario;
		this.nroOrden = nroOrden;
		this.elemento = elemento;
		this.idOperacionExtorno = idOperacionExtorno;
		this.idOperacionAnterior = idOperacionAnterior;
		this.idOperacionExtornoAnterior = idOperacionExtornoAnterior;
		this.orden = orden;
	}
	
	public String getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}
	public String getNombreOperacion() {
		return nombreOperacion;
	}
	public void setNombreOperacion(String nombreOperacion) {
		this.nombreOperacion = nombreOperacion;
	}
	public TipoOperacion getObjTipoOperacion() {
		return objTipoOperacion;
	}
	public void setObjTipoOperacion(TipoOperacion objTipoOperacion) {
		this.objTipoOperacion = objTipoOperacion;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getMostrar() {
		return mostrar;
	}
	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}
	public Usuario getObjUsuario() {
		return objUsuario;
	}
	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}
	public String getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(String nroOrden) {
		this.nroOrden = nroOrden;
	}
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	public String getIdOperacionExtorno() {
		return idOperacionExtorno;
	}
	public void setIdOperacionExtorno(String idOperacionExtorno) {
		this.idOperacionExtorno = idOperacionExtorno;
	}
	public String getIdOperacionAnterior() {
		return idOperacionAnterior;
	}
	public void setIdOperacionAnterior(String idOperacionAnterior) {
		this.idOperacionAnterior = idOperacionAnterior;
	}
	public String getIdOperacionExtornoAnterior() {
		return idOperacionExtornoAnterior;
	}
	public void setIdOperacionExtornoAnterior(String idOperacionExtornoAnterior) {
		this.idOperacionExtornoAnterior = idOperacionExtornoAnterior;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}	
}
