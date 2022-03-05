package com.dio.desafioBancoDigital;

public class Cliente {

    private String nome;
    private String CPF;
    private int IdCliente;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }



    private static int SEQUENCIAL_CLIENTE = 100;

    public int getIdCliente() {
        return IdCliente;
    }

    public Cliente(String nome) {
        this.nome = nome;
        IdCliente = SEQUENCIAL_CLIENTE++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
