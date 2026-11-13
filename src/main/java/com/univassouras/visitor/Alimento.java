package com.univassouras.visitor;

public class Alimento implements ItemCarrinho {
    private final String nome;
    private final double preco;
    private final double pesoKg;
    private final boolean perecivel;

    public Alimento(String nome, double preco, double pesoKg, boolean perecivel) {
        this.nome = nome;
        this.preco = preco;
        this.pesoKg = pesoKg;
        this.perecivel = perecivel;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }
}
