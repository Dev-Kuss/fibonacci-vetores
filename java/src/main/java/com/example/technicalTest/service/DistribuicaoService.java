package com.example.technicalTest.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.technicalTest.dto.DistribuicaoDTO;
import com.example.technicalTest.model.Distribuicao;
import com.example.technicalTest.repository.DistribuicaoRepository;
import java.util.List;

@Service
public class DistribuicaoService {
    
    @Autowired
    private DistribuicaoRepository distribuicaoRepository;
    
    public List<DistribuicaoDTO> calcularDistribuicao() {
        List<Distribuicao> distribuicoes = distribuicaoRepository.findAll();
        
        double total = distribuicoes.stream()
                                  .mapToDouble(Distribuicao::getValor)
                                  .sum();
        
        return distribuicoes.stream()
                          .map(d -> new DistribuicaoDTO(
                              d.getEstado(),
                              d.getValor(),
                              Math.round((d.getValor() / total) * 10000.0) / 100.0
                          ))
                          .toList();
    }
} 