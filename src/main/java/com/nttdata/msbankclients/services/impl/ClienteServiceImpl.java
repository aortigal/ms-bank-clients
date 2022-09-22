package com.nttdata.msbankclients.services.impl;

import com.nttdata.msbankclients.entity.Cliente;
import com.nttdata.msbankclients.repository.IClienteRepository;
import com.nttdata.msbankclients.services.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);


    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        log.info("findById "+ id);
        Optional<Cliente> c = clienteRepository.findById(id);
        if (c.isPresent()){
            log.info("update "+ id);
            return clienteRepository.save(cliente);
        }
        log.info("Cliente no existe "+ id);
        return null;
    }

    @Override
    public List<Cliente> getListAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getById(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseGet(Cliente::new);
    }

    @Override
    public boolean delete(Integer id) {
        clienteRepository.deleteById(id);
        return true;
    }
}
