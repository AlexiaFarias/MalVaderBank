package com.ucb.malvader.controller;

import com.ucb.malvader.model.Transacao;
import com.ucb.malvader.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping("/transacoes/registrar")
    public void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Transacao t = new Transacao();

        t.setConta_origem_id(Integer.parseInt(request.getParameter("conta_origem_id")));
        String destino = request.getParameter("conta_destino_id");
        if (destino != null && !destino.isEmpty()) {
            t.setConta_destino_id(Integer.parseInt(destino));
        }

        t.setTipo_transacao(Transacao.TipoTransacao.valueOf(request.getParameter("tipo_transacao")));
        t.setValor(new BigDecimal(request.getParameter("valor")));
        t.setData_hora(LocalDateTime.now());
        t.setDescricao(request.getParameter("descricao"));
        t.setStatus(Transacao.StatusTransacao.COMPLETADA); // Simples para início

        transacaoRepository.save(t);
        response.sendRedirect("/MenuFuncionario.html");
    }
}

