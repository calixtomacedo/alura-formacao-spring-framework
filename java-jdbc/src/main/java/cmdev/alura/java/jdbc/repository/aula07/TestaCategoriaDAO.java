package cmdev.alura.java.jdbc.repository.aula07;

import java.util.List;

import cmdev.alura.java.jdbc.dao.CategoriaDAO;
import cmdev.alura.java.jdbc.model.Categoria;
import cmdev.alura.java.jdbc.model.Produto;

public class TestaCategoriaDAO {

	public static void main(String[] args) throws Exception {
		Categoria categoria = new Categoria();
		categoria.setNmCategoria("MTB");
		categoria.setFlAtivo("S");
		//CategoriaDAO.getInstance().salvar(categoria);

		//System.out.println(categoria + "\n");
		
		List<Categoria> categoriaList = CategoriaDAO.getInstance().listar();
		categoriaList.stream().forEach(categorias -> System.out.println(categorias));

		
		
		List<Categoria> categoriaProdutos = CategoriaDAO.getInstance().listarCategoriaProdutos();
		categoriaProdutos.stream().forEach(categ -> {
			System.out.println(categ.getNmCategoria());
			for (Produto produto : categ.getProdutos()) {
				System.out.println("Categoria : " + categ.getNmCategoria() + " - Produto: " + produto.getNmProduto() +" "+ produto.getDsProduto());
			}
		});
		
		/*
		// Não é uma boa prática
		List<Categoria> categorias = CategoriaDAO.getInstance().listar();
		categorias.stream().forEach(categ -> {
			System.out.println(categ.getNmCategoria());
			try {
				List<Produto> produtos = ProdutoDAO.getInstance().buscar(categ);
				for (Produto produto : produtos) {
					System.out.println("Categoria : " + categ.getNmCategoria() + " - Produto: " + produto.getDsProduto());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		*/
	}

}
