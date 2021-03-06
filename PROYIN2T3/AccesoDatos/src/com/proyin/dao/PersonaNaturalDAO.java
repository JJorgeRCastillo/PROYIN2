package com.proyin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.proyin.adaptadores.IDTO;
import com.proyin.contratos.IDAO;
import com.proyin.entidades.PersonaNatural;
import com.proyin.entidades.Ubigeo;
import com.proyin.entidades.Urbanizacion;

public class PersonaNaturalDAO implements IDAO {

	private static PersonaNaturalDAO _instance = null;

	private PersonaNaturalDAO() {
	}

	public static PersonaNaturalDAO getInstance() {
		if (_instance == null) {
			_instance = new PersonaNaturalDAO();
		}
		return _instance;
	}

	@Override
	public boolean insert(IDTO dto) throws Exception {
		Connection objConexion = Conexion.getInstance().ConectarBD2();
		PersonaNatural objPersonaNatural = (PersonaNatural)dto;
		boolean respuesta = false;
		try{
			objConexion.setAutoCommit(false); 
			CallableStatement cstm = 
					objConexion.prepareCall("{call SP_REGISTRAR_PERSONANATURAL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstm.setString(1, objPersonaNatural.getTipoPersona());
			cstm.setString(2, objPersonaNatural.getObjUrbanizacion().getIdUrbanizacion());
			cstm.setString(3, objPersonaNatural.getDireccion());
			cstm.setString(4, objPersonaNatural.getFechaNacimiento());
			cstm.setString(5, objPersonaNatural.getTipoVivienda());
			cstm.setString(6, objPersonaNatural.getTelefono());
			cstm.setString(7, objPersonaNatural.getObjUbigeoDireccion().getIdUbigeo());
			cstm.setString(8, objPersonaNatural.getObjEmpelado().getIdPersona()); // idUsuario
			cstm.setString(9, objPersonaNatural.getReferenciaDireccion());
			cstm.setString(10, objPersonaNatural.getProfesion());
			cstm.setString(11, objPersonaNatural.getDireccionNegocio());
			cstm.setString(12, objPersonaNatural.getNombres());
			cstm.setString(13, objPersonaNatural.getApPaterno());
			cstm.setString(14, objPersonaNatural.getApMaterno());
			cstm.setString(15, objPersonaNatural.getTipoDocumento());
			cstm.setString(16, objPersonaNatural.getNroDocumento());
			cstm.setString(17, objPersonaNatural.getSexo());
			cstm.setString(18, objPersonaNatural.getEstadoCivil());
			cstm.setString(19, objPersonaNatural.getGradoInstruccion());
			cstm.setString(20, objPersonaNatural.getOcupacion());
			cstm.setString(21, objPersonaNatural.getObjCiiu().getIdCiiu());
			
			cstm.execute();
			objConexion.commit();
			
			respuesta = true;
			
			
		}catch(Exception ex){
			respuesta = false;
			objConexion.rollback();
			throw ex;
		} finally{
			objConexion.setAutoCommit(true);
			objConexion.close();
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
	
	public IDTO getByDocumento(String dni) throws Exception {
		Connection objConexion = Conexion.getInstance().ConectarBD2();
		PersonaNatural objPersonaNatural = null;
		
		try{
			CallableStatement cstm = objConexion.prepareCall("{call SP_BUSCAR_PERSONANATURAL(?)}");
			cstm.setString(1, dni);
			
			ResultSet rs = cstm.executeQuery();
			
			if(rs.next()){
				objPersonaNatural = new PersonaNatural();
				Urbanizacion objUrbanizacion = new Urbanizacion();
				Ubigeo objUbigeo = new Ubigeo();
				objPersonaNatural.setIdPersona(rs.getString("IdPersona"));
				objPersonaNatural.setApPaterno(rs.getString("PrimerApellido"));
				objPersonaNatural.setApMaterno(rs.getString("SegundoApellido"));
				objPersonaNatural.setNombres(rs.getString("PreNombres"));
				objPersonaNatural.setNroDocumento(rs.getString("NroDocIdentidad"));
				objPersonaNatural.setTipoPersona(rs.getString("TipoPersona"));
				objPersonaNatural.setSexo(rs.getString("Sexo"));
				objUrbanizacion.setNombre(rs.getString("Urbanizacion"));
				objPersonaNatural.setDireccion(rs.getString("Direccion"));
				objUbigeo.setNombre(rs.getString("Ubigeo"));
				objPersonaNatural.setTipoDocumento(rs.getString("TipoDocumento"));
				
				objPersonaNatural.setObjUrbanizacion(objUrbanizacion);
				objPersonaNatural.setObjUbigeoNacionalidad(objUbigeo);
			}
			
		}catch(Exception ex){
			throw ex;
		}finally{
			objConexion.close();
		}
		return (IDTO)objPersonaNatural;
	}


}
