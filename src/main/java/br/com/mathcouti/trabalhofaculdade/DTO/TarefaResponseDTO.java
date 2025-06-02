package br.com.mathcouti.trabalhofaculdade.DTO;

import br.com.mathcouti.trabalhofaculdade.Model.Tarefa;

import java.time.LocalDate;

public record TarefaResponseDTO(Long id, String nome, LocalDate dataEntrega, String responsavel) {

    public TarefaResponseDTO(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDataEntrega(), tarefa.getResponsavel());
    }
}
