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

import com.tiendavirtual.data.models.Producto;
import com.tiendavirtual.data.models.Usuario;
import com.tiendavirtual.data.models.Venta;
import com.tiendavirtual.data.services.ProductoService;
import com.tiendavirtual.data.services.UsuarioService;
import com.tiendavirtual.data.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
    /**private final VentaService vservice;
	public VentaController(VentaService ventaService) {
		this.vservice = ventaService;
	}**/
	
	//Venta carrito = new Venta();
	
	@Autowired 
	private VentaService vs;
	
	@Autowired 
	private ProductoService productoservice;
	
	@Autowired 
	private UsuarioService usuarioservice;
	
	@RequestMapping("")
	public String indexUsuario(@ModelAttribute("venta") Venta venta,Model model, HttpSession session) {
		List<Venta> lista_ventas = vs.findAll();
		List<Producto> lista_productos = productoservice.findAll();
		List<Usuario> lista_usuarios = usuarioservice.findAll();
		
		model.addAttribute("lista_productos", lista_productos);
		model.addAttribute("lista_ventas", lista_ventas);
		if(session.getAttribute("usuarioId")==null) {
			return "redirect:/login";
			
		}
		return "venta.jsp";
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public String crearUsuario(@Valid @ModelAttribute("venta") Venta venta, Model model, HttpSession session) {
		List<Venta> lista_venta = vs.findAll();
		List<Producto> lista_productos = productoservice.findAll();
		Long elide = (Long) session.getAttribute("usuarioId");
		Usuario usuario = usuarioservice.buscarUsuario(elide);
		venta.setUsuario(usuario);
		session.setAttribute("carrito", venta);
		Venta vent = vs.insertarVenta(venta);
		return "redirect:/venta";
	}
	
	/*@RequestMapping(value = "/carrito", method = RequestMethod.POST)
	public String crearcarrito(@ModelAttribute("producto") Producto producto, HttpSession session, Model model) {
		//System.out.println("La lista de productos "+venta.getProductos());
		Venta carrito = (Venta) session.getAttribute("carrito");
		List<Producto> lista_productos = carrito.getProductos();
		model.addAttribute("lista_productos", lista_productos);
		vs.insertarVenta(carrito);
		return "redirect:/venta";
	}*/
	
	/*@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizarVenta(@PathVariable("id") Long id, Model model) {
		Venta venta = vs.buscarVenta(id);
		
		model.addAttribute("venta", venta);
		return "editar_venta.jsp";
	}
	
	@RequestMapping(value="/modificar",method= RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("venta") Venta venta) {
		
		System.out.println("el Id a modificar es: "+ venta.getId());
		vs.modificarVenta(venta);
		
		return "redirect:/venta";
	}*/
	
	@RequestMapping(value="/eliminar/{id}", method = RequestMethod.DELETE)
	public String eliminar(@PathVariable("id") Long id) {
		System.out.println("Eliminar id: "+ id);
		vs.eliminarVenta(id);
		
		return "redirect:/venta";
	}
	

}
