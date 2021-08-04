package br.com.cmdev.springbootapirestiii.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cmdev.springbootapirestiii.config.security.TokenService;
import br.com.cmdev.springbootapirestiii.request.LoginRequest;
import br.com.cmdev.springbootapirestiii.response.LoginResponse;

@RestController
@RequestMapping("/auth")
@Profile("prod")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<LoginResponse> autenticar(@RequestBody @Valid LoginRequest request){
		UsernamePasswordAuthenticationToken authenticationToken = request.createAuthenticationToken();
		
		try {
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			String token = tokenService.generateToken(authentication);
			return ResponseEntity.ok(new LoginResponse(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
