package com.proyin.entidades;

import com.proyin.adaptadores.IDTO;

public class TransaccionxCuenta implements IDTO {
	
	private Oficina objOficinaCuenta;
	private String tipoMoneda;
	private String nroCuenta;
	private String nroTransaccion;
	private Oficina objOficina;
	private TipoCuenta objTipoCuenta;
	
	public TransaccionxCuenta(){}
	
	public TransaccionxCuenta(Oficina objOficinaCuenta, String tipoMoneda,
			String nroCuenta, String nroTransaccion, Oficina objOficina,
			TipoCuenta objTipoCuenta) {
		this.objOficinaCuenta = objOficinaCuenta;
		this.tipoMoneda = tipoMoneda;
		this.nroCuenta = nroCuenta;
		this.nroTransaccion = nroTransaccion;
		this.objOficina = objOficina;
		this.objTipoCuenta = objTipoCuenta;
	}



	public Oficina getObjOficinaCuenta() {
		return objOficinaCuenta;
	}

	public void setObjOficinaCuenta(Oficina objOficinaCuenta) {
		this.objOficinaCuenta = objOficinaCuenta;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getNroTransaccion() {
		return nroTransaccion;
	}

	public void setNroTransaccion(String nroTransaccion) {
		this.nroTransaccion = nroTransaccion;
	}

	public Oficina getObjOficina() {
		return objOficina;
	}

	public void setObjOficina(Oficina objOficina) {
		this.objOficina = objOficina;
	}

	public TipoCuenta getObjTipoCuenta() {
		return objTipoCuenta;
	}

	public void setObjTipoCuenta(TipoCuenta objTipoCuenta) {
		this.objTipoCuenta = objTipoCuenta;
	}
}
