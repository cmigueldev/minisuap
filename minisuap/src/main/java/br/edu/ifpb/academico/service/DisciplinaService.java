package br.edu.ifpb.academico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.academico.entity.Disciplina;
import br.edu.ifpb.academico.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	protected DisciplinaRepository disciplinaRepository;

	public Disciplina save(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	public List<Disciplina> findAll() {
		return disciplinaRepository.findAll();
	}	

	public Disciplina findById(Long id) {
		return disciplinaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
	}

	public void deleteById(Long id) {
		if (!disciplinaRepository.existsById(id)) {
			throw new RuntimeException("Disciplina não encontrada");
		}
		disciplinaRepository.deleteById(id);
	}
	
	public boolean existsByCodigo(String codigo) {
		return disciplinaRepository.existsByCodigo(codigo);
	}
	
}


