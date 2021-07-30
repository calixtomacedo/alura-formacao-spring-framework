/**
 * 
 */

function loadVue() {
	var app = new Vue({
		el: '#ofertas',
		data: {
			pedidoList: []
		},
		mounted () {
			axios.get('http://localhost:8080/api/pedidos/aguardando')
		   		 .then(response => (this.pedidoList = response.data))
		}
	});
}