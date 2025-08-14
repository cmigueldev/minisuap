package br.edu.ifpb.academico.repository;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;


import br.edu.ifpb.academico.entity.Campus;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CampusRepositoryTest {

	@Autowired
	private CampusRepository repository;

	@Test
	@Commit
	@Order(1)
	void testSaveCampusPhoto() throws IOException {
		Campus campus = new Campus();
		campus.setCidade("Monteiro");
		campus.setNome("ifpb campus Monteiro");
		campus.setEstado("Paraiba");
		campus.setDataCriacao(new Date());

		repository.save(campus);


	}
	
	@Test
	@Commit
	@Order(2)
	void testReadCampusPhoto() throws IOException {
		List<Campus> campi  = repository.findAll();
		Campus campus = campi.get(0);
		Assertions.assertTrue(campus.getNome().equals("ifpb campus Monteiro"));
	}
}

