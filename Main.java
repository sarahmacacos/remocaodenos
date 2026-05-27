package noss;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        // pede os numeros pra inserir na arvore
        System.out.println("Digite os números para inserir na árvore.");
        System.out.println("(digite 'parar' para parar)");

        while (true) {
            System.out.print("Número: ");
            String entrada = scanner.next();
            if (entrada.equalsIgnoreCase("parar")) break;
            arvoreBinaria.inserir(Integer.parseInt(entrada));
        }

        System.out.println("\nÁrvore em ordem:");
        arvoreBinaria.percurso("Em");

        // agora pergunta quais quer remover
        System.out.println("\nDigite os números que deseja remover.");  
        System.out.println("(digite 'parar' para parar)");

        while (true) {
            System.out.print("Número: ");
            String entrada = scanner.next();
            if (entrada.equalsIgnoreCase("parar")) break;
            arvoreBinaria.remover(Integer.parseInt(entrada));
        }

        System.out.println("\nÁrvore em ordem após remoções:");
        arvoreBinaria.percurso("Em");

        scanner.close();
    }
}
