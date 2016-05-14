package com.proyin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.proyin.adaptadores.IDTO;
import com.proyin.contratos.IDAO;
import com.proyin.entidades.AsignaDocumentoxOperacion;
import com.proyin.entidades.Documento;
import com.proyin.entidades.Parametro;
import com.proyin.entidades.Socio;
import com.proyin.entidades.Usuario;

public class AsignaDocumentoxOperacionDAO implements IDAO{

	private static AsignaDocumentoxOperacionDAO _instance = null;

	private AsignaDocumentoxOperacionDAO() {
	}

	public static AsignaDocumentoxOperacionDAO getInstance() {
		if (_instance == null) {
			_instance = new AsignaDocumentoxOperacionDAO();
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
	
	public IDTO verificarAsignacionDocumento(String idOperacion, String tipoMoneda) throws Exception {
		Connection objConexion = Conexion.getInstance().ConectarBD2();
		AsignaDocumentoxOperacion objAsignacionDocumento = null;
		Documento objDocumento = null;
		try{
			CallableStatement cstm = objConexion.prepareCall("{call SP_OBTENER_ASIGNACION_DOCUMENTO(?,?)}");
			cstm.setString(1, idOperacion);
			cstm.setString(2, tipoMoneda);
			
			ResultSet rs = cstm.executeQuery();
			
			if(rs.next()){
				objAsignacionDocumento = new AsignaDocumentoxOperacion();
				objDocumento = new Documento();
				
				objAsignacionDocumento.setIdOpe(rs.getString("idOpe"));
				objDocumento.setIdDocumento(rs.getString("idDoc"));
				objDocumento.setNombreDocumento(rs.getString("nombreDoc"));
				objAsignacionDocumento.setTipMoneda(rs.getString("tipMoneda"));
				objDocumento.setParametro(rs.getString("parametro"));
				
				objAsignacionDocumento.setObjDocumento(objDocumento);
			}
			
		}catch(Exception ex){
			throw ex;
		}finally{
			
		}
		return (IDTO)objAsignacionDocumento;
	}
	
	public boolean documentoGenerado(IDTO idtoUsuario, IDTO idtoAsignacionDoc, IDTO idtoSocio, IDTO idtoParametro) throws Exception {
		Connection objConexion = Conexion.getInstance().ConectarBD2();
		Usuario objUsuario = (Usuario)idtoUsuario;
		AsignaDocumentoxOperacion objAsignacion = (AsignaDocumentoxOperacion)idtoAsignacionDoc;
		Parametro objParametro = (Parametro)idtoParametro;
		Socio objSocio = (Socio)idtoSocio;
		String glosa = "REGISTRO INICIAL SOCIO " + objSocio.getNombreSocio();
		boolean respuesta = false;
		try {
			CallableStatement cstm = objConexion.prepareCall("{call SP_INSERTAR_DOCGENERADO(?,?,?,?,?,?,?,?,?)}");
			cstm.setString(1, objUsuario.getObjEmpleado().getObjOficina().getIdOficina());
			cstm.setString(2, objAsignacion.getObjDocumento().getIdDocumento());
			cstm.setString(3, objParametro.getValor());
			cstm.setString(4, "1");
			cstm.setString(5, "01"); // estado del documento
			cstm.setString(6, objAsignacion.getIdOpe());
			cstm.setString(7, objSocio.getObjPersonaNatural().getIdPersona());
			cstm.setString(8, glosa);
			cstm.setString(9,objUsuario.getIdUsuario());
			
			cstm.execute();
			respuesta = true;
			
		} catch (Exception ex) {
			respuesta = false;
			throw ex;
		} finally {
			
		}
		return respuesta;
	}
}
