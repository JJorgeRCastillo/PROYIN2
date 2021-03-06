package com.proyin.negocio;

import com.proyin.dao.*;
import com.proyin.entidades.*;

public class EmpleadoLN {

	private static EmpleadoLN _instance = null;

	private EmpleadoLN() {
	}

	public static EmpleadoLN getInstance() {
		if (_instance == null) {
			_instance = new EmpleadoLN();
		}
		return _instance;
	}
	
	public Empleado verficarAcceso(String idUsuario, String clave) throws Exception{
		try{
			return (Empleado)EmpleadoDAO.getInstance().verficarAcceso(idUsuario, clave);
		}catch(Exception ex){
			throw ex;
		}
	}
}
