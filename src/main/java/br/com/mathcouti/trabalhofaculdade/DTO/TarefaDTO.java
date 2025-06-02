package br.com.mathcouti.trabalhofaculdade.DTO;

import br.com.mathcouti.trabalhofaculdade.Model.Tarefa;

import java.time.LocalDate;

public record TarefaDTO(String nome, LocalDate dataEntrega, String responsavel) {
    public TarefaDTO(Tarefa x) {
        this(x.getNome(), x.getDataEntrega(), x.getResponsavel());
    }
}
