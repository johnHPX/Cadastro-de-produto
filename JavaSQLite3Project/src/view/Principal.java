package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Produto;
import controller.ProdutoController;

public class Principal {
	
	static void menu() {
		System.out.println("      	     MENU DE OPÇÕES			   ");
		System.out.println("---------------------------------------");
		System.out.println(" 1 - Ver Produtos ");
		System.out.println(" 2 - Procurar Produto ");
		System.out.println(" 3 - Cadastrar Produto ");
		System.out.println(" 4 - Editar Produto ");
		System.out.println(" 5 - Remover Produto ");
		System.out.println(" 6 - Sobre ");
		System.out.println(" 7 - Sair ");
		System.out.print("\n==> ");
	}
	
	public static void main(String []args) throws InterruptedException {
		Abertura aber = new Abertura();
		aber.aberturaSistema();
		Scanner ler = new Scanner(System.in);
		 
		boolean open = true;
		while (open) {
			menu();
			int op = ler.nextInt();
			
			if (op == 1) {
				System.out.println();
				ProdutoController pc = new ProdutoController();
				ArrayList<Produto> produtos = pc.ver();
				System.out.println("---------------------------------------");
				System.out.println("          PRODUTOS CADASTRADOS         ");
				System.out.println("---------------------------------------");
				System.out.println("|ID |NOME |DESCRIÇÃO |PREÇO |QUANTIDADE |");
				for (Produto p : produtos) {
					System.out.println("-----------------------------------------");
					System.out.println("|"+p.getId()+"|"+p.getNome()+"|"+p.getDescricao()+"|"+p.getPreco()+"|"+p.getQuantidade()+"|");
				}
				System.out.println("-----------------------------------------");
			}else if(op == 2) {
				System.out.print("Digite o código do produto que deseja procurar: ");
				int id = ler.nextInt();
				ProdutoController pc = new ProdutoController();
				Produto p = pc.buscar(id);
				if (p == null) {
					System.out.println("---------------------------------------");
					System.out.println("        CONSULTA MAL SUCESSIDA!        ");
					System.out.println("---------------------------------------");
				}else {
					System.out.println("---------------------------------------");
					System.out.println("      CONSULTA FEITA COM SUCESSO!      ");
					System.out.println("---------------------------------------");
					System.out.println("|ID |NOME |DESCRIÇÃO |PREÇO |QUANTIDADE |");
					System.out.println("|"+p.getId()+"|"+p.getNome()+"|"+p.getDescricao()+"|"+p.getPreco()+"|"+p.getQuantidade()+"|");
					System.out.println("-----------------------------------------");
				}
			}else if(op == 3) {
				Produto produto = new Produto();
				System.out.println("---------------------------------------");
				System.out.println("           CADASTRAR PRODUTO           ");
				System.out.println("---------------------------------------");
				ler.nextLine();
				System.out.print("Nome:");
				produto.setNome(ler.nextLine());
				System.out.print("Descrição:");
				produto.setDescricao(ler.nextLine());
				System.out.print("Preço:");
				produto.setPreco(ler.nextDouble());
				System.out.print("Quantidade:");
				produto.setQuantidade(ler.nextInt());
				System.out.println("---------------------------------------");
				ProdutoController pc = new ProdutoController();
				boolean ok = pc.cadastrar(produto);
				if (ok) {
					System.out.println("    PRODUTO CADASTRADO COM SUCESSO!    ");
					System.out.println("---------------------------------------");
				}else {
					System.out.println("      ERRO AO CADASTRAR PRODUTO!       ");
					System.out.println("---------------------------------------");
				}
			}else if(op == 4) {
				
				
			}else if(op == 5) {
				
			}else if(op == 6) {
				Sobre sobre = new Sobre();
				sobre.sobre();
			}else {
				open = false;
			}
		}
		
		ler.close();
		Encerramento encer = new Encerramento();
		encer.encerramento();
		

	}

}
