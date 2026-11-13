package com.univassouras.visitor;

public class CalculadoraImposto implements Visitante {
    private static final double ALIQUOTA_LIVRO = 0.0;
    private static final double ALIQUOTA_ELETRONICO = 0.18;
    private static final double ALIQUOTA_ALIMENTO = 0.07;

    private double total;

    @Override
    public void visitar(Livro livro) {
        total += livro.getPreco() * ALIQUOTA_LIVRO;
    }

    @Override
    public void visitar(Eletronico eletronico) {
        total += eletronico.getPreco() * ALIQUOTA_ELETRONICO;
    }

    @Override
    public void visitar(Alimento alimento) {
        total += alimento.getPreco() * ALIQUOTA_ALIMENTO;
    }

    public double getTotal() {
        return total;
    }
}
