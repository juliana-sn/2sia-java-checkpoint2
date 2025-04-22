package br.fiap.exerc1.modelos;

public class Usuario {
    private String nome;
    private long cpf;
    private String tipoUsuario;

    public Usuario(String nome, Long cpf, String tipoUsuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
