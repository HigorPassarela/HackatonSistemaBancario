package br.com.hackaton.classes;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    //Atributos
    private int numero;
    private Cliente titular;
    private double saldo;
    private List<Transacao> extrato;

    //Construtor
    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
        this.extrato = new ArrayList<>();
    }

    //Getter
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    //Metodo depositar
    public void depositar(double valor) {
        saldo += valor;
        extrato.add(new Transacao("Depósito", valor, 0, numero));
    }

    //Metodo sacar
    public boolean sacar(double valor) {
        if (valor > saldo) return false;
        saldo -= valor;
        extrato.add(new Transacao("Saque", valor, numero, 0));
        return true;
    }

    //Metodo transferir
    public boolean transferir(double valor, Conta destino) {
        if (valor > saldo) return false;
        saldo -= valor;
        destino.saldo += valor;
        extrato.add(new Transacao("Transferência Enviada", valor, numero, destino.numero));
        destino.extrato.add(new Transacao("Transferência Recebida", valor, numero, destino.numero));
        return true;
    }

    //Mostrar extrado
    public void mostrarExtrato() {
        if (extrato.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            extrato.forEach(System.out::println);
        }
    }
}
