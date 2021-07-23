package br.com.cmdev.javaservletii.web.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public interface Action {

	public String execute(HttpServletRequest request) throws ServletException, IOException;

}
