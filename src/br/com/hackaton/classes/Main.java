package br.com.hackaton.classes;

import java.util.*;

public class Main {
    private static Set<Cliente> clientes = new HashSet<>();
    private static Map<Integer, Conta> contas = new HashMap<>();
    private static int numeroConta = 1001;

    public static void main(String[] args) {
        //Atributos
        int num;
        double valor;

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Conta");
            System.out.println("3 - Depósito");
            System.out.println("4 - Saque");
            System.out.println("5 - Transferência");
            System.out.println("6 - Consultar Saldo");
            System.out.println("7 - Extrato da Conta");
            System.out.println("8 - Listar Clientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("======CADASTRAR CLIENTE======");
                    System.out.println("Digite o Nome do Cliente: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    System.out.println("CPF do cliente: ");
                    String cpf = sc.nextLine();

                    Cliente novoCliente = new Cliente(nome,cpf);
                    if (clientes.add(novoCliente)){
                        System.out.println("CLiente cadastrado com sucesso!");
                    } else {
                        System.out.println("Cliente já cadastrado!");
                    }
                    break;

                case 2:
                    System.out.println("======CADASTRAR CONTA======");
                    System.out.println("Digite o cpf do cliente: ");
                    sc.nextLine();
                    String cpfTitular = sc.nextLine();
                    Cliente titular = clientes.stream().filter(c -> c.getCpf().
                            equals(cpfTitular)).findFirst().orElse(null);
                    if (titular != null){
                        Conta novaConta = new Conta(numeroConta,titular);
                        contas.put(numeroConta, novaConta);
                        System.out.println("Conta criada! Numero: " + numeroConta);
                        numeroConta++;
                    } else {
                        System.out.println("Cliente não encotrado!");
                    }
                    break;

                case 3:
                    System.out.println("======DEPÓSITO======");
                    System.out.print("Número da conta: ");
                    num = sc.nextInt();
                    System.out.print("Valor: ");
                    valor = sc.nextDouble();

                    Conta conta = contas.get(num);
                    if (conta != null) {
                        conta.depositar(valor);
                        System.out.println("Depósito realizado!");
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 4:
                    System.out.println("======SAQUE======");
                    System.out.print("Número da conta: ");
                    num = sc.nextInt();
                    System.out.print("Valor: ");
                    valor = sc.nextDouble();

                    Conta cont = contas.get(num);
                    if (cont != null && cont.sacar(valor)) {
                        System.out.println("Saque realizado!");
                    } else {
                        System.out.println("Saldo insuficiente ou conta não encontrada!");
                    }
                    break;

                case 5:
                    System.out.println("======TRANSFERÊNCIA======");
                    System.out.println("Conta Origem: ");
                    int origem = sc.nextInt();
                    System.out.println("Conta Destino: ");
                    int destino = sc.nextInt();
                    System.out.println("Valor da Transferência: ");
                    valor = sc.nextDouble();
                    Conta contaOrigem = contas.get(origem);
                    Conta contaDestino = contas.get(destino);

                    if (contaOrigem != null && contaDestino != null && contaOrigem.transferir(valor, contaDestino)) {
                        System.out.println("Transferência realizada!");
                    } else {
                        System.out.println("Conta inválida ou Saldo insuficiente!");
                    }
                    break;

                case 6:
                    System.out.println("======CONSULTAR SALDO======");
                    System.out.print("Número da conta: ");
                    num = sc.nextInt();

                    Conta consultar = contas.get(num);
                    if (consultar != null) {
                        System.out.println("Saldo: " + consultar.getSaldo());
                    } else {
                        System.out.println("⚠ Conta não encontrada.");
                    }
                    break;

                case 7:
                    System.out.println("======EXTRATO DA CONTA======");
                    System.out.println("Digite o numero da conta: ");
                    num = sc.nextInt();
                    Conta contaExtrato = contas.get(num);
                    if (contaExtrato != null) {
                        contaExtrato.mostrarExtrato();
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 8:
                    System.out.println("======LISTAR CLIENTES======");
                    clientes.forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Finalizando o Software...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}