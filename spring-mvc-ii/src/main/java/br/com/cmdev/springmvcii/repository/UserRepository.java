package br.com.cmdev.springmvcii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cmdev.springmvcii.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, String>  {

	public User findByUsername(String username);
}
