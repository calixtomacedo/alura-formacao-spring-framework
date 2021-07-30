package br.com.cmdev.springmvcii.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cmdev.springmvcii.model.Pedido;
import br.com.cmdev.springmvcii.model.enums.StatusPedido;
import br.com.cmdev.springmvcii.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas() {
		Sort sort = Sort.by("id").descending();
		PageRequest pageRequest = PageRequest.of(0, 5, sort);

		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, pageRequest);
	}
}
