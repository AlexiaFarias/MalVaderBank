package com.ucb.malvader.repository;

import com.ucb.malvader.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {}
