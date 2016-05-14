<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cooperativa San Lorenzo</title>

</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- CONTENT -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">		
						<div class="title_left">
							<h3></h3>
						</div>
					</div>
					
					<div class="clearfix"></div>
					
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Registro de Persona Natural</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<br />
									<c:if test="${not empty  mensajepernat}">
										�xito: ${mensajepernat}
									</c:if>
									<spring:form id="form-persona-nat" action="registrarPersonaN" method="post" class="form-horizontal form-label-left">
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Nombres</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:input path="nombres" type="text" class="form-control col-md-7 col-xs-12" required="required" />
                        					</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Apellido Paterno</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:input path="apPaterno" type="text" class="form-control col-md-7 col-xs-12" required="required" />
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Apellido Materno</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:input path="apMaterno" type="text" class="form-control col-md-7 col-xs-12" required="required"  />
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Tipo Documento</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:select path="tipoDocumento" class="form-control">	 
												 	  <option value="0301"> D.N.I. </option>
												 	  <option value="0302"> RUC </option>
												 	  <option value="0303"> L.E. </option>
												 	  <option value="0304"> Pasaporte </option>
												 	  <option value="0305"> Carnet P.N.P. </option>
												 	  <option value="0306"> Acta de Nacimiento </option>
												 	  <option value="0307"> Boleta Militar </option>
												 	  <option value="0308"> Carnet FF.AA. </option>
												 	  <option value="0309"> L. Militar </option>
												 	  <option value="0310"> Carnet de Extranjer�a </option>
						 	  					</spring:select>
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">N�mero Documento</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:input path="nroDocumento" type="text" class="form-control col-md-7 col-xs-12" required="required" />
                        					</div>										
										</div>										
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Sexo</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:select path="sexo" type="text" class="form-control col-md-7 col-xs-12">
											 	  <option value="M">Masculino</option>
											 	  <option value="F">Femenino</option>                          						
                          						</spring:select>
                        					</div>										
										</div>	
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Direcci�n Actual</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:input path="direccion" type="text" class="form-control col-md-7 col-xs-12" required="required" />
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Direcci�n del Negocio</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:input path="direccionNegocio" type="text" class="form-control col-md-7 col-xs-12" required="required" />
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Referencia</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:input path="referenciaDireccion" type="text" class="form-control col-md-7 col-xs-12" required="required" />
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Urbanizaci�n</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:select path="objUrbanizacion.idUrbanizacion" type="text" class="form-control col-md-7 col-xs-12">
											 	  <option value="0100">San Andr�s</option>
											 	  <option value="0101">El Bosque</option>                          						
                          						</spring:select>
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Ubicaci�n Geogr�fica</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:select path="objUbigeoDireccion.idUbigeo" type="text" class="form-control col-md-7 col-xs-12">
											 	  <option value="01010102">Trujillo</option>
											 	  <option value="01130704">Pacasmayo</option>                          						
                          						</spring:select>
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Estado Civil</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
									 	    <spring:select path="estadoCivil" type="text" class="form-control col-md-7 col-xs-12">
										 		<option value="0401">Soltero(a)</option>
										 		<option value="0402">Casado(a)</option>
										 		<option value="0403">Conviviente</option>
										 	  	<option value="0404">Divorciado(a)</option>
										 	  	<option value="0405">Viudo(a)</option>
										 	  	<option value="0406">Separado</option>
									 	    </spring:select>
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Grado de Instrucci�n</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
									 	    <spring:select path="gradoInstruccion" type="text" class="form-control col-md-7 col-xs-12">
										 		<option value="0501">Superior</option>
								 	  			<option value="0502">Primaria</option>
										 	  	<option value="0503">Secundaria</option>
										 	  	<option value="0504">T�cnico</option>
										 	  	<option value="0505">Iletrado</option>
										 	 	 <option value="0507">Inicial</option>
									 	    </spring:select>
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Tel�fono de Casa</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:input path="telefono" type="text" class="form-control col-md-7 col-xs-12" required="required" />
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Tipo de Vivienda</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
									 	    <spring:select path="tipoVivienda" type="text" class="form-control col-md-7 col-xs-12">
										 		<option value="0601">Propia</option>
								 	  			<option value="0602">Alquilada</option>
								 	  			<option value="0603">No Indica</option>
								 	  			<option value="0604">Familiar</option>
									 	    </spring:select>
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">CIIU</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
									 	    <spring:select path="objCiiu.idCiiu" type="text" class="form-control col-md-7 col-xs-12" >
										 		<option value="0121">Cultivo de frutas</option>
								 	  			<option value="0122">Alquilada</option>
									 	    </spring:select>
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Profesi�n</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
									 	    <spring:select path="profesion" type="text" class="form-control col-md-7 col-xs-12">
								 	  			<option value="0101">Ingeniero</option>
									 	    </spring:select>
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Profesi�n</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
									 	    <spring:select path="ocupacion" type="text" class="form-control col-md-7 col-xs-12">
								 	  			<option value="0201">Trabajo</option>
									 	    </spring:select>
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Tipo de Persona</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:input path="tipoPersona" type="text" class="form-control col-md-7 col-xs-12" required="required" />
                        					</div>										
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Fecha Nacimiento</label>
                        					<div class="col-md-6 col-sm-6 col-xs-12">
                          						<spring:input path="fechaNacimiento" type="text" class="form-control col-md-7 col-xs-12" required="required" />
                        					</div>										
										</div>
										 <div class="ln_solid"></div>
										 <div class="form-group">
										 	<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
										 		<input type="submit" class="btn btn-primary" value="Registrar" />
										 	</div>
										 </div>
					 			</spring:form>
								</div>
							</div>
						</div>	
					</div>
				</div>
				<!-- END CONTENT -->
			</div>
		</div>
	</div>
</body>
</html>