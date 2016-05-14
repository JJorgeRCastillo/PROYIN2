<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cooperativa San Lorenzo</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2 align="center">Acceso al Sistema</h2>
		<form action="acceso" method="post" class="form-signin">
			<div class="form-group">
			<table align="center"> 
			<tr>
				<td><label for="usuario" class=>Usuario:</label></td>
				<td><input name="usuario" value="" class="form-control" /></br></td> 
			</tr>
			<tr>
				<td><label for="clave">Contraseņa:</label></td>
				<td><input name="clave" value="" class="form-control" type="password" /></br></td> 
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Ingresar" style="text-align:center" class="btn btn-default"></td>
			</tr>
			</table>
			</div>
		</form>
	</div>
</body>
</html>

