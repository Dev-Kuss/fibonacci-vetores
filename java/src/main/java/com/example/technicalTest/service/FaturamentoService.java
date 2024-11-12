package com.example.technicalTest.service;

import com.example.technicalTest.model.Faturamento;
import com.example.technicalTest.repository.FaturamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturamentoService {
    
    @Autowired
    private FaturamentoRepository faturamentoRepository;

    public double menorValor() {
        return faturamentoRepository.findMenorValor() != null 
            ? faturamentoRepository.findMenorValor() 
            : 0.0;
    }

    public double maiorValor() {
        return faturamentoRepository.findMaiorValor() != null 
            ? faturamentoRepository.findMaiorValor() 
            : 0.0;
    }

    public long diasAcimaMedia() {
        List<Faturamento> faturamentos = faturamentoRepository.findAllWithValue();
        if (faturamentos.isEmpty()) return 0;

        double media = faturamentos.stream()
            .mapToDouble(Faturamento::getValor)
            .average()
            .orElse(0.0);

        return faturamentos.stream()
            .filter(f -> f.getValor() > media)
            .count();
    }

    public Faturamento salvarFaturamento(Faturamento faturamento) {
        return faturamentoRepository.save(faturamento);
    }

    public Optional<Faturamento> obterFaturamento(Long id) {
        return faturamentoRepository.findById(id);
    }
}
