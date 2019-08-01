package com.example.searchviewbasico;

public class Item {
    private String imagem;
    private String nome;
    private String sobreNome;

    public Item(String imagem, String nome, String sobreNome) {
        this.imagem = imagem;
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }
}