package com.idat.idatapirest.service;
import com.idat.idatapirest.dto.ItemRequestDTO;
import com.idat.idatapirest.model.Clients;
import com.idat.idatapirest.model.Items;
import com.idat.idatapirest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository repository;

    @Override
    public void guardarItem(ItemRequestDTO i) {
        Items item = new Items();
        item.setIdItem(i.getIdRequest());
        item.setItem(i.getItem());
        item.setCantidad(i.getCantidad());
        item.setTotal(i.getTotal());
        repository.save(item);
    }

    @Override
    public void eliminarItem(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void editarItem(Items i) {
        repository.saveAndFlush(i);
    }

    @Override
    public List<Items> listarItem() {
        return repository.findAll();
    }

    @Override
    public Items itemById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
