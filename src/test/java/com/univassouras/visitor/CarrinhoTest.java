package com.univassouras.visitor;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarrinhoTest {

    private static final double DELTA = 0.0001;

    private Carrinho carrinhoCompleto() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Livro("Clean Code", 100.0, 0.5));
        carrinho.adicionar(new Eletronico("Notebook", 3000.0, 2.0, 12));
        carrinho.adicionar(new Alimento("Cafe", 20.0, 0.5, false));
        carrinho.adicionar(new Alimento("Leite", 6.0, 1.0, true));
        return carrinho;
    }

    @Test
    void livroNaoDevePagarImposto() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Livro("Clean Code", 100.0, 0.5));
        CalculadoraImposto imposto = new CalculadoraImposto();

        carrinho.aceitar(imposto);

        assertEquals(0.0, imposto.getTotal(), DELTA);
    }

    @Test
    void eletronicoDevePagarDezoitoPorCentoDeImposto() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Eletronico("Notebook", 3000.0, 2.0, 12));
        CalculadoraImposto imposto = new CalculadoraImposto();

        carrinho.aceitar(imposto);

        assertEquals(540.0, imposto.getTotal(), DELTA);
    }

    @Test
    void alimentoDevePagarSetePorCentoDeImposto() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Alimento("Cafe", 20.0, 0.5, false));
        CalculadoraImposto imposto = new CalculadoraImposto();

        carrinho.aceitar(imposto);

        assertEquals(1.4, imposto.getTotal(), DELTA);
    }

    @Test
    void impostoTotalDeveSomarTodosOsTiposDeItem() {
        CalculadoraImposto imposto = new CalculadoraImposto();

        carrinhoCompleto().aceitar(imposto);

        assertEquals(541.82, imposto.getTotal(), DELTA);
    }

    @Test
    void freteDeAlimentoPerecivelDeveCustarMaisQueODeAlimentoComum() {
        CalculadoraFrete freteComum = new CalculadoraFrete();
        CalculadoraFrete fretePerecivel = new CalculadoraFrete();

        Carrinho comum = new Carrinho();
        comum.adicionar(new Alimento("Arroz", 10.0, 1.0, false));
        comum.aceitar(freteComum);

        Carrinho perecivel = new Carrinho();
        perecivel.adicionar(new Alimento("Leite", 10.0, 1.0, true));
        perecivel.aceitar(fretePerecivel);

        assertEquals(10.0, freteComum.getTotal(), DELTA);
        assertEquals(22.0, fretePerecivel.getTotal(), DELTA);
    }

    @Test
    void freteTotalDeveSomarTodosOsTiposDeItem() {
        CalculadoraFrete frete = new CalculadoraFrete();

        carrinhoCompleto().aceitar(frete);

        assertEquals(58.0, frete.getTotal(), DELTA);
    }

    @Test
    void descricaoDeveGerarUmaLinhaPorItemNaOrdemDeInsercao() {
        GeradorDescricao descricao = new GeradorDescricao();

        carrinhoCompleto().aceitar(descricao);

        List<String> linhas = descricao.getLinhas();
        assertEquals(4, linhas.size());
        assertEquals("Livro: Clean Code - R$ 100.00", linhas.get(0));
        assertEquals("Eletronico: Notebook - R$ 3000.00 (garantia de 12 meses)", linhas.get(1));
        assertEquals("Alimento: Cafe - R$ 20.00 (nao perecivel)", linhas.get(2));
        assertEquals("Alimento: Leite - R$ 6.00 (perecivel)", linhas.get(3));
    }

    @Test
    void cadaItemDeveChamarOMetodoVisitarDoSeuProprioTipo() {
        int[] contagem = new int[3];
        Visitante contador = new Visitante() {
            @Override
            public void visitar(Livro livro) {
                contagem[0]++;
            }

            @Override
            public void visitar(Eletronico eletronico) {
                contagem[1]++;
            }

            @Override
            public void visitar(Alimento alimento) {
                contagem[2]++;
            }
        };

        carrinhoCompleto().aceitar(contador);

        assertEquals(1, contagem[0]);
        assertEquals(1, contagem[1]);
        assertEquals(2, contagem[2]);
    }

    @Test
    void carrinhoVazioDeveTerTotaisZerados() {
        Carrinho vazio = new Carrinho();
        CalculadoraImposto imposto = new CalculadoraImposto();
        CalculadoraFrete frete = new CalculadoraFrete();

        vazio.aceitar(imposto);
        vazio.aceitar(frete);

        assertEquals(0, vazio.quantidadeDeItens());
        assertEquals(0.0, imposto.getTotal(), DELTA);
        assertEquals(0.0, frete.getTotal(), DELTA);
    }
}
