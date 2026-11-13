package com.univassouras.visitor;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Livro("Clean Code", 100.0, 0.5));
        carrinho.adicionar(new Eletronico("Notebook", 3000.0, 2.0, 12));
        carrinho.adicionar(new Alimento("Cafe", 20.0, 0.5, false));
        carrinho.adicionar(new Alimento("Leite", 6.0, 1.0, true));

        GeradorDescricao descricao = new GeradorDescricao();
        carrinho.aceitar(descricao);
        System.out.println("Itens do carrinho:");
        for (String linha : descricao.getLinhas()) {
            System.out.println("- " + linha);
        }

        CalculadoraImposto imposto = new CalculadoraImposto();
        carrinho.aceitar(imposto);
        System.out.println();
        System.out.println(String.format(Locale.US, "Total de impostos: R$ %.2f", imposto.getTotal()));

        CalculadoraFrete frete = new CalculadoraFrete();
        carrinho.aceitar(frete);
        System.out.println(String.format(Locale.US, "Total de frete: R$ %.2f", frete.getTotal()));
    }
}
