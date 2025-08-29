package br.com.hackaton.classes;

import java.time.LocalDateTime;

public class Transacao {
    //Atributos
    private static int contador = 1;
    private int id;
    private String tipo;
    private double valor;
    private LocalDateTime data;
    private int contaOrigem;
    private int contaDestino;

    //Construtor
    public Transacao(String tipo, double valor, int contaOrigem, int contaDestino) {
        this.id = contador++;
        this.tipo = tipo;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.data = LocalDateTime.now();
    }

    //Mostrar dados
    @Override
    public String toString() {
        return "[" + data + "] ID:" + id + " | " + tipo + " | R$ " + valor +
                " | Origem: " + contaOrigem + " | Destino: " + contaDestino;
    }
}
