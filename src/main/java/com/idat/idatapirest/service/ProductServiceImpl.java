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

		repository.save(p);
	}

	@Override
	public void eliminarProducto(Integer id) {

		repository.deleteById(id);
	}

	@Override
	public void editarProducto(Products p) {

		repository.saveAndFlush(p);
	}

	@Override
	public List<Products> listarProductos() {

		return repository.findAll();
	}

	@Override
	public Products productById(Integer id) {

		return repository.findById(id).orElse(null);
	}

}
