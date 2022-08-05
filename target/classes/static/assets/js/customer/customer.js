$(document).ready(function() {
	
	$('#tablaCustomers').DataTable({
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
	
	$("#selectCountry").select2({
		theme : "bootstrap-5"
	});
	
	$("#selectCountry").change(function(){
		//console.log("click")
		$.get("http://localhost:8080/ciudadesPorPais/" + $("#selectCountry").val() , function(data, status){
			$('#selectCity').empty().trigger('change')
			
			$("#selectCity").select2({
				theme : "bootstrap-5",
				data : data,
				cache : false
			});	
				
		});
	})
	
});

//$(function(){
//	$('#eliminarCliente').on('click', function(e){
//		$.ajax({
//			type: "POST",
//			url: "/eliminarCustomer",
//			data: $("")
//		});
//	});
//});

$(function() {
	$('#botonGuardarNewCustomer').on('click', function(e) {
		e.preventDefault();
		//var control = true;
	    
	    if(validaForm()){
			$.ajax({
				type : "POST",
				url : "/saveCustomer",
				data : $("#formNewCustomer").serialize(),
				cache : false,
				success : function(){
					swal({
						title: "Cliente registrado correctamente",
						icon: "success"
					});
					$('#modalNewCustomer').modal('hide');
					$(".modal-body input").val('');
					$('#selectCountry').val(-1).trigger('change');
					$('#selectCity').val(-1).trigger('change');
					$(".modal-body select").val(-1);
				},
				error : function() {
					swal({
						title: "Error al registrar el cliente, cliente existente",
						icon: "error"
					});
				}
			
			})
		}
		
		return false;
	});
	
	$('#botonCerrarCustomer').on('click', function(e) {
		$('#modalNewCustomer').modal('hide');
				$(".modal-body input").val('');
				$('#selectCountry').val(-1).trigger('change');
				$('#selectCity').val(-1).trigger('change');
				$(".modal-body select").val(-1);
	});
	$('#botonCerrarCustomer1').on('click', function(e) {
		$('#modalNewCustomer').modal('hide');
				$(".modal-body input").val('');
				$('#selectCountry').val(-1).trigger('change');
				$('#selectCity').val(-1).trigger('change');
				$(".modal-body select").val(-1);
	});
})

function validaForm(){
    // Campos de texto
    if($("#firstName").val() == ""){
		swal("Campo vacío","El campo NOMBRE no puede estar vacío","error");
        $("#nombre").focus();       // Esta función coloca el foco de escritura del usuario en el campo Nombre directamente.
        return false;
    }
    else if($("#lastName").val() == ""){
		swal("Campo vacío","El campo APELLIDO no puede estar vacío","error");
        $("#apellidos").focus();
        return false;
    }
    else if($("#email").val() == ""){
		swal("Campo vacío","El campo EMAIL no puede estar vacío","error");
        $("#apellidos").focus();
        return false;
    }
    else if($("#selectCountry").val() == -1){
		swal("Campo vacío","El campo PAIS no puede estar vacío","error");
        $("#direccion").focus();
        return false;
    }
    else if($("#direccion").val() == ""){
		swal("Campo vacío","El campo DIRECCIÓN no puede estar vacío","error");
        $("#apellidos").focus();
        return false;
    }
    else if($("#selectStore").val() == -1){
		swal("Campo vacío","El campo TIENDA no puede estar vacío","error");
        $("#direccion").focus();
        return false;
    }


    return true; // Si todo está correcto
}

function pruebaBoton(){
	swal("Hola","Si sirve el botón","success");
}