package com.example.technicalTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.technicalTest.model.Distribuicao;

public interface DistribuicaoRepository extends JpaRepository<Distribuicao, Long> {
}
