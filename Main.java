package noss;

public class Main {
    public static void main(String[] args) {


        // Em ordem: 3, 5, 7, 10, 12, 15, 20
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(12);
        arvoreBinaria.inserir(20);

        System.out.println("\nÁrvore em ordem (estado inicial): ");
        arvoreBinaria.percurso("Em");

        // Remoção de nó FOLHA (sem filhos)
        System.out.println("\n=Remoção de nó folha: ");
        arvoreBinaria.remover(3);
        arvoreBinaria.percurso("Em");

        // Remoção de nó com APENAS UM FILHO
        System.out.println("\nRemovendo 12 (folha) ===");
        arvoreBinaria.remover(12);

        System.out.println("\nRemoção de nó com um filho (15, filho = 20): ");
        arvoreBinaria.remover(15);
        arvoreBinaria.percurso("Em");

        // Remoção de nó com DOIS FILHOS
        arvoreBinaria.inserir(4);
        System.out.println("\nRemoção de nó com dois filhos (5, filhos = 4 e 7): ");
        arvoreBinaria.remover(5);
        arvoreBinaria.percurso("Em");

        // Remoção da RAIZ
        System.out.println("\nRemoção da raiz (10):");
        arvoreBinaria.remover(10);
        arvoreBinaria.percurso("Em");

    }
}
