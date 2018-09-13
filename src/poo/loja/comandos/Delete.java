package poo.loja.comandos;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

import java.util.Scanner;

public class Delete extends Comandos{

    public static void DeleteProduto(){
        ProdutoDAO pDAO = new ProdutoDAO();
        Scanner scn = new Scanner(System.in);
        System.out.println("Informe o id do produto que deseja remover");
        for(Produto prod : pDAO.listAll())
            System.out.println(prod);
        pDAO.delete(pDAO.read(scn.nextInt()));
        System.out.println(pDAO.listAll());
        System.out.println("Produto Deletado!");
    }
}
