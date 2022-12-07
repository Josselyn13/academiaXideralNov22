<!DOCTYPE html>
<html>

<head>
	<title>Actualizar Deportista</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Actualizar Deportista</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar Deportista</h3>
		
		<form action="DeportistaControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="deportistaId" value="${THE_DEPORTISTA.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" 
								   value="${THE_DEPORTISTA.nombre}" /></td>
					</tr>

					<tr>
						<td><label>Apellido Paterno:</label></td>
						<td><input type="text" name="aPaterno" 
								   value="${THE_DEPORTISTA.aPaterno}" /></td>
					</tr>

					<tr>
						<td><label>Apellido Materno:</label></td>
						<td><input type="text" name="aMaterno" 
								   value="${THE_DEPORTISTA.aMaterno}" /></td>
					</tr>
					<tr>
						<td><label>Deporte:</label></td>
						<td><input type="text" name="deporte" 
								   value="${THE_DEPORTISTA.deporte}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="DeportistaControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











