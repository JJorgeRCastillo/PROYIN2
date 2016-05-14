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

<!-- Latest compiled and minified CSS
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
-->
 </head>
<body>
<h1> Registrar Persona Natural</h1>
<c:if test="${not empty  mensajepernat}">
	Éxito: ${mensajepernat}
</c:if>
<spring:form action="registrarPersonaN" method="post">
<table>
<tr>
	  <td>Nombres: </td>
	 <!--   <td><input type="text" name="txtNombres" /></td> -->
	 <td>
	 	<spring:input path="nombres"/>
	 </td>
</tr>

<tr>
	  <td>Apellido Paterno: </td>
	  <td><spring:input path="apPaterno" /></td>
 
</tr>
 

<tr>
      <td>Apellido Materno: </td>
 	  <td><spring:input path="apMaterno" /></td>
</tr>
 
<tr>
      <td>Tipo Documento: </td>
      <td>
	 	  <spring:select class="form-control" path="tipoDocumento" style="width: 100%">	
		 	  <option value="0301"> D.N.I. </option>
		 	  <option value="0302"> RUC </option>
		 	  <option value="0303"> L.E. </option>
		 	  <option value="0304"> Pasaporte </option>
		 	  <option value="0305"> Carnet P.N.P. </option>
		 	  <option value="0306"> Acta de Nacimiento </option>
		 	  <option value="0307"> Boleta Militar </option>
		 	  <option value="0308"> Carnet FF.AA. </option>
		 	  <option value="0309"> L. Militar </option>
		 	  <option value="0310"> Carnet de Extranjería </option>
	 	  </spring:select>
 	  </td>
</tr>

<tr>
      <td>Número Documento: </td>
 	  <td><spring:input type="text" path="nroDocumento" /></td>
</tr>

<tr>
      <td>Sexo: </td>
 	  <td>
 	  <spring:select class="form-control" path="sexo" style="width: 100%">
	 	  <option value="M"> Masculino </option>
	 	  <option value="F"> Femenino </option>
 	  </spring:select>
 	  </td>

</tr>

<tr>
      <td>Dirección Actual: </td>
 	  <td><spring:input type="text" path="direccion" /></td>
</tr>

<tr>
      <td>Dirección del Negocio :</td>
 	  <td><input type="text" name="direccionNegocio" /></td>
</tr>

<tr>
      <td>Referencia: </td>
 	  <td><spring:input type="text" path="referenciaDireccion" /></td>
</tr>

<tr>
      <td>Urbanización: </td>
 	  <td>
 	   <spring:select class="form-control" path="objUrbanizacion.idUrbanizacion" style="width: 100%">
	 	  <option value="0100"> San Andrés </option>
	 	  <option value="0101"> El Bosque </option>
 	  </spring:select>
 	  </td>
</tr>

<tr>
      <td>Ubicación Geográfica: </td>
 	  <td>
 	   	  <spring:select class="form-control" path="objUbigeoDireccion.idUbigeo" style="width: 100%">
		 	  <option value="01010102"> Trujillo </option>
		 	  <option value="01130704"> Pacasmayo </option>
 	  	  </spring:select>
 	  </td>
</tr>

<tr>
      <td>Estado Civil: </td>
 	  <td>
 	    <spring:select class="form-control" path="estadoCivil" style="width: 100%">
	 	  <option value="0401">Soltero(a)</option>
	 	  <option value="0402">Casado(a)</option>
	 	  <option value="0403">Conviviente</option>
	 	  <option value="0404">Divorciado(a)</option>
	 	  <option value="0405">Viudo(a)</option>
	 	  <option value="0406">Separado</option>
 	  </spring:select>
 	  </td>
</tr>

<tr>
      <td>Grado de Instrucción: </td>
 		<td>
	 		  <spring:select class="form-control" path="gradoInstruccion" style="width: 100%">
			 	  <option value="0501"> Superior </option>
			 	  <option value="0502"> Primaria </option>
			 	  <option value="0503"> Secundaria </option>
			 	  <option value="0504"> Técnico </option>
			 	  <option value="0505"> Iletrado </option>
			 	  <option value="0507"> Inicial </option>
 	  		  </spring:select>
 	  </td>
</tr>

<tr>
      <td>Teléfono de Casa: </td>
 	  <td><spring:input type="text" path="telefono" /></td>
</tr>

<tr>
      <td>Tipo de Vivienda: </td>
 	  <td>
 	  <spring:select type="text" path="tipoVivienda" style="width: 100%">
			 	  <option value="0601"> Propia </option>
			 	  <option value="0602"> Alquilada </option>
			 	  <option value="0603"> No Indica </option>
			 	  <option value="0604"> Familiar </option>
 	  </spring:select>
 	  </td>
</tr>
<tr>
      <td>CIIU: </td>
	<td>
		  <spring:select class="form-control" path="objCiiu.idCiiu" style="width: 100%">
		 	  <option value="0121"> Cultivo de frutas </option>
		 	  <option value="0122"> Cría de ganado vacuno</option>
		  </spring:select>
 	  </td>
</tr>
<tr>
      <td>Profesión: </td>
 	  <td>
	 	  <spring:select class="form-control" path="profesion" style="width: 100%">
	 	  	<option value="0101"> Ingeniero </option>
		 </spring:select>
 	  </td>
</tr>
<tr>
      <td>Ocupación: </td>
 	  <td>
	 	  	<spring:select class="form-control" path="ocupacion" style="width: 100%">
	 	  		<option value="0201"> Trabajo </option>
			</spring:select>
 	  </td>
</tr>

<tr>
      <td>Tipo de Persona: </td>
 	  <td><spring:input type="text" path="tipoPersona" /></td>
</tr>

<tr>
      <td>Fecha Nacimiento: </td>
 	  <td><spring:input type="text" path="fechaNacimiento" /></td>
</tr>
<!--
 <tr>
      <td>Ingreso Mensual: </td>
 	  <td><input type="text" path="txtIngMensual" /></td>
</tr> 
-->
<tr> 
<td colspan="2" align="center">
	<input type="submit" value="Registrar" style="text-align:center" />
</td>
</tr>
</table>
</spring:form>
</body>
</html>