package com.tiendavirtual.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tiendavirtual.data.models.Venta;

public interface VentaRepository extends CrudRepository<Venta, Long>{
	List<Venta> findAll();

}
