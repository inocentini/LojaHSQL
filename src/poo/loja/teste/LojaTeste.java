package poo.loja.teste;

import java.util.Scanner;

import poo.loja.comandos.Insert;
import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

public class LojaTeste {

	public static void main(String[] args) {
		boolean op = true;
		int opm;
		Scanner scn = new Scanner(System.in);
		ProdutoDAO pDAO = new ProdutoDAO();
		while(op) {
			System.out.println("--------------------MENU----------------------");
			System.out.println("1-Cadastrar Produto.\n2-Alterar Produto.\n3-Listar todos os Produtos.\n4-Deletar um Produto.\n5-Filtrar pelo Nome de um Produto.\n6-Filtrar pelo preço do Produto.\n0-Sair.\n");
			opm = scn.nextInt();
			switch(opm) {
			case 1:
//				Produto p = new Produto();
////				System.out.println("Informe o id do produto:");
////				p.setId(scn.nextInt());
//				System.out.println("Informe o nome do produto");
//				p.setNome(scn.next());
//				System.out.println("Informe o preco do produto");
//				p.setValor(scn.nextDouble());
//				pDAO.insert(p);
				Insert.InsertProduto();
				break;
			case 2:
				System.out.println("Informe o id do produto que deseja alterar:\n");
				for(Produto prod : pDAO.listAll())
					System.out.println(prod);				
				Produto produto =	pDAO.read(scn.nextInt());
				System.out.println("Deseja alterar o nome? S: true N: false");
				boolean opUpdN = scn.nextBoolean();
				if(opUpdN) {
					System.out.println("Informe o novo nome do produto");
					produto.setNome(scn.next());
				}else {
					System.out.println("Deseja alterar o preco? S: true N: false");
					boolean opUpdP = scn.nextBoolean();
					if(opUpdP) {
						System.out.println("Informe o novo valor do produto:");
						produto.setValor(scn.nextDouble());
					}
				}
				System.out.println("Deseja alterar o preco? S: true N: false");
				boolean opUpdP = scn.nextBoolean();
				if(opUpdP) {
					System.out.println("Informe o novo valor do produto:");
					produto.setValor(scn.nextDouble());
				}else {
					break;
				}
				pDAO.update(produto);
				break;
			case 3:
				for(Produto prod : pDAO.listAll())
					System.out.println(prod);
				break;
			case 4:

				break;
			case 5:
				System.out.println("Informe o nome ou parte do produto que deseja pesquisa");
				System.out.println(pDAO.searchByName(scn.next()));
				scn.nextLine();
				break;
			case 6:
				System.out.println("Informe o preco que deseja pesquisar:");
				double preco = scn.nextDouble();
				System.out.println("Deseja pesquisar todos os maiores que " + preco + " ou menores que " + preco + "? \nMaior:true\nMenor:false\n");
				boolean opS = scn.nextBoolean();
				System.out.println(pDAO.searchByPrice(preco, opS));
				break;
			case 0:
				op = false;
				break;
			default:
				System.out.println("Op��o Inv�lida!");
				break;
			}
		}
	}

}
