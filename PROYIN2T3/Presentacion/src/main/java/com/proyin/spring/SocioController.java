package com.proyin.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.proyin.adaptadores.IDTO;
import com.proyin.entidades.Empleado;
import com.proyin.entidades.PersonaNatural;
import com.proyin.entidades.Socio;
import com.proyin.entidades.Usuario;
import com.proyin.negocio.PersonaNaturalLN;
import com.proyin.negocio.SocioLN;

@Controller
public class SocioController {

	@RequestMapping(value = "afiliarSocio", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView mostrarFormulario(){
		return new ModelAndView("registrosocio");
	}
	
	@RequestMapping(value="/buscarsocio", method= {RequestMethod.POST, RequestMethod.GET}, 
            produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String buscarPersonaNatural(@RequestParam("DNI") String dni) throws Exception{
		String nroDni = dni;
		String output = "";
		PersonaNatural objPersonaNatural = null;
		try{
			objPersonaNatural = PersonaNaturalLN.getInstance().getByDocumento(nroDni);
			if(objPersonaNatural != null) {
				output = "<h2>Datos Personales</h2>" +
						  "<input id='tpoPersona' type='hidden' name='tpoPersona' value='"+objPersonaNatural.getTipoPersona()+"' />"
						+ "<table>" +
					    "<tr>" +
					   	  "<td>C�digo:" +
						  "</td>" +
					  	  "<td> <label id='codigoPersonaN'>" + 
						 objPersonaNatural.getIdPersona() +
						"</label></td>" +
					    "</tr>" +
						"<tr>" +
						  	 "<td>Nombres:" +
							 "</td>" +
						  	 "<td><label id='nombres'>" + 
						  	objPersonaNatural.getNombres() +
							"</label></td>" +
						 "</tr>" +
						  "<tr>" +
						  	 "<td>Apellido Paterno:" +
							 "</td>" +
						  	 "<td><label id='apellidoP'>" + 
							 objPersonaNatural.getApPaterno() + 
							"</label></td>" +
						 "</tr>" +
						 "<tr>" +  
						    "<td>Apellido Materno:" +
						 	"</td>" +
						    "<td><label id='apellidoM'>" +
						    	objPersonaNatural.getApMaterno() + 
						 	"</label></td>" +
						 "</tr>" +
						  "<tr>" +
						  	 "<td>Nro. Documeto:" +
							 "</td>" +
						  	 "<td><label id='nroDoc'>" + 
							 objPersonaNatural.getNroDocumento() + 
							"</label></td>" +
						 "</tr>" +		
						  "<tr>" +
						  	 "<td>Direcci�n:" +
							 "</td>" +
						  	 "<td><label id='direccion'>" + 
							 objPersonaNatural.getDireccion() + 
							"</label></td>" +
						 "</tr>" +						
				       "</table>";
			} else{
				output = "No existe la persona.";
			}
		}catch(Exception ex){
			output = "ERROR";
		}
		return output;
	}

	@RequestMapping(value="/registrarsocio", method = RequestMethod.POST, 
            produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String registrarSocio(HttpServletRequest request) throws Exception{
		HttpSession sesion = request.getSession();
		Empleado objEmpleado = (Empleado)sesion.getAttribute("empleado");
		Usuario objUsuario = new Usuario();
		PersonaNatural objPersonaNatural = new PersonaNatural();
		Socio objSocio = new Socio();
		objUsuario.setIdUsuario(objEmpleado.getObjUsuario().getIdUsuario());
		objUsuario.setObjEmpleado(objEmpleado);
		objPersonaNatural.setIdPersona(request.getParameter("ID"));
		objPersonaNatural.setNombres(request.getParameter("Nombres"));
		objPersonaNatural.setApPaterno(request.getParameter("ApellidoP"));
		objPersonaNatural.setApMaterno(request.getParameter("ApellidoM"));
		objPersonaNatural.setTipoPersona(request.getParameter("TpoPer")); 
		objSocio.setObjPersonaNatural(objPersonaNatural); 
		objSocio.setAporteInicial(Float.parseFloat(request.getParameter("AporteIni")));
		objSocio.setDerechoInscripcion(Float.parseFloat(request.getParameter("DerInscri")));
		objSocio.setFondoMortuorio(Float.parseFloat(request.getParameter("FondoM"))); 
		objSocio.setTipoTrabajador(request.getParameter("TpoTrab")); 
		boolean respuesta = false;
		String output = "";
		try{
			respuesta = SocioLN.getInstance().insert((IDTO)objSocio, (IDTO)objUsuario, objSocio.getAporteInicial());
			
			if (respuesta) {
				output = "<label style='color: green; font-weight: bold;'>Se registro socio de manera correcta.<label>";
			} else{
				output = "<label style='color: red; font-weight: bold;'>No se pudo registrar socio.<label>";
			}
		}catch(Exception ex){
			output = "<label style='color: red; font-weight: bold;'>Error al procesar afiliacion de socio.<label>";
		}
		return output;
	}
}
