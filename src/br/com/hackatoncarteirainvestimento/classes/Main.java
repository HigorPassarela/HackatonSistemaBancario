/*
AUTORES:
Higor do Nascimento Passarela
Osmair Coelho
Ryan Victor da Silva Dias
Data: 01/09/2025


15 pontos - Funcionalidade cadastro cliente
10 pontos - Permite digitar qualquer coisa no menu
7 pontos - Nao mostra o tipo de investimento
10 pontos - uso do map
10 pontos - uso do list
5 pontos - Menu quebra com letras e cpf aceita letras
10 pontos - Organização do codigo
5 pontos - Legibilidade e nomes
5 pontos - Interação com o usuario
10 pontos - Comentarios e Documetação
*/

package br.com.hackatoncarteirainvestimento.classes;

import java.util.*;

public class Main {
    private static Map<String, Cliente> clientes = new HashMap<>();


    public static void main(String[] args) {

        SistemaInvestimentos system = new SistemaInvestimentos();
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Adicionar investimentos");
            System.out.println("3 - Listar investimento de um cliente");
            System.out.println("4 - Relatório geral");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("=== CADASTRAR CLIENTE ===");
                    system.cadastrarCliente(clientes, sc);
                    break;
                case 2:
                    System.out.println("=== ADICIONAR INVESTIMENTO ===");
                    system.adicionarInvestimento(clientes, sc);
                    break;
                case 3:
                    System.out.println("=== LISTAR INVESTIMENTO CLIENTE ===");
                    system.listarInvestimentos(clientes, sc);
                    break;
                case 4:
                    System.out.println("=== RELATÓRIO GERAL ===");
                    system.relatorioGeral(clientes);
                    break;
                case 0:
                    System.out.println("Encerrando o software...");
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }
}
