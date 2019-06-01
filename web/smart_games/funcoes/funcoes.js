/*inicio programacao com jquery*/
$(document).ready(function(){
	$('.visualizar').click(function(){
		$('#container').fadeIn(1000);
	});
					
});

$(document).ready(function(){
	$('#fechar').click(function(){
		$('#container').fadeOut(0);
	});
});
			
function verMais(idItem){
	$.ajax({
		type: "GET",
		url: "modal.php",
		data: {id_jogo:idItem},
		success: function(dados){
			$('#modal').html(dados);
   	                     
		}
	});
}
				
function abrirMapa(link){
	$.ajax({
		type: "GET",
		url: "mapa.php",
		data: {link:link},
		success: function(dados){
			$('#mapa_modal').html(dados);
		}
					
	});
}


			