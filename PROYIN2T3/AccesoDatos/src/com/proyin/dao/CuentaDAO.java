package com.proyin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

import com.proyin.adaptadores.IDTO;
import com.proyin.contratos.IDAO;
import com.proyin.entidades.Socio;
import com.proyin.entidades.Usuario;

public class CuentaDAO implements IDAO {

	private static CuentaDAO _instance = null;

	private CuentaDAO() {
	}

	public static CuentaDAO getInstance() {
		if (_instance == null) {
			_instance = new CuentaDAO();
		}
		return _instance;
	}
	
	public boolean insert(IDTO dtoSocio, IDTO dtoUsuario) throws Exception {
		Connection objConexion = Conexion.getInstance().ConectarBD2();
		Socio objSocio = (Socio)dtoSocio;
		Usuario objUsuario = (Usuario)dtoUsuario;

		boolean respuesta = false;
		try{
			CallableStatement cstm = objConexion.prepareCall("{call SP_INSERT_CUENTA(?,?,?)}");
			objConexion.setAutoCommit(false);
			cstm.setString(1, objUsuario.getObjEmpleado().getObjOficina().getIdOficina());
			cstm.setString(2, objUsuario.getIdUsuario());
			cstm.setString(3, objSocio.getObjPersonaNatural().getIdPersona());
			
			cstm.execute();
			objConexion.commit();
			respuesta = true;
			
		}catch(Exception ex){
			respuesta = false;
			objConexion.rollback();
			throw ex;
		} finally {
			//objConexion.close();
			//objConexion.setAutoCommit(true);
		}
		return respuesta;
	}
	
	@Override
	public boolean insert(IDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
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
