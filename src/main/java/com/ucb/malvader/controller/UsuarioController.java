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
import java.text.SimpleDateFormat;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/usuarios/cadastrar")
    public void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 🔐 Verificação de login
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioLogado") == null) {
            response.sendRedirect("/Login.html");
            return;
        }

        Usuario usuario = new Usuario();

        usuario.setNome(request.getParameter("nome"));
        usuario.setCpf(request.getParameter("cpf"));

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            usuario.setData_nascimento(formatter.parse(request.getParameter("data_nascimento")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        usuario.setTelefone(request.getParameter("telefone"));
        usuario.setTipo_usuario(Usuario.TipoUsuario.valueOf(request.getParameter("tipo_usuario")));
        usuario.setSenhaHash(request.getParameter("senhaHash"));

        usuarioRepository.save(usuario);

        response.sendRedirect("/cadastroUsuario.html");
    }
}



