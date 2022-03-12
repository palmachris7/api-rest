package com.idat.idatapirest.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.idatapirest.model.Products;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	public List<Products> listar = new ArrayList<Products>();

	@Override
	public void guardarProducto(Products p) {
		// TODO Auto-generated method stub
		listar.add(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		listar.remove(productById(id));
	}

	@Override
	public void editarProducto(Products p) {
		// TODO Auto-generated method stub
		listar.remove(productById(p.getIdProducto()));
		listar.add(p);
	}

	@Override
	public List<Products> listarProductos() {
		// TODO Auto-generated method stub
		return listar;
	}

	@Override
	public Products productById(Integer id) {
		// TODO Auto-generated method stub
		return listar.stream().filter(p->p.getIdProducto()==id).findFirst().orElse(null);
	}

}
