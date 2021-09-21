package com.tiendavirtual.data.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tiendavirtual.data.models.Usuario;
import com.tiendavirtual.data.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService us;
    
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("user") Usuario usuario) {
		return "registro.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session) {
		System.out.println("llego a ingresar");
		boolean existeUsuario = us.validarUsuario(email, password);
		System.out.println("paso el boolean");
		if(existeUsuario) {
			Usuario usuario = us.findByEmail(email);
			session.setAttribute("usuarioId", usuario.getId());
			return "redirect:/venta";
		}
		//revisar cual es el home
		return "redirect:/login";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@Valid @ModelAttribute("usuario") Usuario usuario) {
		us.insertarUsuario(usuario);
		return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("usuarioId")!=null) {
			session.invalidate();
		}
		return "redirect:/login";
	}
	
	//metodos antiguos
	
	@RequestMapping("")
	public String indexUsuario(@ModelAttribute("usuario") Usuario usuario,Model model ) {
		List<Usuario> lista_usuarios = us.findAll();
		model.addAttribute("lista_usuarios", lista_usuarios);
		return "usuario.jsp";
	}
	
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizarUsuario(@PathVariable("id") Long id, Model model) {
		Usuario usuario = us.buscarUsuario(id);
		model.addAttribute("usuario", usuario);
		return "editar_usuario.jsp";
	}
	
	@RequestMapping(value="/modificar",method= RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("usuario") Usuario usuario) {
		
		System.out.println("el Id a modificar es: "+usuario.getId());
		us.modificarUsuario(usuario);
		return "redirect:/usuario";
	}
	
	@RequestMapping(value="/eliminar/{id}", method = RequestMethod.DELETE)
	public String eliminar(@PathVariable("id") Long id) {
		System.out.println("Eliminar id: "+ id);
		us.eliminarUsuario(id);
		
		return "redirect:/usuario";
	}
	
}
