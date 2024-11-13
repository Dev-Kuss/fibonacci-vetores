package com.example.technicalTest.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {
    
    public String verificarNumero(long numero) {
        List<Long> sequencia = gerarSequenciaAte(numero);
        boolean pertence = sequencia.contains(numero);

        return String.format("O número %d %s pertence à sequência de Fibonacci.\nSequência gerada: %s", 
            numero, 
            pertence ? "" : "não", 
            sequencia);
    }

    public List<Long> gerarSequencia(long limite) {
        return gerarSequenciaAte(limite);
    }

    private List<Long> gerarSequenciaAte(long limite) {
        List<Long> sequencia = new ArrayList<>();
        sequencia.add(0L);
        sequencia.add(1L);

        while (true) {
            long proximo = sequencia.get(sequencia.size() - 1) + sequencia.get(sequencia.size() - 2);
            if (proximo > limite) break;
            sequencia.add(proximo);
        }

        return sequencia;
    }
}
