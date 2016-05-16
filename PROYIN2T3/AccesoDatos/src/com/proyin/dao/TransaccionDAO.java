package com.proyin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

import com.proyin.adaptadores.IDTO;
import com.proyin.contratos.IDAO;
import com.proyin.entidades.Transaccion;

public class TransaccionDAO implements IDAO {

	private static TransaccionDAO _instance = null;

	private TransaccionDAO() {
	}

	public static TransaccionDAO getInstance() {
		if (_instance == null) {
			_instance = new TransaccionDAO();
		}
		return _instance;
	}

	@Override
	public boolean insert(IDTO dto) throws Exception {
		Connection objConexion = Conexion.getInstance().ConectarBD2();
		Transaccion objTransaccion = (Transaccion)dto;
		boolean respuesta = false;
		try{
			CallableStatement cstm = objConexion.prepareCall("{call SP_INSERTAR_TRANSACCION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstm.setString(1, objTransaccion.getObjOficina().getIdOficina());
			cstm.setString(2, objTransaccion.getNroTransaccion()); 
			cstm.setString(3, objTransaccion.getObjOficinaDoc().getIdOficina());
			cstm.setString(4, objTransaccion.getObjDocumento().getIdDocumento());
			cstm.setString(5, objTransaccion.getNroDocumento());
			cstm.setString(6, objTransaccion.getObjOficinaE().getIdOficina());
			cstm.setString(7, objTransaccion.getObjArea().getIdArea());
			cstm.setString(8, objTransaccion.getObjPuesto().getIdPuesto());
			cstm.setString(9, objTransaccion.getObjOperacion().getIdOperacion());
			cstm.setString(10, objTransaccion.getCuentaCargo());
			cstm.setString(11, objTransaccion.getCuentaAbono());
			cstm.setString(12, objTransaccion.getObjPersona().getIdPersona());
			cstm.setString(13, objTransaccion.getGlosaFija());
			cstm.setFloat(14, objTransaccion.getMontoSoles());
			cstm.setString(15, objTransaccion.getObjUsuario().getIdUsuario());
			
			cstm.execute();
			
			respuesta = true;
			
		}catch(Exception ex){
			respuesta = false;
			throw ex;
		}
		return respuesta;
	}

	@Override
	public boolean update(IDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(IDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IDTO> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDTO getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
