package com.proyin.entidades;

import com.proyin.adaptadores.IDTO;

public class AsignaDocumentoxOperacion implements IDTO{

	private String IdOpe;
	private Documento objDocumento;
	private String tipMoneda;
	private String activo;
	private Usuario objUsuario;
	
	public AsignaDocumentoxOperacion(){}

	public AsignaDocumentoxOperacion(String idOpe, Documento objDocumento,
			String tipMoneda, String activo, Usuario objUsuario) {
		super();
		IdOpe = idOpe;
		this.objDocumento = objDocumento;
		this.tipMoneda = tipMoneda;
		this.activo = activo;
		this.objUsuario = objUsuario;
	}

	public String getIdOpe() {
		return IdOpe;
	}

	public void setIdOpe(String idOpe) {
		IdOpe = idOpe;
	}

	public Documento getObjDocumento() {
		return objDocumento;
	}

	public void setObjDocumento(Documento objDocumento) {
		this.objDocumento = objDocumento;
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

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}
}
