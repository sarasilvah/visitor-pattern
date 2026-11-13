package com.univassouras.visitor;

public interface Visitante {
    void visitar(Livro livro);

    void visitar(Eletronico eletronico);

    void visitar(Alimento alimento);
}
