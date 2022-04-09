package com.idat.idatapirest.service;

import com.idat.idatapirest.dto.ClientRequestDTO;
import com.idat.idatapirest.model.Clients;


import java.util.List;

public interface ClientService {
    public void guardarCliente(ClientRequestDTO c);
    public void eliminarCliente(Integer id);
    public void editarCliente(Clients c);
    public List<Clients> listarClientes();
    public Clients ClientById(Integer id);
}
