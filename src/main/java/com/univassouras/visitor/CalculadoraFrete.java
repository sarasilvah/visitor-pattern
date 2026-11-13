package com.univassouras.visitor;

public class CalculadoraFrete implements Visitante {
    private static final double TAXA_LIVRO = 5.0;
    private static final double VALOR_KG_LIVRO = 2.0;
    private static final double TAXA_ELETRONICO = 15.0;
    private static final double VALOR_KG_ELETRONICO = 3.0;
    private static final double TAXA_ALIMENTO_COMUM = 8.0;
    private static final double TAXA_ALIMENTO_PERECIVEL = 20.0;
    private static final double VALOR_KG_ALIMENTO = 2.0;

    private double total;

    @Override
    public void visitar(Livro livro) {
        total += TAXA_LIVRO + livro.getPesoKg() * VALOR_KG_LIVRO;
    }

    @Override
    public void visitar(Eletronico eletronico) {
        total += TAXA_ELETRONICO + eletronico.getPesoKg() * VALOR_KG_ELETRONICO;
    }

    @Override
    public void visitar(Alimento alimento) {
        double taxa = alimento.isPerecivel() ? TAXA_ALIMENTO_PERECIVEL : TAXA_ALIMENTO_COMUM;
        total += taxa + alimento.getPesoKg() * VALOR_KG_ALIMENTO;
    }

    public double getTotal() {
        return total;
    }
}
