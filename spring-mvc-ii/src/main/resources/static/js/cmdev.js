/**
 * 
 */

function loadVue() {
	var app = new Vue({
		el: '#ofertas',
		data: {
			pedidoList: []
		},
		mounted() {
			axios
				.get('http://localhost:8080/api/pedidos/aguardando')
				.then(response => {
					response.data.forEach(pedido => {
						pedido.ofertaEnviada = false;
						pedido.erros = {
	    	  				valorNegociado: '',
	    	  				dataEntrega: ''
	    	  			}
					})
					this.pedidoList = response.data
				})
		},
		methods: {
			enviarOferta: function(pedido) {
				pedido.erros = {
	  				valorNegociado: '',
	  				dataEntrega: ''
				};		
				axios.post('http://localhost:8080/api/ofertas', {
					idPedido: pedido.id,
					valorNegociado: pedido.valorNegociado,
					dataEntrega: pedido.dataDaEntrega,
					comentario: pedido.comentario
				})
				.then(response => pedido.ofertaEnviada = true)
				.catch(error => {
		    	  error.response.data.errors.forEach(error => {
		    		  pedido.erros[error.field] = error.defaultMessage;
		    	  })
		      })
			}
		}
	});
}
