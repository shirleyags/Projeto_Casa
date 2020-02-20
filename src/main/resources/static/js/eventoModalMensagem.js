//$('#eventoConfirmacaoExclusaoModal').on('show.bs.modal', function(event){
//	
//	var button = $(event.relatedTarget); //Pegar o botão - Botão que disparou o evento.
//	
//	var codigoEvento = button.data('code');
//	var nomeEvento = button.data('evento');
//	
//	var modal = $(this);
//	var form = modal.find('form');
//	var action = form.data('url-base');
//	if (!action.endsWith('/')){
//		action += '/';
//	}
//	
//	form.attr('action', action + codigoEvento);
//	
//	modal.find('.modal-body p').html('Tem certeza que deseja excluir a casa <strong>'+ nomeEvento+'<strong>?');
//	
//	
// 
//});