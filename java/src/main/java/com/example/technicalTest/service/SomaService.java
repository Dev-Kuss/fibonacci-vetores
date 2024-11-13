package com.example.technicalTest.service;

import org.springframework.stereotype.Service;

@Service
public class SomaService {
    
    private static final int INDICE = 13;

    public int calcularSoma() {
        int soma = 0;
        int k = 0;

        while (k < INDICE) {
            k = k + 1;
            soma = soma + k;
        }

        return soma;
    }

    public String calcularSomaDetalhada() {
        int soma = 0;
        int k = 0;
        StringBuilder processo = new StringBuilder();

        while (k < INDICE) {
            k = k + 1;
            soma = soma + k;
            processo.append(String.format("Iteração %d: K = %d, SOMA = %d%n", k, k, soma));
        }

        return processo.toString();
    }
}
