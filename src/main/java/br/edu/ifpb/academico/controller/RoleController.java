package br.edu.ifpb.academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.academico.entity.Role;
import br.edu.ifpb.academico.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/form")
	public String home(Model model) {
		model.addAttribute("role", new Role());
		return "cadastrarRole";
	}

    @PostMapping("save")
	public String saveRole(@ModelAttribute Role role, Model model) {	
		// Verifica se o papel já existe
		if (roleService.existsByRole(role.getRole())) {
			model.addAttribute("mensagemErro", "Papel " + role.getRole() + " já cadastrado.");
			return "cadastrarRole";
		} else {
			roleService.save(role);
		}
		model.addAttribute("mensagemSucesso", "Papel " + role.getRole() + " cadastrado com sucesso!");
		return "cadastrarRole";
	}

    @GetMapping("/edit/{id}")
	public String editRole(@PathVariable Long id, Model model) {
		Role role = roleService.findById(id);
		model.addAttribute("role", role);
		return "editarRole";
	}

    @PostMapping("/edit")
	public String editRolePost(@ModelAttribute Role role, Model model) {
		//// Verifica se o nome alterado já existe em outro papel, exceto ele mesmo
		if((!roleService.findById(role.getId()).getRole().equals(role.getRole())) && roleService.existsByRole(role.getRole())) {
			model.addAttribute("mensagemErro", "Papel " + role.getRole() + " já existe.");
			return listRoles(model);
		}else {
		roleService.save(role);
		}

		model.addAttribute("mensagemSucesso", "Papel " + role.getRole() + " atualizado com sucesso!");
		return listRoles(model);

	}

    @GetMapping("list")
	public String listRoles(Model model) {
		model.addAttribute("roles", roleService.findAll());
		return "listarRole";
	}

    @GetMapping("/delete/{id}")
	public String deleteRole(@PathVariable Long id, Model model) {
		roleService.deleteById(id);
		model.addAttribute("mensagemSucesso",  "Papel deletado com sucesso!");
		return listRoles(model);
	}

}
