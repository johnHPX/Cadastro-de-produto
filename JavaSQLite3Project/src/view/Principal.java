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
			
			switch(op) {
				
				case 0:
				
				case 1:
					System.out.println();
					ProdutoController pc1 = new ProdutoController();
					ArrayList<Produto> produtos = pc1.verProdutos();
					
					System.out.println("|ID |NOME |DESCRIÇÃO |PREÇO |QUANTIDADE |");
					for (Produto p : produtos) {
						System.out.println("-----------------------------------------");
						System.out.println("|"+p.getId()+"|"+p.getNome()+"|"+p.getDescricao()+"|"+p.getPreco()+"|"+p.getQuantidade()+"|");
					}
					System.out.println("-----------------------------------------");
					break;
				case 2:
					break;
				case 3:
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
					ProdutoController pc3 = new ProdutoController();
					boolean res = pc3.cadastrar(produto);
					if (res) {
						System.out.println("    PRODUTO CADASTRADO COM SUCESSO!    ");
						System.out.println("---------------------------------------");
					}else {
						System.out.println("      ERRO AO CADASTRAR PRODUTO!       ");
						System.out.println("---------------------------------------");
					}
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					Sobre sobre = new Sobre();
					sobre.sobre();
					break;
				default:
					open = false;
			}
		}
		
		ler.close();
		Encerramento encer = new Encerramento();
		encer.encerramento();
		

	}

}
