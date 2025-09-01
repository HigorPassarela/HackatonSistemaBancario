package br.com.hackatoncarteirainvestimento.classes;

public class Investimento {
    // Atributos
    private String tipo;
    private double valor;

    // Construtor
    public Investimento(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("Tipo: %s | Valor: R$ %.2f", tipo, valor);
    }
}
