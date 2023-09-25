package org.example;

class Livro {
    private int id;
    private String nome;
    private int anoPublicacao;
    private Autor autor;
    private Categoria categoria;

    public Livro(int id, String nome, int anoPublicacao, Autor autor, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    // Getters e Setters (métodos de acesso)
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}