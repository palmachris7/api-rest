package com.idat.idatapirest.repository;

import com.idat.idatapirest.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Suppliers,Integer> {
}
