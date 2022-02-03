package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.excessoes.DomainException;

public class Conta {
    
    Date dt = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteSaque;
    private Date data;
    
    public Conta(){
    }

    public Conta( Date data, Integer numero, String titular, Double saldo, Double limiteSaque) {
        if(data.getTime() > dt.getTime()){
            throw new DomainException("A data é maior que o dia atual!!");
        }
        this. data = data;
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }


    public Double getLimiteSaque() {
        return limiteSaque;
    }

    
    public void deposito(double deposito){
        saldo += deposito;
    }
    
    public void saque(double saque){
        if(saque > saldo && saldo != 0){
            throw new DomainException("você só pode sacar um valor menor do que o saldo da conta!!");
        }
        if(saldo <= 0){
            throw new DomainException("não é possível fazer saques em uma conta sem saldo!!");
        }
        if(saque > limiteSaque){
            throw new DomainException("você só pode sacar um valor menor do que o limite de saque!!");
        }
        
        saldo -= saque;
    }
    
    @Override
    public String toString(){
        return "========================================"
               +"\nData da operação: "+sdf.format(data)
               +"\nNúmero conta: "+numero
               +"\nTitular: "+titular
               +"\nSaldo atualizado: R$ "+String.format("%.2f", saldo)
               +"\n========================================";
    }
    
}
