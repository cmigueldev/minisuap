package br.edu.ifpb.academico.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.academico.entity.*;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByMatricula(String matricula);
}

