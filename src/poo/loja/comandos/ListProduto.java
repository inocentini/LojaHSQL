package poo.loja.comandos;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

import java.util.Scanner;

public class ListProduto implements Comando {

    public void execute(Scanner scn){
        ProdutoDAO pDAO = new ProdutoDAO();
        System.out.println("Produtos Cadastrados:");
        System.out.println("---------------------------------------------------------");
        for(Produto prod : pDAO.listAll()) {
            System.out.println(prod);
            System.out.println("---------------------------------------------------------");
        }
    }
}
