package poo.loja.comandos;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

import java.util.Scanner;

public class InsertProduto implements Comando{

    public void execute(Scanner scn){
        Produto produto = new Produto();
        ProdutoDAO pDAO = new ProdutoDAO();
        System.out.println("Informe o nome do produto");
        produto.setNome(scn.next());
        System.out.println("Informe o preco do produto");
        produto.setValor(scn.nextDouble());
        pDAO.insert(produto);
        System.out.println("Produto Cadastrado com sucesso!");
    }


}
