package br.edu.ifpb.academico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.academico.entity.Curso;
import br.edu.ifpb.academico.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	protected CursoRepository cursoRepository;

	public Curso save(Curso a) {
		return cursoRepository.save(a);
	}

	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	public Curso findById(Long id) {
		return cursoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Curso não encontrado"));
	}

	public void deleteById(Long id) {
		if (!cursoRepository.existsById(id)) {
			throw new RuntimeException("Curso não encontrado");
		}
		cursoRepository.deleteById(id);
	}

	public boolean existsByCodigo(String codigo) {
		return cursoRepository.existsByCodigo(codigo);

	}
}

