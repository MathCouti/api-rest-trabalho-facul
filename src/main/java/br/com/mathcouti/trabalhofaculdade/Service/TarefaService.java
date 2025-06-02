package br.com.mathcouti.trabalhofaculdade.Service;

import br.com.mathcouti.trabalhofaculdade.DTO.TarefaDTO;
import br.com.mathcouti.trabalhofaculdade.DTO.TarefaResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TarefaService {
    TarefaResponseDTO create(TarefaDTO tarefa);
    List<TarefaDTO> findAll();
    TarefaDTO findById(Long id);
    TarefaResponseDTO update(Long id, TarefaDTO tarefa);
    void delete(Long id);

}
