package org.example;

import java.sql.*;
import java.util.Scanner;

public class funcoesAutor {

    public static void adicionarAutor () {
        String url = "jdbc:sqlite:biblioteca.db";
        try (Connection connection = DriverManager.getConnection(url)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Nacionalidade: ");
            String nacionalidade = scanner.nextLine();

            String sql = "INSERT INTO Autores (Nome, Nacionalidade) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, nacionalidade);

                int linhasAfetadas = preparedStatement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Autor adicionado com sucesso.");
                } else {
                    System.err.println("Erro ao adicionar autror.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static void excluirAutor () {
        String url = "jdbc:sqlite:biblioteca.db";

        try (Connection connection = DriverManager.getConnection(url)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o id do autor que deseja excluir: ");
            String idExclusao= scanner.nextLine();

            String sql = "DELETE FROM Autores WHERE ID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idExclusao);

                int linhasAfetadas = preparedStatement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Autor excluído com sucesso.");
                } else {
                    System.err.println("Nenhum autor foi excluída. Verifique o ID da categoria.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static void atualizarAutor () {
        String url = "jdbc:sqlite:biblioteca.db";

        try (Connection connection = DriverManager.getConnection(url)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o id do autor que deseja atualizar: ");
            int idAtualizar = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o novo nome do autor: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite a nova nacionalidade do autor: ");
            String novaNacionalidade = scanner.nextLine();

            String sql = "UPDATE Autores SET Nome = ?, Nacionalidade = ? WHERE ID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, novoNome);
                    preparedStatement.setString(2, novaNacionalidade);
                    preparedStatement.setInt(3, idAtualizar);

                    int linhasAfetadas = preparedStatement.executeUpdate();
                    if (linhasAfetadas > 0) {
                        System.out.println("Autor atualizado com sucesso.");
                    } else {
                        System.err.println("Nenhum autor foi atualizado. Verifique o ID do autor.");
                    }
                }
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            }
    }


    public static void listarAutor () {
            String url = "jdbc:sqlite:biblioteca.db"; // Substitua pelo nome do seu banco de dados SQLite

        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "SELECT ID, Nome, Nacionalidade FROM Autores";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String nome = resultSet.getString("Nome");
                    String nacionalidade = resultSet.getString("Nacionalidade");

                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("Nacionalidade " + nacionalidade);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        }
}