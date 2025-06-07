package com.ucb.malvader.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Relatorio")
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_relatorio;

    @Enumerated(EnumType.STRING)
    private TipoRelatorio tipo_relatorio;

    private LocalDate data_inicio;
    private LocalDate data_fim;

    @Enumerated(EnumType.STRING)
    private StatusRelatorio status;

    private String caminho_arquivo;

    private LocalDateTime data_geracao;

    public enum TipoRelatorio {
        EXTRATO,
        ANÁLISE_FINANCEIRA,
        TRANSACOES
    }

    public enum StatusRelatorio {
        EM_PROCESSAMENTO,
        COMPLETO,
        FALHA
    }

    // Getters e Setters

    public Integer getId_relatorio() {
        return id_relatorio;
    }

    public void setId_relatorio(Integer id_relatorio) {
        this.id_relatorio = id_relatorio;
    }

    public TipoRelatorio getTipo_relatorio() {
        return tipo_relatorio;
    }

    public void setTipo_relatorio(TipoRelatorio tipo_relatorio) {
        this.tipo_relatorio = tipo_relatorio;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

    public StatusRelatorio getStatus() {
        return status;
    }

    public void setStatus(StatusRelatorio status) {
        this.status = status;
    }

    public String getCaminho_arquivo() {
        return caminho_arquivo;
    }

    public void setCaminho_arquivo(String caminho_arquivo) {
        this.caminho_arquivo = caminho_arquivo;
    }

    public LocalDateTime getData_geracao() {
        return data_geracao;
    }

    public void setData_geracao(LocalDateTime data_geracao) {
        this.data_geracao = data_geracao;
    }
}
