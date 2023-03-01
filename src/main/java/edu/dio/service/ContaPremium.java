package edu.dio.service;

import edu.dio.model.Cliente;
import edu.dio.model.Conta;

public class ContaPremium extends Conta {
    private final Double taxaMensal = 25.00;
    private Double chequeEspecial;
    private final Double limitecheque = 500.00;

    public ContaPremium(Cliente cliente) {
        super(cliente);
        this.chequeEspecial=limitecheque;
    }
    public ContaPremium(Double saldo, Cliente cliente) {
        super(saldo, cliente);
        this.chequeEspecial=limitecheque;
    }
    public void atualizacaoMensal(){
        if (super.saldoConta>taxaMensal)super.saldoConta-=taxaMensal;
        else {
            chequeEspecial-= taxaMensal-super.saldoConta;
            super.saldoConta=0.0;
        }
    }
    @Override
    public void sacar(Double valor){
        if (super.saldoConta>=valor) super.saldoConta-=valor;
        else {
            chequeEspecial-=valor-super.saldoConta;
            super.saldoConta=0.0;
        }
    }
    @Override
    public void depositar(Double valor){
        if (super.saldoConta>0.0)super.saldoConta+=valor;
        else if (limitecheque>=(valor+this.chequeEspecial))this.chequeEspecial+=valor;
        else {
            super.saldoConta= valor+this.chequeEspecial-limitecheque;
            this.chequeEspecial=limitecheque;
        }
    }
    public Double getChequeEspecial() {
        return chequeEspecial;
    }
    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    @Override
    public String toString() {
        return "ContaPremium  {" +
                " numeroConta = " + numeroConta +
                ", agenciaConta = " + agenciaConta +
                ", saldoConta = $" + String.format("%.2f",saldoConta) +
                ", chequeEspecial = " + chequeEspecial +
                ", cliente = " + cliente.getNome() +
                ",endereço = "+ cliente.getEndereco()+
                '}';
    }
}
