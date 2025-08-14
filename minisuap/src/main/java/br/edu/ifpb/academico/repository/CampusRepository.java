package br.edu.ifpb.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.academico.entity.*;

@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {

}