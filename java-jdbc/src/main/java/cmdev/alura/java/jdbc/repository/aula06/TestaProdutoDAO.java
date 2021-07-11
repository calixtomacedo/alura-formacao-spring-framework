package cmdev.alura.java.jdbc.repository.aula06;

import java.time.LocalDateTime;
import java.util.List;

import cmdev.alura.java.jdbc.dao.ProdutoDAO;
import cmdev.alura.java.jdbc.model.Produto;

public class TestaProdutoDAO {

	public static void main(String[] args) throws Exception {

		List<Produto> produtoList;

		Produto produto = new Produto();
		//Categoria categoria = new Categoria();
		//categoria.setIdCategoria(41);
		//produto.setCategoria(categoria);
		produto.setNmProduto("TARMAC");
		produto.setDsProduto("SWORK QUE VOÇÊ NÃO PODE PERDER");
		produto.setDtCriacao(LocalDateTime.now().withNano(0));
		produto.setFlAtivo("S");

		produtoList = ProdutoDAO.getInstance().listar();

		produtoList.stream().forEach(product -> System.out.println(product));

		System.out.println("\n");
		/*
		Produto deletar = new Produto();
		deletar.setIdProduto(0);
		ProdutoDAO.getInstance().remover(deletar);

		Produto atualizar = ProdutoDAO.getInstance().pesquisaPorId(61);
		if(atualizar != null) {
			atualizar.setCategoria(categoria);
			atualizar.setNmProduto("MOUSE");
			atualizar.setDsProduto("WIRELESS MOBILE 1850");
			ProdutoDAO.getInstance().alterar(atualizar);
		}
		*/
		ProdutoDAO.getInstance().salvar(produto);

		produtoList = ProdutoDAO.getInstance().listar();

		produtoList.stream().forEach(product -> System.out.println(product));

	}

}
