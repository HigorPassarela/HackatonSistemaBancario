package br.com.hackaton.classes;

import java.util.Objects;

public class Cliente {
    //Atributos
    private String nome;
    private String cpf;

    //Construtor
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    //Getter cpf
    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    //Exibir dados
    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ")";
    }
}
