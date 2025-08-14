package br.edu.ifpb.academico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.academico.entity.Campus;
import br.edu.ifpb.academico.repository.CampusRepository;

@Service
public class CampusService {

	@Autowired
	protected CampusRepository CampusRepository;

	public Campus save(Campus a) {
		return CampusRepository.save(a);
	}

	public List<Campus> findAll() {
		return CampusRepository.findAll();
	}

	public Campus findById(Long id) {
		return CampusRepository.findById(id).orElseThrow(() -> new RuntimeException("Campus não encontrado"));
	}

	public void deleteById(Long id) {
		if (!CampusRepository.existsById(id)) {
			throw new RuntimeException("Campus não encontrado");
		}
		CampusRepository.deleteById(id);
	}

}
