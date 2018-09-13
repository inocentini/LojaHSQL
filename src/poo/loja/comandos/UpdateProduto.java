package poo.loja.comandos;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

import java.util.Scanner;

public class UpdateProduto implements Comando {


    @Override
    public void execute(Scanner scn) {
        ProdutoDAO pDAO = new ProdutoDAO();
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
            return;
        }
        pDAO.update(produto);
        System.out.println("Produto alterado com sucesso!");
    }
}
