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
public class FuncionarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final String CODIGO_EMPRESA_VALIDO = "UCB123"; // chave secreta da empresa

    @PostMapping("/funcionarios/cadastrar")
    public void cadastrarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 🔐 Verificação de login
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioLogado") == null) {
            response.sendRedirect("/Login.html");
            return;
        }

        // 🔒 Verificação do código da empresa
        String codigoRecebido = request.getParameter("codigo_empresa");
        if (!CODIGO_EMPRESA_VALIDO.equals(codigoRecebido)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Código de autorização inválido");
            return;
        }

        // ✅ Cadastro do funcionário
        Usuario funcionario = new Usuario();
        funcionario.setNome(request.getParameter("nome"));
        funcionario.setCpf(request.getParameter("cpf"));

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            funcionario.setData_nascimento(formatter.parse(request.getParameter("data_nascimento")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        funcionario.setTelefone(request.getParameter("telefone"));
        funcionario.setTipo_usuario(Usuario.TipoUsuario.FUNCIONARIO);
        funcionario.setSenhaHash(request.getParameter("senhaHash"));

        usuarioRepository.save(funcionario);
        response.sendRedirect("/MenuFuncionario.html");
    }
}

