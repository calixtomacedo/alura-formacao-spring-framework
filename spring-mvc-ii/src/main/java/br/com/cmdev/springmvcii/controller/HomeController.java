package br.com.cmdev.springmvcii.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String home(Model model, HttpServletRequest request, Principal principal) {
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest pageRequest = PageRequest.of(0, 5, sort);
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, pageRequest);
		model.addAttribute("pedidos", pedidos);

		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(name);
		request.getSession().setAttribute("user", user);
		return "home";
	}

}
