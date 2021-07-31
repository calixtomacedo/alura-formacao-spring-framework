package br.com.cmdev.springmvcii.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cmdev.springmvcii.model.Access;
import br.com.cmdev.springmvcii.repository.AccessRepository;


@RestController
@RequestMapping("/api/acessos")
public class AccessRest {

	@Autowired
	private AccessRepository accessRepository;
	
	@GetMapping
	public List<Access> getAccessList(){
		return accessRepository.findAll();
	}
}
