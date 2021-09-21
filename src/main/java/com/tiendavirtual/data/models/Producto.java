package com.tiendavirtual.data.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Float precio;
	private String caracteristica;
	private Long stock;
	
	
	//relacion con ventas n a m
	//relacion n a m
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="productos_ventas", //nombre tabla intermedia
	joinColumns = @JoinColumn(name="producto_id"),
	inverseJoinColumns  = @JoinColumn(name = "venta_id"))
	private List<Venta> ventas;
	//Join table--> name; Joincolumns; inverseJoinColumns
	

	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate(){
	this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	}
	
	//Constructor vacío
	public Producto() {
		super();
	}
	public Producto(Long id, String nombre, Float precio, String caracteristica, Long stock, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.caracteristica = caracteristica;
		this.stock = stock;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
	

}

