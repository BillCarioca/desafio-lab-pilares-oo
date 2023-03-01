package edu.dio.model;

import lombok.Data;

@Data
public abstract class Conta {
    protected Integer numeroConta;
    protected Integer agenciaConta;
    protected Double saldoConta;
    protected Cliente cliente;
    protected static int cont = 0;
    protected int agencia = 1;
    public Conta (Cliente cliente){
        cont++;
        this.numeroConta=cont;
        this.agenciaConta=agencia;
        this.saldoConta=0.0;
        this.cliente=cliente;
    }
    public Conta(Double saldo,Cliente cliente){
        cont++;
        this.numeroConta=cont;
        this.agenciaConta=agencia;
        this.saldoConta=saldo;
        this.cliente=cliente;
    }
    public void sacar(Double valor){ saldoConta-=valor;  }
    public void depositar(Double valor){saldoConta+=valor;}


}
