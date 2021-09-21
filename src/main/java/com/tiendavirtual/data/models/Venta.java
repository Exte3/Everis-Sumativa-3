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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String direccion_envio;
	private Long cantidad;
	

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	//relacion con ventas n a m
	//relacion n a m
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="productos_ventas", //nombre tabla intermedia
	joinColumns = @JoinColumn(name="venta_id"),
	inverseJoinColumns  = @JoinColumn(name = "producto_id"))
	private List<Producto> productos;
	//Join table--> name; Joincolumns; inverseJoinColumns

	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	//Constructores
	public Venta() {
		super();
	}
	
	public Venta(List<Producto> productos) {
		super();
		this.productos = productos;
	}

	//Getters and Setters

	@PrePersist
	protected void onCreate(){
	this.createdAt = new Date();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDireccion_envio() {
		return direccion_envio;
	}


	public void setDireccion_envio(String direccion_envio) {
		this.direccion_envio = direccion_envio;
	}





	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
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


	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	}
}
