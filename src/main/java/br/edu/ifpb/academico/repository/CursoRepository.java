package br.edu.ifpb.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.academico.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	/**
	 * Verifica se já existe um curso cadastrado com o código informado.
	 *
	 * @param codigo O código do curso a ser verificado.
	 * @return true se já existir um curso com o código, false caso contrário.
	 */
	boolean existsByCodigo(String codigo);

	// achar o curso pelo nome
	Curso findByNome(String nome);

	// verificar se existe curso em um campus
	boolean existsByCampusId(Long campusId);

}
