package com.tiendavirtual.data.services;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.tiendavirtual.data.models.Producto;
import com.tiendavirtual.data.models.Usuario;
import com.tiendavirtual.data.repositories.ProductoRepository;





@Service
public class ProductoService {
	
	private final ProductoRepository prepository;
	public ProductoService(ProductoRepository productoRepository) {
		this.prepository = productoRepository;
	}
	
	public Producto insertarProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		return prepository.save(producto);
	}
	
	public List<Producto> findAll() {
		// retorna una lista de productos
		return prepository.findAll();
	}
	
	public void eliminarProducto(Long id) {
		prepository.deleteById(id);
	}
	
	public Producto buscarProducto(Long id) {

		Optional<Producto> oProducto= prepository.findById(id);
		
		if(oProducto.isPresent()) {
			return oProducto.get();
		}
		
		return null;
	}
	
	public void modificarProducto(@Valid Producto producto) {
		prepository.save(producto);
		
	}
	
	
}

