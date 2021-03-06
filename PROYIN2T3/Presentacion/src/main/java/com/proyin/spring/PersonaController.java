package com.proyin.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.proyin.adaptadores.IDTO;
import com.proyin.entidades.Empleado;
import com.proyin.entidades.PersonaNatural;
import com.proyin.negocio.PersonaNaturalLN;

@Controller
public class PersonaController {

	@RequestMapping("mostrarPersonaN")
	public ModelAndView mostrarFormulario(){
		return new ModelAndView("registropersona", "command", new PersonaNatural());
	}
	
	@RequestMapping(value = "registrarPersonaN", method = RequestMethod.POST)
	public String registrarPersonaNatural(PersonaNatural objPersonaNatural, ModelMap model, HttpServletRequest request) throws Exception{
			
		HttpSession sesion = request.getSession();
		Empleado objEmpleado = (Empleado) sesion.getAttribute("empleado");
		objPersonaNatural.setObjEmpelado(objEmpleado); 
		boolean respuesta = PersonaNaturalLN.getInstance().insert((IDTO)objPersonaNatural); 
		
		if(respuesta) {
			model.addAttribute("command", new PersonaNatural());
			model.addAttribute("mensajepernat", "Se registro correctamente.");
		} else{
			model.addAttribute("command", new PersonaNatural());
			model.addAttribute("mensajepernat", "Error al registrar.");
		}
		
		return "registropersona";
	}
}
