package com.ucb.malvader.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    @Column(nullable = false)
    private Integer id_usuario;

    private Integer score_credito;

    // Getters e Setters

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getScore_credito() {
        return score_credito;
    }

    public void setScore_credito(Integer score_credito) {
        this.score_credito = score_credito;
    }
}
