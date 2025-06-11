package com.ucb.malvader.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data_nascimento;

    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo_usuario;

    @Column(length = 32, nullable = false)
    private String senhaHash;

    private String otp_ativo;
    private Date otp_expiracao;

    public enum TipoUsuario {
        CLIENTE, FUNCIONARIO
    }

  

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoUsuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(TipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getOtp_ativo() {
        return otp_ativo;
    }

    public void setOtp_ativo(String otp_ativo) {
        this.otp_ativo = otp_ativo;
    }

    public Date getOtp_expiracao() {
        return otp_expiracao;
    }

    public void setOtp_expiracao(Date otp_expiracao) {
        this.otp_expiracao = otp_expiracao;
    }
}

