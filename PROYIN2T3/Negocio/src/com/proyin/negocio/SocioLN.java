package com.proyin.negocio;

import com.proyin.adaptadores.IDTO;
import com.proyin.dao.SocioDAO;

public class SocioLN {

	private static SocioLN _instance = null;

	private SocioLN() {
	}

	public static SocioLN getInstance() {
		if (_instance == null) {
			_instance = new SocioLN();
		}
		return _instance;
	}
	
	public boolean insert(IDTO idtoSocio, IDTO idtoUsuario, float aporte) throws Exception {
		try{
		return SocioDAO.getInstance().insert(idtoSocio, idtoUsuario, aporte);
		}catch(Exception ex){
			throw ex;
		}
	}
	
}
