package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;
public class funcoesLivro {


    public static void adicionarLivro() {
            String url = "jdbc:sqlite:biblioteca.db";
            try (Connection connection = DriverManager.getConnection(url)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Título do livro: ");
                String titulo = scanner.nextLine();
                System.out.print("Ano de publicação: ");
                int anoPublicacao = scanner.nextInt();
                System.out.print("ID do autor: ");
                int idAutor = scanner.nextInt();
                System.out.print("ID do categoria: ");
                int idCateogoria = scanner.nextInt();

                String sql = "INSERT INTO Livros (Nome, AnoDePublicacao, IDAutor, IDCategoria) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, titulo);
                    preparedStatement.setInt(2, anoPublicacao);
                    preparedStatement.setInt(3, idAutor);
                    preparedStatement.setInt(4, idCateogoria);

                    int linhasAfetadas = preparedStatement.executeUpdate();
                    if (linhasAfetadas > 0) {
                        System.out.println("Livro adicionado com sucesso.");
                    } else {
                        System.err.println("Erro ao inserir o livro.");
                    }
                }
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            }
    }

    public static void excluirLivro () {
        String url = "jdbc:sqlite:biblioteca.db";

        try (Connection connection = DriverManager.getConnection(url)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o id do livro que deseja excluir: ");
            String idExclusao= scanner.nextLine();

            String sql = "DELETE FROM Livros WHERE ID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idExclusao);

                int linhasAfetadas = preparedStatement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Livro excluído com sucesso.");
                } else {
                    System.err.println("Nenhum livro foi excluída. Verifique o ID da categoria.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static void listarLivros () {
            String url = "jdbc:sqlite:biblioteca.db";

            try (Connection connection = DriverManager.getConnection(url)) {
                String sql = "SELECT ID, Nome, AnoDePublicacao, IDAutor, IDCategoria FROM Livros";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("ID");
                        String nome = resultSet.getString("Nome");
                        int anoPublicacao = resultSet.getInt("AnoDePublicacao");
                        int idAutor = resultSet.getInt("IDAutor");
                        int idCategoria = resultSet.getInt("IDCategoria");

                        System.out.println("ID: " + id);
                        System.out.println("Nome: " + nome);
                        System.out.println("Ano de Publicação: " + anoPublicacao);
                        System.out.println("ID do Autor: " + idAutor);
                        System.out.println("ID da Categoria: " + idCategoria);
                        System.out.println();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            }
    }

        public static void atualizarLivro () {
        String url = "jdbc:sqlite:biblioteca.db";

            try (Connection connection = DriverManager.getConnection(url)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o id do livro que deseja atualizar: ");
                int idAtualizar= Integer.parseInt(scanner.nextLine());
                System.out.print("Digite o novo nome do livro: ");
                String novoNome= scanner.nextLine();
                System.out.print("Digite a nova data de publicação do livro: ");
                int novoAnoPublicacao= Integer.parseInt(scanner.nextLine());
                System.out.print("Digite o id do autor: ");
                int idNovoAutor= Integer.parseInt(scanner.nextLine());
                System.out.print("Digite o id da categoria: ");
                int idNovaCategoria= Integer.parseInt(scanner.nextLine());

                String sql = "UPDATE Livros SET Nome = ?, AnoDePublicacao = ?, IDAutor = ?, IDCategoria = ? WHERE ID = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, novoNome);
                    preparedStatement.setInt(2, novoAnoPublicacao);
                    preparedStatement.setInt(3, idNovoAutor);
                    preparedStatement.setInt(4, idNovaCategoria);
                    preparedStatement.setInt(5, idAtualizar);

                    int linhasAfetadas = preparedStatement.executeUpdate();
                    if (linhasAfetadas > 0) {
                        System.out.println("Livro atualizado com sucesso.");
                    } else {
                        System.err.println("Nenhum livro foi atualizado. Verifique o ID do livro.");
                    }
                }
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            }
        }

}

