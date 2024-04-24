package controller;

import java.util.ArrayList;

import model.Produto;
import repository.ProdutoRepository;

public class ProdutoController implements ProdutoControllerInterface{
	
	public boolean cadastrar(Produto produto) {
		
		if (produto.getNome().length() > 150) {
			return false;
		}
		
		if (produto.getDescricao().length() > 1000) {
			return false;
		}
		
		ProdutoRepository pr = new ProdutoRepository();
		boolean ok = pr.criar(produto);
		
		return ok;
	}
	
	public ArrayList<Produto> ver() {
		ProdutoRepository pr = new ProdutoRepository();
		ArrayList<Produto> produtos = pr.listar();
		return produtos;
	}
	
	public Produto buscar(int id) {
		ProdutoRepository pr = new ProdutoRepository();
		Produto p = pr.buscar(id);
		return p;
	}
	
	public boolean editar(Produto produto) {
		if (produto.getNome().length() > 150) {
			return false;
		}
		
		if (produto.getDescricao().length() > 1000) {
			return false;
		}
		
		ProdutoRepository pr = new ProdutoRepository();
		boolean ok = pr.atualizar(produto);
		
		return ok;
	}
	
	public boolean remover(int id) {		
		ProdutoRepository pr = new ProdutoRepository();
		boolean ok = pr.deletar(id);
		return ok;
	}
	
}
