package com.idat.idatapirest.controller;

import com.idat.idatapirest.dto.ClientRequestDTO;
import com.idat.idatapirest.dto.ItemRequestDTO;
import com.idat.idatapirest.model.Clients;
import com.idat.idatapirest.model.Items;
import com.idat.idatapirest.service.ClientService;
import com.idat.idatapirest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item/v1")
public class ItemController {
    @Autowired
    private ItemService service;

    @RequestMapping(method = RequestMethod.GET, path = "/listar")
    public ResponseEntity<List<Items>> listar(){

        return new ResponseEntity<List<Items>>(service.listarItem(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/guardar")
    public ResponseEntity<Void> guardar(@RequestBody ItemRequestDTO item){
        service.guardarItem(item);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        Items items = service.itemById(id);
        if(items != null) {
            service.eliminarItem(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
}
