package com.nttdata.msbankclients.controllers;

import com.nttdata.msbankclients.entity.Cliente;
import com.nttdata.msbankclients.services.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

    @GetMapping
    public ResponseEntity<List<Cliente>> getListALl(){
        log.info("[INI] getListALl Cliente");

        List<Cliente> lista = clienteService.getListAll();

        log.info("[END] getListALl Cliente");
        return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getListById(@PathVariable("id") Integer id){
        log.info("[INI] getListById Cliente " + id);

        Cliente cliente = clienteService.getById(id);

        log.info("[END] getListById cliente " + id);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        log.info("[INI] save Cliente");

        Cliente p = clienteService.save(cliente);

        log.info("[END] save Cliente");
        return new ResponseEntity<Cliente>(p, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody Cliente cliente){
        log.info("[INI] update Cliente " + id);

        Cliente p = clienteService.update(id, cliente);

        log.info("[END] update Cliente " + id);

        if(p!=null){
            return new ResponseEntity<Object>(p, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<Object>("Cliente no Existe.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        log.info("[INI] delete Cliente " + id);

        clienteService.delete(id);

        log.info("[END] delete Cliente " + id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
