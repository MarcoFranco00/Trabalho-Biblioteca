package org.example;

import java.sql.*;
import java.util.Scanner;

public class funcoesCategoria {

    public static void adicionarCategoria() {
        String url = "jdbc:sqlite:biblioteca.db";
        try (Connection connection = DriverManager.getConnection(url)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Categoria do livro: ");
            String categoria = scanner.nextLine();

            String sql = "INSERT INTO Categorias (Nome) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, categoria);

                int linhasAfetadas = preparedStatement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Categoria adicinada com sucesso.");
                } else {
                    System.err.println("Erro ao inserir o livro.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static void excluirCategoria () {
        String url = "jdbc:sqlite:biblioteca.db";

        try (Connection connection = DriverManager.getConnection(url)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o id do categoria que deseja excluir: ");
            String idExclusao= scanner.nextLine();

            String sql = "DELETE FROM Categorias WHERE ID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idExclusao);

                int linhasAfetadas = preparedStatement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Categoria excluída com sucesso.");
                } else {
                    System.err.println("Nenhuma categoria foi excluída. Verifique o ID da categoria.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static void listarCategoria () {
        String url = "jdbc:sqlite:biblioteca.db"; // Substitua pelo nome do seu banco de dados SQLite

        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "SELECT ID, Nome FROM Categorias";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String nome = resultSet.getString("Nome");

                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static void atualizarCategoria() {
        String url = "jdbc:sqlite:biblioteca.db";

        try (Connection connection = DriverManager.getConnection(url)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o id do categoria que deseja atualizar: ");
            int idAtualizar = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o novo nome do livro: ");
            String novoNome = scanner.nextLine();
            String sql = "UPDATE Categorias SET Nome = ? WHERE ID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, novoNome);
                preparedStatement.setInt(2, idAtualizar);

                int linhasAfetadas = preparedStatement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Categoria atualizada com sucesso.");
                } else {
                    System.err.println("Nenhuma categoria foi atualizada. Verifique o ID da categoria.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

}
