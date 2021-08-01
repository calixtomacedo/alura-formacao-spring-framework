package br.com.cmdev.springmvcii.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("user")
public class UserController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("pedido")
	public String home(Model model, HttpServletRequest request, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findAllByUser(principal.getName());
		model.addAttribute("pedidos", pedidos);

		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(name);
		request.getSession().setAttribute("user", user);

		return "user/home";
	}

	@GetMapping("pedido/{status}")
	public String listarPedidoPorStatus(@PathVariable("status") String status, Model model, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findByStatusAndUser(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "user/home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/user/home";
	}
}
