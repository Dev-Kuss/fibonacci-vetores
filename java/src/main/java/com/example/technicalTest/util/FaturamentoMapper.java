package com.example.technicalTest.util;

import com.example.technicalTest.dto.FaturamentoDTO;
import com.example.technicalTest.model.Faturamento;

public class FaturamentoMapper {
    public static FaturamentoDTO toDTO(Faturamento faturamento) {
        return new FaturamentoDTO(faturamento.getDia(), faturamento.getValor());
    }

    public static Faturamento toEntity(FaturamentoDTO dto) {
        Faturamento faturamento = new Faturamento();
        faturamento.setDia(dto.dia());
        faturamento.setValor(dto.valor());
        return faturamento;
    }
}