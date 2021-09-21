package com.tiendavirtual.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;


import com.tiendavirtual.data.models.Venta;
import com.tiendavirtual.data.repositories.VentaRepository;

@Service
public class VentaService {
	
	private final VentaRepository vrepository;
	
	public VentaService(VentaRepository ventaRepository) {
		this.vrepository = ventaRepository;
	}
	
	public Venta insertarVenta(@Valid Venta venta) {
		
		return vrepository.save(venta);
	}
	
	public List<Venta> findAll() {
		// retorna una lista de usuarios
		return vrepository.findAll();
	}
	
	public void eliminarVenta(Long id) {
		vrepository.deleteById(id);
	}
	
	public Venta buscarVenta(Long id) {

		Optional<Venta> oVenta= vrepository.findById(id);
		
		if(oVenta.isPresent()) {
			return oVenta.get();
		}
		
		return null;
	}
	
	public void modificarVenta(@Valid Venta venta) {
		vrepository.save(venta);
		
	}

}
