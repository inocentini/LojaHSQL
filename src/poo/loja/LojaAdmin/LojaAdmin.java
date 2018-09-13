package poo.loja.LojaAdmin;

import poo.loja.comandos.*;

import java.util.*;

public class LojaAdmin {

    public static void menu(){
        System.out.println("----------------------MENU---------------------");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Alterar Produto");
        System.out.println("3 - Excluir Produto");
        System.out.println("4 - Listar Produtos");
        System.out.println("5 - Listar Produtos por Name");
        System.out.println("6 - Listar Produtos por preço");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção");
    }

    public static void main(String[] args){
        int opc =0;
        Scanner scn = new Scanner(System.in);
        Hashtable<Integer, Comando> comandos = new Hashtable<>();
        comandos.put(0, new Sair());
        comandos.put(1, new InsertProduto());
        comandos.put(2, new UpdateProduto());
        comandos.put(3, new DeleteProduto());
        comandos.put(4, new ListProduto());
        comandos.put(5, new SearchByName());
        comandos.put(6, new SearchByPrice());
        do{
            menu();
            opc = scn.nextInt();
            comandos.get(opc).execute(scn);

        }while(opc != 0);

        scn.close();
    }
}
