package br.edu.ifpb.academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifpb.academico.entity.Campus;
import br.edu.ifpb.academico.service.CampusService;
@Controller
@RequestMapping("/campus")
public class CampusController {

	@Autowired
	protected CampusService campusService;
	
	@PostMapping("save")
	@ResponseBody
	public String saveCampus(@ModelAttribute Campus campus) {
		campusService.save(campus);		
		return "Salvo com sucesso!";
	}
	
	@GetMapping("/delete/{id}")
	@ResponseBody
	public String deleteCampus(@PathVariable Long id) {
		campusService.deleteById(id);
		return "Campus removido com sucesso";
	} 
	
}
// http://localhost:8080/campus/save