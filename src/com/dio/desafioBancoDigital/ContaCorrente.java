package com.dio.desafioBancoDigital;

public class ContaCorrente extends Conta {


    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato(){
        System.out.println("**** Saldo Conta Corrente ****");
        super.imprimirInfosComuns();
    }
}
