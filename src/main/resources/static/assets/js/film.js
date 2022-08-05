$(document).ready(function() {
    $("#selectCategory").select2({
		theme : "bootstrap-5"
	});
	$("#selectActor").select2({
		theme : "bootstrap-5"
	});
    
    $('.js-example-basic-multiple').select2();
    
});

$('#botonCerrarFilm').on('click', function(e) {
		$('#modalNewFilm').modal('hide');
		$(".modal-body input").val('');
		$('#selectActor').val("").trigger('change');
		$('#selectCategory').val("").trigger('change');
		$(".modal-body select").val(-1);
});
$('#botonCerrarFilm1').on('click', function(e) {
		$('#modalNewFilm').modal('hide');
		$(".modal-body input").val('');
		$('#selectActor').val("").trigger('change');
		$('#selectCategory').val("").trigger('change');
		$(".modal-body select").val(-1);
});