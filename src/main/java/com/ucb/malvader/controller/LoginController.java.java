package com.ucb.malvader.controller;

import com.ucb.malvader.model.Usuario;
import com.ucb.malvader.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");

        String senhaHash = md5(senha);

        var usuario = usuarioRepository.findByCpfAndSenhaHash(cpf, senhaHash);

        if (usuario.isPresent()) {
            // Login bem-sucedido
            response.sendRedirect("/MenuCliente.html");
        } else {
            // Login falhou
            response.sendRedirect("/Login.html?erro=true");
        }
    }

    private String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
