package com.univassouras.visitor;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private final List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionar(ItemCarrinho item) {
        itens.add(item);
    }

    public int quantidadeDeItens() {
        return itens.size();
    }

    public void aceitar(Visitante visitante) {
        for (ItemCarrinho item : itens) {
            item.aceitar(visitante);
        }
    }
}
