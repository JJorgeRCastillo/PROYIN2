<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cooperativa San Lorenzo</title>
</head>
 <body style="background:#F7F7F7;">
      <div id="wrapper">
        <div id="login" class="form">
          <section class="login_content">
            <form action="acceso" method="post">
            	<h1 align="center">Acceso al Sistema</h1>
            	<table align="center">
      				<tr>
      					<td>Usuario</td>
      					<td><input type="text" name="usuario" value="" /></td>
      				</tr>
      				<tr>
      					<td>Contraseņa</td>
      					<td><input type="password" name="clave" value="" /></td>
      				</tr>
      				<tr>
      					<td colspan="2"><input type="submit" value="Ingresar"  class="btn btn-default" style="margin-left: 100px;"/> </td>
      				</tr>
      			</table>
            </form>
          </section>
        </div>
      </div>
  </body>
</html>

