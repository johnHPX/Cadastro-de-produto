package controller;

import java.util.ArrayList;

import model.Produto;
import repository.ProdutoRepository;

public class ProdutoController {
	
	public boolean cadastrar(Produto produto) {
		
		if (produto.getNome().length() > 150) {
			return false;
		}
		
		if (produto.getDescricao().length() > 1000) {
			return false;
		}
		
		ProdutoRepository pr = new ProdutoRepository();
		boolean res = pr.criar(produto);
		
		return res;
	}
	
	public ArrayList<Produto> verProdutos() {
		ProdutoRepository pr = new ProdutoRepository();
		ArrayList<Produto> produtos = pr.listar();
		return produtos;
	}
	
}
