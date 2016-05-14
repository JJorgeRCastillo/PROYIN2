package com.proyin.entidades;

public class Cuenta {
	
	private String numeroCuenta; // representa el id de la cuenta
	private Oficina objOficina;
	private TipoCuenta objTipoCuenta;
	private String idEstadoCuenta;
	private String fechaApertura;
	private String tipoApertura;
	private float saldo;
	private String fechaEstado;
	private Usuario objUsuario;
	private String disponibilidad;
	private String diferenciarDepositos;
	private String noReportarSaldos;
	
	public Cuenta(){}
	
	public Cuenta(String numeroCuenta, Oficina objOficina,
			TipoCuenta objTipoCuenta, String idEstadoCuenta,
			String fechaApertura, String tipoApertura, float saldo,
			String fechaEstado, Usuario objUsuario, String disponibilidad,
			String diferenciarDepositos, String noReportarSaldos) {
		this.numeroCuenta = numeroCuenta;
		this.objOficina = objOficina;
		this.objTipoCuenta = objTipoCuenta;
		this.idEstadoCuenta = idEstadoCuenta;
		this.fechaApertura = fechaApertura;
		this.tipoApertura = tipoApertura;
		this.saldo = saldo;
		this.fechaEstado = fechaEstado;
		this.objUsuario = objUsuario;
		this.disponibilidad = disponibilidad;
		this.diferenciarDepositos = diferenciarDepositos;
		this.noReportarSaldos = noReportarSaldos;
	}

	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
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

	public String getIdEstadoCuenta() {
		return idEstadoCuenta;
	}

	public void setIdEstadoCuenta(String idEstadoCuenta) {
		this.idEstadoCuenta = idEstadoCuenta;
	}

	public String getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getTipoApertura() {
		return tipoApertura;
	}

	public void setTipoApertura(String tipoApertura) {
		this.tipoApertura = tipoApertura;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getFechaEstado() {
		return fechaEstado;
	}

	public void setFechaEstado(String fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getDiferenciarDepositos() {
		return diferenciarDepositos;
	}

	public void setDiferenciarDepositos(String diferenciarDepositos) {
		this.diferenciarDepositos = diferenciarDepositos;
	}

	public String getNoReportarSaldos() {
		return noReportarSaldos;
	}

	public void setNoReportarSaldos(String noReportarSaldos) {
		this.noReportarSaldos = noReportarSaldos;
	}
	
	
	
}
