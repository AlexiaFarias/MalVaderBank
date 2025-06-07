package com.ucb.malvader.controller;

import com.ucb.malvader.model.Cliente;
import com.ucb.malvader.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    @ResponseBody
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
