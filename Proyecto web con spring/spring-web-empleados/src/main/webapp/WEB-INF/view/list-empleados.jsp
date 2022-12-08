<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Hospital</title>
	
	<!-- reference our style sheet -->

	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>

	<div id="wrapper" class="mt-4 row">
		<img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="logo" width="10px" class="col-sm-2">
		<div class="col-sm-10 mt-4">
			<h1 class="font-weight-bold">Hospital central</h1>
		</div>
	</div>
	
	<div id="boton-agregar" class="mt-4">
		<!-- put new button: Add Empleado -->
		<input type="button" value="Agregar empleado" 
			onclick="window.location.href='showFormForAdd'; return false;"
			class="btn btn-success"/>
	</div>
	
	<div id="container" class="text-center mt-4">
	
		<div id="content">
		
			<!--  add our html table here -->
			
			<table class="table table-striped table-hover">
				
				<thead class="bg-primary text-white">
					<tr>
						<th>Nombre</th>
						<th>Apellido paterno</th>
						<th>Apellido materno</th>
						<th>Correo</th>
						<th>Acción</th>
					</tr>
				</thead>
				
				<!-- loop over and print our empleados -->
				<c:forEach var="tempEmpleado" items="${empleados}">
				
					<!-- construct an "update" link with empleado id -->
					<c:url var="updateLink" value="/empleado/showFormForUpdate">
						<c:param name="empleadoId" value="${tempEmpleado.id}" />
					</c:url>					

					<!-- construct an "delete" link with empleado id -->
					<c:url var="deleteLink" value="/empleado/delete">
						<c:param name="empleadoId" value="${tempEmpleado.id}" />
					</c:url>					
					
					<tbody>											
						<tr>
							<td> ${tempEmpleado.nombre} </td>
							<td> ${tempEmpleado.ap} </td>
							<td> ${tempEmpleado.am} </td>
							<td> ${tempEmpleado.correo} </td>
							<td> 
								<div class="btn-group">
									<a href="${updateLink}" class="btn btn-warning">Update</a> 
									<a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#eliminar_modal">
									Delete</a>
								</div>
							</td>
						</tr>
					</tbody>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
	<!-- The Modal -->
	<div class="modal" id="eliminar_modal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <div class="modal-header">
	        <h4 class="modal-title">¡Advertencia!</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <div class="modal-body">¿Esta seguro que desea eliminar a este empleado?</div>
	
	      <div class="modal-footer">
	        <a class="btn btn-primary" href="${deleteLink}">Aceptar</a>
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	      </div>
	
	    </div>
	  </div>
	</div>

</body>

<script type="text/javascript">
//href="${deleteLink}"
	function eliminar(){		
			swal({
				  title: "Advertencia!",
				  text: "¿Esta seguro que desea eliminar a este empleado?\n Los cambios no podran deshacerse.",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
				    swal("El empleado se ha eliminado correctamente.", {
				      icon: "success",
				    });
				    location.replace("${updateLink}");
				  }
				});

			
	}
	
</script>

</html>









