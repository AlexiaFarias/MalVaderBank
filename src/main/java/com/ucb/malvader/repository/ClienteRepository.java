package com.ucb.malvader.repository;

import com.ucb.malvader.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {}
