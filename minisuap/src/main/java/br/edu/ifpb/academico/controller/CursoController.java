package br.edu.ifpb.academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.academico.entity.Curso;
import br.edu.ifpb.academico.service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	protected CursoService cursoService;
	
// formulario de cadastro de curso
	@GetMapping("/form")
	public String home(Model model) {
		model.addAttribute("curso", new Curso());
		return "cadastrarCurso";
	}
	
//Salvar um novo curso no sistema.
	@PostMapping("save")
	public String saveCurso(@ModelAttribute Curso curso, Model model) {	
		// Verifica se o curso já existe pelo código
		if (cursoService.existsByCodigo(curso.getCodigo())) {
			model.addAttribute("mensagemErro", "Curso com código " + curso.getCodigo() + " já cadastrado.");
			return "cadastrarCurso";
		} else {			
			cursoService.save(curso);
		}
		model.addAttribute("mensagemSucesso", "Curso com código " + curso.getCodigo() + " cadastrado com sucesso!");
		return "cadastrarCurso";
	}
	
//levar para pagina de edição do curso indicado pelo id
	@GetMapping("/edit/{id}")
	public String editCurso(@PathVariable Long id, Model model) {
		Curso curso = cursoService.findById(id);
		model.addAttribute("curso", curso);
		return "editarCurso";
	}
	
//Listar todos os cursos cadastrados
	@GetMapping("/list")
	public String listCursos(Model model) {
		model.addAttribute("cursos", cursoService.findAll());
		return "listarCurso";
	}
	
//editar um curso existente no sistema.
	@PostMapping("/edit")
	public String editCursoPost(@ModelAttribute Curso curso, Model model) {
		// Verifica se o codigo alterado já existe em outro curso, exeto ele mesmo
		if ((!cursoService.findById(curso.getId()).getCodigo().equals(curso.getCodigo())) && cursoService.existsByCodigo(curso.getCodigo())) {
			model.addAttribute("mensagemErro", "Curso com código " + curso.getCodigo() + " já cadastrado.");
			return listCursos(model);
		} else {			
			cursoService.save(curso);
		}
		model.addAttribute("mensagemSucesso", "Curso com código " + curso.getCodigo() + " editado com sucesso!");
		return listCursos(model);
	}
	
//Deletar um curso existente no sistema.
	@GetMapping("/delete/{id}")
	public String deleteAluno(@PathVariable Long id, Model model) {
		cursoService.deleteById(id);
		model.addAttribute("mensagemSucesso",  "deletado com sucesso!");
		return listCursos(model);
	}

}
