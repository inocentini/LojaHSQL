package poo.loja.comandos;

import java.util.Scanner;

public class Sair implements Comando {
    @Override
    public void execute(Scanner scn) {
        System.out.println("Sessão encerrada!");
        System.exit(0);
    }
}
