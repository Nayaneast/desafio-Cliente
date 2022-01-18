package com.serasa.Experian.desafioCliente.resource;

import com.serasa.Experian.desafioCliente.model.Cliente;
import com.serasa.Experian.desafioCliente.repository.ClienteRepository;
import com.serasa.Experian.desafioCliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.findClienteAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Cliente>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findClienteById(id));
    }

    @PostMapping("/inserir")
    public ResponseEntity<Cliente> salvaCliente(@RequestBody Cliente cliente) {
        Optional<Cliente> clienteSalvo = clienteService.save(cliente);

        if(clienteSalvo.isPresent()){
            return ResponseEntity.ok().body(clienteSalvo.get());
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
