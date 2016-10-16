package com.proyin.clasesbases;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.proyin.adaptadores.IDTO;
import com.proyin.entidades.DatosCredito;
import com.proyin.entidades.Empleado;
import com.proyin.entidades.Oficina;
import com.proyin.entidades.PersonaNatural;
import com.proyin.entidades.Puesto;
import com.proyin.entidades.SeguimientoExpedienteCredito;
import com.proyin.entidades.Usuario;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JorgePC on 21/06/16.
 */
public class WebServiceConection {
    //192.168.1.37
    private static String NAMESPACE = "http://servicio.proyin.com/";
    private static String URL = "http://10.252.35.170:8080/WSCooperativa/WSCooperativaSL?WSDL";
    private static String ACTION;
    private static String SOAP_ACTION;

    /**
     *
     * @param sopaAction Nombre de la accion del webservice
     * @return Retorna una instancia del objeto WebServiceConection
     */
    public WebServiceConection(String sopaAction) {
        ACTION = sopaAction;
        SOAP_ACTION = NAMESPACE + ACTION;
    }

    /**
     *
     * @param usuario Usuario para acceder a la app
     * @param clave Clave para acceder a la app
     * @return Retorna una interfaz del tipo IDTO
     */
    public IDTO invokeLogin(String usuario, String clave) {

        Empleado objEmpleado = new Empleado();

        SoapObject request = new SoapObject(NAMESPACE, ACTION);

        request.addProperty("usuario", usuario);
        request.addProperty("clave", clave);
        request.addProperty("tipo", "MOVIL"); // PARA CONEXION MOVIL

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(URL);

        try{
            httpTransport.call(SOAP_ACTION, envelope);
            SoapObject response = (SoapObject)envelope.getResponse();
            objEmpleado = (Empleado) getEmpleadoEntity(response, objEmpleado);

        } catch (Exception ex) {
            // solo para enviar un mensaje de error de excepcion
            objEmpleado.setIdPersona(TipoError.EXCEPCION.toString());
        }


        return (IDTO) objEmpleado;
    }

    public List<DatosCredito> invokeExpedientesPendientes(String tipoDocumento, String estadoDocumento
            , String idOficina, String idUsuarioApr, String idOficinaUsuario) {

        List<DatosCredito> lstDatosCredito = null;

        SoapObject request = new SoapObject(NAMESPACE, ACTION);
        request.addProperty("tipoDocumento", tipoDocumento);
        request.addProperty("estadoDocumento", estadoDocumento);
        request.addProperty("idOficina", idOficina);
        request.addProperty("idUsuarioApr", idUsuarioApr);
        request.addProperty("idOficinaUsuario", idOficinaUsuario);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(URL);

        try {
            httpTransport.call(SOAP_ACTION, envelope);
            SoapObject response = (SoapObject)envelope.bodyIn;
            lstDatosCredito = getDatosCreditoList(response);
        } catch (Exception ex) {
            DatosCredito objDatosCredito = new DatosCredito();
            objDatosCredito.setComentarios(TipoError.EXCEPCION.toString());
           lstDatosCredito.add(objDatosCredito);
        }

        return lstDatosCredito;

    }

