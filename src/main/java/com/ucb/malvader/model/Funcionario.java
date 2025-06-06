package com.ucb.malvader.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_funcionario;

    @Column(nullable = false)
    private Integer id_usuario;

    @Column(unique = true)
    private String codigo_funcionario;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    private Integer id_supervisor;

    public enum Cargo {
        ESTAGIARIO,
        ATENDENTE,
        GERENTE
    }

    // Getters e Setters

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCodigo_funcionario() {
        return codigo_funcionario;
    }

    public void setCodigo_funcionario(String codigo_funcionario) {
        this.codigo_funcionario = codigo_funcionario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Integer getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(Integer id_supervisor) {
        this.id_supervisor = id_supervisor;
    }
}
