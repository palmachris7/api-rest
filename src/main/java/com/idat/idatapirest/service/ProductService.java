package com.idat.idatapirest.service;

import java.util.List;

import com.idat.idatapirest.model.Products;

public interface ProductService {

	public void guardarProducto(Products p);
	public void eliminarProducto(Integer id);
	public void editarProducto(Products p);
	public List<Products> listarProductos();
	public Products productById(Integer id);
	
}
