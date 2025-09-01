package br.com.hackatoncarteirainvestimento.classes;

import java.util.*;

public class SistemaInvestimentos {

    Scanner sc = new Scanner(System.in);
    // Atributos
    private Map<String, Cliente> clientes;  // chave = CPF

    // Construtor
    public SistemaInvestimentos() {
        clientes = new HashMap<>();
    }

    // Métodos sugeridos
    public void cadastrarCliente(Map<String, Cliente> clienteMap, Scanner sc) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = sc.next();

        if (clienteMap.containsKey(cpf)) {
            System.out.println("Já existe um cliente cadastrado com esse CPF!");
            return;
        }

        System.out.print("Digite o nome do cliente: ");
        String nome = sc.next();

        System.out.print("Digite o email do cliente: ");
        String email = sc.next();

        Cliente novoCliente = new Cliente(cpf, nome, email, new ArrayList<>());

        clienteMap.put(cpf, novoCliente);
        System.out.println(" Cliente cadastrado com sucesso!");
    }

    public Cliente buscarCliente(Map<String, Cliente> clienteMap, String cpf) {
        return clienteMap.get(cpf);
    }

    public void adicionarInvestimento(Map<String, Cliente> clienteMap, Scanner sc) {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.next();

        Cliente cliente = clienteMap.get(cpf);

        if (cliente == null) {
            System.out.println(" Cliente não encontrado!");
            return;
        }


        System.out.println("Digite o tipo de investimento(ex.: Tesouro Selic, CDB, Ações) : ");
        String tipo = sc.nextLine();


        sc.nextLine();
        double valor = -1;

        while (valor <= 0) {
            try {
                System.out.println("\nDigite o valor investido: ");
                valor = Double.parseDouble(sc.nextLine());
                if (valor <= 0) {
                    System.out.println("O valor dever ser positivo!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido!");
            }
        }


        Investimento investimento = new Investimento(tipo, valor);
        cliente.getInvestimentos().add(investimento);

        System.out.println(" Investimento cadastrado com sucesso para o cliente " + cliente.getNome());
    }

    public void listarInvestimentos(Map<String, Cliente> clienteMap, Scanner sc) {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.next();

        Cliente cliente = clienteMap.get(cpf);

        if (cliente == null) {
            System.out.println(" Cliente não encontrado!");
            return;
        }
        System.out.println("Investimentos do cliente " + cliente.getNome() + " CPF: " + cliente.getCpf());

        if (cliente.getInvestimentos().isEmpty()) {
            System.out.println("Nenhum investimento cadastrado!");
        } else {
            for (Investimento inv : cliente.getInvestimentos()) {
                System.out.println("  - " + inv);
            }
        }

    }

    public void relatorioGeral(Map<String, Cliente> clienteMap) {
        if (clienteMap.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        for (Cliente cliente : clienteMap.values()) {
            System.out.println("Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");
            System.out.println("Email: " + cliente.getEmail());

            List<Investimento> investimentos = cliente.getInvestimentos();

            if (investimentos.isEmpty()) {
                System.out.println("Nenhum investimento cadastrado.");
            } else {
                double totalInvestido = 0;
                System.out.println("Investimentos:");
                for (Investimento inv : investimentos) {
                    System.out.println("     - " + inv.getTipo() + ": R$ " + inv.getValor());
                    totalInvestido += inv.getValor();
                }
                System.out.printf("Total investido: R$ %.2f%n", totalInvestido);
            }
        }
    }

}
