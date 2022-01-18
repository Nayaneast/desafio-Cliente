package com.serasa.Experian.desafioCliente.resource;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.serasa.Experian.desafioCliente.model.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@Sql(statements = {
//        "insert into termoresponsabilidade(id, datacriacao, usuario, conteudo, datainiciovalidade) " +
//                "values(25, '2020-07-01T18:00:00','Maria Silva','Termo de Responsabilidade 1', '2021-05-31')",
//        "insert into termoresponsabilidade(id, datacriacao, usuario, conteudo, datainiciovalidade) " +
//                "values(55, '2020-07-12T18:00:00','Bella Silva','Termo de Responsabilidade 2', '2021-05-25')"
//})

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClienteResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveBuscarTodos() throws Exception {
        this.mockMvc.perform(get("/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }



    @Test
    public void deveDeletar() throws Exception {
    this.mockMvc.perform(delete("/clientes/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());
    }
}
