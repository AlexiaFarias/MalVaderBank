package com.ucb.malvader.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transacao;

    @Column(nullable = false)
    private Integer conta_origem_id;

    private Integer conta_destino_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTransacao tipo_transacao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime data_hora;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTransacao status;

    public enum TipoTransacao {
        DEPOSITO, SAQUE, TRANSFERENCIA, PAGAMENTO
    }

    public enum StatusTransacao {
        COMPLETADA, FALHOU, PENDENTE
    }

    // Getters e Setters

    public Integer getId_transacao() {
        return id_transacao;
    }

    public void setId_transacao(Integer id_transacao) {
        this.id_transacao = id_transacao;
    }

    public Integer getConta_origem_id() {
        return conta_origem_id;
    }

    public void setConta_origem_id(Integer conta_origem_id) {
        this.conta_origem_id = conta_origem_id;
    }

    public Integer getConta_destino_id() {
        return conta_destino_id;
    }

    public void setConta_destino_id(Integer conta_destino_id) {
        this.conta_destino_id = conta_destino_id;
    }

    public TipoTransacao getTipo_transacao() {
        return tipo_transacao;
    }

    public void setTipo_transacao(TipoTransacao tipo_transacao) {
        this.tipo_transacao = tipo_transacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }
}
