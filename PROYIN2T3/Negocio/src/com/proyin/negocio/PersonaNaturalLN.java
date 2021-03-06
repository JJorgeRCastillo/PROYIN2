package com.proyin.negocio;

import com.proyin.adaptadores.IDTO;
import com.proyin.dao.PersonaNaturalDAO;
import com.proyin.entidades.PersonaNatural;

public class PersonaNaturalLN {

	private static PersonaNaturalLN _instance = null;

	private PersonaNaturalLN() {
	}

	public static PersonaNaturalLN getInstance() {
		if (_instance == null) {
			_instance = new PersonaNaturalLN();
		}
		return _instance;
	}
	
	public boolean insert(IDTO objPersona) throws Exception{
		try{
			return PersonaNaturalDAO.getInstance().insert(objPersona);
		} catch(Exception ex){
			throw ex;
		}
	}
	
	public PersonaNatural getByDocumento(String dni) throws Exception {
		try{
			return (PersonaNatural)PersonaNaturalDAO.getInstance().getByDocumento(dni);
		}catch(Exception ex){
			throw ex;
		}
	}
}
