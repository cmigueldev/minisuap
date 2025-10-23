package br.edu.ifpb.academico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import br.edu.ifpb.academico.entity.Campus;
import br.edu.ifpb.academico.entity.Curso;
import br.edu.ifpb.academico.entity.Disciplina;
//import br.edu.ifpb.academico.service.CampusService;
import br.edu.ifpb.academico.service.CursoService;
import br.edu.ifpb.academico.service.DisciplinaService;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    protected DisciplinaService disciplinaService;
    @Autowired
    protected CursoService cursoService;
    //@Autowired
    //protected CampusService campusService;

    // método para exibir o formulário de cadastro
    @GetMapping("/form")
    public String home(Model model) {
        cursos(model);
        //campi(model);
        model.addAttribute("disciplina", new Disciplina());
        return "cadastrarDisciplina";
    }

    private void cursos(Model model) {
		List<Curso> cursos = cursoService.findAll();
		model.addAttribute("cursos", cursos);
	}

    /* 
    private void campi(Model model) {
        List<Campus> campi = campusService.findAll();
        model.addAttribute("campi", campi);
    }
    */

    // método para salvar a disciplina
    @PostMapping("save")
    public String saveDisciplina(@ModelAttribute Disciplina disciplina, Model model) {
       if (disciplinaService.existsByCodigo(disciplina.getCodigo())) {
        model.addAttribute("mensagemErro", "Disciplina com o codigo " + disciplina.getCodigo() + " já existe.");
            return "cadastrarDisciplina";
        } else {
            disciplinaService.save(disciplina);
        }
        model.addAttribute("mensagemSucesso", "Disciplina com código " + disciplina.getCodigo() + " cadastrada com sucesso!");
        return "cadastrarDisciplina";
    }

    // método para levar para a pagina de editar a disciplina
    @GetMapping("/edit/{id}")
    public String editDisciplina(@PathVariable Long id, Model model) {
        cursos(model);
        //campi(model);
        Disciplina disciplina = disciplinaService.findById(id);
        model.addAttribute("disciplina", disciplina);
        return "editarDisciplina";
    }

    //metodo para listar as disciplinas
    @GetMapping("list")
    public String listarDisciplina(Model model) {
        model.addAttribute("disciplinas", disciplinaService.findAll());
        return "listarDisciplina";
    }

    // método para editar uma disciplina existente no sistema
    @PostMapping("/edit")
    public String editDisciplinaPost(@ModelAttribute Disciplina disciplina, Model model) {
        if ((!disciplinaService.findById(disciplina.getId()).getCodigo().equals(disciplina.getCodigo())) && disciplinaService.existsByCodigo(disciplina.getCodigo())) {
            model.addAttribute("mensagemErro", "Disciplina com o código " + disciplina.getCodigo() + " já cadastrada.");
            return listarDisciplina(model);
        } else {
            disciplinaService.save(disciplina);
        }
        model.addAttribute("mensagemSucesso", "Disciplina com o código " + disciplina.getCodigo() + " editada com sucesso!");
        return listarDisciplina(model);
    }

    // método para deletar uma disciplina existente no sistema
    @GetMapping("/delete/{id}")
    public String deleteDisciplina(@PathVariable Long id, Model model) {
        disciplinaService.deleteById(id);
        model.addAttribute("mensagemSucesso", "Disciplina deletada com sucesso!");
        return listarDisciplina(model);
    }
    
    
}
   