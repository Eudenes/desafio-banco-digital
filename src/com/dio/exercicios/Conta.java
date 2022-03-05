package com.dio.exercicios;

public abstract class Conta {

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente) {

        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void sacar(double valor) {

        saldo = saldo - valor;

    }

    public void depositar(double valor) {
        saldo = saldo + valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfosComuns(){
        System.out.printf("Cliente: %s \n", this.cliente.getNome());
        System.out.printf("Agencia: %d \n", this.agencia);
        System.out.printf("Numero: %d  \n", this.numero);
        System.out.printf("Saldo: %.2f  \n", this.saldo);

    }

    public void exibirSaldoAtualizado(){
        System.out.printf("Cliente: %s \n", this.cliente.getNome());
        System.out.printf("Agencia: %d \n", this.agencia);
        System.out.printf("Numero: %d  \n", this.numero);
        System.out.printf("Saldo: %.2f  \n", this.saldo);

    }
}
