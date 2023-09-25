package org.example;

import java.util.Scanner;

import static org.example.funcoesAutor.*;
import static org.example.funcoesCategoria.*;
import static org.example.funcoesLivro.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Livro");
            System.out.println("2. Autor");
            System.out.println("3. Categoria");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int escolhaPrincipal = scanner.nextInt();

            switch (escolhaPrincipal) {
                case 0:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                case 1:
                    menuLivro(scanner);
                    break;
                case 2:
                    menuAutor(scanner);
                    break;
                case 3:
                    menuCategoria(scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuLivro(Scanner scanner) {
        while (true) {
            System.out.println("\nMenu Livro:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Atualizar Livro");
            System.out.println("3. Listar Livros");
            System.out.println("4. Excluir Livro");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int escolhaLivro = scanner.nextInt();

            switch (escolhaLivro) {
                case 0:
                    return;
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    atualizarLivro();
                    break;
                case 3:
                    System.out.println("Aqui estão todos os livros.");
                    listarLivros();
                    break;
                case 4:
                    excluirLivro();
                    System.out.println("Livro excluido com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuAutor(Scanner scanner) {
        System.out.println("Menu Autor");
        while (true) {
            System.out.println("\nMenu Autor:");
            System.out.println("1. Adicionar Autor");
            System.out.println("2. Atualizar Autor");
            System.out.println("3. Listar Autores");
            System.out.println("4. Excluir Autor");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int escolhaAutor = scanner.nextInt();

            switch (escolhaAutor) {
                case 0:
                    return;
                case 1:
                    adicionarAutor();
                    break;
                case 2:
                    atualizarAutor();
                    break;
                case 3:
                    System.out.println("Aqui estão todos os autores.");
                    listarAutor();
                    break;
                case 4:
                    excluirAutor();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuCategoria(Scanner scanner) {
        System.out.println("Menu Categoria");
        while (true) {
            System.out.println("\nMenu Categoria:");
            System.out.println("1. Adicionar Categoria");
            System.out.println("2. Atualizar Categoria");
            System.out.println("3. Listar Categorias");
            System.out.println("4. Excluir Categoria");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int escolhaAutor = scanner.nextInt();

            switch (escolhaAutor) {
                case 0:
                    return;
                case 1:
                    adicionarCategoria();
                    break;
                case 2:
                    atualizarCategoria();
                    break;
                case 3:
                    System.out.println("Aqui estão todos os Categorias.");
                    listarCategoria();
                    break;
                case 4:
                    excluirCategoria();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}