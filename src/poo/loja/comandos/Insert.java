package poo.loja.comandos;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

import java.util.Scanner;

public class Insert extends Comandos {


    public static void InsertProduto(){
        Produto produto = new Produto();
        Scanner scn = new Scanner(System.in);
        ProdutoDAO pDAO = new ProdutoDAO();
        System.out.println("Informe o nome do produto");
        produto.setNome(scn.next());
        System.out.println("Informe o preco do produto");
        produto.setValor(scn.nextDouble());
        pDAO.insert(produto);
        System.out.println("Produto Inserido!");
    }

}