    /**
     *
     * @param idto Objeto que impleta interfaz IDTO para adaptarla
     * @return Retornar true si se guardo correctamente o false si ocurre un error
     */
    public boolean invokeAprobarExpedienteCredito(IDTO idto) {

        DatosCredito objDatosCredito = (DatosCredito)idto;
        boolean respuesta = false;

        SoapObject request = new SoapObject(NAMESPACE, ACTION);

        request.addProperty("montoAprobado",String.valueOf(objDatosCredito.getMontoAprobado()));
        request.addProperty("plazoAprobado", objDatosCredito.getPlazoAprobado());
        request.addProperty("tasaAprobada", String.valueOf(objDatosCredito.getIcAprobado()));
        request.addProperty("fechaVPrimCouta", objDatosCredito.getFechaVencimientoPimCouta());
        request.addProperty("nroDocumento", objDatosCredito.getObjDocumentoGenerado().getNroDocumento());
        request.addProperty("tipoMoneda", objDatosCredito.getObjDocumentoGenerado().getTipoMoneda());
        request.addProperty("idOficina", objDatosCredito.getObjDocumentoGenerado().getObjOfcina().getIdOficina());
        request.addProperty("idUsuario", objDatosCredito.getObjDocumentoGenerado().getObjUsuario().getIdUsuario());
        request.addProperty("idPersona", objDatosCredito.getObjDocumentoGenerado().getObjPersona().getIdPersona());
        request.addProperty("idOperacion", getIdOperacion(objDatosCredito.getObjProductoCrediticio().getIdProductoCrediticio()));
        request.addProperty("estadoDocumentoAnt", objDatosCredito.getObjDocumentoGenerado().getEstadoDocumento().split("-")[0]);
        request.addProperty("fechaDocumentoAnt", getFormatoFecha(objDatosCredito.getObjDocumentoGenerado().getFechaDocumento()));
        request.addProperty("fechaProcesoAnt", getFormatoFecha(objDatosCredito.getFechaProceso()));
        request.addProperty("horaProcesoAnt", objDatosCredito.getHoraProceso());

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(URL);

        try {
            httpTransport.call(SOAP_ACTION, envelope);
            SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
            respuesta = Boolean.valueOf(response.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = false;
        }

        return respuesta;
    }

    /**
     *
     * @param response Respuesta del tipo SoapObject
     * @param transferObject Interfaz que sera retornada
     * @return Retorna una interfaz del tipo IDTO
     */
    private IDTO getEmpleadoEntity(SoapObject response, IDTO transferObject) {
        Empleado objEmpleado = (Empleado) transferObject;
        Usuario objUsuario = new Usuario();
        objEmpleado.setObjUsuario(objUsuario);

        if (response == null) {
            objEmpleado = null;
        } else {
            objEmpleado.setIdPersona(response.getProperty("idPersona").toString());

            // Costruimos el objeto anidado de IDTO Usuario
            SoapObject soapUsuario = (SoapObject)response.getProperty("objUsuario");
            objEmpleado.getObjUsuario().setIdUsuario(soapUsuario.getProperty("idUsuario").toString());

            // Construimos el objeto anidado de IDTO Oficina
            SoapObject soapOficina = (SoapObject) response.getProperty("objOficina");
            objEmpleado.getObjOficina().setIdOficina(soapOficina.getProperty("idOficina").toString());
            objEmpleado.getObjOficina().setNombre(soapOficina.getProperty("nombre").toString());

            // Construimos el objeto anidado de IDTO PersonaNatural
            SoapObject soapPersonaNatural = (SoapObject)response.getProperty("objPersonaNatural");
            objEmpleado.getObjPersonaNatural().setIdPersona(soapPersonaNatural.getProperty("idPersona").toString());
            objEmpleado.getObjPersonaNatural().setApMaterno(soapPersonaNatural.getProperty("apMaterno").toString());
            objEmpleado.getObjPersonaNatural().setApPaterno(soapPersonaNatural.getProperty("apPaterno").toString());
            objEmpleado.getObjPersonaNatural().setNombres(soapPersonaNatural.getProperty("nombres").toString());
            objEmpleado.getObjPersonaNatural().setNroDocumento(soapPersonaNatural.getProperty("nroDocumento").toString().trim());

            // Construimos el objeto anidado de IDTO Puesto
            SoapObject soapPuesto = (SoapObject)response.getProperty("objPuesto");
            objEmpleado.getObjPuesto().setIdPuesto(soapPuesto.getProperty("idPuesto").toString());
            objEmpleado.getObjPuesto().setNombre(soapPuesto.getProperty("nombre").toString());
        }

        return (IDTO) objEmpleado;
    }

    /**
     *
     * @param response Respuesta del tipo SoapObject
     * @return Retorna una interfaz del tipo IDTO
     */
    private IDTO getDatosCreditoEntity(SoapObject response) {
        DatosCredito objDatosCredito = new DatosCredito();

        // Construimos la entidad DatosCredito
        objDatosCredito.setFechaVencimientoPimCouta(response.getProperty("fechaVencimientoPimCouta").toString());
        objDatosCredito.setFechaProceso(response.getProperty("fechaProceso").toString());
        objDatosCredito.setHoraProceso(response.getProperty("horaProceso").toString());
        objDatosCredito.setIcSolicitado(Float.parseFloat(response.getProperty("icSolicitado").toString()));
        objDatosCredito.setIcAprobado(Float.parseFloat(response.getProperty("icAprobado").toString()));
        objDatosCredito.setMontoAprobado(Float.parseFloat(response.getProperty("montoAprobado").toString()));
        objDatosCredito.setMontoSolicitado(Float.parseFloat(response.getProperty("montoSolicitado").toString()));
        objDatosCredito.setNivel1(response.getProperty("nivel1").toString());
        objDatosCredito.setPlazoAprobado(Integer.parseInt(response.getProperty("plazoAprobado").toString()));
        objDatosCredito.setPlazoSolicitado(Integer.parseInt(response.getProperty("plazoSolicitado").toString()));
        objDatosCredito.setTipoCredito(response.getProperty("tipoCredito").toString());

        // Construimos la entidad DocumentoGenerado
        SoapObject soapDocumentoGenerado = (SoapObject) response.getProperty("objDocumentoGenerado");
        objDatosCredito.getObjDocumentoGenerado().setFechaDocumento(soapDocumentoGenerado.getProperty("documentoAnterior").toString());
        objDatosCredito.getObjDocumentoGenerado().setEstadoDocumento(soapDocumentoGenerado.getProperty("estadoDocumento").toString());
        objDatosCredito.getObjDocumentoGenerado().setFechaCambioEstado(soapDocumentoGenerado.getProperty("fechaCambioEstado").toString());
        objDatosCredito.getObjDocumentoGenerado().setFechaDocumento(soapDocumentoGenerado.getProperty("fechaDocumento").toString());
        objDatosCredito.getObjDocumentoGenerado().setNroDocumento(soapDocumentoGenerado.getProperty("nroDocumento").toString());
        objDatosCredito.getObjDocumentoGenerado().setTipoMoneda(soapDocumentoGenerado.getProperty("tipoMoneda").toString());

        SoapObject soapDocumento = (SoapObject) soapDocumentoGenerado.getProperty("objDocumento");
        objDatosCredito.getObjDocumentoGenerado().getObjDocumento().setIdDocumento(soapDocumento.getProperty("idDocumento").toString());

        SoapObject soapOficina = (SoapObject) soapDocumentoGenerado.getProperty("objOfcina");
        objDatosCredito.getObjDocumentoGenerado().getObjOfcina().setIdOficina(soapOficina.getProperty("idOficina").toString());
        objDatosCredito.getObjDocumentoGenerado().getObjOfcina().setNombreAbreviado(soapOficina.getProperty("nombreAbreviado").toString());

        SoapObject soapPersona = (SoapObject) soapDocumentoGenerado.getProperty("objPersona");
        objDatosCredito.getObjDocumentoGenerado().getObjPersona().setIdPersona(soapPersona.getProperty("idPersona").toString());

        SoapObject soapUsuario = (SoapObject) soapDocumentoGenerado.getProperty("objUsuario");
        objDatosCredito.getObjDocumentoGenerado().getObjUsuario().setIdUsuario(soapUsuario.getProperty("idUsuario").toString());


        // Construimos la entidad ProductoCrediticio
        SoapObject soapProductoCrediticio = (SoapObject) response.getProperty("objProductoCrediticio");
        objDatosCredito.getObjProductoCrediticio().setIdProductoCrediticio(soapProductoCrediticio.getProperty("idProductoCrediticio").toString());

        // Construimos la entidad SeguimientoExpedienteCredito
        SoapObject soapSeguimiento = (SoapObject) response.getProperty("objSeguimiento");
        objDatosCredito.getObjSeguimiento().setMaximoNivel(Integer.parseInt(soapSeguimiento.getProperty("maximoNivel").toString()));
        objDatosCredito.getObjSeguimiento().setNivel(soapSeguimiento.getProperty("nivel").toString());

        SoapObject soapSocio = (SoapObject) response.getProperty("objSocio");
        objDatosCredito.getObjSocio().setIdSocio(soapSocio.getProperty("idSocio").toString());
        objDatosCredito.getObjSocio().setNombreSocio(soapSocio.getProperty("nombreSocio").toString());


        return objDatosCredito;
    }

    /**
     *
     * @param response Respuesta del tipo SoapObject
     * @return
     */
    private List<DatosCredito> getDatosCreditoList(SoapObject response) {

        List<DatosCredito> lstDatosCredito = new ArrayList<>();
        int k = response.getPropertyCount();
        for (int i = 0; i < response.getPropertyCount(); i++) {
            IDTO objDatosCredito = getDatosCreditoEntity((SoapObject) response.getProperty(i));
            lstDatosCredito.add((DatosCredito) objDatosCredito);
        }

        return lstDatosCredito;
    }

    /**
     *
     * @param tipoProducto Cadena con el valor del tipo de producto
     * @return String con el valor del codigo de operacion
     */
    private String getIdOperacion(@NonNull String tipoProducto) {
        if (tipoProducto.equals("0003")){
            return "00210";
        }
        return "00211";
    }

    /**
     *
     * @param fecha Formato de fecha en [yyyy-mm-dd]
     * @return Retorna el formato de fecha [dd-mm-yyyy]
     */
    private String getFormatoFecha(@NonNull String fecha) {
        String[] ffecha = fecha.split("-");
        return ffecha[2] + "/" + ffecha[1] + "/" + ffecha[0];
    }
}
