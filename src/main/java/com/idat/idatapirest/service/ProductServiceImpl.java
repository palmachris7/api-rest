package com.idat.idatapirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idatapirest.model.Products;
import com.idat.idatapirest.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public void guardarProducto(Products p) {
		// TODO Auto-generated method stub
		repository.guardarProducto(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.eliminarProducto(id);
	}

	@Override
	public void editarProducto(Products p) {
		// TODO Auto-generated method stub
		repository.editarProducto(p);
	}

	@Override
	public List<Products> listarProductos() {
		// TODO Auto-generated method stub
		return repository.listarProductos();
	}

	@Override
	public Products productById(Integer id) {
		// TODO Auto-generated method stub
		return repository.productById(id);
	}

}
