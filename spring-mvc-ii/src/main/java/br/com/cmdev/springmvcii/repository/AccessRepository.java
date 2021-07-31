package br.com.cmdev.springmvcii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cmdev.springmvcii.model.Access;

@Repository
public interface AccessRepository extends JpaRepository<Access, Long> {

}
