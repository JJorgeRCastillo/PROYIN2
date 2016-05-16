package com.proyin.entidades;

import com.proyin.adaptadores.IDTO;

public class EstructuraContable implements IDTO {

	private Operacion objOperaciones;
	private Oficina objOficina;
	private String cuentaCargo;
	private String cuentaAbono;
	private String tipMoneda;
	private String activo;
	private Usuario usuario;
	
	public EstructuraContable(){}

	public EstructuraContable(Operacion objOperaciones, Oficina objOficina,
			String cuentaCargo, String cuentaAbono, String tipMoneda,
			String activo, Usuario usuario) {
		this.objOperaciones = objOperaciones;
		this.objOficina = objOficina;
		this.cuentaCargo = cuentaCargo;
		this.cuentaAbono = cuentaAbono;
		this.tipMoneda = tipMoneda;
		this.activo = activo;
		this.usuario = usuario;
	}

	public Operacion getObjOperaciones() {
		return objOperaciones;
	}

	public void setObjOperaciones(Operacion objOperaciones) {
		this.objOperaciones = objOperaciones;
	}

	public Oficina getObjOficina() {
		return objOficina;
	}

	public void setObjOficina(Oficina objOficina) {
		this.objOficina = objOficina;
	}

	public String getCuentaCargo() {
		return cuentaCargo;
	}

	public void setCuentaCargo(String cuentaCargo) {
		this.cuentaCargo = cuentaCargo;
	}

	public String getCuentaAbono() {
		return cuentaAbono;
	}

	public void setCuentaAbono(String cuentaAbono) {
		this.cuentaAbono = cuentaAbono;
	}

	public String getTipMoneda() {
		return tipMoneda;
	}

	public void setTipMoneda(String tipMoneda) {
		this.tipMoneda = tipMoneda;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
