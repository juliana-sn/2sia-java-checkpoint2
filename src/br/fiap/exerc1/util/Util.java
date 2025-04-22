package br.fiap.exerc1.util;

import br.fiap.exerc1.modelos.Bilhete;
import br.fiap.exerc1.modelos.Usuario;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Util {
    static Scanner sc = new Scanner(System.in);
    private Bilhete[] bilhetes = new Bilhete[5];
    private int contBilhete = 0;

    public void menuPrincipal(){
        int entrada = 0;
        String msg = "--Menu Bilhete Único --\n1.Administrador\n2.Usuario\n3.Finalizar";

        do {
            System.out.println(msg);
            entrada = sc.nextInt();
            switch (entrada){
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    menuUsuario();
                    break;
            }

        }while (entrada != 3);
    }

    private void menuAdministrador(){
        String msg = "1.Emitir novo bilhete\n2.Listar bilhetes\n3.Remover Bilhete\n4.Sair";
        int entrada = 0;

        do {
            System.out.println(msg);
            entrada = sc.nextInt();
            switch (entrada){
                case 1:
                    System.out.println(emitirBilhete());
                    break;
                case 2:
                    System.out.println(listarBilhetes());
                    break;
                case 3:
                    System.out.println(removerBilhete());
                    break;
            }

        }while(entrada != 4);

    }

    private void menuUsuario(){
        String msg = "1.Consultar saldo\n2.Carregar saldo\n3.Passar na catraca\n4.Sair";
        int entrada = 0;

        do {
            System.out.println(msg);
            entrada = sc.nextInt();
            switch (entrada){
                case 1:
                    System.out.println(consultarSaldo());
                    break;
                case 2:
                    System.out.println(carregarSaldo());
                    break;
                case 3:
                    System.out.println(passarNaCatraca());
                    break;
            }
        }while(entrada != 4);

    }

    private String emitirBilhete(){
        if(contBilhete < bilhetes.length){
            String nome, perfil;
            long cpf;

            System.out.println("Insira os dados para emitir o bilhete");
            System.out.print("Nome: ");
            nome = sc.next();
            System.out.print("CPF: ");
            cpf = sc.nextLong();
            System.out.print("Tipo de tarifa (perfil) -> Estudante, professor ou comum: ");
            perfil = sc.next();

            bilhetes[contBilhete] = new Bilhete(new Usuario(nome, cpf, perfil));
            contBilhete++;
            return "Bilhete emitido!";
        }else{
            return "Não é possível emitir, contate a administração";
        }
    }

    private String listarBilhetes(){
        DecimalFormat df = new DecimalFormat("0.00");
        String msg = "";

        if(contBilhete > 0){
            for (int i = 0; i < contBilhete; i++) {
                msg += "Nome do usuário: " + bilhetes[i].getUsuario().getNome() + "\n";
                msg += "CPF: " + bilhetes[i].getUsuario().getCpf()  + "\n";
                msg += "Número do cartão: " + bilhetes[i].getNumCartao() + "\n";
                msg += "Saldo disponível: " + bilhetes[i].getSaldo() + "\n";
                msg += "Perfil (tipo da tarifa): " + bilhetes[i].getUsuario().getTipoUsuario() + "\n";
                msg += "=========================\n";
                return msg;
            }
        }
        return "Sem bilhetes cadastrados";
    }

    private String removerBilhete(){
        int posicao = pesquisarBilhete();
        int opcao = 0;

        if(posicao != -1){
            System.out.println("Tem certeza que deseja remover o bilhete? (1. Sim ou 2. Não)");
            opcao = sc.nextInt();
            if (opcao == 1){
                contBilhete--;
                bilhetes[posicao] = bilhetes[contBilhete];
                return "Bilhete removido";
            }
            return "Voltando ao menu...\n";
        }
        return "Bilhete não encontrado!";
    }

    private String consultarSaldo(){
        int posicao = pesquisarBilhete();

        if (posicao != -1){
            return "Saldo disponível: R$" + bilhetes[posicao].consultarSaldo();
        }

        return "Bilhete não encontrado!";

    }

    private String carregarSaldo(){
        int posicao = pesquisarBilhete();
        double valor;

        if (posicao != -1){
            System.out.print("Digite o valor que deseja carregar: ");
            valor = sc.nextDouble();

            bilhetes[posicao].carregarSaldo(valor);
            return "Valor carregado!";
        }

        return "Bilhete não encontrado!";
    }

    private String passarNaCatraca(){
        int posicao = pesquisarBilhete();

        if (posicao != -1){
            bilhetes[posicao].passarNaCatraca();
            return "Passando na catraca...";
        }

        return "Bilhete não encontrado!";
    }

    private int pesquisarBilhete(){
        long cpf;
        int posicao = -1;

        System.out.print("CPF do usuário do bilhete: ");
        cpf = sc.nextLong();

        for (int i = 0; i < contBilhete; i++) {
            if (cpf == bilhetes[i].getUsuario().getCpf()){
                posicao = i;
            }
        }
        return posicao;
    }
}