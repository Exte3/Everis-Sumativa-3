package com.tiendavirtual.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tiendavirtual.data.models.Producto;
import com.tiendavirtual.data.services.ProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	
   
    private final ProductoService pservice;
	public ProductoController(ProductoService productoService) {
		this.pservice = productoService;
	}
	
	@RequestMapping("")
	public String indexUsuario(@ModelAttribute("producto") Producto producto,Model model ) {
		List<Producto> lista_productos = pservice.findAll();
		model.addAttribute("lista_productos", lista_productos);
		
		return "producto.jsp";
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public String crearUsuario(@Valid @ModelAttribute("producto") Producto producto, Model model) {
		if(producto.getNombre().isBlank() || producto.getPrecio().isNaN() || producto.getCaracteristica().isBlank() || producto.getStock()== null) {
			model.addAttribute("error", "Todos los campos son requeridos!");
			List<Producto> lista_producto = pservice.findAll();
			model.addAttribute("lista_productos", lista_producto);
			return "producto.jsp";
		}
		
		
		Producto produ = pservice.insertarProducto(producto);
		return "redirect:/producto";
	}
	
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizarProducto(@PathVariable("id") Long id, Model model) {
		Producto producto = pservice.buscarProducto(id);
		
		model.addAttribute("producto", producto);
		return "editar_producto.jsp";
	}
	
	@RequestMapping(value="/modificar",method= RequestMethod.PUT)
	public String modificarProducto(@Valid @ModelAttribute("producto") Producto producto) {
		
		System.out.println("el Id a modificar es: "+producto.getId());
		pservice.modificarProducto(producto);
		
		return "redirect:/producto";
	}
	
	@RequestMapping(value="/eliminar/{id}", method = RequestMethod.DELETE)
	public String eliminar(@PathVariable("id") Long id) {
		System.out.println("Eliminar id: "+ id);
		pservice.eliminarProducto(id);
		
		return "redirect:/producto";
	}
	
}