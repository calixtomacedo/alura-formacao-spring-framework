package br.com.cmdev.javaservletii.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//@WebFilter(urlPatterns = "/controller")
public class MonitoringFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("MonitoringFilter");

		long before = System.currentTimeMillis();

		String action = request.getParameter("action");
		chain.doFilter(request, response);

		long after = System.currentTimeMillis();

		System.out.println("Tempo gasto na execução da ação: " + action + " = " + (after - before));
	}

}
