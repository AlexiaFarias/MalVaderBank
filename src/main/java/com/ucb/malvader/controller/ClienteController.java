package com.ucb.malvader.controller;

import com.ucb.malvader.model.Cliente;
import com.ucb.malvader.model.Usuario;
import com.ucb.malvader.repository.ClienteRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/clientes/cadastrar")
    public void cadastrarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("usuarioLogado") == null) {
            response.sendRedirect("/Login.html");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (usuario.getTipo_usuario() != Usuario.TipoUsuario.CLIENTE) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Apenas clientes podem acessar esta página");
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setUsuario(usuario);
        cliente.setScore_credito(700);

        clienteRepository.save(cliente);
        response.sendRedirect("/MenuCliente.html");
    }

    @GetMapping("/clientes")
    @ResponseBody
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}


