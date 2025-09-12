package br.edu.ifpb.academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.academico.entity.Campus;
import br.edu.ifpb.academico.service.CampusService;
@Controller
@RequestMapping("/campus")
public class CampusController {

	@Autowired
	protected CampusService campusService;

	@GetMapping("/form")
	public String home(Model model) {
		model.addAttribute("campus", new Campus());
		return "cadastrarCampus";
	}

	//salvar campus
	@PostMapping("save")
	public String saveCampus(@ModelAttribute Campus campus, Model model) {	
		// Verifica se o campus já existe pelo nome
		if (campusService.existsByNome(campus.getNome())) {
			model.addAttribute("mensagemErro", "Campus com nome " + campus.getNome() + " já cadastrado.");
			return "cadastrarCampus";
		} else {			
			campusService.save(campus);
		}
		model.addAttribute("mensagemSucesso", "Campus com nome " + campus.getNome() + " cadastrado com sucesso!");
		return "cadastrarCampus";
	}

	//Listar todos os campus cadastrados
	@GetMapping("/list")
	public String listCampus(Model model) {
		model.addAttribute("campus", campusService.findAll());
		return "listarCampus";
	}

	//levar para pagina de edição do curso indicado pelo id
	@GetMapping("/edit/{id}")
	public String editCampus(@PathVariable Long id, Model model) {
		Campus campus = campusService.findById(id);
		model.addAttribute("campus", campus);
		return "editarCampus";
	}
	
	//editar um curso existente no sistema.
	@PostMapping("/edit")
	public String editCampus(@ModelAttribute Campus campus, Model model) {
		// Verifica se o nome alterado já existe em outro campus, exceto ele mesmo
		if ((!campusService.findById(campus.getId()).getNome().equals(campus.getNome())) && campusService.existsByNome(campus.getNome())) {
			model.addAttribute("mensagemErro", "Campus com nome " + campus.getNome() + " já cadastrado.");
			return listCampus(model);
		} else {			
			campusService.save(campus);
		}
		model.addAttribute("mensagemSucesso", "Campus com nome " + campus.getNome() + " editado com sucesso!");
		return listCampus(model);
	}

	//deletar campus
	@GetMapping("/delete/{id}")
	public String deleteCampus(@PathVariable Long id, Model model) {
		campusService.deleteById(id);
		model.addAttribute("mensagemSucesso", "Campus removido com sucesso");
		return listCampus(model);
	}

}
// http://localhost:8080/campus/save