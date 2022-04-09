package com.idat.idatapirest.service;

import com.idat.idatapirest.dto.ProductRequestDTO;
import com.idat.idatapirest.dto.SupplierRequestDTO;
import com.idat.idatapirest.model.Products;
import com.idat.idatapirest.model.Suppliers;

import java.util.List;

public interface SupplierService {

    public void guardarSupplier(SupplierRequestDTO s);
    public void eliminarSupplier(Integer id);
    public void editarSupplier(Suppliers s);
    public List<Suppliers> listarSuppliers();
    public Suppliers supplierById(Integer id);

}
