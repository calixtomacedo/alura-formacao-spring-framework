package br.com.cmdev.springmvcii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cmdev.springmvcii.model.Pedido;
import br.com.cmdev.springmvcii.model.enums.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);

}
