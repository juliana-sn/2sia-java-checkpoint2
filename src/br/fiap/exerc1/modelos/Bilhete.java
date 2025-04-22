package br.fiap.exerc1.modelos;

import java.util.Random;

public class Bilhete {
    private static final Double tarifaBase = 5.20;
    private Long numCartao;
    private Usuario usuario;
    private double saldo;

    public Bilhete(Usuario usuario) {
        this.usuario = usuario;
        this.numCartao = gerarNumero();
    }

    private Long gerarNumero() {
        Random rd = new Random();
        return rd.nextLong(1000,10000);
    }

    public void carregarSaldo(double valor){
        saldo += valor;
    }

    public double consultarSaldo(){
        return saldo;
    }

    public String passarNaCatraca(){
        double debito = tarifaBase/2;
        if (usuario.getTipoUsuario().equalsIgnoreCase("comum")){
            debito = tarifaBase;
        }
        if(saldo >= debito){
            saldo -= debito;
            return "Passando na catraca";
        }
        return "Saldo Insuficiente";
    }


    public Long getNumCartao() {
        return numCartao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getSaldo() {
        return saldo;
    }
}
