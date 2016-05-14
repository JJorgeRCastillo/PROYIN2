package com.proyin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.proyin.contratos.*;
import com.proyin.adaptadores.*;
import com.proyin.entidades.*;

public class EmpleadoDAO implements IDAO{

	private static EmpleadoDAO _instance = null;

	private EmpleadoDAO() {
	}

	public static EmpleadoDAO getInstance() {
		if (_instance == null) {
			_instance = new EmpleadoDAO();
		}
		return _instance;
	}

	@Override
	public boolean insert(IDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(IDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(IDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDTO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public IDTO verficarAcceso(String usuario, String clave) throws Exception {

		Connection objConexion = Conexion.getInstance().ConectarBD2();
		Usuario objUsuario = null;
		Empleado objEmpleado = null;
		PersonaNatural objPersonaNatural = null;
		Oficina objOficina = null;
		Area objArea = null;
		Puesto objPuesto = null;
		
		try {
			CallableStatement cstm = objConexion.prepareCall("{call SP_VERIFICAR_ACCESO(?,?)}");
			cstm.setString(1, usuario);
			cstm.setString(2, clave);
			ResultSet rs = cstm.executeQuery();
			if (rs.next()) {
				objEmpleado = new Empleado();
				objUsuario = new Usuario();
				objOficina = new Oficina();
				objArea = new Area();
				objPuesto = new Puesto();
				objPersonaNatural = new PersonaNatural();
				
				objUsuario.setIdUsuario(rs.getString("idUsuario"));
				objUsuario.setClave(rs.getString("clave"));
				objUsuario.setEstado("1");
				
				objEmpleado.setIdPersona(rs.getString("idPersona"));
				objOficina.setIdOficina(rs.getString("idOficina"));
				objOficina.setNombre(rs.getString("nombreOficina"));
				objOficina.setNombreAbreviado(rs.getString("nombreOficinaAbrev")); 
				objArea.setIdArea(rs.getString("idArea"));
				objArea.setNombre(rs.getString("nombreArea"));
				objPuesto.setIdPuesto(rs.getString("idPuesto"));
				objPuesto.setNombre(rs.getString("nombreArea"));
				
				objPersonaNatural.setNombres(rs.getString("nombres"));
				objPersonaNatural.setApPaterno(rs.getString("apPaterno"));
				objPersonaNatural.setApMaterno(rs.getString("apMaterno"));
				
				objEmpleado.setObjUsuario(objUsuario);
				objEmpleado.setObjOficina(objOficina); 
				objEmpleado.setObjArea(objArea); 
				objEmpleado.setObjPuesto(objPuesto); 
				objEmpleado.setObjPersonaNatural(objPersonaNatural);
 			}

		} catch (Exception ex) {
			throw ex;
		} finally {
			objConexion.close();
		}

		return (IDTO) objEmpleado;
	}
}
