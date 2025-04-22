package br.fiap.exerc2.produto;

import br.fiap.exerc2.fornecedor.Fornecedor;

public class Produto {
    private String nome;
    private Double valor;
    private int qtdEstoque;
    private Fornecedor fornecedor;

    public Produto(String nome, Double valor, int qtdEstoque, Fornecedor fornecedor) {
        this.nome = nome;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
