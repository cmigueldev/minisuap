package br.edu.ifpb.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.academico.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

	/**
	 * Verifica se já existe uma disciplina cadastrada com o código informado.
	 *
	 * @param codigo O código da disciplina a ser verificado.
	 * @return true se já existir uma disciplina com o código, false caso contrário.
	 */
	boolean existsByCodigo(String codigo);

}
