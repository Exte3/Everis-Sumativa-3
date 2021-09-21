package com.tiendavirtual.data.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tiendavirtual.data.models.Usuario;
import com.tiendavirtual.data.services.UsuarioService;



@Controller
@RequestMapping("/")
public class IndexController {
	
    private final UsuarioService uservice;
	public IndexController(UsuarioService usuarioService) {
		this.uservice = usuarioService;
	}
	
	@RequestMapping("")
	public String indexUsuario() {
		return "index.jsp";
	}
	
	@RequestMapping("/login")
	public String loginUsuario() {
		return "login.jsp";
	}
	
	@RequestMapping("/registrar")
	public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario,Model model) {
		return "registrar.jsp";
	}
	
	@RequestMapping(value="/guardar", method = RequestMethod.POST)
	public String crearUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
		if(usuario.getNombre().isBlank() || usuario.getApellido().isBlank() || usuario.getEmail().isBlank()) {
			model.addAttribute("error", "Todos los campos son requeridos!");
			return "registrar.jsp";
		}
		System.out.println("crear "+ usuario.getNombre() + " " + usuario.getApellido() + " " + usuario.getEmail());
		Usuario user = uservice.insertarUsuario(usuario);
		return "redirect:/venta";
	}
	
	

}