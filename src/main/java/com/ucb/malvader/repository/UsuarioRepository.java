package com.ucb.malvader.repository;

import com.ucb.malvader.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCpfAndSenhaHash(String cpf, String senhaHash);
}
