package com.univassouras.visitor;

public class Eletronico implements ItemCarrinho {
    private final String nome;
    private final double preco;
    private final double pesoKg;
    private final int garantiaMeses;

    public Eletronico(String nome, double preco, double pesoKg, int garantiaMeses) {
        this.nome = nome;
        this.preco = preco;
        this.pesoKg = pesoKg;
        this.garantiaMeses = garantiaMeses;
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

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }
}
