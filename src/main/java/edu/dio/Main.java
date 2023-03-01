package edu.dio;

import edu.dio.model.Cliente;
import edu.dio.model.Conta;
import edu.dio.service.ContaCorrente;
import edu.dio.service.ContaPoupanca;
import edu.dio.service.ContaPremium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente1 = new Cliente(1,"Bill","rua 10, casa 10, Aquiraz-CE");
        Cliente cliente2 = new Cliente(2,"João","rua 12, casa 8, Aquiraz-CE");
        Cliente cliente3 = new Cliente(3,"Maria","rua 20, casa 11, Aquiraz-CE");
        Cliente cliente4 = new Cliente(4,"Ana","rua 1, casa 15, Aquiraz-CE");
        List<Conta> contas= new ArrayList<>();
        contas.add(new ContaCorrente(300.00,cliente1));
        contas.add(new ContaPremium(500.00,cliente2));
        contas.add(new ContaPoupanca(100.00,cliente2));
        contas.add(new ContaPremium(500.00,cliente3));
        contas.add(new ContaCorrente(400.00,cliente4));
        contas.add(new ContaPoupanca(100.00,cliente4));
        System.out.println("Banco Brasileiro Agencia 1");
        System.out.println("----------------------------------------------------");
        contas.stream().forEach(System.out::println);
        int verificador;
        do {
            System.out.println("----------------------------------------------------");
            System.out.println("Digite o Numero da Conta que deseja acessar: ou Digite 0 para Sair");
            verificador = sc.nextInt();
            Integer finalVerificador = verificador;
            if (verificador!=0){
                contas.stream().filter(c->c.getNumeroConta()== finalVerificador).forEach(System.out::println);
                System.out.println("Digite a opção desejada: 1-depositar, 2-sacar, 3-transferir");
                int opcao=sc.nextInt();
                switch (opcao) {
                    case 1: {
                        System.out.println("digite o valor do deposito:");
                        Double valor = sc.nextDouble();
                        contas.stream().filter(c -> c.getNumeroConta() == finalVerificador).forEach(c -> c.depositar(valor));
                        break;
                    }
                    case 2: {
                        System.out.println("digite o valor do saque:");
                        Double valor = sc.nextDouble();
                        contas.stream().filter(c -> c.getNumeroConta() == finalVerificador).forEach(c -> c.sacar(valor));
                        break;
                    }
                    case 3: {
                        System.out.println("digite o valor da Transfferencia:");
                        Double valor = sc.nextDouble();
                        System.out.println("digite o numero da conta para transferencia");
                        Integer numero = sc.nextInt();
                        contas.stream().filter(c -> c.getNumeroConta() == finalVerificador).forEach(c -> c.sacar(valor));
                        contas.stream().filter(c -> c.getNumeroConta() == numero).forEach(c -> c.depositar(valor));
                        break;
                    }
                }
            }
        }while (verificador!=0);
        sc.close();
    }
}