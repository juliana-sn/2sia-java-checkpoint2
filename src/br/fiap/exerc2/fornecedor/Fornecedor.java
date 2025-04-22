package br.fiap.exerc2.fornecedor;

public class Fornecedor {
    private String nome;
    private Long cnpj;

    public Fornecedor(String nome, Long cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public Long getCnpj() {
        return cnpj;
    }
}
