package com.example.technicalTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/soma")
@Tag(name = "Soma", description = "API para cálculo de soma sequencial")
public class SomaController {

    @Operation(summary = "Calcula a soma sequencial até o índice 13")
    @GetMapping
    public int calcularSoma() {
        int INDICE = 13;
        int SOMA = 0;
        int K = 0;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        return SOMA;
    }

    @Operation(summary = "Retorna o processo de cálculo detalhado")
    @GetMapping("/detalhado")
    public String calcularSomaDetalhada() {
        int INDICE = 13;
        int SOMA = 0;
        int K = 0;
        StringBuilder processo = new StringBuilder();

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
            processo.append(String.format("Iteração %d: K = %d, SOMA = %d%n", K, K, SOMA));
        }

        return processo.toString();
    }
} 