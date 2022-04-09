package com.idat.idatapirest.service;

import com.idat.idatapirest.dto.ItemRequestDTO;

import com.idat.idatapirest.model.Items;
import com.idat.idatapirest.model.Products;

import java.util.List;

public interface ItemService {

    public void guardarItem(ItemRequestDTO i);
    public void eliminarItem(Integer id);
    public void editarItem(Items i);
    public List<Items> listarItem();
    public Items itemById(Integer id);

}
