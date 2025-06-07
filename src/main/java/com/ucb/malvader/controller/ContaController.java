package com.ucb.malvader.controller;

import com.ucb.malvader.model.Conta;
import com.ucb.malvader.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @PostMapping("/contas/cadastrar")
    public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Conta conta = new Conta();

        conta.setNumero(request.getParameter("numero"));
        conta.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
        conta.setId_agencia(Integer.parseInt(request.getParameter("id_agencia")));
        conta.setSaldo(new BigDecimal(request.getParameter("saldo")));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        conta.setData_abertura(LocalDate.parse(request.getParameter("data_abertura"), formatter));

        conta.setStatus(Conta.Status.valueOf(request.getParameter("status").toLowerCase()));

        contaRepository.save(conta);

        response.sendRedirect("/MenuFuncionario.html");
    }
}

