package br.fiap.exerc2.util;

import br.fiap.exerc2.fornecedor.Fornecedor;
import br.fiap.exerc2.produto.Produto;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Util {
    Scanner sc = new Scanner(System.in);
    int entrada = 0;
    Fornecedor[] fornecedores = new Fornecedor[5];
    Produto[] produtos = new Produto[5];
    int contFornecedores, contProdutos = 0;

    public void menu(){
        do {
            System.out.println("---Menu de Produtos e Fornecedores---");
            System.out.println("1. Cadastrar produto\n" + "2.Pesquisar produto por nome");
            System.out.println("3.Pesquisar por fornecedor\n" + "4.Finalizar");
            entrada = sc.nextInt();

            switch (entrada){
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisarFornecedor();
                    break;
                case 4:
                    System.out.println("Encerrando o sistema");
                    entrada = 5;
                    break;
                default:

            }
        }while(entrada != 5);
    }

    private void cadastrarProduto() {
        Fornecedor fornecedor = pesquisarFornecedor();

        if(fornecedor == null){
            fornecedor = cadastrarFornecedor();
        }

        System.out.print("Digite o nome do produto: ");
        String nome = sc.next();
        System.out.print("Valor do produto: ");
        double valor = sc.nextDouble();
        System.out.print("Digite a quantidade em estoque: ");
        int estoque = sc.nextInt();

        Produto produto = new Produto(nome, valor, estoque, fornecedor);
        produtos[contProdutos] = produto;
        contProdutos++;
    }

    private void pesquisarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = sc.next();

        DecimalFormat df = new DecimalFormat("0.00");
        String msg = "Produto não cadastrado";

        for (int i = 0; i < contProdutos; i++) {
            if(produtos[i].getNome().equalsIgnoreCase(nome)){
                msg = "Produto: " + nome + "\n";
                msg += "Valor unitário: R$" + df.format(produtos[i].getValor()) + "\n";
                msg += "Fornecedor: " + produtos[i].getFornecedor().getNome();
            }
        }

        System.out.println(msg);
    }

    private Fornecedor pesquisarFornecedor() {
        System.out.print("Digite o cnpj do fornecedor: ");
        long cnpj = sc.nextLong();
        for (int i = 0; i < contFornecedores; i++) {
            if(cnpj == fornecedores[i].getCnpj()){
                return fornecedores[i];
            }
        }
        System.out.println("Fornecedor não cadastrado");
        return null;
    }

    private Fornecedor cadastrarFornecedor(){
        System.out.print("Nome do fornecedor: ");
        String nome = sc.next();
        System.out.print("CNPJ do fornecedor: ");
        Long cnpj = sc.nextLong();

        Fornecedor fornecedor = new Fornecedor(nome, cnpj);
        fornecedores[contFornecedores] = fornecedor;
        contFornecedores++;
        return fornecedor;
    }
}
