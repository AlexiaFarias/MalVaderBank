package com.ucb.malvader.controller;

import com.ucb.malvader.model.Usuario;
import com.ucb.malvader.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senhaHash");

        Optional<Usuario> usuario = usuarioRepository.findByCpfAndSenhaHash(cpf, senha);

        if (usuario.isPresent()) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuario.get());

            
            Usuario.TipoUsuario tipo = usuario.get().getTipo_usuario();

            if (tipo == Usuario.TipoUsuario.FUNCIONARIO) {
                response.sendRedirect("/MenuFuncionario.html");
            } else if (tipo == Usuario.TipoUsuario.CLIENTE) {
                response.sendRedirect("/MenuCliente.html");
            } else {
                
                response.sendRedirect("/Login.html?erro=tipoDesconhecido");
            }
        } else {
            
            response.sendRedirect("/Login.html?erro=credenciais");
        }
    }
}


