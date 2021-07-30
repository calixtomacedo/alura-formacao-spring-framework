package br.com.cmdev.springmvcii.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cmdev.springmvcii.dto.OfertaRequest;
import br.com.cmdev.springmvcii.model.Oferta;
import br.com.cmdev.springmvcii.model.Pedido;
import br.com.cmdev.springmvcii.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@PostMapping
	public Oferta criarOferta(OfertaRequest request) {
		
		Optional<Pedido> pedido = pedidoRepository.findById(request.getIdPedido());
		if(!pedido.isPresent()) {
			return null;
		}
		
		Pedido novoPedido = pedido.get();
		
		Oferta novaOferta = request.toOferta();
		novaOferta.setPedido(novoPedido);
		novoPedido.getOfertaList().add(novaOferta);
		
		pedidoRepository.save(novoPedido);
		
		return novaOferta;
	}
}
