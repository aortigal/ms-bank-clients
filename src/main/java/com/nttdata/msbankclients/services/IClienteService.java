package com.nttdata.msbankclients.services;

import com.nttdata.msbankclients.entity.Cliente;

import java.util.List;

public interface IClienteService {

    Cliente save(Cliente cliente);

    Cliente update(Cliente cliente);

    List<Cliente> getListAll();

    Cliente getById(Integer id);

    boolean delete(Integer id);

}
