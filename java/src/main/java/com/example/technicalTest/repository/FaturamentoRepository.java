package com.example.technicalTest.repository;

import com.example.technicalTest.model.Faturamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaturamentoRepository extends JpaRepository<Faturamento, Long> {
    
    @Query("SELECT MIN(f.valor) FROM Faturamento f WHERE f.valor > 0")
    Double findMenorValor();

    @Query("SELECT MAX(f.valor) FROM Faturamento f")
    Double findMaiorValor();

    @Query("SELECT f FROM Faturamento f WHERE f.valor > 0")
    List<Faturamento> findAllWithValue();
}
