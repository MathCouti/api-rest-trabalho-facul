package br.com.mathcouti.trabalhofaculdade.Service.Impl;

import br.com.mathcouti.trabalhofaculdade.DTO.TarefaDTO;
import br.com.mathcouti.trabalhofaculdade.DTO.TarefaResponseDTO;
import br.com.mathcouti.trabalhofaculdade.Exception.ResourceNotFoundException;
import br.com.mathcouti.trabalhofaculdade.Model.Tarefa;
import br.com.mathcouti.trabalhofaculdade.Repository.TarefaRepository;
import br.com.mathcouti.trabalhofaculdade.Service.TarefaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository repository;

    public TarefaServiceImpl(TarefaRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public TarefaResponseDTO create(TarefaDTO tarefa) {
        Tarefa t = new Tarefa(tarefa);
        Tarefa tReturn =  repository.save(t);
        return new TarefaResponseDTO(tReturn);
    }

    @Override
    public List<TarefaDTO> findAll() {
        List<TarefaDTO> tarefaDTOS = repository.findAll()
                .stream().map(TarefaDTO::new).toList();
        return tarefaDTOS;
    }

    @Override
    public TarefaDTO findById(Long id) {
        Tarefa tarefa=  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objeto não encontrado!"));

        return new TarefaDTO(tarefa);

    }

    @Override
    @Transactional
    public TarefaResponseDTO update(Long id, TarefaDTO tarefa) {
        Tarefa t = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objeto não encontrado!"));
        t.setNome(tarefa.nome());
        t.setDataEntrega(tarefa.dataEntrega());
        t.setResponsavel(tarefa.responsavel());
        return new TarefaResponseDTO(repository.save(t));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("A tarefa com id" + id + "Não existe" );
        }
        repository.deleteById(id);
    }
}
