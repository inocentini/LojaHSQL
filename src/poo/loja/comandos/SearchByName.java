package poo.loja.comandos;

import poo.loja.dao.ProdutoDAO;

import java.util.Scanner;

public class SearchByName implements Comando {
    @Override
    public void execute(Scanner scn) {
        ProdutoDAO pDAO = new ProdutoDAO();
        System.out.println("Informe o nome ou parte do produto que deseja pesquisa");
        System.out.println(pDAO.searchByName(scn.next()));
    }
}
