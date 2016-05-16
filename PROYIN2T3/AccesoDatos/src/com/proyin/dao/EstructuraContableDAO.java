package com.proyin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.proyin.adaptadores.IDTO;
import com.proyin.contratos.IDAO;
import com.proyin.entidades.EstructuraContable;
import com.proyin.entidades.Operacion;

public class EstructuraContableDAO implements IDAO{

	private static EstructuraContableDAO _instance = null;

	private EstructuraContableDAO() {
	}

	public static EstructuraContableDAO getInstance() {
		if (_instance == null) {
			_instance = new EstructuraContableDAO();
		}
		return _instance;
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
	
	public IDTO getEstructuraContable(String idOperacion, String tipoMoneda, String idOficina, String idDepartamento, String idPuesto) throws Exception {
		Connection objConexion = Conexion.getInstance().ConectarBD2();
		EstructuraContable objEstructuraContable = null;
		Operacion objOperacion = null;
		try{
			CallableStatement cstm = objConexion.prepareCall("{call SP_OBTENER_ESTRUCTURA_CONTABLE(?,?,?,?,?)}");
			cstm.setString(1, idOperacion);
			cstm.setString(2, tipoMoneda);
			cstm.setString(3, idOficina);
			cstm.setString(4, idDepartamento);
			cstm.setString(5, idPuesto);
			
			ResultSet rs = cstm.executeQuery();
			
			if(rs.next()) {
				objEstructuraContable = new EstructuraContable();
				objOperacion = new Operacion();
				objOperacion.setIdOperacion(rs.getString("idOpe"));
				objOperacion.setNombreOperacion(rs.getString("Operacion"));
				objEstructuraContable.setCuentaCargo(rs.getString("CuentaCargo"));
				objEstructuraContable.setCuentaAbono(rs.getString("CuentaAbono"));
				objEstructuraContable.setObjOperaciones(objOperacion);
			}
			
		}catch(Exception ex){
			throw ex;
		}
		
		return (IDTO)objEstructuraContable; 
	}
	
}
