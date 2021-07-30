package br.com.cmdev.springmvcii.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cmdev.springmvcii.dto.PedidoRequest;
import br.com.cmdev.springmvcii.model.Pedido;
import br.com.cmdev.springmvcii.model.User;
import br.com.cmdev.springmvcii.repository.PedidoRepository;
import br.com.cmdev.springmvcii.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("formulario")
	public String formulario(PedidoRequest request) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid PedidoRequest request, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(name);
		
		Pedido pedido = request.toPedido();
		pedido.setUser(user);
		pedidoRepository.save(pedido);
		
		return "redirect:/home";
	}
}
