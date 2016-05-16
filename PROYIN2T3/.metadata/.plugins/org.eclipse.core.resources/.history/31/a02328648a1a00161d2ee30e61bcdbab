package com.proyin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.proyin.adaptadores.IDTO;
import com.proyin.contratos.IDAO;
import com.proyin.entidades.Operacion;

public class OperacionDAO implements IDAO {

	private static OperacionDAO _instance = null;

	private OperacionDAO() {
	}

	public static OperacionDAO getInstance() {
		if (_instance == null) {
			_instance = new OperacionDAO();
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
	
	// por defecto el idOperacion es 00001
	public List<IDTO> getRelacionOperaciones(String idOperacion) throws Exception {
		
		Connection objConexion = Conexion.getInstance().ConectarBD2();
		List<IDTO> listaOperaciones = new ArrayList<IDTO>();
		try{
			CallableStatement cstm = objConexion.prepareCall("{call SP_OBTENER_RELACION_OPERACION(?)}");
			cstm.setString(1, idOperacion); 
			
			ResultSet rs = cstm.executeQuery();
			
			while(rs.next()){
				Operacion objOperacion = new Operacion();
				objOperacion.setIdOperacion(rs.getString("idOpe"));
				objOperacion.setNombreOperacion(rs.getString("operacion")); 
				objOperacion.setOrden(rs.getInt("orden"));
				
				listaOperaciones.add((IDTO)objOperacion);
			}
			
		}catch(Exception ex){
			throw ex;
		} finally {
			objConexion.close();
		}
		return listaOperaciones;
	}

}
