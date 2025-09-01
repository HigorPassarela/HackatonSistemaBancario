package br.com.hackatoncarteirainvestimento.classes;

import java.util.List;
import java.util.Objects;

public class Cliente {
    //Atributos
    private String cpf;
    private String nome;
    private String email;
    private List<Investimento> investimentos;


    //Construtor
    public Cliente(String cpf, String nome, String email, List<Investimento> investimentos) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.investimentos = investimentos;
    }

    // Getters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public List<Investimento> getInvestimentos() { return investimentos; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "cpf='" + cpf + '\'' +
                ", nome=' " + nome + '\'' +
                ", email= '" + email + '\'' +
                ", investimentos= " + investimentos;
    }
}
