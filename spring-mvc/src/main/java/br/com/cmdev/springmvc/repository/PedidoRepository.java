package br.com.cmdev.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cmdev.springmvc.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
