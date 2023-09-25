package org.example;

class Autor {
    private int id;
    private String nome;
    private String nacionalidade;

    public Autor(int id, String nome, String nacionalidade) {
        this.id= id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    // Getters e Setters (métodos de acesso)
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

}