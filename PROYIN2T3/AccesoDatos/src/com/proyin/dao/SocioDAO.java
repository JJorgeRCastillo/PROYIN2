package com.proyin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

import com.proyin.adaptadores.IDTO;
import com.proyin.contratos.IDAO;
import com.proyin.entidades.AsignaDocumentoxOperacion;
import com.proyin.entidades.Parametro;
import com.proyin.entidades.Socio;
import com.proyin.entidades.Usuario;

public class SocioDAO implements IDAO{

	private static SocioDAO _instance = null;

	private SocioDAO() {
	}

	public static SocioDAO getInstance() {
		if (_instance == null) {
			_instance = new SocioDAO();
		}
		return _instance;
	}
	
	public boolean insert(IDTO idtoSocio, IDTO idtoUsuario, float aporte) throws Exception {
		Connection objConexion = Conexion.getInstance().ConectarBD2();
		Socio objSocio = (Socio)idtoSocio;
		Usuario objUsuario = (Usuario)idtoUsuario;
		AsignaDocumentoxOperacion objAsignacionDocumento;
		Parametro objParametro = null;
		boolean respuesta = false;
		try{
			CallableStatement cstm = objConexion.prepareCall("{call SP_INSERTAR_SOCIO(?,?,?,?,?,?,?,?,?,?,?)}");
			objConexion.setAutoCommit(false); 
			
			String nombreSocio = objSocio.getObjPersonaNatural().getApPaterno() + " " +
								 objSocio.getObjPersonaNatural().getApMaterno() + " " +
								 objSocio.getObjPersonaNatural().getNombres();
			objSocio.setNombreSocio(nombreSocio); 
			cstm.setString(1, objSocio.getObjPersonaNatural().getIdPersona()); // idPersona
			cstm.setString(2, nombreSocio); // nombre socio
			cstm.setString(3, "11"); // estado socio
			cstm.setString(4, objSocio.getObjPersonaNatural().getTipoPersona()); // tipo de persona (N, J)
			cstm.setString(5, objUsuario.getObjEmpleado().getObjOficina().getIdOficina()); // id de oficina
			cstm.setString(6, objSocio.getTipoTrabajador()); // id de tipo trabajador
			cstm.setFloat(7, objSocio.getAporteInicial()); // monto de aporte incial
			cstm.setFloat(8, objSocio.getFondoMortuorio()); // monto de fondo mortuorio
			cstm.setFloat(9, objSocio.getDerechoInscripcion()); // monto derecho de inscripcion
			cstm.setString(10, objUsuario.getIdUsuario()); // ID DEL USUARIO
			cstm.setString(11, "0"); // ingreso de PIC
			
			cstm.execute();
			CuentaDAO.getInstance().insert((IDTO)objSocio,(IDTO) objUsuario); 
			
			// obtenemos la asignacion del documento a la operacion realizada
			objAsignacionDocumento = (AsignaDocumentoxOperacion)AsignaDocumentoxOperacionDAO.getInstance().verificarAsignacionDocumento("00001", "1"); 
			
			objParametro = (Parametro)ParametroDAO.getInstance().getParametroCompuesto(objAsignacionDocumento.getObjDocumento().getParametro(), objUsuario.getObjEmpleado().getObjOficina().getIdOficina(), "1");
			
			// registro de documento generado
			AsignaDocumentoxOperacionDAO.getInstance().documentoGenerado(idtoUsuario,(IDTO) objAsignacionDocumento, idtoSocio, (IDTO)objParametro);
			
			
			// Actualizar parametro
			ParametroDAO.getInstance().actualizarParametro((IDTO)objParametro);
			
			objConexion.commit();
			
			
			respuesta = true;
			
		}catch(Exception ex){
			objConexion.rollback();
			throw ex;
		}finally{
			objConexion.setAutoCommit(true);
			objConexion.close();
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