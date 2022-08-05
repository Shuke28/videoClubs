$(document).ready(function() {

	$('#tablaRental').DataTable({
		language: {
			processing: "Tratamiento en curso...",
			search: "Buscar&nbsp;:",
			lengthMenu: "Agrupar de _MENU_ items",
			info: "Mostrando del item _START_ al _END_ de un total de _TOTAL_ items",
			infoEmpty: "No existen datos.",
			infoFiltered: "(filtrado de _MAX_ elementos en total)",
			infoPostFix: "",
			loadingRecords: "Cargando...",
			zeroRecords: "No se encontraron datos con tu busqueda",
			emptyTable: "No hay datos disponibles en la tabla.",
			paginate: {
				first: "Primero",
				previous: "Anterior",
				next: "Siguiente",
				last: "Ultimo"
			},
			aria: {
				sortAscending: ": active para ordenar la columna en orden ascendente",
				sortDescending: ": active para ordenar la columna en orden descendente"
			}
		},

	});	
	$("#botonBuscar").on("click",function(){
		let inventory = $("#inventoryId").val();
		console.log("vghvfgyvg");	
		$.get("http://localhost:8080/detallesRentalInventory/" + inventory, function(data, status){
			console.log(data);	
			if(!data.details){
				alerta("info", "Id incorrecto");
			}
			else{
				 $("#tituloFilm").val(data.details.film.title);
				 $("#rentalDuration").val(data.details.film.rentalDuration);
				 $("#rentalRate").val(data.details.film.rentalRate); 
			}
								 	
		});
		
			
	});

	$("#customerId").blur(function(){
		console.log("hola");
		 //let status=$("#activeBool").val
		 let customer = $("#customerId").val();
			$.get("http://localhost:8080/detallesCustomer/" + customer, function(data, status){
				console.log(data);
			    $("#firstName").val(data.details.firstName);
				$("#lastName").val(data.details.lastName);
				
				data.details.activeBool ? adBoton("#botonGuardarNewrental", false,"error","cliente activo, permite prestamos") : adBoton("#botonGuardarNewrental", true,"error", "Cliente inactivo, imposible efectuar prestamo"); 
			});			
			
	});
	
					
	$("#ingresoPago").keyup(function(){
		console.log($("#ingresoPago").val()-$("#rentalRate").val());
		let importe = $("#ingresoPago").val();
		let monto = $("#rentalRate").val();
		if (monto!=0 && monto!=null ){
			let cambio= importe-monto;
			//console.log(cambio);
			$("#cambio").val(cambio);
		}
		else 
		{
			$("#cambio").val("");
		}
		
	});
	
	
});


function adBoton(boton, valor, tipo, mensaje){
	if (valor==true){
		$(boton).attr("disabled", valor);
		
		Lobibox.alert( tipo, {//AVAILABLE TYPES: "error", "info", "success", "warning"
	    msg: mensaje
		});	
	}
	else 
	{
		$(boton).attr("disabled", valor);
	}
}


function alerta(tipo, mensaje){
	Lobibox.alert( tipo, {//AVAILABLE TYPES: "error", "info", "success", "warning"
	    msg: mensaje
	});	
} 

function rentalRegis(){
	alert('Renta Registrada');
}

function receiptGene(){
	alert('Recibo Generado');
}
