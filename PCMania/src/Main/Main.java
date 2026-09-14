package Main;

import Cliente.Cliente;
import Computador.Computador;
import Computador.HardwareBasico;
import Computador.MemoriaUSB;
import Computador.SistemaOperacional;
import ProcessarPedido.ProcessarPedido;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int matricula = 2288;

        //PC1
        HardwareBasico[] hw1 = {
                new HardwareBasico("Processador Core i5", 2200),
                new HardwareBasico("Memória RAM", 8),
                new HardwareBasico("HD", 500)
        };
        SistemaOperacional so1 = new SistemaOperacional("macOS Sequoia", 64);
        Computador promocao1 = new Computador("Apple", matricula, hw1, so1);
        promocao1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        //PC2
        HardwareBasico[] hw2 = {
                new HardwareBasico("Processador Core i7", 3370),
                new HardwareBasico("Memória RAM", 16),
                new HardwareBasico("HD", 1000) // 1Tb
        };
        SistemaOperacional so2 = new SistemaOperacional("Windows 8", 64);
        Computador promocao2 = new Computador("Samsung", matricula + 1, hw2, so2);
        promocao2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        //PC3
        HardwareBasico[] hw3 = {
                new HardwareBasico("Processador Core i7", 4500),
                new HardwareBasico("Memória RAM", 32),
                new HardwareBasico("HD", 2000) // 2Tb
        };
        SistemaOperacional so3 = new SistemaOperacional("Windows 10", 64);
        Computador promocao3 = new Computador("Dell", matricula + 2, hw3, so3);
        promocao3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));

        System.out.println("OPA! BEM VINDO A LOJA!");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);

        int escolha;

        do {
            System.out.println("\nEscolha uma promoção:");
            System.out.println("1 - Apple   | R$" + promocao1.getPreco());
            System.out.println("2 - Samsung | R$" + promocao2.getPreco());
            System.out.println("3 - Dell    | R$" + promocao3.getPreco());
            System.out.println("0 - Finalizar compra");

            escolha = Integer.parseInt(scanner.nextLine());

            if (escolha == 1) {
                cliente.addComputador(promocao1);
                System.out.println("PC Apple adicionado no carrinho!");
            } else if (escolha == 2) {
                cliente.addComputador(promocao2);
                System.out.println("PC Samsung adicionado no carrinho!");
            } else if (escolha == 3) {
                cliente.addComputador(promocao3);
                System.out.println("PC Dell adicionado no carrinho");
            } else if (escolha == 0) {
                if (cliente.getQtdCompras() < 2) {
                    System.out.println("Você precisa comprar pelo menos 2 PCs antes de finalizar!");
                    escolha = -1;
                } else {
                    System.out.println("Finalizando carrinho.");
                }
            } else {
                System.out.println("Código inválido! Tente novamente.");
            }

        } while (escolha != 0);

        System.out.println(" ");
        System.out.println("Resumo da Compra");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println(" ");
        System.out.print("Computadores adquiridos: ");
        cliente.mostraCompras();
        System.out.println("Total da compra: R$" + cliente.calculaTotalCompra());

        ProcessarPedido.enviarPedido(cliente.getComputadoresComprados());

        scanner.close();
    }
}
