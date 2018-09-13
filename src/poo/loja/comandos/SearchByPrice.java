package poo.loja.comandos;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

import java.util.Scanner;

public class SearchByPrice implements Comando {
    @Override
    public void execute(Scanner scn) {
        ProdutoDAO pDAO = new ProdutoDAO();
        System.out.println("Informe o preco que deseja pesquisar:");
        double preco = scn.nextDouble();
        System.out.println("Deseja pesquisar todos os maiores(true) que " + preco + " ou menores(false) que " + preco + "?");
        boolean opS = scn.nextBoolean();
        System.out.println(pDAO.searchByPrice(preco, opS));
    }
}
