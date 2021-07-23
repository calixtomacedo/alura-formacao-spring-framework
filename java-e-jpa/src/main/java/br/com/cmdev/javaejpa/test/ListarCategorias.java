package br.com.cmdev.javaejpa.test;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cmdev.javaejpa.dao.CategoriaDAO;
import br.com.cmdev.javaejpa.model.Categoria;
import br.com.cmdev.javaejpa.util.Util;
import br.com.cmdev.javaejpa.util.JPAUtil;

public class ListarCategorias {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		
		CategoriaDAO dao = new CategoriaDAO(entityManager);
		/*
		Categoria c = dao.buscarPorId(4L);
		System.out.println("Categoria id: "+c.getId()+", Descricao: "+c.getDescricao()+", Data Cadastro: "+Util.formatDataComHora(c.getDataCadastro()));
		 */
		
		List<Categoria> categorias = dao.listar();
		System.out.println("\n");
		
		categorias.forEach(cc -> {
			System.out.println("Categoria id: "+cc.getId()+", Descricao: "+cc.getDescricao()+", Data Cadastro: "+Util.formatDataComHora(cc.getDataCadastro()));
		});
	}
}
