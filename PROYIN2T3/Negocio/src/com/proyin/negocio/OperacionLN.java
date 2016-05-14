package com.proyin.negocio;

import java.util.List;

import com.proyin.adaptadores.IDTO;
import com.proyin.dao.OperacionDAO;

public class OperacionLN {

	private static OperacionLN _instance = null;

	private OperacionLN() {
	}

	public static OperacionLN getInstance() {
		if (_instance == null) {
			_instance = new OperacionLN();
		}
		return _instance;
	}
	
	// se retorna la lista con IDTO, pero cuando se recorre se obtiene cada elemento
	// del tipo Operacion ya que esta clase implementa la interfaz a devolver
	public List<IDTO> getRelacionOperaciones(String idOperacion) throws Exception {
		try{
			return OperacionDAO.getInstance().getRelacionOperaciones(idOperacion);
		}catch(Exception ex){
			throw ex;
		}
	}
}
