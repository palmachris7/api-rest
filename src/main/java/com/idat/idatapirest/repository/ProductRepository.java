package com.idat.idatapirest.repository;


import com.idat.idatapirest.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {

	

}
