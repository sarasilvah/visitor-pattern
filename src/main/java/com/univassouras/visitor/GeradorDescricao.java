package com.univassouras.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GeradorDescricao implements Visitante {
    private final List<String> linhas = new ArrayList<>();

    @Override
    public void visitar(Livro livro) {
        linhas.add(String.format(Locale.US, "Livro: %s - R$ %.2f", livro.getTitulo(), livro.getPreco()));
    }

    @Override
    public void visitar(Eletronico eletronico) {
        linhas.add(String.format(Locale.US, "Eletronico: %s - R$ %.2f (garantia de %d meses)",
                eletronico.getNome(), eletronico.getPreco(), eletronico.getGarantiaMeses()));
    }

    @Override
    public void visitar(Alimento alimento) {
        String tipo = alimento.isPerecivel() ? "perecivel" : "nao perecivel";
        linhas.add(String.format(Locale.US, "Alimento: %s - R$ %.2f (%s)",
                alimento.getNome(), alimento.getPreco(), tipo));
    }

    public List<String> getLinhas() {
        return new ArrayList<>(linhas);
    }
}
