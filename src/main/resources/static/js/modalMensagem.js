$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	
	var button = $(event.relatedTarget); //Pegar o botão - Botão que disparou o evento.
	
	var codigoCasa = button.data('code');
	var nomeCasa = button.data('casa');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')){
		action += '/';
	}
	
	form.attr('action', action+codigoCasa);
	
	modal.find('.modal-body p').html('Tem certeza que deseja excluir a casa <strong>'+ nomeCasa+'<strong>?');
	
	
 
});