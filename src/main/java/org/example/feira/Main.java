package org.example.feira;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Feira feira = new Feira();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Remover produto");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();
                    feira.adicionarProduto(new Produto(nome, preco));
                    break;
                case 2:
                    feira.listarProdutos();
                    break;
                case 3:
                    System.out.print("Nome do produto a remover: ");
                    String nomeRemover = scanner.nextLine();
                    feira.removerProduto(nomeRemover);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}

