package br.com.cmdev.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cmdev.springmvc.model.Pedido;
import br.com.cmdev.springmvc.model.enums.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);

}
