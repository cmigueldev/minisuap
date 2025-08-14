package br.edu.ifpb.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.academico.entity.*;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	

	/**
	 * Verifica se já existe um aluno cadastrado com a matrícula informada.
	 * 
	 * @param matricula A matrícula do aluno a ser verificada.
	 * @return true se já existir um aluno com a matrícula, false caso contrário.
	 */
	boolean existsByMatricula(String matricula);
}
