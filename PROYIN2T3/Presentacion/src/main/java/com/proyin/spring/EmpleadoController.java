package com.proyin.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyin.entidades.Empleado;
import com.proyin.negocio.EmpleadoLN;


@Controller
public class EmpleadoController {
	
	//@RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST} )
	@RequestMapping("irlogin")
	public ModelAndView goFormulario(){
		return new ModelAndView("login");
	}
		
	@RequestMapping(value = "/acceso", method = { RequestMethod.GET ,RequestMethod.POST} )
	public ModelAndView login(@RequestParam("usuario")String usuario, @RequestParam("clave") String clave, HttpServletRequest request) throws Exception{
		ModelAndView mv = null;
		try{
			Empleado objEmpleado = EmpleadoLN.getInstance().verficarAcceso(usuario, clave);
			
			if(objEmpleado != null){
				HttpSession sesion = request.getSession();
				sesion.setAttribute("empleado", objEmpleado); 
				mv = new ModelAndView("principal", "nombredatos", objEmpleado.getObjPersonaNatural().getNombres());
			}else{
				mv = new ModelAndView("principal", "nombredatos", "ERROR");
			}
		} catch(Exception ex){
			ex.toString();
		}
		return mv;
	}
}
