package com.ucb.malvader.controller;

import com.ucb.malvader.model.Relatorio;
import com.ucb.malvader.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class RelatorioController {

    @Autowired
    private RelatorioRepository relatorioRepository;

    @PostMapping("/relatorios/gerar")
    public void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Relatorio r = new Relatorio();
        r.setTipo_relatorio(Relatorio.TipoRelatorio.valueOf(request.getParameter("tipo_relatorio")));
        r.setData_inicio(LocalDate.parse(request.getParameter("data_inicio")));
        r.setData_fim(LocalDate.parse(request.getParameter("data_fim")));
        r.setStatus(Relatorio.StatusRelatorio.EM_PROCESSAMENTO);
        r.setData_geracao(LocalDateTime.now());
        r.setCaminho_arquivo("/relatorios/exemplo.txt");

        relatorioRepository.save(r);
        response.sendRedirect("/MenuFuncionario.html");
    }
}

