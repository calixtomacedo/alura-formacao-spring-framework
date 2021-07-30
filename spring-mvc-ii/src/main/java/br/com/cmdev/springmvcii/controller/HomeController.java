package br.com.cmdev.springmvcii.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cmdev.springmvcii.model.Pedido;
import br.com.cmdev.springmvcii.model.User;
import br.com.cmdev.springmvcii.model.enums.StatusPedido;
import br.com.cmdev.springmvcii.repository.PedidoRepository;
import br.com.cmdev.springmvcii.repository.UserRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findAllByUser(principal.getName());
		model.addAttribute("pedidos", pedidos);
		
		User user = userRepository.findByUsername(principal.getName());
		model.addAttribute("user", user);

		return "home";
	}
	
	@GetMapping("/{status}")
	public String listarPedidoPorStatus(@PathVariable("status") String status, Model model) {
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		
		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError(){
		return "redirect:/home";
	}
	
}
