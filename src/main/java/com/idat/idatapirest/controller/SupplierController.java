package com.idat.idatapirest.controller;

import com.idat.idatapirest.dto.ItemRequestDTO;
import com.idat.idatapirest.dto.SupplierRequestDTO;
import com.idat.idatapirest.model.Items;
import com.idat.idatapirest.model.Suppliers;
import com.idat.idatapirest.service.ItemService;
import com.idat.idatapirest.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor/v1")
public class SupplierController {
    @Autowired
    private SupplierService service;

    @RequestMapping(method = RequestMethod.GET, path = "/listar")
    public ResponseEntity<List<Suppliers>> listar(){

        return new ResponseEntity<List<Suppliers>>(service.listarSuppliers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/guardar")
    public ResponseEntity<Void> guardar(@RequestBody SupplierRequestDTO supplier){
        service.guardarSupplier(supplier);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        Suppliers suppliers = service.supplierById(id);
        if(suppliers != null) {
            service.eliminarSupplier(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
}
