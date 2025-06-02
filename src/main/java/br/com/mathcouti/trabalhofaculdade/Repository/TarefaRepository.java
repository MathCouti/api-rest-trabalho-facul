package br.com.mathcouti.trabalhofaculdade.Repository;

import br.com.mathcouti.trabalhofaculdade.Model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
