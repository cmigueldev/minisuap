package br.edu.ifpb.academico.repository;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.junit.jupiter.api.Assertions;

import br.edu.ifpb.academico.entity.Aluno;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class AlunoRepositoryTest {
	@Autowired
	private AlunoRepository repository;

	@Test
	@Commit
	@Order(1)
	void testSaveStudentPhoto() throws IOException {
		Aluno aluno = new Aluno();
		aluno.setCRE(8.0);
		aluno.setNome("Zé da Silva");
		aluno.setDataNascimento(new Date());

		repository.save(aluno);

	}

	@Test
	@Commit
	@Order(2)
	void testReadStudentPhoto() throws IOException {
		List<Aluno> alunos = repository.findAll();
		
		Aluno aluno = alunos.get(0);
		Assertions.assertTrue(aluno.getNome().equals("Zé da Silva"));
	}

}
