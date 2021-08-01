package br.com.cmdev.springmvcii.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import br.com.cmdev.springmvcii.model.Access;
import br.com.cmdev.springmvcii.model.User;
import br.com.cmdev.springmvcii.repository.AccessRepository;

public class InterceptorAccess implements AsyncHandlerInterceptor {

	@Autowired
	private AccessRepository accessRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Access access = new Access();
		access.setPath(request.getRequestURI());
		access.setDateTime(LocalDateTime.now());
		request.setAttribute("access", access);

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

		User user = (User) request.getSession().getAttribute("user");

		Access access = (Access) request.getAttribute("access");
		access.setDuration(Duration.between(access.getDateTime(), LocalDateTime.now()));
		access.setLogin(user != null ? user.getUsername() : "");
		access.setNome(user != null ? user.getName() : "");

		accessRepository.save(access);
	}

}
