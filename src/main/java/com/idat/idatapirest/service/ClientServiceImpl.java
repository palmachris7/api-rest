package com.idat.idatapirest.service;

import com.idat.idatapirest.dto.ClientRequestDTO;
import com.idat.idatapirest.model.Clients;
import com.idat.idatapirest.model.Products;
import com.idat.idatapirest.repository.ClientRepository;
import com.idat.idatapirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository repository;

    @Override
    public void guardarCliente(ClientRequestDTO c) {
        Clients clients = new Clients();
        clients.setIdCliente(c.getIdRequest());
        clients.setCliente(c.getCliente());
        clients.setCelular(c.getCelular());
        repository.save(clients);
    }

    @Override
    public void eliminarCliente(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void editarCliente(Clients c) {
        repository.saveAndFlush(c);
    }

    @Override
    public List<Clients> listarClientes() {
        return repository.findAll();
    }

    @Override
    public Clients ClientById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
