package br.com.cmdev.springmvcii.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cmdev.springmvcii.model.Pedido;
import br.com.cmdev.springmvcii.model.enums.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	// @Cacheable("pedidos")
	List<Pedido> findByStatus(StatusPedido status, Pageable pageable);

	@Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :pUsername")
	List<Pedido> findAllByUser(@Param("pUsername") String username);

	@Query("SELECT p FROM Pedido p JOIN p.user u WHERE p.status = :pStatus AND u.username = :pUsername")
	List<Pedido> findByStatusAndUser(@Param("pStatus") StatusPedido status, @Param("pUsername") String name);

}
