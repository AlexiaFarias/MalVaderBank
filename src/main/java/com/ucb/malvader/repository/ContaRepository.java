package com.ucb.malvader.repository;

import com.ucb.malvader.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {}
