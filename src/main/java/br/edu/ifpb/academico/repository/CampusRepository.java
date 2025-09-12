package br.edu.ifpb.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.academico.entity.*;

@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {

    boolean existsByNome(String nome);

    // retorna um campus com seus cursos associados
    @Query("SELECT c FROM Campus c LEFT JOIN FETCH c.cursos WHERE c.id = :id")
    Campus findByIdWithCursos(@Param("id") Long id);
}