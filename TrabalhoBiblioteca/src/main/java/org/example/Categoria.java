package org.example;

class Categoria {
    private int id;
    private String nome;

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters (métodos de acesso)
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}