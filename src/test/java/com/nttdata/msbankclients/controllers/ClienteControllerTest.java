package com.nttdata.msbankclients.controllers;

import com.nttdata.msbankclients.entity.Cliente;
import com.nttdata.msbankclients.services.IClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IClienteService clienteService;

    @Test
    void getListALl() throws Exception {
        mvc.perform(get("/api/clientes"))
                .andExpect(status().isOk());
    }

    @Test
    void getListById() throws Exception {

        Integer id =1;
        Cliente cuenta = new Cliente(id, "123", true);

        when(clienteService.getById(id)).thenReturn(cuenta);

        mvc.perform(get("/api/clientes/" + id))
                .andExpect(status().isOk());
    }

}
