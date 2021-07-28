package br.com.cmdev.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cmdev.springmvc.dto.PedidoRequest;
import br.com.cmdev.springmvc.model.Pedido;
import br.com.cmdev.springmvc.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(PedidoRequest request) {
		
		Pedido pedido = request.toPedido();
		pedidoRepository.save(pedido);
		
		return "pedido/formulario";
	}
}
