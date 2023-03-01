package edu.dio.service;

import edu.dio.model.Cliente;
import edu.dio.model.Conta;

public class ContaPoupanca extends Conta {
    private final Integer taxaRendimento = 1;
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }
    public ContaPoupanca(Double saldo, Cliente cliente) {
        super(saldo, cliente);
    }
    public void atualizacaoMensal(){
        super.saldoConta+=saldoConta*taxaRendimento/100.00;
    }
    @Override
    public String toString() {
        return "ContaPoupança {" +
                " numeroConta = " + numeroConta +
                ", agenciaConta = " + agenciaConta +
                ", saldoConta = $" + String.format("%.2f",saldoConta) +
                ", cliente = " + cliente.getNome() +
                ", endereço = "+ cliente.getEndereco()+
                '}';
    }
}
