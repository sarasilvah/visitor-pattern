package com.univassouras.visitor;

public class Livro implements ItemCarrinho {
    private final String titulo;
    private final double preco;
    private final double pesoKg;

    public Livro(String titulo, double preco, double pesoKg) {
        this.titulo = titulo;
        this.preco = preco;
        this.pesoKg = pesoKg;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }
}
