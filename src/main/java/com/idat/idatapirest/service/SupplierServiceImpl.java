package com.idat.idatapirest.service;

import com.idat.idatapirest.dto.SupplierRequestDTO;
import com.idat.idatapirest.model.Suppliers;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService {
    @Override
    public void guardarSupplier(SupplierRequestDTO s) {

    }

    @Override
    public void eliminarSupplier(Integer id) {

    }

    @Override
    public void editarSupplier(Suppliers s) {

    }

    @Override
    public List<Suppliers> listarSuppliers() {
        return null;
    }

    @Override
    public Suppliers supplierById(Integer id) {
        return null;
    }
}
