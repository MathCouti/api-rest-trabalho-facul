package br.com.mathcouti.trabalhofaculdade.Controller;

import br.com.mathcouti.trabalhofaculdade.DTO.TarefaDTO;
import br.com.mathcouti.trabalhofaculdade.DTO.TarefaResponseDTO;
import br.com.mathcouti.trabalhofaculdade.Service.Impl.TarefaServiceImpl;
import br.com.mathcouti.trabalhofaculdade.Service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefaController {


    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> create(@RequestBody TarefaDTO dto){
        TarefaResponseDTO dtoResponse = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TarefaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TarefaResponseDTO> update(@PathVariable Long id, @RequestBody TarefaDTO tarefa){
        return ResponseEntity.ok(service.update(id, tarefa));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
