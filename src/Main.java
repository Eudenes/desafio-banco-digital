import com.dio.exercicios.Cliente;
import com.dio.exercicios.Conta;
import com.dio.exercicios.ContaCorrente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Main {

    static List<Cliente> clientes = new ArrayList<>();
    static List<Conta> contas = new ArrayList<>();
    static boolean clienteVazio = true;
    static boolean clienteVazioDestino = true;
    static boolean sessaoAberta = true;
    static int posicao, posicaoDestino;
    static double valor;


    public static void main(String[] args) {
        criarCliente();
        //listarClientes();
        CriarContasCorrente();
        Scanner scan = new Scanner(System.in);
        int position = -1;
        int positionDestino = -1;

        while (clienteVazio) {
            System.out.println("Digite o seu Id de cliente:");
            int id = scan.nextInt();
            position = pesquisarCLiente(id);
        }

        while (sessaoAberta) {
            System.out.println("\n Qual operação deseja realizar?");
            System.out.println("0 - Exibir Saldo");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Encerrar Sessão");

            int id = scan.nextInt();

            switch (id) {
                case 0:
                    contas.get(position).exibirSaldoAtualizado();
                    break;
                case 1:
                    System.out.println("Qual valor deseja depositar?");
                    valor = scan.nextDouble();
                    contas.get(position).depositar(valor);
                    contas.get(position).exibirSaldoAtualizado();
                    break;
                case 2:
                    System.out.println("Qual valor deseja sacar?");
                    valor = scan.nextDouble();
                    contas.get(position).sacar(valor);
                    contas.get(position).exibirSaldoAtualizado();
                    break;
                case 3:
                    System.out.println("Qual valor deseja transferir?");
                    valor = scan.nextDouble();
                    int idDestino;
                    while (clienteVazioDestino) {
                        System.out.println("Qual o Id do cliente que receberá o valor de " + valor + " ?");
                        idDestino = scan.nextInt();
                        positionDestino = encontrarContaDestino(idDestino);
                    }

                    contas.get(position).transferir(valor, contas.get(positionDestino));
                    contas.get(position).exibirSaldoAtualizado();
                    break;
                case 4:
                    System.out.println("Obrigado por usar os nossos serviços!!\n Sessão encerrada");
                    sessaoAberta = false;
                    break;
                default:
                    System.out.println("Tipo de operação não Válida \n Sessão encerrada");
                    sessaoAberta = false;
            }

        }
        System.out.println("");
        for (Conta ct : contas) {
            System.out.println("Id: " + ct.getCliente().getIdCliente() + "\tSaldo: " + ct.getSaldo());
        }


//        Conta cp = new ContaPoupanca(Eudenes);
//        cp.depositar(85.45);
//        cp.transferir(5, cc);
//        cp.sacar(0.45);
//
//        ((ContaCorrente) cc).imprimirExtrato();
//        ((ContaPoupanca) cp).imprimirExtrato();


    }

    private static int encontrarContaDestino(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdCliente() == id) {
                listarClientes(i);
                clienteVazioDestino = false;
                posicaoDestino = i;
            }
        }
        return posicaoDestino;
    }

    public static int pesquisarCLiente(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdCliente() == id) {
                listarClientes(i);
                clienteVazio = false;
                posicao = i;
            }
        }
        return posicao;
    }

    private static void CriarContasCorrente() {
        Conta conta = new ContaCorrente(clientes.get(0));
        contas.add(conta);
        conta = new ContaCorrente(clientes.get(1));
        contas.add(conta);
        conta = new ContaCorrente(clientes.get(2));
        contas.add(conta);
    }

    private static void listarClientes(int i) {

//        System.out.println("**  Dados:  **");
//
//        System.out.println("Id: " + clientes.get(i).getIdCliente() + "\n" + "Nome:" + clientes.get(i).getNome());
//        System.out.println("CPF: " + clientes.get(i).getCPF() + " " + "\n \n \n ");

        ((ContaCorrente) contas.get(i)).imprimirExtrato();

    }

    private static void listarClientes() {

        System.out.println("**  Lista de Clientes  **");
        for (Cliente cl : clientes) {
            System.out.println("Id: " + cl.getIdCliente() + "\n" + "Nome:" + cl.getNome());
            System.out.println("CPF: " + cl.getCPF() + " " + "\n");
        }
    }

    public static void criarCliente() {
        Cliente cliente = new Cliente("Cliente1 ");
        cliente.setCPF("12345678999");
        clientes.add(cliente);
        cliente = new Cliente("Cliente2");
        clientes.add(cliente);
        cliente = new Cliente("Cliente3");
        clientes.add(cliente);


    }

}
