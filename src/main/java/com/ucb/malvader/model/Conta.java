package com.ucb.malvader.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_conta;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private Integer id_agencia;

    @Column(nullable = false)
    private Integer id_cliente;

    @Column(nullable = false)
    private BigDecimal saldo;

    @Column(nullable = false)
    private LocalDate data_abertura;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum Status {
        ativa, inativa
    }

    // Getters e Setters

    public Integer getId_conta() {
        return id_conta;
    }

    public void setId_conta(Integer id_conta) {
        this.id_conta = id_conta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(Integer id_agencia) {
        this.id_agencia = id_agencia;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public LocalDate getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(LocalDate data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

