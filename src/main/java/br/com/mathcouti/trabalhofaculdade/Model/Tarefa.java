package br.com.mathcouti.trabalhofaculdade.Model;

import br.com.mathcouti.trabalhofaculdade.DTO.TarefaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEntrega;
    private String responsavel;

    public Tarefa(TarefaDTO tarefa) {
        this.nome = tarefa.nome();
        this.dataEntrega = tarefa.dataEntrega();
        this.responsavel = tarefa.responsavel();
    }
}
